/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.ActivityTransactionBean;
import com.Paladion.teamwork.beans.UserDataBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class UserDAOImpl implements UserDAO{

    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	
    @Override
    public boolean addUser(UserDataBean userBean) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(userBean);
            System.out.println("User added succefully ");
            tx.commit();
            return true;
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return false;
        }
        finally{
            if(session.isOpen()){
            System.out.println("---------Closing session----------");
            session.close();
            }
        }
    }
        
    //@Override
    public List getAvailableEngineers2(Date projStartDate, Date projEndDate){
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
	try{	
            String SQL_QUERY1= "select distinct userid from ActivityTransactionBean PB where PB.taskenddate > :projstartdate and PB.taskstartdate < :projenddate";
            Query query = session1.createQuery(SQL_QUERY1);
            query.setParameter("projstartdate",projStartDate);
            query.setParameter("projenddate",projEndDate);
	    List list2 = query.list();
            tx.commit();
            return list2;
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("---------Closing session------------");
            session1.close();
            }
        }
    }
    
    
    
    @Override
    public List getAvailableEngineers(Date projStartDate, Date projEndDate){
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
	try{	
            String SQL_QUERY1= "select distinct engineerId from AllocationBean AB where AB.allocationEndenddate > :projstartdate and AB.allocationStartdate < :projenddate";
            Query query = session1.createQuery(SQL_QUERY1);
            query.setParameter("projstartdate",projStartDate);
            query.setParameter("projenddate",projEndDate);
	    List list2 = query.list();
            tx.commit();
            return list2;
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("---------Closing session------------");
            session1.close();
            }
        }
    }
    

        
        
//      Unused Code  
//	
//	@Override
//	public List<UserDataBean> getUsersByRole(String role)
//	{
//		List<UserDataBean> UserList=new ArrayList<UserDataBean>();
//		UserDataBean ubean=new UserDataBean();
//		
//		Session session1 = sessionFactory.getCurrentSession();
//		Transaction tx;
//		tx = session1.beginTransaction();
//		
//		System.out.println("Get Users by Role UserDAO");
//	        String SQL_QUERY1= "from UserDataBean where role=?";
//                Query query2 = session1.createQuery(SQL_QUERY1);
//	        query2.setParameter(0,role);
//         
//                List list2 = query2.list();
//	        tx.commit();
//	        System.out.println("Query executed :)");
//	        Iterator it= list2.iterator();
//                    while(it.hasNext())
//                      {
//		           ubean=(UserDataBean) it.next();
//                           System.out.print("\nUser retrived from DB based on Role: "+role+" User name: "+ubean.getUsername());
//	                   UserList.add(ubean);
//                      }
//		
//	           return UserList;	
//	}
        
  
    @Override
    public List<UserDataBean> GetAllUser(){
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        try{        
            String SQL_QUERY1= "from UserDataBean";
            Query query2 = session1.createQuery(SQL_QUERY1);
	    List<UserDataBean> UserList = query2.list();
            tx.commit();
            return UserList;	
	}
        catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("-----------Closing session-------------");
            session1.close();
            }
        }
    }
        
        
    @Override
    public boolean DeleteUser(int id){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "update users set status = \"Inactive\" where userid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            query.executeUpdate();
            tx.commit();
            return true;	
	}catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return false;
        }
        finally{
            if(session.isOpen()){
            System.out.println("--------Closing session----------");
            session.close();
            }
        }
    }
        
        
    @Override
    public boolean UpdateUserDetails(UserDataBean UB){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "UPDATE users SET username=?,email=?,team=?,phone=?,role=?, status=? WHERE userid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,UB.getUsername());
            query.setParameter(1,UB.getEmail());
            query.setParameter(2,UB.getTeam());
            query.setParameter(3,UB.getPhone());
            query.setParameter(4,UB.getRole());
            query.setParameter(5,UB.getStatus());
            query.setParameter(6,UB.getUserid());
            query.executeUpdate();
            tx.commit();
            return true;
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return false;
        }
        finally{
            if(session.isOpen()){
            System.out.println("-----------Closing session------------");
            session.close();
            }
        }
    }
        
    @Override
    public UserDataBean GetUserById(int id){
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{ 
            UserDataBean ubean=new UserDataBean();
            String SQL_QUERY1= "from UserDataBean where userid=?";
            Query query2 = session1.createQuery(SQL_QUERY1);
            query2.setParameter(0, id);
	    List list2 = query2.list();
            Iterator it= list2.iterator();
                while(it.hasNext()){
                     ubean=(UserDataBean)it.next();
                }
            tx.commit();
            return ubean;       
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("----------Closing session------------");
            session1.close();
            }
        }
    }
        
    public List<UserDataBean> GetUsersByRole(String role){
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
            try{
                List<UserDataBean> UserList=new ArrayList<UserDataBean>();
                Criteria criteria = session1.createCriteria(UserDataBean.class);
                criteria.add(Restrictions.eq("role", role));
                criteria.add(Restrictions.eq("status", "Active"));
                UserList = criteria.list();
                tx.commit();
                return UserList;
            }
            catch(Exception e){
                System.out.println("Exception occured. "+e.getMessage());
                return null;
            }
            finally{
                if(session1.isOpen()){
                System.out.println("-----------------Closing session---------------");
                session1.close();
                }
            }
    }
}

    

