
package com.sg.vendingmachine;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emmastout
 */
//@Configuration
//@ComponentScan
@SpringBootApplication
public class App {
    public static void main(String[] args) 
            throws VendingMachinePersistenceException{
//    ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//    VendingMachineController controller = 
//            context.getBean(VendingMachineController.class);
//    controller.run();

        SpringApplication.run(App.class, args);
    }
}
