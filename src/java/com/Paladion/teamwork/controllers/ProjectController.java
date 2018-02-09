/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.controllers;

import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.services.AdminService;
import com.Paladion.teamwork.services.CompanyService;
import com.Paladion.teamwork.utils.CommonUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Santhosh
 */

@Controller
public class ProjectController {
    
//    @InitBinder("ProjectM")
//    protected void initProjectBeanBinder(WebDataBinder binder) {
//    binder.addValidators(projectBeanValidator);
//    } 

//    public void setCservice(CompanyService Cservice) {
//    this.Cservice = Cservice;
//    }
  
    @Autowired
    @Qualifier(value="CompanyService")
    CompanyService CS;
    
    @Autowired
    @Qualifier(value = "CommonUtil")
    CommonUtil CU;
  
    @ModelAttribute("ProjectM")
    public ProjectBean populate()
    {
        return new ProjectBean();
    }

    @RequestMapping(value="/CreateProject",method=RequestMethod.GET)
    public ModelAndView CreateProject(HttpServletRequest req)
    {   
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        HttpSession sess=req.getSession(false);
	ModelAndView model=new ModelAndView("CreateProject");
	try{
              model.addObject("AllCompany", CS.getAllCompany());
              model.addObject("AllDManagers", CU.getUsersByRole("manager",sess));
              model.addObject("AllPManagers", CU.getUsersByRole("manager",sess));
	}
        catch(Exception ex){}
	return model;
        
    }



























}
