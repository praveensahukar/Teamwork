/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.EmailTemplateBean;
import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.UserDataBean;
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

public boolean sendSchedulingMail(ActivityBean AB, ProjectBean PB);

public boolean sendSchedulingMail(ActivityBean AB, HttpSession sess);

public void sendReminder(ActivityBean AB);

public boolean sendUserCreationMail(UserDataBean UB);
	
}
