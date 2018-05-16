
package com.sg.vendingmachine;
import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
@Configuration
@ComponentScan
public class App {
    public static void main(String[] args) 
            throws VendingMachinePersistenceException{
//        
//        VendingMachineView view = new VendingMachineView();
//        VendingMachineDao dao = new VendingMachineDaoFileImpl();
//        VendingMachineService service = new VendingMachineServiceImpl(dao);
//        VendingMachineController controller = 
//                new VendingMachineController(view, dao, service);
//        
//        controller.run();

    ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    
    VendingMachineController controller = 
            context.getBean(VendingMachineController.class);
    
    controller.run();
    }
}
