/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author pal
 */

@Entity
@Table(name = "eptschedulereq",catalog="teamwork")
public class eptScheduleRequestBean {
    
    
     @Id
@GenericGenerator(name="gen",strategy="increment")
@GeneratedValue(generator="gen")
@Column(name = "ept_scheduleid", unique = true, nullable = false, precision = 15, scale = 0)
int ept_scheduleid;
     
     
  @Column(name = "prefstartdate")
@DateTimeFormat (pattern="MM/dd/yyyy")
@Temporal(javax.persistence.TemporalType.DATE)
Date prefstartdate;
 
 @Column(name = "proj_scheduleid")
int proj_scheduleid;

 @Column(name = "projectid")
int projectid;
 
 @Column(name = "assesstype")
String assesstype;
 
@Column(name="whitelistconf")
String whitelistconf;

@Column(name="timewindow")
String timewindow;

@Column(name="domain")
String domain;

@Column(name="ipproposal")
String ipproposal;

@Column(name = "effort")
String effort;

@Column(name = "hosting")
String hosting;

@Column(name = "pre_req")
String pre_req;

@Column(name="projectname")
String projectname;

@Column(name="status")
String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }


    public String getHosting() {
        return hosting;
    }

    public void setHosting(String hosting) {
        this.hosting = hosting;
    }

    public String getPre_req() {
        return pre_req;
    }

    public void setPre_req(String pre_req) {
        this.pre_req = pre_req;
    }



    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public int getEpt_scheduleid() {
        return ept_scheduleid;
    }

    public void setEpt_scheduleid(int ept_scheduleid) {
        this.ept_scheduleid = ept_scheduleid;
    }

    public Date getPrefstartdate() {
        return prefstartdate;
    }

    public void setPrefstartdate(Date prefstartdate) {
        this.prefstartdate = prefstartdate;
    }

    public int getProj_scheduleid() {
        return proj_scheduleid;
    }

    public void setProj_scheduleid(int proj_scheduleid) {
        this.proj_scheduleid = proj_scheduleid;
    }

    public String getAssesstype() {
        return assesstype;
    }

    public void setAssesstype(String assesstype) {
        this.assesstype = assesstype;
    }

    public String getWhitelistconf() {
        return whitelistconf;
    }

    public void setWhitelistconf(String whitelistconf) {
        this.whitelistconf = whitelistconf;
    }

    public String getTimewindow() {
        return timewindow;
    }

    public void setTimewindow(String timewindow) {
        this.timewindow = timewindow;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIpproposal() {
        return ipproposal;
    }

    public void setIpproposal(String ipproposal) {
        this.ipproposal = ipproposal;
    }


}
