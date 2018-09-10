/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.MapTemplateTaskBean;
import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.ActivityTransactionBean;
import com.Paladion.teamwork.beans.UserDataBean;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import com.Paladion.teamwork.DAO.ActivityDAO;
import com.Paladion.teamwork.beans.AllocationBean;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Santosh Babar
 */
public class ActivityServiceImpl implements ActivityService {

@Autowired
@Qualifier(value="ActivityDAO")
ActivityDAO PD;
	
    @Override
    public void addProject(ActivityBean pb) {   
	PD.addProjectDao(pb);
    }

    @Override
    public List<ActivityBean> getAllProjects(int userid, String role) {
        return PD.getAllProjects(userid, role);
    }

    @Override
    public ActivityBean getProjectById(int id) {
        return PD.getProjectById(id); 
    }
    
    @Override
    public void insertProjectTransaction(ActivityTransactionBean PTB) {
        PD.insertProjectTransaction(PTB); 
    }
    
    @Override
    public List<ActivityTransactionBean> getProjectTransaction(int projectid) {
        return PD.getProjectTransaction(projectid);
    }
    
    @Override
    public boolean updateTaskStatus(int transid, String status) {
        return PD.updateTaskStatus(transid, status);
    }
    
    @Override
    public boolean updateTaskStatus(int projid) {
        return PD.updateTaskStatus(projid);
    }
    
    @Override
    public boolean deleteProject(int projid) {
        return PD.deleteProject(projid);
    }
    
    @Override
    public boolean updateProjectStatus(int projid, String status) {
        return PD.updateProjectStatus(projid, status);
    }
    
    @Override
    public ActivityTransactionBean getTransactionOnTransID(int transid){
        return PD.getTransactionOnTransID(transid);
    }
    
    @Override
    public void updateProjectTransaction(List<ActivityTransactionBean> PTBList){
        PD.updateProjectTransaction(PTBList);
    }

    @Override
    public int[] getProjectsCount(javax.servlet.http.HttpServletRequest req) {
        HttpSession sess= req.getSession(false);
        UserDataBean sessuser=(UserDataBean) sess.getAttribute("Luser");
	ModelAndView result=new ModelAndView("Welcome");
        List<ActivityBean> PBList=(List<ActivityBean>)this.getAllProjects(sessuser.getUserid(), sessuser.getRole());
     
        int total_projects=PBList.size();
        int project_new=0;
        int project_progress=0;
        int project_completed=0;
        int on_hold=0;
        for(ActivityBean PB:PBList){
            if(PB.getStatus().equalsIgnoreCase("new")){
                project_new++;
            }
            if(PB.getStatus().equalsIgnoreCase("progress")){
                project_progress++;
            }
            if(PB.getStatus().equalsIgnoreCase("completed")){
                project_completed++;
            }
            if(PB.getStatus().equalsIgnoreCase("on hold")){
                on_hold++;
            }
        }
        System.out.println("No of completed projects : "+project_completed);
        System.out.println("No of on going projects : "+project_progress);
        System.out.println("No of new projects : "+project_new);
        int [] counts = new int[5];
        counts[0]=total_projects;
        counts[1]=project_completed;
        counts[2]=project_progress;
        counts[3]=project_new;
        counts[4]=on_hold;
        return counts;
    }
    
   @Override
    public boolean allocateResource(AllocationBean AB) {
          return PD.allocateResource(AB);  
    }
    
    @Override
    public List<ActivityBean> getUpcomingActivities() {
        Date today = new Date();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        Date maxDate;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        
        if(day == 6){          
        maxDate = new Date(today.getTime() + TimeUnit.DAYS.toMillis(4));
        }
        else{
        maxDate = new Date(today.getTime() + TimeUnit.DAYS.toMillis(2));
        }
        return PD.getUpcomingActivities(today, maxDate);  
    }
    
    @Override
    public void checkTaskStatusOnhold() {
           PD.checkTaskStatusOnhold();  
    }
    
	
}
