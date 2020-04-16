/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.DAO.ProjectDAO;
import com.Paladion.teamwork.DAO.ScheduleDAO;
import com.Paladion.teamwork.beans.AppSecScheduleRequestBean;
import com.Paladion.teamwork.beans.CodeReviewScheduleRequestBean;
import com.Paladion.teamwork.beans.ProjectScheduleRequestBean;
import com.Paladion.teamwork.beans.eptScheduleRequestBean;
import com.Paladion.teamwork.beans.iptScheduleRequestBean;
import com.Paladion.teamwork.beans.vascanScheduleRequestBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author santosh.babar
 */
public class ScheduleServiceImpl implements ScheduleService {
    
    @Autowired
    @Qualifier(value="ScheduleDAO")
    ScheduleDAO SD;

    @Override
    public void saveCodeReviewActvitiy(CodeReviewScheduleRequestBean CRSRB) {

        SD.saveCodeReviewActvitiy(CRSRB);
    }

    @Override
    public void saveAppSecActivity(AppSecScheduleRequestBean ASSRB) {
        SD.saveAppSecActivity(ASSRB);
    }

    @Override
    public void EPTActivity(eptScheduleRequestBean EPTSRB) {
        SD.EPTActivity(EPTSRB);
    }

    @Override
    public void IPTActivity(iptScheduleRequestBean IPTSRB) {
       
        SD.IPTActivity(IPTSRB);
    }
    @Override
    public void VAscanActivity(vascanScheduleRequestBean VAscanSRB) {
        SD.VAscanActivity(VAscanSRB);
    }

    @Override
    public void saveprojschedule(ProjectScheduleRequestBean Projschedule) {
        SD.saveprojschedule(Projschedule);
    }

    @Override
    public List<CodeReviewScheduleRequestBean> getAllCodereview() {
        return SD.getAllCodereview(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AppSecScheduleRequestBean> getAllAppsec() {
        return SD.getAllAppsec(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<eptScheduleRequestBean> getAllEpt() {
        return SD.getAllEpt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<iptScheduleRequestBean> getAllIpt() {
        return SD.getAllIpt();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<vascanScheduleRequestBean> GetAllVascan() {
        return SD.GetAllVascan(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
