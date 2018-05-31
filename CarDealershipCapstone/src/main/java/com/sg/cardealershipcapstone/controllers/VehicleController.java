/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.controllers;

import com.sg.cardealershipcapstone.models.Vehicle;
import com.sg.cardealershipcapstone.models.VehicleSearchCriteria;
import com.sg.cardealershipcapstone.services.Result;
import com.sg.cardealershipcapstone.services.VehicleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emmastout
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles().getPayload();
    }

    @GetMapping("/new")
    public List<Vehicle> getNewVehicles(VehicleSearchCriteria criteria) {
        return service.getNewVehicles(criteria).getPayload();
    }

    @GetMapping("/used")
    public List<Vehicle> getUsedVehicles() {
        return service.getUsedVehicles().getPayload();
    }

    @GetMapping("/featured")
    public List<Vehicle> getFeaturedehicles() {
        return service.getFeaturedVehicles().getPayload();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable int vehicleId) {
        return service.getVehicleById(vehicleId).getPayload();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v) {
        Result<Vehicle> result = service.addVehicle(v);
        if (result.isSuccess()) {
            return ResponseEntity.ok(v);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editVehicle(@PathVariable int vehicleId, @RequestBody Vehicle vehicle) {

        if (vehicle.getVehicleId() <= 0 || vehicleId <= 0 || vehicleId != vehicle.getVehicleId()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Result<Vehicle> result = service.addVehicle(vehicle);
        if (result.isSuccess()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteVehicle(@PathVariable int vehicleId) {
        Result result = service.deleteById(vehicleId);
        if (result.isSuccess()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
