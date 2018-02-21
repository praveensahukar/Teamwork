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
 * @author Santhosh
 */

@Entity
@Table(name = "resource_tracker",catalog="teamwork")
public class AllocationBean implements Serializable {
    @Id
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Column(name = "trackerid", unique = true, nullable = false, precision = 15, scale = 0)
    int trackerid;
    
    @Column(name = "engineerid")
    int engineerId;
    
    @Column(name = "activityid")
    int activityId;
    
    @Column(name = "status")
    String status;
    
    
    @Column(name = "allocationenddate")
    @DateTimeFormat (pattern="MM/dd/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date allocationEndenddate;
    
    
    @Column(name = "allocationstartdate")
    @DateTimeFormat (pattern="MM/dd/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date allocationStartdate;

    
    public int getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(int engineerId) {
        this.engineerId = engineerId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAllocationEndenddate() {
        return allocationEndenddate;
    }

    public void setAllocationEndenddate(Date allocationEndenddate) {
        this.allocationEndenddate = allocationEndenddate;
    }

    public Date getAllocationStartdate() {
        return allocationStartdate;
    }

    public void setAllocationStartdate(Date allocationStartdate) {
        this.allocationStartdate = allocationStartdate;
    }

    public int getTrackerid() {
        return trackerid;
    }

    public void setTrackerid(int trackerid) {
        this.trackerid = trackerid;
    }
    
    
}
