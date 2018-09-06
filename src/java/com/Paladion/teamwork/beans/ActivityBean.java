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
 * @author Santhosh
 */
@Entity
@Table(name = "activity",catalog="teamwork")
public class ActivityBean {
    
@Id
@GenericGenerator(name="gen",strategy="increment")
@GeneratedValue(generator="gen")
@Column(name = "activityid", unique = true, nullable = false, precision = 15, scale = 0)
int activityid;

@Column(name = "mandays")
int mandays;

@Column(name = "opid")
String opid;

@Column(name = "activityname")
String activityname;

@Column(name = "lead")
String lead;

@Column(name = "templateid")
int templateid;

@Column(name = "status")
String status;

@Column(name = "leadid")
int leadid;

@Column(name = "team")
String team;

@Column(name = "projectid")
int projectid;

@Column(name = "assessmentType")
String assessmentType;

@Column(name = "compliance")
String compliance;

@Column(name = "whitelisting")
String whitelisting;

@Column(name = "details")
String details;

@Column(name = "requirements")
String requirements;

@Column(name = "startdate")
@DateTimeFormat (pattern="MM/dd/yyyy")
@Temporal(javax.persistence.TemporalType.DATE)
Date startdate;

@Column(name = "enddate")
@DateTimeFormat(pattern="MM/dd/yyyy")
@Temporal(javax.persistence.TemporalType.DATE)
Date enddate;

@Column(name = "engtracker")
int engtracker;

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    public int getMandays() {
        return mandays;
    }

    public void setMandays(int mandays) {
        this.mandays = mandays;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public int getTemplateid() {
        return templateid;
    }

    public void setTemplateid(int templateid) {
        this.templateid = templateid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLeadid() {
        return leadid;
    }

    public void setLeadid(int leadid) {
        this.leadid = leadid;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }



public Date getStartdate()  {
    return startdate;
}

public void setStartdate(Date startdate)  {
    this.startdate = startdate;
}
 
public Date getEnddate()  {
    return enddate;
}

public void setEnddate(Date enddate)  {
    this.enddate = enddate;
}

    public int getEngtracker() {
        return engtracker;
    }

    public void setEngtracker(int engtracker) {
        this.engtracker = engtracker;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getCompliance() {
        return compliance;
    }

    public void setCompliance(String compliance) {
        this.compliance = compliance;
    }

    public String getWhitelisting() {
        return whitelisting;
    }

    public void setWhitelisting(String whitelisting) {
        this.whitelisting = whitelisting;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }



}
