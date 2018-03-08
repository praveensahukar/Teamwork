/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.TeamBean;
import java.util.ArrayList;
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
 * @author santosh.babar
 */
public class TeamDAOImpl implements TeamDAO{
    
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	
	
	@Override
	public void addTeamDao(TeamBean TB) {
		
	Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = null;
	tx = session1.beginTransaction();
	session1.save(TB);
	tx.commit();
	
	System.out.println("Team create successfully");
	}
	
    @Override
	public List<TeamBean> getAllTeams()
	{
	List <TeamBean> Teamlist=new ArrayList<TeamBean>();
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String teamquery= "from TeamBean";
            System.out.println("Get all teams query");
            Query query2 = session.createQuery(teamquery);
            Teamlist= query2.list();
            tx.commit();
            //  session.refresh(TeamBean.class);
            System.out.println(Teamlist.size());
            return Teamlist;
        }
        catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            return null;
            }
            finally{
            if(session.isOpen()){
            System.out.println("-----------Closing session---------------");
            session.close();
            }
            }
        }
        
        
        @Override
	public boolean deleteTeam(int id)
	{
            Session session = this.sessionFactory.openSession();
            String sql = "delete from teams where teamid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            query.executeUpdate();
	return true;
        }
  
    
}
