/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.MapTemplateTaskBean;
import com.Paladion.teamwork.beans.TaskBean;
import com.Paladion.teamwork.beans.TemplateBean;
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
public class TemplateDAOImpl implements TemplateDAO{
	
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
    @Override
    public void addTemplateDao(TemplateBean TempB) {
	Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        try{
            session1.save(TempB);
            tx.commit();
            System.out.println("Template create successfully");	
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
    public boolean addTaskToTemplate(MapTemplateTaskBean MTT){
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{
            session1.save(MTT);
            tx.commit();
            System.out.println("Template weights added successfully");    
            return true;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return false;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("Closing session");
            session1.close();
            }
        }
    }

    @Override
    public List<TaskBean> getAllTasksforTemplate(){
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <TaskBean> taskList=new ArrayList<TaskBean>();
            String taskquery= "from TaskBean";
            System.out.println(taskquery);
            Query query2 = session.createQuery(taskquery);
            taskList= query2.list();
            tx.commit();
            return taskList;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return null;
        }
        finally{
            if(session.isOpen()){
            System.out.println("Closing session");
            session.close();
            }
        }
        
    }
    
     public  List<TemplateBean> getAllTemplates() {
        
 	List <TemplateBean> templateList = new ArrayList<TemplateBean>();
	
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        try{
        String templatequery= "from TemplateBean";
        System.out.println("template query");
        Query query2 = session.createQuery(templatequery);
       
        templateList= query2.list();
	tx.commit();
         
        return templateList;
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
	public boolean deleteTemplate(int id)
	{
            Session session = this.sessionFactory.openSession();
            
            Transaction tx = session.beginTransaction();
            String sql = "delete from templates where templateid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            query.executeUpdate();
            tx.commit();
            
            Session session1 = this.sessionFactory.openSession();
            String sql1 = "delete from template_task where templateid=?";
            SQLQuery query1 = session1.createSQLQuery(sql1);
            query1.setParameter(0, id);
            query1.executeUpdate();
            
            return true;	
	}
    
	
        @Override
	public List<MapTemplateTaskBean> getAllWeights(int tempID) {
		 
           System.out.println("com.Paladion.teamwork.DAO.ProjectDAOImpl.getAllWeights()");
           MapTemplateTaskBean MTTB;
	   Session session1 = sessionFactory.getCurrentSession();
	   Transaction tx = null;
           tx = session1.beginTransaction();
           String SQL_QUERY1= "from MapTemplateTaskBean as O where O.templateid=?";
           Query query2 = session1.createQuery(SQL_QUERY1);
           query2.setParameter(0,tempID);
           
           List list2 = query2.list();
	   System.out.println("Query executed :)");
	   Iterator it= list2.iterator();
	   tx.commit();
                while(it.hasNext())
                  {
                      MTTB=(MapTemplateTaskBean) it.next();
                      System.out.print("Taskid from the DB"+MTTB.getTaskid());
                  }
	   return list2;
        }
}
