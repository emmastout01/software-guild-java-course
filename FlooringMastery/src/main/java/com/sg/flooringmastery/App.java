/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery;

import com.sg.flooringmastery.controller.FlooringController;
import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.OrderDaoFileImpl;
import com.sg.flooringmastery.dao.ProductDao;
import com.sg.flooringmastery.dao.ProductDaoFileImpl;
import com.sg.flooringmastery.dao.StateDao;
import com.sg.flooringmastery.dao.StateDaoFileImpl;
import com.sg.flooringmastery.service.FlooringService;
import com.sg.flooringmastery.ui.ConsoleIO;
import com.sg.flooringmastery.ui.FlooringView;

/**
 *
 * @author emmastout
 */
public class App {
    public static void main(String[] args) {
        
        ConsoleIO io = new ConsoleIO();
        FlooringView view = new FlooringView(io);
        OrderDao odao = new OrderDaoFileImpl();
        ProductDao pdao = new ProductDaoFileImpl();
        StateDao sdao = new StateDaoFileImpl();
        FlooringService service = new FlooringService(odao, pdao, sdao);
        
        FlooringController controller = new FlooringController(view, service);
        
        controller.run();
    }
}
