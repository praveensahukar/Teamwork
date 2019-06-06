/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.DAO.ProjectDAO;
import com.Paladion.teamwork.beans.ProjectBean;
import java.util.List;
import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.ProjectOPIDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Santhosh
 */
public class ProjectServiceImpl  implements ProjectService {

    @Autowired
    @Qualifier(value="ProjectDAO")
    ProjectDAO PD;
    
    @Override
    public void addProject(ProjectBean pb) {
        
       
       
       PD.addProjectDao(pb);
    }

    @Override
    public void editProject(ProjectBean pb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProjectBean> getAllProjects() {
        return PD.getAllProject();
         }

    @Override
    public boolean deleteProject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
      @Override
        public ProjectBean getProjectDeatails( int pid){
        return PD.getProjectDetails(pid);
   }
    
    @Override
        public List<ActivityBean> getProjectActivities(int pid){
        return PD.getProjectActivities(pid);
    }
    
    @Override
    public boolean updateProjectDetails(ProjectBean PB){
        return PD.updateProjectDetails(PB);
    }
    
    @Override
    public List<ProjectOPIDMapper> getProjectOPID(int pid){
        return PD.getProjectOPID(pid);
    }
    
  
    
}
