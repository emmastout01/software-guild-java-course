/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery;

import com.sg.flooringmastery.controller.FlooringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author emmastout
 */
public class App {
    public static void main(String[] args) {
        
//        ConsoleIO io = new ConsoleIO();
//        FlooringView view = new FlooringView(io);
//        OrderDao odao = new OrderDaoFileImpl();
//        ProductDao pdao = new ProductDaoFileImpl();
//        StateDao sdao = new StateDaoFileImpl();
//        FlooringService service = new FlooringService(odao, pdao, sdao);
//        
//        FlooringController controller = new FlooringController(view, service);
//        
//        controller.run();
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller
                = ctx.getBean("controller", FlooringController.class);
        controller.run();
       

    }
    
       
}
