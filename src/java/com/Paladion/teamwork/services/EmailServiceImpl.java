/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.DAO.EmailDAO;
import com.Paladion.teamwork.DAO.LoginDAO;
import com.Paladion.teamwork.beans.ActivityBean;
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
        public boolean sendSchedulingMailToLead(ActivityBean AB, HttpSession sess, ProjectBean PB){
        
        try{
         EmailUtil EU=new EmailUtil();
         EmailBean ebean=new EmailBean();
         UserDataBean leadb=CU.getUserById(AB.getLeadid(), sess);
         ebean.setTo(leadb.getEmail());
         ebean.setSubject("Project Scheduling Mail");
         
         UserDataBean pmbean=CU.getUserById(PB.getProjectmanager(), sess);
         UserDataBean dmbean=CU.getUserById(PB.getDeliverymanager(), sess);
         
         SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
         String sDate = sm.format(AB.getStartdate());
         String eDate = sm.format(AB.getEnddate());
         
         StringBuilder mess=new StringBuilder();
         mess.append("<html><body>");
         mess.append("<h4 style = \"color:#000033\">");
         mess.append("Dear ").append(leadb.getUsername()).append("</br></br>").append("You have been assigned to the below project as delivery lead. </h4><br>");
             
                 
         mess.append( "<table border='2' style='border-collapse:collapse' width='70%'");
         
         mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Project Name</b> </td> <td>").append(PB.getProjectname()).append("</td> <tr>");
         
         mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Client</b> </td> <td>").append(PB.getCompanyid()).append("</td> <tr>");
        
         mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>OPID</b> </td> <td>").append(PB.getOpid()).append("</td> <tr>");
         
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity</b> </td> <td>").append(AB.getActivityname()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity Start Date</b> </td> <td>").append(sDate).append("</td> <tr>");
       
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Activity End Date</b> </td> <td>").append(eDate).append("</td> <tr>");
         
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Lead Assigned</b> </td> <td>").append(AB.getLead()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Delivery Manager</b> </td> <td>").append(dmbean.getUsername()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Project Manager</b> </td> <td>").append(pmbean.getUsername()).append("</td> <tr>");

        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Region</b> </td> <td>").append(PB.getRegion()).append("</td> <tr>");
        
        mess.append("<tr style = /'color:#000033/'> <td bgcolor=/'#ccddff/' > <b>Details</b> </td> <td>").append(PB.getDescription()).append("</td> <tr>");
        
                  
         
         mess.append("</table>").append("</br>").append("<b> Best Regards,").append("</br>").append("COE Scheduling Team,</br> Paladion Networks <b></body></html>");        
         String message=mess.toString();
         
         ebean.setMessage(message);
         SystemBean syssetting = (SystemBean)sess.getAttribute("SysConfig");
         EU.sendEmail(ebean, syssetting);
        return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
        
	
	
	
}
