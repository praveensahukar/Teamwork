/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.MapTemplateTaskBean;
import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.ActivityTransactionBean;
import com.Paladion.teamwork.beans.AllocationBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
public interface ActivityService {
    
    public void addProject(ActivityBean pb);
    public List<ActivityBean> getAllProjects(int userid, String role);
    public ActivityBean getProjectById(int id);
    public void insertProjectTransaction(ActivityTransactionBean PTB);
    public List<ActivityTransactionBean> getProjectTransaction(int projectid);
    public boolean updateTaskStatus(int transid, String status);
    public boolean updateTaskStatus(int projid);
    public boolean updateProjectStatus(int projid, String status);
    public void updateProjectTransaction(List<ActivityTransactionBean>PTBList);
    public int[] getProjectsCount(HttpServletRequest req);
    public boolean deleteProject(int projid);
    public ActivityTransactionBean getTransactionOnTransID(int Transid);
    public boolean allocateResource(AllocationBean AB);
    public List<ActivityBean> getUpcomingActivities();
    public void checkTaskStatusOnhold();
    
}

