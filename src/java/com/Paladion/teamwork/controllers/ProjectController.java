/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.controllers;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.CompanyBean;
import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.UserDataBean;
import com.Paladion.teamwork.services.CompanyService;
import com.Paladion.teamwork.services.ProjectService;
import com.Paladion.teamwork.services.UserService;
import com.Paladion.teamwork.utils.CommonUtil;
import com.Paladion.teamwork.utils.ProjectValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Qualifier(value="ProjectValidator")
    ProjectValidator PV;
    
    @Autowired
    @Qualifier(value="ProjectService")
    ProjectService PS;
    
    @Autowired
    @Qualifier(value = "CommonUtil")
    CommonUtil CU;
    
    @Autowired
    @Qualifier(value = "UserService")
    UserService US;
    
   
    @InitBinder("ProjectM")
    protected void initBinder(WebDataBinder binder) {
      binder.addValidators(PV);
    }
  
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
        try{
        List<UserDataBean> ManagerList=US.GetUsersByRole("manager");
	ModelAndView model=new ModelAndView("CreateProject");
        model.addObject("AllCompany", CS.getAllCompany());
        model.addObject("AllDManagers", ManagerList);
        model.addObject("AllPManagers", ManagerList);
        return model;
	}
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }


    @RequestMapping(value="/CreateProject",method=RequestMethod.POST)
    public ModelAndView CreateProject(@ModelAttribute("ProjectM")@Validated ProjectBean PB, BindingResult result, HttpServletRequest req) 
    {
        String[] authorizedRoles = {"admin","manager","lead", "scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        if (result.hasErrors()) {
            //validates the user input, this is server side validation
            System.out.println("error!!!!!!!!");
            try{
            List<UserDataBean> ManagerList=US.GetUsersByRole("manager");
            ModelAndView model=new ModelAndView("CreateProject");
            model.addObject("AllCompany", CS.getAllCompany());
            model.addObject("AllDManagers", ManagerList);
            model.addObject("AllPManagers", ManagerList);
            return model;
            }
             catch(Exception ex){
            ex.printStackTrace();
            return new ModelAndView("Error");
            }
        }
        if(PB.getOpid().isEmpty()){
            PB.setOpid(null);
        }
	PS.addProject(PB);
        System.out.println("Project Created with projectid "+PB.getProjectid());
        
        ModelAndView model=new ModelAndView("CreateProject");
	model.addObject("AllCompany", CS.getAllCompany());
        model.addObject("AllDManagers", US.GetUsersByRole("manager"));
        model.addObject("AllPManagers", US.GetUsersByRole("pmanager"));
	model.addObject("Message","Project Created Successfully");
        return model;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }	
    
@RequestMapping(value="/GetAllProjects",method=RequestMethod.GET)
public ModelAndView GetAllProjects(HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("DisplayProjects");
    List<ProjectBean> PBList= PS.getAllProjects();
    result.addObject("AllProjects",PBList);
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}

@RequestMapping(value="/GetProjectActivities",method=RequestMethod.GET)
public ModelAndView GetAllProjectActivities(@RequestParam int pid, HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("DisplayActivity");
    List<ActivityBean> AList= PS.getProjectActivities(pid);
    if(AList.size()>0){
    result.addObject("AllProjects",AList);
    }
    else{
        result.addObject("Message", "No Activities Are Scheduled Under This Project");
    }
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}


@RequestMapping(value="/EditProjectDetails",method=RequestMethod.GET)
public ModelAndView EditProjectDetails(@RequestParam int pid, HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("UpdateProjectDetails");
    ProjectBean PBean= PS.getProjectDeatails(pid);
    
    if(PBean != null){
        List<UserDataBean> ManagerList=US.GetUsersByRole("manager");
        result.addObject("AllCompany", CS.getAllCompany());
        if(PBean.getCompanyid()!=0){
        result.addObject("CompanyName",CS.getCompanyByID(PBean.getCompanyid()).getCompanyname());
        }
         else{
            result.addObject("CompanyName","Select");
        }
        if(PBean.getDeliverymanager()!=0){
        result.addObject("Dmanager", US.GetUserById(PBean.getDeliverymanager()).getUsername());
        }
        else{
            result.addObject("Dmanager","Select");
        }
        if(PBean.getProjectmanager()!=0){
        result.addObject("Pmanager", US.GetUserById(PBean.getProjectmanager()).getUsername());
        }
        else{
            result.addObject("Pmanager","Select");
        }
        result.addObject("AllDManagers", ManagerList);
        result.addObject("AllPManagers", ManagerList);
        result.addObject("ProjectData",PBean);
    }
    else{
        result.addObject("Message", "No Project was found.");
    }
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}


    @RequestMapping(value="/UpdateProjectDetails",method=RequestMethod.POST)
    public ModelAndView UpdateProjectDetails(@ModelAttribute("ProjectM")@Validated ProjectBean PB, BindingResult result, HttpServletRequest req) 
    {
        String[] authorizedRoles = {"admin","manager","lead", "scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        if (result.hasErrors()) {
            //validates the user input, this is server side validation
            
            System.out.println("error!!!!!!!!");
            ModelAndView model=new ModelAndView("UpdateProjectDetails");
            ProjectBean PBean= PS.getProjectDeatails(PB.getProjectid());
            if(PBean != null){
            List<UserDataBean> ManagerList=US.GetUsersByRole("manager");
            model.addObject("AllCompany", CS.getAllCompany());
            if(PBean.getCompanyid()!=0){
            model.addObject("CompanyName",CS.getCompanyByID(PBean.getCompanyid()).getCompanyname());
            }
            else{
            model.addObject("CompanyName","Select");
            }
            if(PBean.getDeliverymanager()!=0){
            model.addObject("Dmanager", US.GetUserById(PBean.getDeliverymanager()).getUsername());
            }
            else{
            model.addObject("Dmanager","Select");
            }
            if(PBean.getProjectmanager()!=0){
            model.addObject("Pmanager", US.GetUserById(PBean.getProjectmanager()).getUsername());
            }
            else{
            model.addObject("Pmanager","Select");
            }
            model.addObject("AllDManagers", ManagerList);
            model.addObject("AllPManagers", ManagerList);
            model.addObject("ProjectData",PBean);
            }
            else{
                model.addObject("Message", "No Project was found.");
            }
            return model;
        }
        if(PB.getOpid().isEmpty()){
            PB.setOpid(null);
        }
	PS.updateProjectDetails(PB);
        System.out.println("Project updated with projectid "+PB.getProjectid() );
        
         ModelAndView model=new ModelAndView("DisplayProjects");
        List<ProjectBean> PBList= PS.getAllProjects();
        model.addObject("AllProjects",PBList);
        model.addObject("Message", "Project Details Updated Successfully.");
        return model;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }	


















}
