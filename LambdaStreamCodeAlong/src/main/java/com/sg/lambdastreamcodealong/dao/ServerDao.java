/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdastreamcodealong.dao;

import com.sg.lambdastreamcodealong.dto.Server;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emmastout
 */
public interface ServerDao {
    //First 4 methods are familiar, look like DAOs we've seen in the past

    public void addServer(Server server);

    public Server getServer(String name);

    public void removeServer(String name);

    public List<Server> getAllServers();
    
    
    //Go into server inventory, get all, 
    //sort by manufact, and put them into a map
    public Map<String, List<Server>> getAllServersGroupByManufacturer();

    //Pass manufact in, will only give us servers by that manufact
    public List<Server> getServersByManufacturer(String manufacturer);

    //Get servers older than an age
    public List<Server> getServersOlderThan(int ageInYears);

    //Filter by age, then sort by manufact
    public Map<String, List<Server>>
            getServersOlderThanGroupByManufacturer(int ageInYears);

    //Get avg age of servers in our inventory
    public double getAverageServerAge();
}
