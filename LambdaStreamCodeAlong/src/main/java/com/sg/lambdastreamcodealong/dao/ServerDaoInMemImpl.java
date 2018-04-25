/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdastreamcodealong.dao;

import com.sg.lambdastreamcodealong.dto.Server;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author emmastout
 */
public class ServerDaoInMemImpl implements ServerDao {

    private Map<String, Server> serverMap = new HashMap<>();

    @Override
    public void addServer(Server server) {
        serverMap.put(server.getName(), server);
    }

    @Override
    public Server getServer(String name) {
        return serverMap.get(name);
    }

    @Override
    public void removeServer(String name) {
        serverMap.remove(name);
    }

    //One of the constructors for ArrayList takes in a collection 
    //and converts it into an ArrayList. How handy for us!
    @Override
    public List<Server> getAllServers() {
        return new ArrayList<Server>(serverMap.values());
    }

    @Override
    public Map<String, List<Server>> getAllServersGroupByManufacturer() {
        //We want to get all the servers back, but instead of just one list we want to put them in a map, where key is manu name and value for each key is a list of all servers associated with that manu
        //First, get values from map
        return serverMap.values()
                //Grab the stream for this collection of server objects
                .stream()
                //Here, we don't want to do any filter operations
                //We just want one terminal operation that will transform the collection into a map that we will return
                .collect(Collectors.groupingBy(Server::getManufacturer));
        //:: syntax: For every server that comes through, call the getManu method on it. 
    }

    @Override
    public List<Server> getServersByManufacturer(String manufacturer) {
        return serverMap.values()
                .stream()
                //Filter takes a method that takes a server in, and then it will filter out based on criteria we put in.
                //Whatever we put in here that comes back true, we will keep
                .filter(s -> s.getManufacturer().equalsIgnoreCase(manufacturer))
                //Takes whatever is passed in, collects into a list, and returns that
                .collect(Collectors.toList());
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() >= ageInYears)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears) {
        //Similar to above method, but we want to collect into a map instead of a list
        return serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() >= ageInYears)
                .collect(Collectors.groupingBy(Server::getManufacturer));

    }

    @Override
    public double getAverageServerAge() {
        return serverMap.values()
                .stream()
                //Take a stream of servers and convert it into stream of longs
                //Below syntax does the same thing as the :: syntax in above methods
                .mapToLong(s -> s.getServerAge())
                //Pass stream of longs into average; this will calc average
                .average()
                //Get the average as a double
                .getAsDouble();
    }

}
