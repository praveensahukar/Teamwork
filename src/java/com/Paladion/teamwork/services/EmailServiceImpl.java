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
        
        
        
        public boolean sendSchedulingMailToLead(ActivityBean PB, HttpSession sess) throws ParseException{
        
         EmailUtil EU=new EmailUtil();
         EmailBean ebean=new EmailBean();
         UserDataBean ub=CU.getUserById(PB.getLeadid(), sess);
         ebean.setTo(ub.getEmail());
         ebean.setSubject("Project Scheduling Mail");
         
         SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
         String sDate = sm.format(PB.getStartdate());
         String eDate = sm.format(PB.getEnddate());
         
         StringBuilder mess=new StringBuilder();
         mess.append("Dear ").append(ub.getUsername()).append("\n\nYou have been assigned to the below project as delivery lead.")
                  .append(" Please assign Engineers to execute the project.")
                  .append("\n\nProject : ").append(PB.getActivityname())
                  .append("\nOPID : ").append(PB.getOpid())
                  .append("\nStart Date : ").append(sDate)
                  .append("\nEnd Date : ").append(eDate)
                  .append("\nNo Of Days : ").append(PB.getMandays())
                  .append("\n\nBest Regards,").append("\nTeam Paladion");
         
         String message=mess.toString();
         
         ebean.setMessage(message);
         SystemBean syssetting = (SystemBean)sess.getAttribute("SysConfig");
         EU.sendEmail(ebean, syssetting);
        return true;
    }
        
	
	
	
}
