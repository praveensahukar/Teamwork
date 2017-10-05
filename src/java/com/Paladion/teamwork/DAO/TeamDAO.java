/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.TeamBean;
import java.util.List;

/**
 *
 * @author santosh.babar
 */
public interface TeamDAO {
    public void addTeamDao(TeamBean tb);
	public List<TeamBean> getAllTeams();
        public boolean deleteTeam(int id);
}
