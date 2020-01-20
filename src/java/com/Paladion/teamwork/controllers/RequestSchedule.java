/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.controllers;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.ActivityTransactionBean;
import com.Paladion.teamwork.beans.AllocationBean;
import com.Paladion.teamwork.beans.AppSecScheduleRequestBean;
import com.Paladion.teamwork.beans.CodeReviewScheduleRequestBean;
import com.Paladion.teamwork.beans.EmailBean;
import com.Paladion.teamwork.beans.ScheduleBean;
import com.Paladion.teamwork.beans.TaskBean;
import com.Paladion.teamwork.beans.eptScheduleRequestBean;
import com.Paladion.teamwork.beans.fileuploadBean;
import com.Paladion.teamwork.beans.iptScheduleRequestBean;
import com.Paladion.teamwork.beans.vascanScheduleRequestBean;
import com.Paladion.teamwork.services.ActivityService;
import com.Paladion.teamwork.services.AdminService;
import com.Paladion.teamwork.services.EmailService;
import com.Paladion.teamwork.services.ProjectService;
import com.Paladion.teamwork.services.ScheduleService;
import com.Paladion.teamwork.services.TaskService;
import com.Paladion.teamwork.services.TeamService;
import com.Paladion.teamwork.services.TemplateService;
import com.Paladion.teamwork.services.UserService;
import com.Paladion.teamwork.utils.ActivityValidator;
import com.Paladion.teamwork.utils.CommonUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author santosh.babar
 */
@Controller
public class RequestSchedule {
    
    
    @ModelAttribute("ScheduleM")
    public ScheduleBean populate()
    {
    return new ScheduleBean();
    }
    
    @Autowired
    @Qualifier(value="TemplateService")
    TemplateService TS;

    @Autowired
    @Qualifier(value="TaskService")
    TaskService TaskS;

    @Autowired
    @Qualifier(value="CommonUtil")
    CommonUtil CU;
    
    @Autowired
    @Qualifier(value="ActivityService")
    ActivityService AS;

    @Autowired
    @Qualifier(value="ProjectService")
    ProjectService PS;
    
    @Autowired
    @Qualifier(value="ScheduleService")
    ScheduleService SS;
    

    @Autowired
    @Qualifier(value="UserService")
    UserService US;

    @Autowired()
    @Qualifier(value = "AdminService")
    AdminService Aservice;

    @Autowired()
    @Qualifier(value = "TeamService")
    TeamService TeamS;

    @Autowired()
    @Qualifier(value = "EmailService")
    EmailService EmailS;

    @Autowired
    @Qualifier(value="EmailBean")
    EmailBean eBean;

    @Autowired
    @Qualifier(value="ActivityValidator")
    ActivityValidator projectBeanValidator;
   
    @InitBinder("ProjectM")
    protected void initProjectBeanBinder(WebDataBinder binder) {
    binder.addValidators(projectBeanValidator);
    } 
	
    @ModelAttribute("ProjectM")
    public ActivityBean populateAB()
    {
    return new ActivityBean();
    }

    @ModelAttribute("ActivityTB")
    public ActivityTransactionBean populateATB()
    {
    return new ActivityTransactionBean();
    }

    @ModelAttribute("AllocationB")
    public AllocationBean populateBean()
    {
    return new AllocationBean();
    }

    
    @ModelAttribute("filebean")
    public fileuploadBean populate1()
    {
    return new fileuploadBean();
    }
    @ModelAttribute("CRBean")
    public CodeReviewScheduleRequestBean populateCR()
    {
    return new CodeReviewScheduleRequestBean();
    }
      @ModelAttribute("AppSecBean")
    public AppSecScheduleRequestBean populateAS()
    {
    return new AppSecScheduleRequestBean();
    }
    @ModelAttribute("EPTBean")
    public eptScheduleRequestBean populateEPT()
    {
    return new eptScheduleRequestBean();
    }
     @ModelAttribute("IPTBean")
    public iptScheduleRequestBean populateIPT()
    {
    return new iptScheduleRequestBean();
    }
     @ModelAttribute("VAscanBean")
    public vascanScheduleRequestBean populateVAscan()
    {
    return new vascanScheduleRequestBean();
    }
    
    @RequestMapping(value="/RequestSchedule",method=RequestMethod.GET)
    public ModelAndView requestSchedule(HttpServletRequest req)
    {   
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        ModelAndView model=new ModelAndView("CreateScheduleRequest");
	
            model.addObject("AllTemplates", TS.getAllTemplates());
            model.addObject("AllLeads", US.GetUsersByRole("lead"));
            model.addObject("AllTeams",  TeamS.getAllTeams());
            model.addObject("AllProjects",PS.getAllProjects());  
            return model;
	}
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    @RequestMapping(value="/LoadScheduleRequestPage",method=RequestMethod.GET)
    public ModelAndView loadSchedulePage(HttpServletRequest req, @RequestParam String page, @RequestParam int pid )
    {   
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        if(page.equalsIgnoreCase("CodeReview")){
        
        ModelAndView model=new ModelAndView("CRScheduleRequest");
        model.addObject("pid",pid);
        return model;
        }   
         if(page.equalsIgnoreCase("Grey")){
        
        ModelAndView model=new ModelAndView("GreyBoxScheduleRequest");
        model.addObject("pid",pid);
        return model;
        }
            if(page.equalsIgnoreCase("EPT")){
        
        ModelAndView model=new ModelAndView("EPTScheduleRequest");
        model.addObject("pid",pid);
        return model;
        }
            
        if(page.equalsIgnoreCase("IPT")){
        
        ModelAndView model=new ModelAndView("IPTScheduleRequest");
        model.addObject("pid",pid);
        return model;
        }
        if(page.equalsIgnoreCase("VAscan")){
        
        ModelAndView model=new ModelAndView("VAscanScheduleRequest");
        model.addObject("pid",pid);
        return model;
        }
        
        
         
    ModelAndView model=new ModelAndView("error");
    return model;
	}
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    
    @RequestMapping(value="/saveCodeReviewActivity",method=RequestMethod.POST)
    public ModelAndView saveCodeReviewActvitiy(@ModelAttribute("CRBean") CodeReviewScheduleRequestBean CRSRB, HttpServletRequest req )
    {   
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        
        int i = Integer.parseInt(req.getParameter("pid"));
        CRSRB.setProjectid(i);
        SS.saveCodeReviewActvitiy(CRSRB);
        ModelAndView model=new ModelAndView("CreateScheduleRequest");
        return model;
        
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
     @RequestMapping(value="/saveAppSecActivity",method=RequestMethod.POST)
    public ModelAndView saveAppSecActivity(@ModelAttribute("AppSecBean") AppSecScheduleRequestBean ASSRB, HttpServletRequest req )
    {   
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        
        int i = Integer.parseInt(req.getParameter("pid"));
        ASSRB.setProjectid(i);
        SS.saveAppSecActivity(ASSRB);
        ModelAndView model=new ModelAndView("CreateScheduleRequest");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    
    @RequestMapping(value="/EPTActivity",method=RequestMethod.POST)
    public ModelAndView EPTActivity(@ModelAttribute("EPTBean") eptScheduleRequestBean EPTSRB, HttpServletRequest req )
    {   
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        
        int i = Integer.parseInt(req.getParameter("pid"));
        EPTSRB.setProjectid(i);
        SS.EPTActivity(EPTSRB);
        ModelAndView model=new ModelAndView("CreateScheduleRequest");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    @RequestMapping(value="/IPTActivity",method=RequestMethod.POST)
    public ModelAndView IPTActivity(@ModelAttribute("IPTBean") iptScheduleRequestBean IPTSRB, HttpServletRequest req )
    {   
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        
        int i = Integer.parseInt(req.getParameter("pid"));
        IPTSRB.setProjectid(i);
        SS.IPTActivity(IPTSRB);
        ModelAndView model=new ModelAndView("CreateScheduleRequest");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    @RequestMapping(value="/VAscanActivity",method=RequestMethod.POST)
    public ModelAndView VAscanActivity(@ModelAttribute("VAscanBean") vascanScheduleRequestBean VAscanSRB, HttpServletRequest req )
    {   
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        
        int i = Integer.parseInt(req.getParameter("pid"));
        VAscanSRB.setProjectid(i);
        SS.VAscanActivity(VAscanSRB);
        ModelAndView model=new ModelAndView("CreateScheduleRequest");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
}
