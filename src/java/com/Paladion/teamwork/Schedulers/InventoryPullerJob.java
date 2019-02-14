/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.Schedulers;

import com.Paladion.teamwork.beans.ActivityBean;
import com.Paladion.teamwork.services.ActivityService;
import com.Paladion.teamwork.services.EmailService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author Santhosh
 */

public class InventoryPullerJob {
    
    @Autowired
    @Qualifier(value="ActivityService")
    ActivityService AS;
    
    @Autowired
    @Qualifier(value="EmailService")
    EmailService EmailS;
    
    
//    @Scheduled(fixedDelay = 90000)
//    public void updateEmployeeInventory(){
//       // System.out.println("Started fixed delay job");
//        /**
//         * add your scheduled job logic here
//         */
//        
//    }
    
//    @Scheduled(cron = "0 30 09 * * ?")
//    public void releaseResource(){
//       
//    }
//    
    @Scheduled(cron = "0 30 09 * * ?")
    public void activityReminderEmail(){
        try{
        //Fetch all the activity starting from next day
        LocalDateTime now = LocalDateTime.now(); 
        List <ActivityBean> AList=AS.getUpcomingActivities();
        if(AList.size() > 0){
        for(ActivityBean ABean: AList){
            
            //Send reminder email to lead and engineer
            EmailS.sendReminder(ABean);
            System.out.println("Sending Activity Reminder email for Activity: "+ABean.getActivityname() +" "
                    + "scheduled from: "+ABean.getStartdate() +" is completed at time : "+ now);
            }
        }
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        else{
        System.out.println(" ----- Time the scheduler run : " + now+"-------");
        System.out.println("----- No activity reminder mails were sent for the today ----");
        }
        }catch(Exception ex){
             System.out.println("Error Occured : "+ex.getMessage());
        }
    }
    
    @Scheduled(cron = "0 */120 * * * ?")
    public void checkOnHoldTaskAndUpdateActivityStatus(){
        try{  
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            System.out.println("-----Inside checkOnHoldTaskAndUpdateActivityStatus() at "+dtf.format(now)+" --------");
            AS.checkTaskStatusOnhold();
            }catch(Exception ex){
            System.out.println("Error Occured : "+ex.getMessage());
        }
    }
}
