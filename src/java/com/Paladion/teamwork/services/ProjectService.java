/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.ProjectOPIDMapper;
import com.Paladion.teamwork.beans.TaskBean;
import java.util.List;

/**
 *
 * @author Santhosh
 */
public interface ProjectService {
    public void addProject(ProjectBean pb);
    public void editProject(ProjectBean pb);
    public List<ProjectBean> getAllProjects();
    public boolean deleteProject(int id);
    //public ProjectBean getProjectOPID(int pid);
    public List<ActivityBean> getProjectActivities(int pid);
    public ProjectBean getProjectDeatails(int pid);
    public boolean updateProjectDetails(ProjectBean PB);
    public List<ProjectOPIDMapper> getProjectOPID(int pid);
 //   public boolean addOPID(ProjectOPIDMapper opid);
}
