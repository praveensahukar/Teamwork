/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.EmailTemplateBean;
import com.Paladion.teamwork.beans.ProjectBean;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public interface EmailService {
	
	
	
public boolean createEmailTemplate(EmailTemplateBean emailTempBean);

public boolean updateEmailTemplate(EmailTemplateBean emailTempBean);

public List<EmailTemplateBean> listEmailTemplate();

public boolean deleteEmailTemplate(EmailTemplateBean emailTempBean);

public boolean sendSchedulingMailToLead(ActivityBean AB, HttpSession sess, ProjectBean PB);

public void sendReminder(ActivityBean AB);
	
}
