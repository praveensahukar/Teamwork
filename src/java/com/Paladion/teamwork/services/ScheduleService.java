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

    public List<iptScheduleRequestBean> getAllIpt();

    public List<vascanScheduleRequestBean> GetAllVascan();

    public CodeReviewScheduleRequestBean EditCodereviewDetails(int crid);

    public boolean DeleteRequest(int id);

    public void UpdateCodeReviewActivity(CodeReviewScheduleRequestBean crBean);

    public boolean DeleteAppRequest(int id);

    public AppSecScheduleRequestBean EditAppSecDetails(int asid);

    public boolean DeleteEptRequest(int id);

    public boolean DeleteIptRequest(int id);

    public boolean DeleteVascanRequest(int id);

    public Object EditEptDetails(int eptid);

    public Object EditIptDetails(int iptid);

    public Object EditVascanDetails(int vascanid);

    public void UpdateAppsecActivity(AppSecScheduleRequestBean ASBean);

    public void UpdateCodeReviewActivity1(CodeReviewScheduleRequestBean crBean);

    public void UpdateEptActivity(eptScheduleRequestBean EPTBean);

    public void UpdateAppsecActivity1(AppSecScheduleRequestBean ASBean);

    public void UpdateEptActivity1(eptScheduleRequestBean EPTBean);
    
}
