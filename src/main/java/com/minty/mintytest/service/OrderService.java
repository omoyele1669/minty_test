/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minty.mintytest.service;

import com.minty.mintytest.dbentities.OrderEntity;
import com.minty.mintytest.dbentities.ProductEntity;
import com.minty.mintytest.models.RequestPayload;
import com.minty.mintytest.models.ResponseModel;
import com.minty.mintytest.repository.OrderRepository;
import com.minty.mintytest.repository.ProductRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Developer
 */
@Service
public class OrderService {
    
    @Autowired
    ProductRepository productRepository;
    @Autowired 
    OrderRepository orderRepository;
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    
   public ResponseModel createOrder(RequestPayload request)
    {   
        ResponseModel responseModel = new ResponseModel();
        LOGGER.info("Order Request::: "+request.toString());
        ProductEntity pe = productRepository.findById(request.getProductId()).get();
        if(pe != null){
            if(pe.getAvailableStock() > 0  && pe.getAvailableStock() >= request.getOrderQuantity()){
                OrderEntity order = new OrderEntity();
                order.setCustomername(request.getCustomerName());
        order.setCustomerphonenumber(request.getCustomerPhonenumber());
        order.setOrderquantity(request.getOrderQuantity());
        order.setProductId(request.getProductId());
        order.setTotalPrice(pe.getProductPrice() * request.getOrderQuantity());
        
        try{
            orderRepository.save(order);
         responseModel.setResponseCode("00");
            responseModel.setResponseMessage("Order successfully inserted");
        }catch(Exception ex){
         LOGGER.info("error occurred ::: "+ex.getMessage());
            responseModel.setResponseCode("01");
            responseModel.setResponseMessage("Error Creating Orde");
        }
        
            }
            else
            {
                responseModel.setResponseCode("01");
                responseModel.setResponseMessage("Low stock");
                        
            }
        }
        else
        {
            responseModel.setResponseCode("01");
            responseModel.setResponseMessage("Product cannot be found");
        }
        
        return responseModel;
        
    }
   
}
