/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.utils;

import com.Paladion.teamwork.beans.EmailBean;
import com.Paladion.teamwork.beans.SystemBean;
import com.Paladion.teamwork.services.AdminService;
import com.Paladion.teamwork.services.AdminServiceImpl;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;


import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Controller;


/**
 *
 * @author user
 */
@Controller
public class EmailUtil {
	

AdminService Aservice = new AdminServiceImpl();

 
public boolean sendEmail(EmailBean ebean, SystemBean syssetting) throws RuntimeException
{
           
            System.out.println("com.Paladion.teamwork.utils.EmailUtil.sendEmail()");
            System.out.println("Server:" + syssetting.getMailserver());
            
            final String mailID=syssetting.getMailuser();
            final String mailPass=syssetting.getMailpass();
            
            
		Properties props = new Properties();
		props.put("mail.smtp.host", syssetting.getMailserver());
		props.put("mail.smtp.socketFactory.port", syssetting.getPort());
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", syssetting.getPort());
                props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailID,mailPass);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(syssetting.getMailuser()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(ebean.getTo()));
			message.setSubject(ebean.getSubject());
                        message.setContent(ebean.getMessage(),"text/html");
			//message.setText("Dear Mail Crawler," +
					//"\n\n No spam to my email, please!");
			
			//message.setText(ebean.getMessage());

			Transport.send(message);

			System.out.println("***** Mail Sent Successfully! *****");
                        return true;

		} catch (MessagingException e) {
                    e.printStackTrace();
                    System.out.println("----- Exception occured during sending mail!!! ----");
                    return false;
                }
		
	}
	
}
