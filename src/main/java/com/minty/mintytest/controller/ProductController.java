/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minty.mintytest.controller;

import com.minty.mintytest.models.RequestPayload;
import com.minty.mintytest.models.ResponseModel;
import com.minty.mintytest.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Developer
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    
    @GetMapping(value = "/getproduct")   
    public  ResponseModel getProduct() {
        
        return productService.getProduct();
    }
    
    @PostMapping(value = "/createproduct")   
    public  ResponseModel createProduct(@RequestBody RequestPayload request) {
        
        return productService.createProduct(request);
    }
    
  @PutMapping(value = "/updateproduct/{id}")   
    public  ResponseModel updateProduct(@RequestBody RequestPayload request, @PathVariable Long id) {
        
        return productService.updateProduct(request,id);
    }
   
}
