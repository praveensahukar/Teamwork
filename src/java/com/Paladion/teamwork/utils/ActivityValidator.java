/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.utils;

import com.Paladion.teamwork.beans.ActivityBean;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.validation.Errors;

/**
 *
 * @author reshma.m
 */
public class ActivityValidator implements org.springframework.validation.Validator{
  
    @Override
    public boolean supports(Class<?> clazz) {
        return ActivityBean.class.isAssignableFrom(clazz); 
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        ActivityBean pbean = (ActivityBean) target;
        Date startDate = null;
        Date endDate = null;
                
        try {
        startDate = pbean.getStartdate();
        endDate = pbean.getEnddate();
        } 
        catch (Exception ex) {
        startDate = null;
        endDate = null;
        Logger.getLogger(ActivityValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
                
//	if(pbean.getOpid().length() == 0)
//        {
//	    errors.rejectValue("opid","opid.required");
//	}
        if(pbean.getActivityname().length() == 0)
	{
	    errors.rejectValue("activityname","projectname.required");
	}
        else if(pbean.getLeadid()<=0)
	{
	    errors.rejectValue("leadid","leadid.required");
	}
        else if(null == startDate)
        {
	    errors.rejectValue("startdate","startdate.required");
	}
        else if(null == endDate)
	{
	    errors.rejectValue("enddate","enddate.required");
	}      
//        else if(pbean.getTemplateid()<=0)
//	{
//	    errors.rejectValue("templateid","templateid.required");
//	}
//        else if(pbean.getTeam().isEmpty())
//	{
//	    errors.rejectValue("team","team.required");
//	}
        else if (startDate.after(endDate))
        {
            errors.rejectValue("startdate","dates.invalid");
        }
    }
    
}
