/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.CompanyBean;
import java.util.List;

/**
 *
 * @author Santhosh
 */
public interface CompanyService {
	
	public void addCompany(CompanyBean tb);
    public void editCompany(CompanyBean tb);
    public List<CompanyBean> getAllCompany();
    public boolean deleteCompany(int id);
    public CompanyBean getCompanyByID(int id);
    
}

