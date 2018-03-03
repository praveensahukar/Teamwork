/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.Schedulers;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.beans.ActivityTransactionBean;
import com.Paladion.teamwork.services.ActivityService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Santhosh
 */

public class InventoryPullerJob {
    
    @Autowired
    @Qualifier(value="ActivityService")
    ActivityService AS;
    
    
    @Scheduled(fixedDelay = 90000)
    public void updateEmployeeInventory(){
       // System.out.println("Started fixed delay job");
        /**
         * add your scheduled job logic here
         */
        
    }
    
    @Scheduled(cron = "0 30 09 * * ?")
    public void releaseResource(){
        
        
        
    }
    
    @Scheduled(cron = "0 30 09 * * ?")
    public void activityReminderEmail(){
        
        //Fetch all the activity starting from tomorrow
        
        List <ActivityBean> AList=AS.getUpcomingActivities();
        
        for(ActivityBean ABean: AList){
        System.out.println("Activity "+ABean.getActivityname() +" is scheduled from: "+ABean.getStartdate());
        //Send reminder email to lead and engineer
        
        
        
        }
        Date now=new Date();
        System.out.println(" ----- Time the scheduler run : " + now+"-------");
        System.out.println("----- Sending Activity start reminder completed ----");
        
    }
    
}
