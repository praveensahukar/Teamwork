/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.CompanyBean;
import java.util.List;

/**
 *
 * @author Santhosh
 */
public interface CompanyDAO {
    public void addCompanyDao(CompanyBean cb);
	public List<CompanyBean> getAllCompany();
        public boolean deleteCompany(int id);
}
