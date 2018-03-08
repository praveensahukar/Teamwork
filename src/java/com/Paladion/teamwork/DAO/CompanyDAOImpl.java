/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.CompanyBean;
import java.util.ArrayList;
import java.util.Iterator;
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
	Transaction tx = null;
	tx = session1.beginTransaction();
	session1.save(CB);
	tx.commit();
	
	System.out.println("Company create successfully");
	}
	
    @Override
	public List<CompanyBean> getAllCompany()
	{
	List <CompanyBean> Companylist=new ArrayList<CompanyBean>();
	Session session=sessionFactory.openSession();
        String companyquery= "from CompanyBean";
        System.out.println("Get all company query");
        Query query2 = session.createQuery(companyquery);
       
        Companylist= query2.list();
        return Companylist;
        }
        
        
            @Override
	public boolean deleteCompany(int id)
	{
            Session session = this.sessionFactory.openSession();
            String sql = "delete from company where companyid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            query.executeUpdate();
            return true;
        }
        
        @Override
        public CompanyBean getCompanyByID(int id){
         
           List<CompanyBean> CList;
          
           Transaction tx = null;
	   Session session1 = sessionFactory.getCurrentSession();
           tx = session1.beginTransaction();
           Criteria criteria = session1.createCriteria(CompanyBean.class);
           criteria.add(Restrictions.eq("companyid", id));
           CList = criteria.list();
           tx.commit();
           CompanyBean CB = (CompanyBean) CList.get(0);
           return CB;       
          }
  
}
