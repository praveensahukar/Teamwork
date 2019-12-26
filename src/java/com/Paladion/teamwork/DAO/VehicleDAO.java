/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.DAO;

import com.Paladion.teamwork.beans.Vehiclebean;
import java.util.List;

/**
 *
 * @author pal
 */
public interface VehicleDAO {
    
    
	public void addVehicleDao(Vehiclebean vb);

    public List<Vehiclebean> addVehicleDao();

    public Object GetVehicleById(int id);

    public boolean deleteVehicle(int id);

    public boolean UpdateVehicleDetails(Vehiclebean vehicleBean);
}
