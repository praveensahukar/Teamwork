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
@Table(name = "vascanschedulereq",catalog="teamwork")
public class vascanScheduleRequestBean {
    
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
 
 @Column(name="vpnConn")
 String vpnConn;
 
 @Column(name="timewindow")
String timewindow;

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

    public String getVpnConn() {
        return vpnConn;
    }

    public void setVpnConn(String vpnConn) {
        this.vpnConn = vpnConn;
    }

    public String getTimewindow() {
        return timewindow;
    }

    public void setTimewindow(String timewindow) {
        this.timewindow = timewindow;
    }

}
