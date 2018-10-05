/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.ProjectBean;
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
    public class ProjectDAOImpl implements ProjectDAO {
        
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
        @Override
	public void addProjectDao(ProjectBean PB) {
	Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
            try{
            session1.save(PB);
            tx.commit();
            System.out.println("Project create successfully");
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
	}

    @Override
    public List<ProjectBean> getAllProject() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <ProjectBean> Projectlist=new ArrayList<ProjectBean>();
            String projectquery= "from ProjectBean";
            System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Projectlist= query2.list();
            tx.commit();
            return Projectlist;
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
    public List<ActivityBean> getProjectActivities(int pid) {
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{
        Criteria criteria = session1.createCriteria(ActivityBean.class);
        criteria.add(Restrictions.eq("projectid", pid));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	List<ActivityBean> AList = criteria.list();
        tx.commit();
        return AList;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("-------------Closing session--------------");
            session1.close();
            }
        }
    }
    

    @Override
    public boolean deleteProject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ProjectBean getProjectDetails(int projectid){
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{
        Criteria criteria = session1.createCriteria(ProjectBean.class);
        criteria.add(Restrictions.eq("projectid", projectid));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	List<ProjectBean> PList = criteria.list();
        tx.commit();
            if(1 == PList.size()){
            Iterator iter = PList.iterator();
            return (ProjectBean)iter.next();
            }
            return null;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("-------------Closing session--------------");
            session1.close();
            }
        }
    }
    
    
    @Override
    public boolean updateProjectDetails(ProjectBean PB){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "UPDATE projects SET companyid=?,opid=?,deliverymanager=?,projectmanager=?,description=?,region=?,projectname=?,revenue=? WHERE projectid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,PB.getCompanyid());
            query.setParameter(1,PB.getOpid());
            query.setParameter(2,PB.getDeliverymanager());
            query.setParameter(3,PB.getProjectmanager());
            query.setParameter(4,PB.getDescription());
            query.setParameter(5,PB.getRegion());
            query.setParameter(6,PB.getProjectname());
            query.setParameter(7,PB.getRevenue());
            query.setParameter(8,PB.getProjectid());
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
    
}
