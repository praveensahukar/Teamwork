/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.AppSecScheduleRequestBean;
import com.Paladion.teamwork.beans.CodeReviewScheduleRequestBean;
import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.ProjectScheduleRequestBean;
import com.Paladion.teamwork.beans.Vehiclebean;
import com.Paladion.teamwork.beans.eptScheduleRequestBean;
import com.Paladion.teamwork.beans.iptScheduleRequestBean;
import com.Paladion.teamwork.beans.vascanScheduleRequestBean;
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
 * @author santosh.babar
 */
public class ScheduleDAOImpl implements ScheduleDAO{
    
    @Autowired
    @Qualifier(value="hibernate4AnnotatedSessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCodeReviewActvitiy(CodeReviewScheduleRequestBean CRSRB) {
        
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(CRSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void saveAppSecActivity(AppSecScheduleRequestBean ASSRB) {
        
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(ASSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void EPTActivity(eptScheduleRequestBean EPTSRB) {
       Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(EPTSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void IPTActivity(iptScheduleRequestBean IPTSRB) {
            Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(IPTSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void VAscanActivity(vascanScheduleRequestBean VAscanSRB) {
           Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(VAscanSRB);
            System.out.println("Code review activity added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public void saveprojschedule(ProjectScheduleRequestBean Projschedule) {
        Session session1 = sessionFactory.getCurrentSession();
	Transaction tx = session1.beginTransaction();
        
           try{
            session1.save(Projschedule);
            System.out.println("project schedule added successfully");
            tx.commit();
            }
            catch(Exception ex){
                tx.rollback();
                System.out.println("Error Occured : "+ex.getMessage());
                ex.printStackTrace();
                return;
            }finally{
                if(session1.isOpen()){
                System.out.println("-------------Closing session--------------");
                session1.close();
                }
            }
    }

    @Override
    public List<CodeReviewScheduleRequestBean> getAllCodereview() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <CodeReviewScheduleRequestBean> Codereviewlist=new ArrayList<CodeReviewScheduleRequestBean>();
            String projectquery= "from CodeReviewScheduleRequestBean";
            //System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Codereviewlist= query2.list();
            tx.commit();
            return Codereviewlist;
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
    public List<AppSecScheduleRequestBean> getAllAppsec() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <AppSecScheduleRequestBean> Codereviewlist=new ArrayList<AppSecScheduleRequestBean>();
            String projectquery= "from AppSecScheduleRequestBean";
            //System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Codereviewlist= query2.list();
            tx.commit();
            return Codereviewlist;
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
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<eptScheduleRequestBean> getAllEpt() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <eptScheduleRequestBean> Eptlist=new ArrayList<eptScheduleRequestBean>();
            String projectquery= "from eptScheduleRequestBean";
            //System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Eptlist= query2.list();
            tx.commit();
            return Eptlist;
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
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<iptScheduleRequestBean> getAllIpt() {
        Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <iptScheduleRequestBean> Iptlist=new ArrayList<iptScheduleRequestBean>();
            String projectquery= "from iptScheduleRequestBean";
            //System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Iptlist= query2.list();
            tx.commit();
            return Iptlist;
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
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<vascanScheduleRequestBean> GetAllVascan() {
       Session session=sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            List <vascanScheduleRequestBean> Vascanlist=new ArrayList<vascanScheduleRequestBean>();
            String projectquery= "from vascanScheduleRequestBean";
            //System.out.println("Get all projects query");
            Query query2 = session.createQuery(projectquery);
            Vascanlist= query2.list();
            tx.commit();
            return Vascanlist;
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
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CodeReviewScheduleRequestBean EditCodereviewDetails(int crid) {
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{ 
            CodeReviewScheduleRequestBean CRbean=new CodeReviewScheduleRequestBean();
            String SQL_QUERY1= "from CodeReviewScheduleRequestBean where cr_scheduleid=?";
            Query query2 = session1.createQuery(SQL_QUERY1);
            query2.setParameter(0, crid);
	    List list2 = query2.list();
            Iterator it= list2.iterator();
                while(it.hasNext()){
                     CRbean=(CodeReviewScheduleRequestBean)it.next();
                }
            tx.commit();
            return CRbean;       
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("----------Closing session------------");
            session1.close();
            }
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteRequest(int id) {
               Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "delete from codereviewschedulereq where cr_scheduleid=?";
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
    public void UpdateCodeReviewActivity(CodeReviewScheduleRequestBean crBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "UPDATE codereviewschedulereq SET prefstartdate=?,technology=?,appname=?,scope=? where cr_scheduleid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,crBean.getPrefstartdate());
            query.setParameter(1,crBean.getTechnology());
            query.setParameter(2,crBean.getAppname());
           query.setParameter(3,crBean.getScope());
           query.setParameter(4,crBean.getCr_scheduleid());
            query.executeUpdate();
            tx.commit();
  
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
 
        }
        finally{
            if(session.isOpen()){
            System.out.println("-----------Closing session------------");
            session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteAppRequest(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "delete from appsecschedulereq where as_scheduleid=?";
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
        } //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public AppSecScheduleRequestBean EditAppSecDetails(int asid) {
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{ 
            AppSecScheduleRequestBean ASbean=new AppSecScheduleRequestBean();
            String SQL_QUERY1= "from AppSecScheduleRequestBean where as_scheduleid=?";
            Query query2 = session1.createQuery(SQL_QUERY1);
            query2.setParameter(0, asid);
	    List list2 = query2.list();
            Iterator it= list2.iterator();
                while(it.hasNext()){
                     ASbean=(AppSecScheduleRequestBean)it.next();
                }
            tx.commit();
            return ASbean;       
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("----------Closing session------------");
            session1.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteEptRequest(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "delete from eptschedulereq where ept_scheduleid=?";
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
        } //To change body of generated methods, choose Tools | Templates.
 //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteIptRequest(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "delete from iptschedulereq where ipt_scheduleid=?";
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
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteVascanRequest(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "delete from vascanschedulereq where va_scheduleid=?";
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
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public eptScheduleRequestBean EditEptDetails(int eptid) {
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{ 
            eptScheduleRequestBean EPTbean=new eptScheduleRequestBean();
            String SQL_QUERY1= "from eptScheduleRequestBean where ept_scheduleid=?";
            Query query2 = session1.createQuery(SQL_QUERY1);
            query2.setParameter(0, eptid);
	    List list2 = query2.list();
            Iterator it= list2.iterator();
                while(it.hasNext()){
                     EPTbean=(eptScheduleRequestBean)it.next();
                }
            tx.commit();
            return EPTbean;       
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("----------Closing session------------");
            session1.close();
            }
         //To change body of generated methods, choose Tools | Templates.
    }
}

    @Override
    public iptScheduleRequestBean EditIptDetails(int iptid) {
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{ 
            iptScheduleRequestBean IPTbean=new iptScheduleRequestBean();
            String SQL_QUERY1= "from iptScheduleRequestBean where ipt_scheduleid=?";
            Query query2 = session1.createQuery(SQL_QUERY1);
            query2.setParameter(0, iptid);
	    List list2 = query2.list();
            Iterator it= list2.iterator();
                while(it.hasNext()){
                     IPTbean=(iptScheduleRequestBean)it.next();
                }
            tx.commit();
            return IPTbean;       
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("----------Closing session------------");
            session1.close();
            }
         //To change body of generated methods, choose Tools | Templates.
    } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public vascanScheduleRequestBean EditVascanDetails(int vascanid) {
        Session session1 = sessionFactory.getCurrentSession();
        Transaction tx = session1.beginTransaction();
        try{ 
            vascanScheduleRequestBean VAscanBean=new vascanScheduleRequestBean();
            String SQL_QUERY1= "from vascanScheduleRequestBean where va_scheduleid=?";
            Query query2 = session1.createQuery(SQL_QUERY1);
            query2.setParameter(0, vascanid);
	    List list2 = query2.list();
            Iterator it= list2.iterator();
                while(it.hasNext()){
                     VAscanBean=(vascanScheduleRequestBean)it.next();
                }
            tx.commit();
            return VAscanBean;       
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        return null;
        }
        finally{
            if(session1.isOpen()){
            System.out.println("----------Closing session------------");
            session1.close();
            }
         //To change body of generated methods, choose Tools | Templates.
    } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateAppsecActivity(AppSecScheduleRequestBean ASBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "UPDATE appsecschedulereq SET prefstartdate=?,hosting=?,appname=?,scope=? where as_scheduleid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,ASBean.getPrefstartdate());
            query.setParameter(1,ASBean.getHosting());
            query.setParameter(2,ASBean.getAppname());
           query.setParameter(3,ASBean.getScope());
           query.setParameter(4,ASBean.getAs_scheduleid());
            query.executeUpdate();
            tx.commit();
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        }
        finally{
            if(session.isOpen()){
            System.out.println("-----------Closing session------------");
            session.close();
            }
        }
    }

    @Override
    public void UpdateCodeReviewActivity1(CodeReviewScheduleRequestBean crBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "UPDATE codereviewschedulereq SET status=? where cr_scheduleid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,crBean.getStatus());
            
           query.setParameter(1,crBean.getCr_scheduleid());
            query.executeUpdate();
            tx.commit();
  
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
 
        }
        finally{
            if(session.isOpen()){
            System.out.println("-----------Closing session------------");
            session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateEptActivity(eptScheduleRequestBean EPTBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "UPDATE eptschedulereq SET prefstartdate=?,hosting=?,whitelistconf=?,timewindow=?,domain=?,ipproposal=? where ept_scheduleid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,EPTBean.getPrefstartdate());
            query.setParameter(1,EPTBean.getHosting());
            query.setParameter(2,EPTBean.getWhitelistconf());
           query.setParameter(3,EPTBean.getDomain());
           query.setParameter(4,EPTBean.getTimewindow());
           query.setParameter(5,EPTBean.getIpproposal());
           query.setParameter(6,EPTBean.getEpt_scheduleid());
            query.executeUpdate();
            tx.commit();
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        }
        finally{
            if(session.isOpen()){
            System.out.println("-----------Closing session------------");
            session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateAppsecActivity1(AppSecScheduleRequestBean ASBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "UPDATE appsecschedulereq SET status=? where as_scheduleid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,ASBean.getStatus());
            
           query.setParameter(1,ASBean.getAs_scheduleid());
            query.executeUpdate();
            tx.commit();
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        }
        finally{
            if(session.isOpen()){
            System.out.println("-----------Closing session------------");
            session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateEptActivity1(eptScheduleRequestBean EPTBean) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String sql = "UPDATE eptschedulereq SET status=? where ept_scheduleid=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0,EPTBean.getStatus());
            
           query.setParameter(1,EPTBean.getEpt_scheduleid());
            query.executeUpdate();
            tx.commit();
        }catch(Exception e){
        System.out.println("Exception occured. "+e.getMessage());
        }
        finally{
            if(session.isOpen()){
            System.out.println("-----------Closing session------------");
            session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }
}
