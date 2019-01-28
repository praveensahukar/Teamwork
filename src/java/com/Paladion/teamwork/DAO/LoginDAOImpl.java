/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;
import com.Paladion.teamwork.beans.UserDataBean;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Administrator
 */
public class LoginDAOImpl implements LoginDAO{
    
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserDataBean Login(UserDataBean LB) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
        UserDataBean SessUserBean=null;
        System.out.println("Inside LoginDao");
        String SQL_QUERY1 ="from UserDataBean as o where o.email=? and o.password=?";
        Query query1 = session.createQuery(SQL_QUERY1);
        query1.setParameter(0,LB.getEmail());
        query1.setParameter(1,LB.getPassword());
        List list1=query1.list();
        Iterator it= list1.iterator();
            while(it.hasNext()){
            SessUserBean=(UserDataBean) it.next();
            }
            if ((list1 != null) && (list1.size() > 0)){
            return SessUserBean;
            }
            else{
            return null;
            }            
        }
        catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                return null;
            }finally{
                if(session.isOpen()){
                System.out.println("-------------Closing session--------------");
                session.close();
                }
            }
        }
    }  
              
    
        
    

