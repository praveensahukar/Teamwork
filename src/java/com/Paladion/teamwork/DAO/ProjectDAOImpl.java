/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.ProjectTransactionBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author user
 */
public class ProjectDAOImpl implements ProjectDAO
{
           @Autowired
           @Qualifier(value="hibernate4AnnotatedSessionFactory")
           private SessionFactory sessionFactory;

           public void setSessionFactory(SessionFactory sessionFactory) {
                       this.sessionFactory = sessionFactory;
           }
	
	@Override
	public void addProjectDao(ProjectBean PB) {
	    Session session1 = sessionFactory.getCurrentSession();
            Transaction tx = null;
	    tx = session1.beginTransaction();
	    session1.save(PB );
	    tx.commit();
            System.out.println("Project created successfully");
      }

	
	@Override
	public List<ProjectBean> getAllProjects(int userid, String role) {
		
            Session session1 = sessionFactory.getCurrentSession();
	    List <ProjectBean> allProjects=new ArrayList<>();
            List<ProjectTransactionBean> PTbeanList=new ArrayList<>();
            Transaction tx = null;
	    tx = session1.beginTransaction();
            
            if (role.equalsIgnoreCase("Manager")||role.equalsIgnoreCase("Admin")||role.equalsIgnoreCase("scheduling"))
            {
             Criteria criteria = session1.createCriteria(ProjectBean.class);
             allProjects= criteria.list();
            }
            else if(role.equalsIgnoreCase("Lead"))
            {
            Criteria criteria = session1.createCriteria(ProjectBean.class);    
            criteria.add(Restrictions.eq("leadid", userid));
            allProjects= criteria.list();
            }   
            else if(role.equalsIgnoreCase("Engineer"))
            {
                       
            Query query1 = session1.createQuery("from ProjectTransactionBean where userid=? group by projectid");
            query1.setParameter(0, userid);
            
            PTbeanList=(List<ProjectTransactionBean>) query1.list();
        
            for(ProjectTransactionBean PTB:PTbeanList)
            {
            Criteria criteria2 = session1.createCriteria(ProjectBean.class); 
            criteria2.add(Restrictions.eq("projectid", PTB.getProjectid()));
            ProjectBean PB=(ProjectBean)criteria2.uniqueResult();
            allProjects.add(PB);
            }
            
            }
            
	    tx.commit();
	    return allProjects;
        }
        
        @Override
        public ProjectBean getProjectById(int id) {
	   Transaction tx = null;
	   Session session1 = sessionFactory.getCurrentSession();
           tx = session1.beginTransaction();
           String SQL_QUERY1= "from ProjectBean as O where O.projectid=?";
           Query query1 = session1.createQuery(SQL_QUERY1);
           query1.setParameter(0,id);
           List list1 = query1.list();       
           ProjectBean PB = (ProjectBean) list1.get(0);
           tx.commit();
        
           return PB;
      }

    @Override
    public void insertProjectTransaction(List <ProjectTransactionBean> PTBList){
        
        for(ProjectTransactionBean PTBean : PTBList){
                Session session1 = sessionFactory.getCurrentSession();
		Transaction tx = null;
	        tx = session1.beginTransaction();
	        session1.save(PTBean);
	        tx.commit();
		System.out.println("Project transaction updated successfully");
        }
        
    }
    
    
 
    
    
        @Override
       public List<ProjectTransactionBean> getProjectTransaction(int projectid){
        
           List<ProjectTransactionBean> PList;
           Transaction tx = null;
	   Session session1 = sessionFactory.getCurrentSession();
           tx = session1.beginTransaction();
           Criteria criteria = session1.createCriteria(ProjectTransactionBean.class);
           criteria.add(Restrictions.eq("projectid", projectid));
//         criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	   PList = criteria.list();
           tx.commit();
           return PList;
    }
  
        @Override
       public boolean updateTaskStatus(int transid, String status){
           
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date1 = new Date();
        System.out.println(df.format(date1));
           
           if(!status.equalsIgnoreCase("new") && !status.isEmpty())
           {
            
               
               ProjectTransactionBean PTBean=this.getTransactionOnTransID(transid);
               System.out.println(PTBean.getStartdate());
               

                 
            if(status.equalsIgnoreCase("progress"))
                
            {               
                Date date2 = PTBean.getTaskstartdate();
              // Get msec from each, and subtract.
                long diff = date1.getTime() - date2.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000);
                System.out.println("Time in seconds: " + diffSeconds + " seconds.");
                System.out.println("Time in minutes: " + diffMinutes + " minutes.");
                System.out.println("Time in hours: " + diffHours + " hours.");
            
                if(diffHours >= 2){
                //Redirect to update the delay reason
                }
                PTBean.setStartdate(date1);
               // this.updatePTB(PTBean);
            }
            
            
            if(status.equalsIgnoreCase("completed")){
                
                Date date2 = PTBean.getTaskenddate();
              // Get msec from each, and subtract.
                long diff = date1.getTime() - date2.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000);
                System.out.println("Time in seconds: " + diffSeconds + " seconds.");
                System.out.println("Time in minutes: " + diffMinutes + " minutes.");
                System.out.println("Time in hours: " + diffHours + " hours.");
            
                if(diffHours >= 2){
                //Redirect to update the delay reason
                }
                PTBean.setEnddate(date1);
               
            }
            
            
            
            
//            Session session = this.sessionFactory.openSession();
//            Transaction tx;
//            String sql;
//          
//            if(status.equalsIgnoreCase("progress")){
//            sql = "UPDATE projects_transaction SET status=?, taskstartdate =? where transid=?";
//            }
//            
//            else if(status.equalsIgnoreCase("completed")){
//            sql = "UPDATE projects_transaction SET status=?, taskenddate =? where transid=?";
//            }
//            
//            else{
//                return false;
//            }
//            tx = session.beginTransaction();
//            SQLQuery query = session.createSQLQuery(sql);
//            query.setParameter(0,status);
//            query.setParameter(1,dateobj);
//            query.setParameter(2,transid);
//            query.executeUpdate();
//            tx.commit();
//            return true;
           }           
           
           else{
               System.out.println("Invalid option selected");
               return false;
           }
           
           return true; // remove this
       }
       
       
             @Override
       public boolean updateTaskStatus(int projid){
            Session session = this.sessionFactory.openSession();
            Transaction tx;
            tx = session.beginTransaction();
            String sql = "UPDATE projects_transaction SET status=? WHERE projectid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,"Completed");
            query.setParameter(1,projid);
            query.executeUpdate();
            tx.commit();
            return true;
       }
       
       @Override
       public ProjectTransactionBean getTransactionOnTransID(int transid){
           List<ProjectTransactionBean> PList;
            Transaction tx = null;
            Session session1 = sessionFactory.getCurrentSession();
            tx = session1.beginTransaction();
            Criteria criteria = session1.createCriteria(ProjectTransactionBean.class);
            criteria.add(Restrictions.eq("transid", transid));
//          criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            PList = criteria.list();
            tx.commit();
            
            if(PList.size()==1){
            ProjectTransactionBean PTB = PList.get(0);
            return PTB;
            }
            else{
           return null;
           }
       }
       
       
       
         @Override
       public boolean updateProjectStatus(int projid, String status){
           if(status.equalsIgnoreCase("new")||status.equalsIgnoreCase("progress")||status.equalsIgnoreCase("completed"))
           {
            Session session = this.sessionFactory.openSession();
            Transaction tx;
            tx = session.beginTransaction();
            String sql = "UPDATE projects SET status=? WHERE projectid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,status);
            query.setParameter(1,projid);
            query.executeUpdate();
            tx.commit();
            return true;
           }           
           
           else{
               System.out.println("Invalid option selected");
               return false;
           }
       }


@Override
    public void updateProjectTransaction(List <ProjectTransactionBean> PTBList){
        
        for(ProjectTransactionBean PTBean : PTBList){
                Session session1 = sessionFactory.getCurrentSession();
		Transaction tx = null;
	        tx = session1.beginTransaction();
                
                String sql = "UPDATE projects_transaction SET taskstartdate=?, taskenddate=?, taskhours=?,taskdays=?, status=? , startdate = ?, enddate=? WHERE transid=?";
                SQLQuery query = session1.createSQLQuery(sql);
                query.setParameter(0,PTBean.getTaskstartdate());
                query.setParameter(1,PTBean.getTaskenddate());
                query.setParameter(2,PTBean.getTaskhours());
                query.setParameter(3,PTBean.getTaskdays());
                query.setParameter(4,PTBean.getStatus());
                query.setParameter(5,PTBean.getStartdate());
                query.setParameter(6,PTBean.getEnddate());
                query.setParameter(7,PTBean.getTransid());
                query.executeUpdate();
                tx.commit();
		System.out.println("Project transaction updated successfully");
        }
        
    } 
         @Override
	public boolean deleteProject(int id)
	{
            Session session = this.sessionFactory.openSession();
            String sql = "delete p.*, pt.* from projects p left join projects_transaction pt on p.projectid=pt.projectid where p.projectid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            query.executeUpdate();
            return true;
        }
        
        
      




}