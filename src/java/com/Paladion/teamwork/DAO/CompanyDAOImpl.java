/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.CompanyBean;
import java.util.ArrayList;
import java.util.List;
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
 * @author Santhosh
 */
public class CompanyDAOImpl implements CompanyDAO{
    
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addCompanyDao(CompanyBean CB) {
		
	Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        try{
	session1.save(CB);
	tx.commit();
	System.out.println("Company create successfully");
        }
        catch(Exception ex){
            tx.rollback();
            System.out.println("Error Occured : "+ex.getMessage());
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
	public List<CompanyBean> getAllCompany(){
        Session session=sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
            try{
            List <CompanyBean> Companylist=new ArrayList<CompanyBean>();
            String companyquery= "from CompanyBean";
            System.out.println("Get all company query");
            Query query2 = session.createQuery(companyquery);
            Companylist= query2.list();
            tx.commit();
            return Companylist;
            }
            catch(Exception ex){
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
	public boolean deleteCompany(int id)
	{
            Session session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            try{
            String sql = "delete from company where companyid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            query.executeUpdate();
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
        public CompanyBean getCompanyByID(int id){
         
            Session session1 = sessionFactory.getCurrentSession();
            Transaction tx = session1.beginTransaction();
            try{
            Criteria criteria = session1.createCriteria(CompanyBean.class);
            criteria.add(Restrictions.eq("companyid", id));
            List<CompanyBean> CList = criteria.list();
            tx.commit();
            CompanyBean CB = (CompanyBean) CList.get(0);
            return CB;
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                return null;
            }
            finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
          }
  
}
