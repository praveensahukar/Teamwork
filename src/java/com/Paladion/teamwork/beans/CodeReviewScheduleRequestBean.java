/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.beans;

import java.io.Serializable;
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
@Table(name = "codereviewschedulereq",catalog="teamwork")
public class CodeReviewScheduleRequestBean implements Serializable
{
@Id
@GenericGenerator(name="gen",strategy="increment")
@GeneratedValue(generator="gen")
@Column(name = "cr_scheduleid", unique = true, nullable = false, precision = 15, scale = 0)
int cr_scheduleid;


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

@Column(name = "scope")
String scope;

@Column(name = "appname")
String appname;

@Column(name = "access")
String access;

@Column(name = "technology")
String technology;

@Column(name = "effort")
String effort;

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getCr_scheduleid() {
        return cr_scheduleid;
    }

    public void setCr_scheduleid(int cr_scheduleid) {
        this.cr_scheduleid = cr_scheduleid;
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

    public String getScope() {
        return scope;
    }
    
    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getEffort() {
        return effort;
    }
    public void setEffort(String effort) {
        this.effort = effort;
    }
}
