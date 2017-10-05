/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.TeamBean;
import java.util.List;

/**
 *
 * @author santosh.babar
 */
public interface TeamService {
    
    public void addTeam(TeamBean tb);
    public List<TeamBean> getAllTeams();
    public boolean deleteTeam(int id);
}
