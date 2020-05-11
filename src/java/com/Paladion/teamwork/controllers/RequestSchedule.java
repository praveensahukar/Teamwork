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
import com.Paladion.teamwork.beans.ProjectBean;
import com.Paladion.teamwork.beans.ProjectScheduleRequestBean;
import com.Paladion.teamwork.beans.ScheduleBean;
import com.Paladion.teamwork.beans.TaskBean;
import com.Paladion.teamwork.beans.UserDataBean;
import com.Paladion.teamwork.beans.Vehiclebean;
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
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
     @ModelAttribute("Projschedule")
    public ProjectScheduleRequestBean populateProjschedule()
    {
    return new ProjectScheduleRequestBean();
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
    @RequestMapping(value="/ActivityRequestSchedule",method=RequestMethod.GET)
    public ModelAndView ActivityRequestSchedule(HttpServletRequest req)
    {   
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        ModelAndView model=new ModelAndView("ActivityScheduleRequest");
	
           // model.addObject("AllTemplates", TS.getAllTemplates());
           // model.addObject("AllLeads", US.GetUsersByRole("lead"));
           // model.addObject("AllTeams",  TeamS.getAllTeams());
            model.addObject("AllProjects",PS.getAllProjects());  
            return model;
	}
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    @RequestMapping(value="/GetScheduleAllocation",method=RequestMethod.GET)
    public ModelAndView GetScheduleAllocation(HttpServletRequest req, @RequestParam int crid)
    {  
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        ModelAndView model=new ModelAndView("CreateScheduleAllocation");
           
        CodeReviewScheduleRequestBean crbean = SS.EditCodereviewDetails(crid);
       
        String activityname = crbean.getAppname()+crbean.getAssesstype();
       
        ActivityBean abean = new ActivityBean();
        abean.setActivityname(activityname);
        abean.setAssessmentType("Initial");
        abean.setProjectid(crbean.getProjectid());
        abean.setRequirements(crbean.getPre_req());
        model.addObject("projectname", crbean.getProjectname());
       
            model.addObject("CRData",SS.EditCodereviewDetails(crid));
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
    
    @RequestMapping(value="/GetScheduleAllocationAppSec",method=RequestMethod.GET)
    public ModelAndView GetScheduleAllocationAppSec(HttpServletRequest req, @RequestParam int asid)
    {  
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        ModelAndView model=new ModelAndView("CreateScheduleAllocationAppSec");
           
        AppSecScheduleRequestBean AppSecbean = SS.EditAppSecDetails(asid);
      // result.addObject("ASData",SS.EditAppSecDetails(asid));
        String activityname = AppSecbean.getAppname()+AppSecbean.getAssesstype();
       
        ActivityBean abean = new ActivityBean();
        abean.setActivityname(activityname);
        abean.setAssessmentType("Initial");
        abean.setProjectid(AppSecbean.getProjectid());
        abean.setRequirements(AppSecbean.getPre_req());
        model.addObject("projectname", AppSecbean.getProjectname());
       
            model.addObject("ASData",SS.EditAppSecDetails(asid));
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
    
    @RequestMapping(value="/GetScheduleAllocationNet",method=RequestMethod.GET)
    public ModelAndView GetScheduleAllocationNet(HttpServletRequest req, @RequestParam int eptid)
    {  
        try
        {
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        ModelAndView model=new ModelAndView("CreateScheduleAllocationNet");
           
        eptScheduleRequestBean Netbean;
            Netbean = (eptScheduleRequestBean) SS.EditEptDetails(eptid);
      // result.addObject("ASData",SS.EditAppSecDetails(asid));
        String activityname = Netbean.getAssesstype();
       
        ActivityBean abean = new ActivityBean();
        abean.setActivityname(activityname);
        abean.setAssessmentType("Initial");
        abean.setProjectid(Netbean.getProjectid());
        abean.setRequirements(Netbean.getPre_req());
        model.addObject("projectname", Netbean.getProjectname());
       
            model.addObject("EPTData",SS.EditEptDetails(eptid));
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
        
        if(page.equalsIgnoreCase("scr")){
        
        ModelAndView model=new ModelAndView("CRScheduleRequest");
        model.addObject("pid",pid);
        model.addObject("AllProjects",PS.getAllProjects()); 
        return model;
        }   
         if(page.equalsIgnoreCase("apptest")){
        
        ModelAndView model=new ModelAndView("GreyBoxScheduleRequest");
        model.addObject("pid",pid);
        model.addObject("AllProjects",PS.getAllProjects()); 
        return model;
        }
        
        if(page.equalsIgnoreCase("nettest")){
        ModelAndView model=new ModelAndView("EPTScheduleRequest");
        model.addObject("pid",pid);
        model.addObject("AllProjects",PS.getAllProjects()); 
        return model;
        } 
         
         
        if(page.equalsIgnoreCase("EPT")){
        ModelAndView model=new ModelAndView("EPTScheduleRequest");
        model.addObject("pid",pid);
        model.addObject("AllProjects",PS.getAllProjects()); 
        return model;
        }
        if(page.equalsIgnoreCase("IPT")){
            
        ModelAndView model=new ModelAndView("IPTScheduleRequest");
        model.addObject("pid",pid);
        model.addObject("AllProjects",PS.getAllProjects()); 
        return model;
        }
        if(page.equalsIgnoreCase("VAscan")){
        ModelAndView model=new ModelAndView("VAscanScheduleRequest");
        model.addObject("pid",pid);
        model.addObject("AllProjects",PS.getAllProjects()); 
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

    
    @RequestMapping(value="/saveprojschedule",method=RequestMethod.POST)
    public ModelAndView saveprojschedule(@ModelAttribute("Projschedule") ProjectScheduleRequestBean Projschedule, HttpServletRequest req )
    {
        try{
             String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
            
        SS.saveprojschedule(Projschedule);
        ModelAndView model=new ModelAndView("CreateScheduleRequest");
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
//        int i = Integer.parseInt(req.getParameter("pid"));
//        CRSRB.setProjectid(i);
        ProjectBean pb = PS.getProjectDeatails(CRSRB.getProjectid());
        CRSRB.setProjectname(pb.getProjectname());
        SS.saveCodeReviewActvitiy(CRSRB);
        ModelAndView model=new ModelAndView("ActivityScheduleRequest");
        model.addObject("Message","Schedule Request Submitted Successfully");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    
    @RequestMapping(value="/GetAllCodereview",method=RequestMethod.GET)
    public ModelAndView GetAllCodereview(HttpServletRequest req)
    { 
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayCodereview");
        List<CodeReviewScheduleRequestBean> CRList= SS.getAllCodereview();
        result.addObject("AllCodereview",CRList);
        return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }
    
@RequestMapping(value="/EditCodereviewDetails",method=RequestMethod.GET)
public ModelAndView EditCodereviewDetails(@RequestParam int crid, HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("UpdateCodereviewDetails");
    if(crid!=0)
    {
        result.addObject("CRData",SS.EditCodereviewDetails(crid));
        return result;
    }
    else{
        result=new ModelAndView("Error");
    }
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}

@RequestMapping(value="/UpdateCodeReviewActivity",method=RequestMethod.POST)
    public ModelAndView UpdateCodeReviewActivity(@ModelAttribute("CRBean") CodeReviewScheduleRequestBean crBean,  HttpServletRequest req)
    {
        String[] authorizedRoles = {"admin","manager"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        try{
        System.out.println("in update vehicle details controller method");
         int i = Integer.parseInt(req.getParameter("pid"));
        crBean.setCr_scheduleid(i);
        SS.UpdateCodeReviewActivity(crBean);
        List<CodeReviewScheduleRequestBean> CRList=SS.getAllCodereview();
	ModelAndView result=new ModelAndView("DisplayCodereview");
        result.addObject("AllCodereview",CRList);
        result.addObject("Message","request Details Updated Successfully");
	return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }  
    } 

@RequestMapping(value="/DeleteRequest",method=RequestMethod.GET)
    public ModelAndView DeleteRequest(@RequestParam int id, HttpServletRequest req) throws ParseException
    {
        String[] authorizedRoles = {"admin","manager"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayCodereview");
        if(id!=0){
           boolean status =  SS.DeleteRequest(id);
            List<CodeReviewScheduleRequestBean> CRList= SS.getAllCodereview();
           
	    result.addObject("AllCodereview",CRList);
            result.addObject("Message","request deleted successfully");    
            }
            else{
            result=new ModelAndView("Welcome");
            }
            return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
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
//        int i = Integer.parseInt(req.getParameter("pid"));
//        ASSRB.setProjectid(i);
        ProjectBean pb = PS.getProjectDeatails(ASSRB.getProjectid());
        ASSRB.setProjectname(pb.getProjectname());
        SS.saveAppSecActivity(ASSRB);
        ModelAndView model=new ModelAndView("ActivityScheduleRequest");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    
    @RequestMapping(value="/GetAllAppsec",method=RequestMethod.GET)
    public ModelAndView GetAllAppsec(HttpServletRequest req)
    { 
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayAppsec");
        List<AppSecScheduleRequestBean> APList= SS.getAllAppsec();
        result.addObject("AllAppsec",APList);
        return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }
    
    @RequestMapping(value="/EditAppSecDetails",method=RequestMethod.GET)
public ModelAndView EditAppSecDetails(@RequestParam int asid, HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("UpdateAppSecDetails");
    if(asid!=0)
    {
        result.addObject("ASData",SS.EditAppSecDetails(asid));
        return result;
    }
    else{
        result=new ModelAndView("Error");
    }
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}
    
    
    @RequestMapping(value="/DeleteAppRequest",method=RequestMethod.GET)
    public ModelAndView DeleteAppRequest(@RequestParam int id, HttpServletRequest req) throws ParseException
    {
        String[] authorizedRoles = {"admin","manager"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayAppsec");
        if(id!=0){
           boolean status =  SS.DeleteAppRequest(id);
            List<AppSecScheduleRequestBean> AppsecList= SS.getAllAppsec();
           
	    result.addObject("AllAppsec",AppsecList);
            result.addObject("Message","request deleted successfully");    
            }
            else{
            result=new ModelAndView("Welcome");
            }
            return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
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
        ModelAndView model=new ModelAndView("ActivityScheduleRequest");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    @RequestMapping(value="/GetAllEpt",method=RequestMethod.GET)
    public ModelAndView GetAllEpt(HttpServletRequest req)
    { 
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayEpt");
        List<eptScheduleRequestBean> EptList= SS.getAllEpt();
        result.addObject("AllEpt",EptList);
        return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }
    
    @RequestMapping(value="/EditEptDetails",method=RequestMethod.GET)
public ModelAndView EditEptDetails(@RequestParam int eptid, HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("UpdateEptDetails");
    if(eptid!=0)
    {
        result.addObject("EPTData",SS.EditEptDetails(eptid));
        return result;
    }
    else{
        result=new ModelAndView("Error");
    }
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}
   
    
    @RequestMapping(value="/DeleteEptRequest",method=RequestMethod.GET)
    public ModelAndView DeleteEptRequest(@RequestParam int id, HttpServletRequest req) throws ParseException
    {
        String[] authorizedRoles = {"admin","manager"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayEpt");
        if(id!=0){
           boolean status =  SS.DeleteEptRequest(id);
            List<eptScheduleRequestBean> EptList= SS.getAllEpt();
           
	    result.addObject("AllEpt",EptList);
            result.addObject("Message","request deleted successfully");    
            }
            else{
            result=new ModelAndView("Welcome");
            }
            return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
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
        ModelAndView model=new ModelAndView("ActivityScheduleRequest");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    
    @RequestMapping(value="/GetAllIpt",method=RequestMethod.GET)
    public ModelAndView GetAllIpt(HttpServletRequest req)
    { 
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayIpt");
        List<iptScheduleRequestBean> IptList= SS.getAllIpt();
        result.addObject("AllIpt",IptList);
        return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }
    
    
    @RequestMapping(value="/EditIptDetails",method=RequestMethod.GET)
public ModelAndView EditIptDetails(@RequestParam int iptid, HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("UpdateIptDetails");
    if(iptid!=0)
    {
        result.addObject("IPTData",SS.EditIptDetails(iptid));
        return result;
    }
    else{
        result=new ModelAndView("Error");
    }
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}
    
    @RequestMapping(value="/DeleteIptRequest",method=RequestMethod.GET)
    public ModelAndView DeleteIptRequest(@RequestParam int id, HttpServletRequest req) throws ParseException
    {
        String[] authorizedRoles = {"admin","manager"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayIpt");
        if(id!=0){
           boolean status =  SS.DeleteIptRequest(id);
            List<iptScheduleRequestBean> IptList= SS.getAllIpt();
           
	    result.addObject("AllIpt",IptList);
            result.addObject("Message","request deleted successfully");    
            }
            else{
            result=new ModelAndView("Welcome");
            }
            return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
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
        ModelAndView model=new ModelAndView("ActivityScheduleRequest");
        return model;
        }
        catch(Exception ex){
        System.out.println("Exception occured. "+ex.getMessage());
        return new ModelAndView("Error");
        }   
    }
    
    @RequestMapping(value="/GetAllVascan",method=RequestMethod.GET)
    public ModelAndView GetAllVascan(HttpServletRequest req)
    { 
        String[] authorizedRoles = {"admin","manager","lead","scheduling"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayVascan");
        List<vascanScheduleRequestBean> VascanList= SS.GetAllVascan();
        result.addObject("AllVascan",VascanList);
        return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }
    
    @RequestMapping(value="/EditVascanDetails",method=RequestMethod.GET)
public ModelAndView EditVascanDetails(@RequestParam int vascanid, HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("UpdateVascanDetails");
    if(vascanid!=0)
    {
        result.addObject("VascanData",SS.EditVascanDetails(vascanid));
        return result;
    }
    else{
        result=new ModelAndView("Error");
    }
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}
    
    @RequestMapping(value="/DeleteVascanRequest",method=RequestMethod.GET)
    public ModelAndView DeleteVascanRequest(@RequestParam int id, HttpServletRequest req) throws ParseException
    {
        String[] authorizedRoles = {"admin","manager"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        try{
        ModelAndView result=new ModelAndView("DisplayVascan");
        if(id!=0){
           boolean status =  SS.DeleteVascanRequest(id);
            List<vascanScheduleRequestBean> VascanList= SS.GetAllVascan();
           
	    result.addObject("AllVascan",VascanList);
            result.addObject("Message","request deleted successfully");    
            }
            else{
            result=new ModelAndView("Welcome");
            }
            return result;
        }
        catch(Exception ex){
        ex.printStackTrace();
        return new ModelAndView("Error");
        }
    }
    
    
    @RequestMapping(value="/GetAllSchedulerequests",method=RequestMethod.GET)
public ModelAndView GetAllProjects(HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead","scheduling"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    try{
    ModelAndView result=new ModelAndView("DisplayProjects");
    List<ProjectBean> PBList1= PS.getAllProjects();
    result.addObject("AllProjects",PBList1);
    return result;
    }
    catch(Exception ex){
    ex.printStackTrace();
    return new ModelAndView("Error");
    }
}
    
    
    
}
