/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.services;

import com.sg.cardealershipcapstone.data.VehicleRepository;
import com.sg.cardealershipcapstone.models.Vehicle;
import com.sg.cardealershipcapstone.models.VehicleSearchCriteria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author emmastout
 */
@Service
public class VehicleService {

    @Autowired
    VehicleRepository repo;

    public Result<List<Vehicle>> getAllVehicles() {
        Result<List<Vehicle>> result = new Result<>();
        result.setPayload(repo.findAll());
        return result;
    }

    public Result<List<Vehicle>> getNewVehicles(VehicleSearchCriteria criteria) {
        Result<List<Vehicle>> result = new Result<>();
        result.setPayload(repo.getNewVehicleSearch("New", criteria.getMake().getMake(),
                criteria.getModel().getModel(), criteria.getYear(), criteria.getMinYear(),
                criteria.getMaxYear(), criteria.getMinSalePrice(),
                criteria.getMaxSalePrice()));
        return result;
    }

    public Result<List<Vehicle>> getUsedVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Result<List<Vehicle>> getFeaturedVehicles() {
        Result<List<Vehicle>> result = new Result<>();
        result.setPayload(repo.getFeaturedVehicles());
        return result;
    }

    public Result<Vehicle> addVehicle(Vehicle v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Result deleteById(int vehicleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Result<Vehicle> getVehicleById(int vehicleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
