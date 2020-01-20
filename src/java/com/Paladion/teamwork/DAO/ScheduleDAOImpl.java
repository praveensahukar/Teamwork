/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.AppSecScheduleRequestBean;
import com.Paladion.teamwork.beans.CodeReviewScheduleRequestBean;
import com.Paladion.teamwork.beans.eptScheduleRequestBean;
import com.Paladion.teamwork.beans.iptScheduleRequestBean;
import com.Paladion.teamwork.beans.vascanScheduleRequestBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author santosh.babar
 */
public class ScheduleDAOImpl implements ScheduleDAO{
    
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCodeReviewActvitiy(CodeReviewScheduleRequestBean CRSRB) {
        
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(CRSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void saveAppSecActivity(AppSecScheduleRequestBean ASSRB) {
        
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(ASSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void EPTActivity(eptScheduleRequestBean EPTSRB) {
       Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(EPTSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void IPTActivity(iptScheduleRequestBean IPTSRB) {
            Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(IPTSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void VAscanActivity(vascanScheduleRequestBean VAscanSRB) {
           Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(VAscanSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }
    
    
}
