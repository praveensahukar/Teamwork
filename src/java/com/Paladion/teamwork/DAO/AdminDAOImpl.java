/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.SystemBean;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Lenovo
 */
public class AdminDAOImpl implements AdminDAO{
    
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    static Logger log = Logger.getLogger(ActivityDAOImpl.class.getName());

    @Override
    @SuppressWarnings("empty-statement")
    public boolean SaveSettings(SystemBean SysModel) {
    Session session=sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
        try{
        session.update(SysModel);
        tx.commit();
        return true;
        }
        catch(Exception ex){
            tx.rollback();
            log.error("Expection occured : "+ex.getMessage());
            return false;
        }
        finally{
            if(session.isOpen()){
            session.close();
            }
        }
    }

    @Override
    public SystemBean getSystemSettings() {
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
	try{   
        Criteria criteria = session1.createCriteria(SystemBean.class);    
        SystemBean settings=(SystemBean) criteria.uniqueResult();
        tx.commit();
        return settings;
        }
        catch(Exception ex){
            tx.rollback();
            log.error("Expection occured : "+ex.getMessage());
            return null;
        }
        finally{
            if(session1.isOpen()){
            session1.close();
            }
        }
            
    }
    
}
