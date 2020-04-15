/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.AppSecScheduleRequestBean;
import com.Paladion.teamwork.beans.CodeReviewScheduleRequestBean;
import com.Paladion.teamwork.beans.ProjectScheduleRequestBean;
import com.Paladion.teamwork.beans.eptScheduleRequestBean;
import com.Paladion.teamwork.beans.iptScheduleRequestBean;
import com.Paladion.teamwork.beans.vascanScheduleRequestBean;
import java.util.List;

/**
 *
 * @author santosh.babar
 */
public interface ScheduleService {

    public void saveCodeReviewActvitiy(CodeReviewScheduleRequestBean CRSRB);

    public void saveAppSecActivity(AppSecScheduleRequestBean ASSRB);

    public void EPTActivity(eptScheduleRequestBean EPTSRB);

    public void IPTActivity(iptScheduleRequestBean IPTSRB);

    public void VAscanActivity(vascanScheduleRequestBean VAscanSRB);

    public void saveprojschedule(ProjectScheduleRequestBean Projschedule);

    public List<CodeReviewScheduleRequestBean> getAllCodereview();

    public List<AppSecScheduleRequestBean> getAllAppsec();

    public List<eptScheduleRequestBean> getAllEpt();
    
}
