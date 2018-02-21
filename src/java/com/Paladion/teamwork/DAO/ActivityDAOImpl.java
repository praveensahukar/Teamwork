/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.ActivityTransactionBean;
import com.Paladion.teamwork.beans.AllocationBean;
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
public class ActivityDAOImpl implements ActivityDAO
{
           @Autowired
           @Qualifier(value="hibernate4AnnotatedSessionFactory")
           private SessionFactory sessionFactory;

           public void setSessionFactory(SessionFactory sessionFactory) {
                       this.sessionFactory = sessionFactory;
           }
	
	@Override
	public void addProjectDao(ActivityBean PB) {
            try{
	    Session session1 = sessionFactory.getCurrentSession();
            Transaction tx = null;
	    tx = session1.beginTransaction();
	    session1.save(PB );
	    tx.commit();
            System.out.println("Project created successfully");
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
      }

	
	@Override
	public List<ActivityBean> getAllProjects(int userid, String role) {
		
            Session session1 = sessionFactory.getCurrentSession();
	    List <ActivityBean> allProjects=new ArrayList<>();
            List<ActivityTransactionBean> PTbeanList=new ArrayList<>();
            Transaction tx = null;
	    tx = session1.beginTransaction();
            
            if (role.equalsIgnoreCase("Manager")||role.equalsIgnoreCase("Admin")||role.equalsIgnoreCase("scheduling"))
            {
             Criteria criteria = session1.createCriteria(ActivityBean.class);
             allProjects= criteria.list();
            }
            else if(role.equalsIgnoreCase("Lead"))
            {
            Criteria criteria = session1.createCriteria(ActivityBean.class);    
            criteria.add(Restrictions.eq("leadid", userid));
            allProjects= criteria.list();
            }   
            else if(role.equalsIgnoreCase("Engineer"))
            {
                       
            Query query1 = session1.createQuery("from ActivityTransactionBean where userid=? group by activityid");
            query1.setParameter(0, userid);
            
            PTbeanList=(List<ActivityTransactionBean>) query1.list();
        
            for(ActivityTransactionBean PTB:PTbeanList)
            {
            Criteria criteria2 = session1.createCriteria(ActivityBean.class); 
            criteria2.add(Restrictions.eq("activityid", PTB.getActivityid()));
            ActivityBean PB=(ActivityBean)criteria2.uniqueResult();
            allProjects.add(PB);
            }
            
            }
            
	    tx.commit();
	    return allProjects;
        }
        
        @Override
        public ActivityBean getProjectById(int id) {
	   Transaction tx = null;
	   Session session1 = sessionFactory.getCurrentSession();
           tx = session1.beginTransaction();
           String SQL_QUERY1= "from ActivityBean as O where O.activityid=?";
           Query query1 = session1.createQuery(SQL_QUERY1);
           query1.setParameter(0,id);
           List list1 = query1.list();       
           ActivityBean PB = (ActivityBean) list1.get(0);
           tx.commit();
        
           return PB;
      }

    @Override
    public void insertProjectTransaction(List <ActivityTransactionBean> PTBList){
        
        for(ActivityTransactionBean PTBean : PTBList){
                Session session1 = sessionFactory.getCurrentSession();
		Transaction tx = null;
	        tx = session1.beginTransaction();
	        session1.save(PTBean);
	        tx.commit();
		System.out.println("Project transaction updated successfully");
        }
        
    }
    
    
 
    
    
        @Override
       public List<ActivityTransactionBean> getProjectTransaction(int projectid){
        
           List<ActivityTransactionBean> PList;
           Transaction tx = null;
	   Session session1 = sessionFactory.getCurrentSession();
           tx = session1.beginTransaction();
           Criteria criteria = session1.createCriteria(ActivityTransactionBean.class);
           criteria.add(Restrictions.eq("activityid", projectid));
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
            
               
               ActivityTransactionBean PTBean=this.getTransactionOnTransID(transid);
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
            String sql = "UPDATE activity_transaction SET status=? WHERE activityid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,"Completed");
            query.setParameter(1,projid);
            query.executeUpdate();
            tx.commit();
            return true;
       }
       
       @Override
       public ActivityTransactionBean getTransactionOnTransID(int transid){
           List<ActivityTransactionBean> PList;
            Transaction tx = null;
            Session session1 = sessionFactory.getCurrentSession();
            tx = session1.beginTransaction();
            Criteria criteria = session1.createCriteria(ActivityTransactionBean.class);
            criteria.add(Restrictions.eq("transid", transid));
//          criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            PList = criteria.list();
            tx.commit();
            
            if(PList.size()==1){
            ActivityTransactionBean PTB = PList.get(0);
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
            String sql = "UPDATE activity SET status=? WHERE activityid=?";
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
    public void updateProjectTransaction(List <ActivityTransactionBean> PTBList){
        
        for(ActivityTransactionBean PTBean : PTBList){
                Session session1 = sessionFactory.getCurrentSession();
		Transaction tx = null;
	        tx = session1.beginTransaction();
                
                String sql = "UPDATE activity_transaction SET taskstartdate=?, taskenddate=?, taskhours=?,taskdays=?, status=? , startdate = ?, enddate=? WHERE transid=?";
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
            String sql = "delete p.*, pt.* from activity p left join activity_transaction pt on p.activityid=pt.activityid where p.activityid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            query.executeUpdate();
            return true;
        }
        
        
      
        @Override
	public boolean allocateResource(AllocationBean AB) {
		
	Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = null;
	tx = session1.beginTransaction();
	session1.save(AB);
	tx.commit();
	System.out.println("Resource "+AB.getEngineerId()+" allocated successfully");
        return true;
	}
   


}