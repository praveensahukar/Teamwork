/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.services;

import com.Paladion.teamwork.beans.Vehiclebean;
import java.util.List;

/**
 *
 * @author pal
 */
public interface VehicleService {
    
    public void addVehicle(Vehiclebean vb);

    public List<Vehiclebean> GetAllVehicle();

    public Object GetVehicleById(int id);

    public boolean DeleteVehicle(int id);

    public boolean UpdateVehicleDetails(Vehiclebean vehicleBean);
}
