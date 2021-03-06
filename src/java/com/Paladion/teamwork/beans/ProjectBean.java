/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Santhosh
 */

@Entity
@Table(name = "projects",catalog="teamwork")
public class ProjectBean implements Serializable {
    
@Id
@GenericGenerator(name="gen",strategy="increment")
@GeneratedValue(generator="gen")
@Column(name = "projectid", unique = true, nullable = false, precision = 15, scale = 0)
int projectid;
    
@Column(name = "projectname")
String projectname;

@Column(name = "companyid")
int companyid;

@Column(name = "opid")
String opid;

@Column(name = "deliverymanager")
int deliverymanager;

@Column(name = "projectmanager")
int projectmanager;

@Column(name = "description")
String description;

@Column(name = "region")
String region;

@Column (name = "revenue")
int revenue;

@Column(name="complaince")
 String complaince;

@Column(name="reporting")
String reporting;

@Column(name="clspoc")
String clspoc;

    public String getComplaince() {
        return complaince;
    }

    public void setComplaince(String complaince) {
        this.complaince = complaince;
    }

    public String getReporting() {
        return reporting;
    }

    public void setReporting(String reporting) {
        this.reporting = reporting;
    }

    public String getClspoc() {
        return clspoc;
    }

    public void setClspoc(String clspoc) {
        this.clspoc = clspoc;
    }


   public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getDeliverymanager() {
        return deliverymanager;
    }

    public void setDeliverymanager(int deliverymanager) {
        this.deliverymanager = deliverymanager;
    }

    public int getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(int projectmanager) {
        this.projectmanager = projectmanager;
    }
    
//    @OneToMany(targetEntity =ProjectOPIDMapper.class, mappedBy="pbean", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    private List<ProjectOPIDMapper> OPIDList;
//    
//    public List<ProjectOPIDMapper> getOPIDList() {
//        return OPIDList;
//    }
//
//    public void setOPIDList(List<ProjectOPIDMapper> OPIDList) {
//        this.OPIDList = OPIDList;
//    }
    
    
}
