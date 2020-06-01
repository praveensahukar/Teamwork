/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.UserDataBean;
import com.Paladion.teamwork.beans.TemplateBean;
import java.util.Date;

import java.util.List;


/**
 *
 * @author user
 */
public interface UserDAO {

	//public void addUserDao(UserBean Ubean);
	//public List<UserDataBean> getUsersByRole(String role);

	public boolean addUser(UserDataBean loginbean);
        
        public List<UserDataBean> GetAllUser();
        
        public boolean DeleteUser(int id);
        
       public boolean UpdateUserDetails(UserDataBean LB);
       
       public UserDataBean GetUserById(int id);
       
       public List getAvailableEngineers(Date projStartDate, Date projEndDate);
       
       public List<UserDataBean> GetUsersByRole(String role); 

    public List<UserDataBean> GetAllCodeReviewUser();

    public List<UserDataBean> GetAllAppSecUser();

    public List<UserDataBean> GetAllNetUser();

}
