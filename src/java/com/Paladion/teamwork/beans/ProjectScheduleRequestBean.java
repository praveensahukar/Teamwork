/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author pal
 */


@Entity
@Table(name = "projschedulereq",catalog="teamwork")
public class ProjectScheduleRequestBean implements Serializable
{
@Id
@GenericGenerator(name="gen",strategy="increment")
@GeneratedValue(generator="gen")
@Column(name = "proj_scheduleid", unique = true, nullable = false, precision = 15, scale = 0)
int proj_scheduleid;


@Column(name = "projectid")
int projectid;

@Column(name = "reporting_req")
String reporting_req;

@Column(name = "regulation_compliance")
String regulation_compliance;

@Column(name = "whitelisting")
String whitelisting;

@Column(name = "hosting_env")
String hosting_env;

    public int getProj_scheduleid() {
        return proj_scheduleid;
    }

    public void setProj_scheduleid(int proj_scheduleid) {
        this.proj_scheduleid = proj_scheduleid;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getReporting_req() {
        return reporting_req;
    }

    public void setReporting_req(String reporting_req) {
        this.reporting_req = reporting_req;
    }

    public String getRegulation_compliance() {
        return regulation_compliance;
    }

    public void setRegulation_compliance(String regulation_compliance) {
        this.regulation_compliance = regulation_compliance;
    }

    public String getWhitelisting() {
        return whitelisting;
    }

    public void setWhitelisting(String whitelisting) {
        this.whitelisting = whitelisting;
    }

    public String getHosting_env() {
        return hosting_env;
    }

    public void setHosting_env(String hosting_env) {
        this.hosting_env = hosting_env;
    }





}
