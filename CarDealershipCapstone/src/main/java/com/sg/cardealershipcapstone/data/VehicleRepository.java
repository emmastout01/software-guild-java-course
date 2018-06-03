/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.data;

import com.sg.cardealershipcapstone.models.Vehicle;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author emmastout
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query(value = "SELECT * FROM Vehicle v"
            + "Inner join Model mo on v.ModelId = mo.ModelId"
            + "Inner join Make ma on v.MakeId = ma.MakeId"
            + "WHERE"
            + "`Type` LIKE ?1"
            + "AND ('' = ?2 or ma.Make LIKE ?2)"
            + "AND ('' = ?3 or mo.Model LIKE ?3)"
            + "AND ('' = ?4 or `Year` LIKE ?4)"
            + "AND ('' = ?5 or `Year` > ?5)"
            + "AND ('' = ?6 or `Year` < ?6)"
            + "AND ('' = ?7 or SalePrice > ?7)"
            + "AND ('' = ?8 or SalePrice < ?8)"
            + "AND `Sold` = ?9"
            + "ORDER BY MSRP DESC LIMIT 20;", nativeQuery = true)
    public List<Vehicle> getNewOrUsedVehicleSearch(String type, String make, 
            String model, int year, int minYear, int maxYear, 
            BigDecimal minPrice, BigDecimal maxPrice, String sold);
    
    @Query(value = "SELECT * FROM Vehicle v"
            + "Inner join Model mo on v.ModelId = mo.ModelId"
            + "Inner join Make ma on v.MakeId = ma.MakeId"
            + "WHERE"
            + "`Sold` = ?1"
            + "AND ('' = ?2 or ma.Make LIKE ?2)"
            + "AND ('' = ?3 or mo.Model LIKE ?3)"
            + "AND ('' = ?4 or `Year` LIKE ?4)"
            + "AND ('' = ?5 or `Year` > ?5)"
            + "AND ('' = ?6 or `Year` < ?6)"
            + "AND ('' = ?7 or SalePrice > ?7)"
            + "AND ('' = ?8 or SalePrice < ?8)"
            + "ORDER BY MSRP DESC LIMIT 20;", nativeQuery = true)
    public List<Vehicle> getAllAvailableVehiclesSearch(String sold, String make, 
            String model, int year, int minYear, int maxYear, 
            BigDecimal minPrice, BigDecimal maxPrice);

    
    @Query(value = "SELECT * FROM Vehicle WHERE Featured = true", nativeQuery = true)
    public List<Vehicle> getFeaturedVehicles();
    
}
