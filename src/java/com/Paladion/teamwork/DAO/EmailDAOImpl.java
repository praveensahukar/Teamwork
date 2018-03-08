/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.EmailTemplateBean;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author user
 */
public class EmailDAOImpl implements EmailDAO{
	
	
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public boolean createEmailTemplate(EmailTemplateBean emailTempBean) {
	Session session=sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
        try{
	session.save(emailTempBean);
	tx.commit();
        return true;
        }
        catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                return false;
            }
            finally{
                if(session.isOpen()){
                System.out.println("-------------Closing session--------------");
                session.close();
                }
            }
	}

	@Override
	public boolean updateEmailTemplate(EmailTemplateBean emailTempBean) {
            Session session=sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            try{
                session.update(emailTempBean );
	        tx.commit();
                return true;
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                return false;
            }
            finally{
                if(session.isOpen()){
                System.out.println("-------------Closing session--------------");
                session.close();
                }
            }
        }

	@Override
	public List<EmailTemplateBean> listEmailTemplate() {
            Session session=sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            try{
		Criteria criteria = session.createCriteria(EmailTemplateBean.class);
	        List <EmailTemplateBean> emailTemplateBean = (List<EmailTemplateBean>)criteria.list();
	        tx.commit();
                return emailTemplateBean;
            }catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                return null;
            }
            finally{
                if(session.isOpen()){
                System.out.println("-------------Closing session--------------");
                session.close();
                }
            }
	}

	@Override
	public boolean deleteEmailTemplate(EmailTemplateBean emailTempBean) {
            Session session=sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
	    try{
		session.delete(emailTempBean);
	        tx.commit();
                return true;
            }catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                return false;
            }finally{
                if(session.isOpen()){
                System.out.println("-------------Closing session--------------");
                session.close();
                }
            }
		
	}
	
}
