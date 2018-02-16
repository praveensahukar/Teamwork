/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.ProjectBean;
import java.util.List;

/**
 *
 * @author Santhosh
 */
public interface ProjectDAO {
    public void addProjectDao(ProjectBean tb);
    public List<ProjectBean> getAllProject();
    public boolean deleteProject(int id);
}
