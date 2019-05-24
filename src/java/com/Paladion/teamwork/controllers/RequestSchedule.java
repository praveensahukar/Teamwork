/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.controllers;

import com.Paladion.teamwork.beans.ScheduleBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author santosh.babar
 */
@Controller
@SessionAttributes("ScheduleM")
public class RequestSchedule {
    
    
@ModelAttribute("ScheduleM")
public ScheduleBean populate()
{
    return new ScheduleBean();
}
    
}
