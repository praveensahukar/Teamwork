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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author santosh.babar
 */
@Entity
@Table(name = "projects_opid",catalog="teamwork")
public class ProjectOPIDMapper implements Serializable{
    
@Id
@GenericGenerator(name="gen",strategy="increment")
@GeneratedValue(generator="gen")
@Column(name = "mapperid", unique = true, nullable = false, precision = 15, scale = 0)
int mapperid;

@Column(name = "opid")   
String opid;

@ManyToOne
@JoinColumn(name="pid")
ProjectBean pbean;

    public int getMapperid() {
        return mapperid;
    }

    public void setMapperid(int mapperid) {
        this.mapperid = mapperid;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }
    
    
    public ProjectBean getPbean() {
        return pbean;
    }

    public void setPbean(ProjectBean pbean) {
        this.pbean = pbean;
    }
   
}
