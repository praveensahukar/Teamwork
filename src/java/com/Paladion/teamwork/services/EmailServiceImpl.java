/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.DAO.EmailDAO;
import com.Paladion.teamwork.DAO.LoginDAO;
import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.CompanyBean;
import com.Paladion.teamwork.beans.EmailBean;
import com.Paladion.teamwork.beans.EmailTemplateBean;
import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.SystemBean;
import com.Paladion.teamwork.beans.UserDataBean;
import com.Paladion.teamwork.utils.CommonUtil;
import com.Paladion.teamwork.utils.EmailUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author user
 */
public class EmailServiceImpl implements EmailService{
	
    @Autowired
    @Qualifier(value="EmailDAO")
    EmailDAO emailDAO;
    
    @Autowired
    @Qualifier(value="CommonUtil")
    CommonUtil CU;
    
    @Autowired
    @Qualifier(value="UserService")
    UserService UserS;
    
    @Autowired
    @Qualifier(value="CompanyService")
    CompanyService CompanyS;
    
    @Autowired
    @Qualifier(value="AdminService")
    AdminService AdminS;

	@Override
	public boolean createEmailTemplate(EmailTemplateBean emailTempBean) {
		return emailDAO.createEmailTemplate(emailTempBean);
	}

	@Override
	public boolean updateEmailTemplate(EmailTemplateBean emailTempBean) {
		return emailDAO.updateEmailTemplate(emailTempBean);
	}

	@Override
	public List<EmailTemplateBean> listEmailTemplate() {
		return emailDAO.listEmailTemplate();
	}

	@Override
	public boolean deleteEmailTemplate(EmailTemplateBean emailTempBean) {
		return emailDAO.deleteEmailTemplate(emailTempBean);
	}
        
        
        @Override
        public boolean sendSchedulingMail(ActivityBean AB, HttpSession sess, ProjectBean PB){
        
        try{
         EmailUtil EU=new EmailUtil();
         EmailBean ebean=new EmailBean();
         UserDataBean leadb=UserS.GetUserById(AB.getLeadid());
         UserDataBean eng=UserS.GetUserById(AB.getEngtracker());
         UserDataBean pmbean=UserS.GetUserById(PB.getProjectmanager());
         UserDataBean dmbean=UserS.GetUserById(PB.getDeliverymanager());
         List <UserDataBean> scheduling = UserS.GetUsersByRole("scheduling");
         
         CompanyBean CB = CompanyS.getCompanyByID(PB.getCompanyid());
         
         StringBuilder emails =new StringBuilder();
         
         if(leadb.getEmail()!=null){
             emails.append(leadb.getEmail()).append(",");
         }
         if(eng.getEmail()!=null){
             emails.append(eng.getEmail()).append(",");
         }
         if(pmbean.getEmail()!=null){
             emails.append(pmbean.getEmail()).append(",");
         }
         if(dmbean.getEmail()!=null){
             emails.append(dmbean.getEmail()).append(",");
         }
         
         for(UserDataBean ubean : scheduling){
             emails.append(ubean.getEmail()).append(",");
         }
         
         String to = emails.toString();
         
         ebean.setTo(to);
         
         ebean.setSubject("Project Scheduling Mail :: "+PB.getProjectname());
  
         SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
         String sDate = sm.format(AB.getStartdate());
         String eDate = sm.format(AB.getEnddate());
         
         StringBuilder mess=new StringBuilder();
         mess.append("<html><body>");
         mess.append("<h4 style = \"color:#000033\">");
         mess.append("Dear ").append(leadb.getUsername()).append("/").append(eng.getUsername()).append("</br></br>").append("You have been scheduled to execute the below activity. Please find the activity details below. </h4><br>");
             
                 
         mess.append( "<table border=\"2\" cellpadding=\"5\" cellspacing=\"5\" style=\"border-collapse:collapse\" width='70%'>");
         
         mess.append("<tr style = /'color:#000055/'> <td bgcolor=/'#ccddff/' > <b>Project Name</b> </td> <td>").append(PB.getProjectname()).append("</td> <tr>");
         
         mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Client</b> </td> <td>").append(CB.getCompanyname()).append("</td> <tr>");
        
         mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>OPID</b> </td> <td>").append(PB.getOpid()).append("</td> <tr>");
         
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity</b> </td> <td>").append(AB.getActivityname()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Assessment Type</b> </td> <td>").append(AB.getAssessmentType()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Compliance</b> </td> <td>").append(AB.getCompliance()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity Start Date</b> </td> <td>").append(sDate).append("</td> <tr>");
       
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity End Date</b> </td> <td>").append(eDate).append("</td> <tr>");
         
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Lead Assigned</b> </td> <td>").append(AB.getLead()).append("</td> <tr>");
        
         mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Engineer Assigned</b> </td> <td>").append(eng.getUsername()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Delivery Manager</b> </td> <td>").append(dmbean.getUsername()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Project Manager</b> </td> <td>").append(pmbean.getUsername()).append("</td> <tr>");

        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Pre-requisites</b> </td> <td>").append(AB.getRequirements()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Whitelisting Confirmation</b> </td> <td>").append(AB.getWhitelisting()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Region</b> </td> <td>").append(PB.getRegion()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Other Details</b> </td> <td>").append(AB.getDetails()).append("</td> <tr>");
   
        mess.append("</table>").append("</br>").append("<b>Regards,").append("</br>").append("Team Paladion Networks <b></body></html>");        
        String message=mess.toString();
         
         ebean.setMessage(message);
         SystemBean syssetting = AdminS.getSystemSettings();
         EU.sendEmail(ebean, syssetting);
        return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
        

    @Override
    public boolean sendSchedulingMail(ActivityBean AB, HttpSession sess){
        
        try{
         EmailUtil EU=new EmailUtil();
         EmailBean ebean=new EmailBean();
         UserDataBean leadb=UserS.GetUserById(AB.getLeadid());
         UserDataBean eng=UserS.GetUserById(AB.getEngtracker());
        // UserDataBean pmbean=UserS.GetUserById(PB.getProjectmanager());
        // UserDataBean dmbean=UserS.GetUserById(PB.getDeliverymanager());
         List <UserDataBean> scheduling = UserS.GetUsersByRole("scheduling");
         
        // CompanyBean CB = CompanyS.getCompanyByID(PB.getCompanyid());
         
         StringBuilder emails =new StringBuilder();
         
         if(leadb.getEmail()!=null){
             emails.append(leadb.getEmail()).append(",");
         }
         if(eng.getEmail()!=null){
             emails.append(eng.getEmail()).append(",");
         }
        // if(pmbean.getEmail()!=null){
        //     emails.append(pmbean.getEmail()).append(",");
        // }
        // if(dmbean.getEmail()!=null){
        //     emails.append(dmbean.getEmail()).append(",");
        // }
         
         for(UserDataBean ubean : scheduling){
             emails.append(ubean.getEmail()).append(",");
         }
         
         String to = emails.toString();
         
         ebean.setTo(to);
         
         ebean.setSubject("Activity Scheduling Mail :: "+AB.getActivityname());
  
         SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
         String sDate = sm.format(AB.getStartdate());
         String eDate = sm.format(AB.getEnddate());
         
         StringBuilder mess=new StringBuilder();
         mess.append("<html><body>");
         mess.append("<h4 style = \"color:#000033\">");
         mess.append("Dear ").append(leadb.getUsername()).append("/").append(eng.getUsername()).append("</br></br>").append("You have been scheduled to execute the below activity. Please find the activity details below. </h4><br>");
             
                 
         mess.append( "<table border=\"2\" cellpadding=\"5\" cellspacing=\"5\" style=\"border-collapse:collapse\" width='70%'>");
         
        // mess.append("<tr style = /'color:#000055/'> <td bgcolor=/'#ccddff/' > <b>Project Name</b> </td> <td>").append(PB.getProjectname()).append("</td> <tr>");
         
        // mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Client</b> </td> <td>").append(CB.getCompanyname()).append("</td> <tr>");
        
         mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>OPID</b> </td> <td>").append("Not yet received.").append("</td> <tr>");
         
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity</b> </td> <td>").append(AB.getActivityname()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Assessment Type</b> </td> <td>").append(AB.getAssessmentType()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Compliance</b> </td> <td>").append(AB.getCompliance()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity Start Date</b> </td> <td>").append(sDate).append("</td> <tr>");
       
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity End Date</b> </td> <td>").append(eDate).append("</td> <tr>");
         
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Lead Assigned</b> </td> <td>").append(AB.getLead()).append("</td> <tr>");
        
         mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Engineer Assigned</b> </td> <td>").append(eng.getUsername()).append("</td> <tr>");
        
        // mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Delivery Manager</b> </td> <td>").append(dmbean.getUsername()).append("</td> <tr>");
        
        // mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Project Manager</b> </td> <td>").append(pmbean.getUsername()).append("</td> <tr>");

        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Pre-requisites</b> </td> <td>").append(AB.getRequirements()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Whitelisting Confirmation</b> </td> <td>").append(AB.getWhitelisting()).append("</td> <tr>");
        
        // mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Region</b> </td> <td>").append(PB.getRegion()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Other Details</b> </td> <td>").append(AB.getDetails()).append("</td> <tr>");
   
        mess.append("</table>").append("</br>").append("<b>Regards,").append("</br>").append("Team Paladion Networks <b></body></html>");        
        String message=mess.toString();
         
         ebean.setMessage(message);
         SystemBean syssetting = AdminS.getSystemSettings();
         EU.sendEmail(ebean, syssetting);
        return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }    
        
        
        
        
        
        
        
     @Override
        public void sendReminder(ActivityBean AB){
        
        try{
        
            UserDataBean eng = UserS.GetUserById(AB.getEngtracker());
            UserDataBean lead = UserS.GetUserById(AB.getLeadid());
            
            EmailUtil EU=new EmailUtil();
            EmailBean ebean=new EmailBean();
            
            String to= lead.getEmail()+","+eng.getEmail();
            ebean.setTo(to);
            ebean.setSubject("Activity Reminder Mail :: "+AB.getActivityname());
            
            StringBuilder mess=new StringBuilder();
            mess.append("<html><body>");
            mess.append("<h4 style = \"color:#000033\">");
            mess.append("Dear ").append(lead.getUsername()).append(" & ").append(eng.getUsername()).append("</br></br>")
                .append("This is a reminder email for the subject mentioned activity starting from ")
                .append(AB.getStartdate()).append(". ")
                .append("Kindly ensure to have all the pre-requisites ready to start the activity.")
                .append("<br> <br>Please inform the scheduling and project team in case the activity is delayed. </h4>");
            mess.append("</br>").append("<b> Best Regards,").append("</br>").append("COE Team,</br> Paladion Networks <b></body></html>");  
        
            String message=mess.toString();
            ebean.setMessage(message);
            SystemBean syssetting = AdminS.getSystemSettings();
            EU.sendEmail(ebean, syssetting);
        }
        catch(Exception ex){
            
        }
        }
        
    @Override
    public boolean sendUserCreationMail(UserDataBean UB){
        try{
        EmailBean ebean=new EmailBean();
        EmailUtil eutil=new EmailUtil();
        ebean.setTo(UB.getEmail());
        String subject="Paladion TeamWork - User Account Created";
        StringBuilder mess=new StringBuilder();
                
        mess.append("Dear ").append(UB.getUsername())
            .append(",<br><br>Your account has been created in the <a href = 'http://10.0.1.11:8090/TeamWorkAlpha/Login.do'> Paladion Teamwork Protal.</a> ")
            .append("<br>Please Log into your account using the following credentials.<br><br>")
            .append("UserName : ").append(UB.getEmail()).append("<br>Password : ").append(UB.getPassword())
            .append("<br><br> <b>Note: This is a auto generated temporary password. Request you to update your password.</b>")
            .append("<br><br>Best Regards,<br>Team Paladion");
               
            String message=mess.toString();
                
            //String message="Dear "+loginBean.getUsername()+"\n\nYour account has been created in the Paladion Teamwork Application ( http://10.0.1.128/TeamWork/ ).\nPlease Log into your account using the following credentials\n\nUsername: "+loginBean.getEmail() +"\nPassword: "+loginBean.getPassword()+"\n\n\n\nBest Regards\nTeam Paladion";
            ebean.setSubject(subject);
            ebean.setMessage(message);
            SystemBean syssetting = AdminS.getSystemSettings();
            eutil.sendEmail(ebean, syssetting);
            return true;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return false;
        }
    }
}
