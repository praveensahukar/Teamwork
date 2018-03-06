/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.DAO.CompanyDAO;
import com.Paladion.teamwork.beans.CompanyBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Santhosh
 */
public class CompanyServiceImpl implements CompanyService{

@Autowired
@Qualifier(value="CompanyDAO")
CompanyDAO CD;
	
	@Override
	public void addCompany(CompanyBean cb) {
		CD.addCompanyDao(cb);
            }

	@Override
	public void editCompany(CompanyBean cb) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

	
	@Override
	public List<CompanyBean> getAllCompany() {
		System.out.println("Inside TaskServiceImpl -getAllTaks method");
	        return  CD.getAllCompany();
            }
        
        @Override
        public boolean deleteCompany(int id) {
                return CD.deleteCompany(id);
            }
        
        @Override
        public CompanyBean getCompanyByID(int id){
            return CD.getCompanyByID(id);
        }
	
}
