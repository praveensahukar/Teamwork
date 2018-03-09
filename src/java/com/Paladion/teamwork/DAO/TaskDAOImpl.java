/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.TaskBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author user
 */
public class TaskDAOImpl implements TaskDAO{
    
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    @Override
    public void addTaskDao(TaskBean TB) {	
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        try{
            session1.save(TB);
            System.out.println("Task create successfully");
            tx.commit();
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("-------------Closing session--------------");
            session1.close();
            }
        }
    }
	
    @Override
    public List<TaskBean> getAllTasks(){
	Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String taskquery= "from TaskBean";
            System.out.println("Get all tasks query");
            Query query2 = session.createQuery(taskquery);
            List <TaskBean> Tasklist = query2.list();
            tx.commit();
            return Tasklist;
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
    public boolean deleteTask(int id){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "delete from tasks where taskid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            query.executeUpdate();
            tx.commit();
            return true;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return false;
        }
        finally{
            if(session.isOpen()){
            System.out.println("-------------Closing session--------------");
            session.close();
            }
        }
    }
}