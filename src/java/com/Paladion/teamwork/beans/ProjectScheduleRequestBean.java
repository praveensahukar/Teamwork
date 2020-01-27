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

@Column(name = "requirements")
String requirements;

@Column(name = "compliance")
String compliance;

@Column(name="opid")
String opid;

@Column(name = "whitelisting")
String whitelisting;

@Column(name = "Hosting")
String Hosting;

@Column(name = "clspoc")
String clspoc;

@Column(name = "Pre_reques")
String Pre_reques;

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getCompliance() {
        return compliance;
    }

    public void setCompliance(String compliance) {
        this.compliance = compliance;
    }

    public String getHosting() {
        return Hosting;
    }

    public void setHosting(String Hosting) {
        this.Hosting = Hosting;
    }

    public String getClspoc() {
        return clspoc;
    }

    public void setClspoc(String clspoc) {
        this.clspoc = clspoc;
    }

    public String getPre_reques() {
        return Pre_reques;
    }

    public void setPre_reques(String Pre_reques) {
        this.Pre_reques = Pre_reques;
    }
    
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

    public String getWhitelisting() {
        return whitelisting;
    }

    public void setWhitelisting(String whitelisting) {
        this.whitelisting = whitelisting;
    }
    
}
