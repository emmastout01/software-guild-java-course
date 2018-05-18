/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Treat;
import com.sg.vendingmachine.service.VendingMachineService;
import java.awt.print.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emmastout
 */
@RestController
public class SpringController {

    private VendingMachineDao dao;
    private VendingMachineService service;

    @Autowired
    public SpringController(
            VendingMachineDao dao, VendingMachineService service) {
        this.dao = dao;
        this.service = service;
    }

    @GetMapping("/items")
    public List<Treat> getTreats() {
        return service.getTreats();
    }

    @GetMapping("/money/{amount}/item/{id}")
    public List<Book> getAllBooks() {
        return bookService.all().getPayload();
    }

}
