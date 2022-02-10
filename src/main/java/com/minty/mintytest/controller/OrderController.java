/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minty.mintytest.controller;

import com.minty.mintytest.models.RequestPayload;
import com.minty.mintytest.models.ResponseModel;
import com.minty.mintytest.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Developer
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
   OrderService orderService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
   
    @PostMapping(value = "/createorder")   
    public  ResponseModel createOrder(@RequestBody RequestPayload request) {
        
        return orderService.createOrder(request);
    }
}
