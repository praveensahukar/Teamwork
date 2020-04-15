/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.AppSecScheduleRequestBean;
import com.Paladion.teamwork.beans.CodeReviewScheduleRequestBean;
import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.ProjectScheduleRequestBean;
import com.Paladion.teamwork.beans.eptScheduleRequestBean;
import com.Paladion.teamwork.beans.iptScheduleRequestBean;
import com.Paladion.teamwork.beans.vascanScheduleRequestBean;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
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

    @Override
    public void saveprojschedule(ProjectScheduleRequestBean Projschedule) {
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(Projschedule);
            System.out.println("project schedule added successfully");
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
    public List<CodeReviewScheduleRequestBean> getAllCodereview() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <CodeReviewScheduleRequestBean> Codereviewlist=new ArrayList<CodeReviewScheduleRequestBean>();
            String projectquery= "from CodeReviewScheduleRequestBean";
            //System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Codereviewlist= query2.list();
            tx.commit();
            return Codereviewlist;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
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
    public List<AppSecScheduleRequestBean> getAllAppsec() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <AppSecScheduleRequestBean> Codereviewlist=new ArrayList<AppSecScheduleRequestBean>();
            String projectquery= "from AppSecScheduleRequestBean";
            //System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Codereviewlist= query2.list();
            tx.commit();
            return Codereviewlist;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return null;
        }
        finally{
            if(session.isOpen()){
            System.out.println("-------------Closing session--------------");
            session.close();
            }
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<eptScheduleRequestBean> getAllEpt() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <eptScheduleRequestBean> Eptlist=new ArrayList<eptScheduleRequestBean>();
            String projectquery= "from eptScheduleRequestBean";
            //System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Eptlist= query2.list();
            tx.commit();
            return Eptlist;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return null;
        }
        finally{
            if(session.isOpen()){
            System.out.println("-------------Closing session--------------");
            session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }
}
