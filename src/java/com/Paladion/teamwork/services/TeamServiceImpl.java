/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.DAO.TeamDAO;
import com.Paladion.teamwork.beans.TeamBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.List;
/**
 *
 * @author santosh.babar
 */
public class TeamServiceImpl implements TeamService  {
    
@Autowired
@Qualifier(value="TeamDAO")
TeamDAO TD;
	
	@Override
	public void addTeam(TeamBean tb) {
		TD.addTeamDao(tb);
            }

	@Override
	public List<TeamBean> getAllTeams() {
		System.out.println("Inside TaskServiceImpl -getAllTaks method");
	        return  TD.getAllTeams();
            }
        
        @Override
        public boolean deleteTeam(int id) {
                return TD.deleteTeam(id);
            }
    
}
