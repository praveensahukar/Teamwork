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
 * @author santosh.babar
 */
@Entity
@Table(name = "tasks",catalog="teamwork")
public class TeamBean implements Serializable {
    
@Id
@GenericGenerator(name="gen",strategy="increment")
@GeneratedValue(generator="gen")
@Column(name = "teamId", unique = true, nullable = false)
int teamId;	 

    public int getTeamid() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    

@Column(name = "teamname")
String teamname;

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
    

}
