/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.controllers;

import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.TaskBean;
import com.Paladion.teamwork.services.CompanyService;
import com.Paladion.teamwork.services.ProjectService;
import com.Paladion.teamwork.utils.CommonUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    @Qualifier(value="ProjectService")
    ProjectService PS;
    
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


    @RequestMapping(value="/CreateProject",method=RequestMethod.POST)
    public ModelAndView CreateCompany(@ModelAttribute("ProjectM")@Validated ProjectBean PB,BindingResult result,HttpServletRequest req) 
    {
        String[] authorizedRoles = {"admin","manager","lead"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        if (result.hasErrors()) {
            //validates the user input, this is server side validation
            System.out.println("error!!!!!!!!");
            return new ModelAndView("CreateCompany");
        }
        
	System.out.println("\n inside create company method ");
        PB.getRevenue();
	PS.addProject(PB);
	System.out.println("Project Created with projectid "+PB.getProjectid());
	return new ModelAndView( "CreateProject","Message","Project Created Successfully"  );  
    }	
    
@RequestMapping(value="/GetAllProjects",method=RequestMethod.GET)
public ModelAndView GetAllProjects(HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    
    ModelAndView result=new ModelAndView("DisplayProjects");
    List<ProjectBean> PBList= PS.getAllProjects();
    result.addObject("AllProjects",PBList);
    return result; 
}























}
