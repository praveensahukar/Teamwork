/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.MapTemplateTaskBean;
import com.Paladion.teamwork.beans.ActivityTransactionBean;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ActivityDAO {
   public void addProjectDao(ActivityBean pb);
   
   public List<ActivityBean> getAllProjects(int userid, String role);

    public ActivityBean getProjectById(int id);
    public void insertProjectTransaction(List<ActivityTransactionBean> PTBList);
    public List<ActivityTransactionBean> getProjectTransaction(int projectid);
    public boolean updateTaskStatus(int transid, String status);
    
     public boolean updateProjectStatus(int projid, String status);
      public boolean updateTaskStatus(int projid);
       public boolean deleteProject(int projid);
      public void updateProjectTransaction(List<ActivityTransactionBean>PTBList);
      public ActivityTransactionBean getTransactionOnTransID(int transid);
     
    
}
