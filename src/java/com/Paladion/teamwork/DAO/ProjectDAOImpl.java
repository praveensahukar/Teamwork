/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.ProjectBean;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	Transaction tx = null;
	tx = session1.beginTransaction();
	session1.save(PB);
	tx.commit();
	
	System.out.println("Project create successfully");
	}

    @Override
    public List<ProjectBean> getAllProject() {
    
    List <ProjectBean> Projectlist=new ArrayList<ProjectBean>();
	 Session session=sessionFactory.openSession();
        String projectquery= "from ProjectBean";
        System.out.println("Get all projects query");
        Query query2 = session.createQuery(projectquery);
       
        Projectlist= query2.list();
        return Projectlist;
    }

    @Override
    public boolean deleteProject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
