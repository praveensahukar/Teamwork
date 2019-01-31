package com.Paladion.teamwork.services;



import java.util.List;
import java.util.Date;

import com.Paladion.teamwork.DAO.UserDAO;
import com.Paladion.teamwork.beans.UserDataBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl implements UserService{
	
@Autowired
@Qualifier(value="UserDAO")
UserDAO userDAO;
	
@Override
	public boolean addUser(UserDataBean loginBean) {
            loginBean.setStatus("Active");
		return userDAO.addUser(loginBean);
		//System.out.println("com.Paladion.teamwork.services.UserServiceImpl.addUser()");	
            }
	
	
	
//	@Override
//	public List<UserDataBean> getUsersByRole(String role) {
//		return userDAO.getUsersByRole(role);
//	}
        
        @Override
	public List<UserDataBean> GetAllUser() {
		return userDAO.GetAllUser();
		
}

    @Override
    public boolean DeleteUser(int id) {
        return userDAO.DeleteUser(id);
    }
    
    @Override
	 public boolean UpdateUserDetails(UserDataBean LB) {
		return userDAO.UpdateUserDetails(LB);
		
}

    
@Override
public UserDataBean GetUserById(int id){
    
    return userDAO.GetUserById(id);
}

@Override
public List<UserDataBean> getAvailableEngineers(Date projStartDate, Date projEndDate, List<UserDataBean> AllEng){
    
   
        
        List list1 = userDAO.getAvailableEngineers(projStartDate, projEndDate);
        int[] userIDs = new int[list1.size()];
        int index=0;
        for(Object uid : list1){
            userIDs[index] = (int) uid;
            index++;
        }
 
        List <UserDataBean> UserList = new ArrayList<>();
        int i=0;
        for(UserDataBean uBean : AllEng){
            boolean flag = true;
            for(i=0; i< list1.size();i++){
            if(uBean.getUserid()== userIDs[i] || uBean.getStatus().equalsIgnoreCase("inactive")){
                flag=false;
                }    
            }
            if(flag == true){
                UserList.add(uBean);
            }
        }
    return UserList;
    
}   

    public List<UserDataBean> GetUsersByRole(String role){
        return userDAO.GetUsersByRole(role);
    }
    

		
}




