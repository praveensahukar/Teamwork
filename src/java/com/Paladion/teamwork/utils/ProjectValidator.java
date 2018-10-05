/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.utils;

import com.Paladion.teamwork.beans.ProjectBean;
import org.springframework.validation.Errors;

/**
 *
 * @author santosh.babar
 */
public class ProjectValidator implements org.springframework.validation.Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectBean.class.isAssignableFrom(clazz); 
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        ProjectBean pbean = (ProjectBean) target;
     
                
//	if(pbean.getOpid().length() == 0)
//        {
//	    errors.rejectValue("opid","opid.required");
//	}
        if(pbean.getProjectname().length() == 0)
	{
	    errors.rejectValue("projectname","projectname.required");
	}
        else if(pbean.getCompanyid() <= 0)
	{
	    errors.rejectValue("companyid","companyid.required");
	}
        else if(pbean.getDeliverymanager()<=0)
	{
	    errors.rejectValue("deliverymanager","deliverymanager.required");
	}
        else if(pbean.getProjectmanager() <= 0)
	{
	    errors.rejectValue("projectmanager","projectmanager.required");
	}
     
        
        else if(pbean.getRegion().length() == 0)
	{
	    errors.rejectValue("region","region.required");
	}
//        else if(pbean.getTemplateid()<=0)
//	{
//	    errors.rejectValue("templateid","templateid.required");
//	}
//        else if(pbean.getTeam().isEmpty())
//	{
//	    errors.rejectValue("team","team.required");
//	}
       
    }

  
}
