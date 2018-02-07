/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.controllers;

import com.Paladion.teamwork.beans.CompanyBean;
import com.Paladion.teamwork.services.CompanyService;
import com.Paladion.teamwork.utils.CommonUtil;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
 * @author Administrator
 */
@Controller
public class CompanyController {	
    
//@Autowired
//@Qualifier(value="CompanyValidator")
//CompanyValidator CV;

@Autowired
@Qualifier(value="CommonUtil")
CommonUtil CU;
   
//@InitBinder
//protected void initBinder(WebDataBinder binder) {
//binder.addValidators(CV);
//}    
    
@Autowired
@Qualifier(value="CompanyService")
CompanyService CS;
		
@ModelAttribute("CompanyM")
public CompanyBean populate()
{
    return new CompanyBean();
}

	
@RequestMapping(value="/CreateCompany",method=RequestMethod.GET)
     public ModelAndView CreateCompany(HttpServletRequest req)
    {   
        String[] authorizedRoles = {"admin","manager","lead"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
	return new ModelAndView("CreateCompany");
    }
	
@RequestMapping(value="/CreateCompany",method=RequestMethod.POST)
    public ModelAndView CreateCompany(@ModelAttribute("CompanyM")@Validated CompanyBean CB,BindingResult result,HttpServletRequest req) 
    {
        String[] authorizedRoles = {"admin","manager","lead"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        if (result.hasErrors()) {
            //validates the user input, this is server side validation
            System.out.println("error!!!!!!!!");
            return new ModelAndView("CreateCompany");
        }
        
	System.out.println("\n inside create company method ");
	CS.addCompany(CB); 	
	System.out.println("Company Created with companyid"+CB.getCompanyid());
	return new ModelAndView( "CreateCompany","Message","Company Created Successfully"  );  
    }	
    
    
@RequestMapping(value="/GetAllCompany",method=RequestMethod.GET)
public ModelAndView GetAllTasks(HttpServletRequest req)
{ 
    String[] authorizedRoles = {"admin","manager","lead"};
    if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
    
    ModelAndView result=new ModelAndView("DisplayCompany");
    List<CompanyBean> CBList= CS.getAllCompany();
    result.addObject("AllCompany",CBList);
    return result; 
}


@RequestMapping(value="/DeleteCompany",method=RequestMethod.GET)
    public ModelAndView DeleteCompany(@RequestParam int id, HttpServletRequest req) throws ParseException
    {
        String[] authorizedRoles = {"admin","manager","lead"};
        if(!CU.checkUserAuthorization(authorizedRoles, req)) return new ModelAndView("Error");
        
        if(id!=0)
           {
               boolean value= CS.deleteCompany(id);
               ModelAndView result=new ModelAndView("DisplayCompany");
               List<CompanyBean> CBList= CS.getAllCompany();
               result.addObject("AllCompany",CBList);
               result.addObject("Message","Company Deleted Succefully");
               return result; 
           }
           else{
                return new ModelAndView("Error");
            }
    }  
}
