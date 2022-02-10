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
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;
    @Autowired 
    OrderRepository orderRepository;
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    public ResponseModel createProduct(RequestPayload request)
    {
        ProductEntity product = new ProductEntity();
        product.setAvailableStock(request.getAvailableStock());
        product.setProductDescription(request.getDescription());
        product.setProductName(request.getName());
        product.setProductPrice(request.getPrice());
        ResponseModel responseModel = new ResponseModel();
        try{
            productRepository.save(product);
            responseModel.setResponseCode("00");
            responseModel.setResponseMessage("Product successfully inserted");
        }
        catch(Exception ex)
        {
            LOGGER.info("error occurred ::: "+ex.getMessage());
            responseModel.setResponseCode("01");
            responseModel.setResponseMessage("Error saving product");
        }
        return responseModel;
        
    }
    
    public ResponseModel getProduct()
    {
       List<ProductEntity> productEntity = productRepository.findAll();
        ResponseModel responseModel = new ResponseModel();
        responseModel.setResponseCode("00");
        responseModel.setResponseMessage("Product fetched successfully");
        responseModel.setData(productEntity);
        return responseModel;
        
    } 
    
    
    // Update operation
    public ResponseModel updateProduct(RequestPayload request,Long id)
    {
         ProductEntity pe = productRepository.findById(id).get();
         ResponseModel response = new ResponseModel();
         if(pe!=null)
         {
             if(request.getAvailableStock()!=null)
             {
                 pe.setAvailableStock(request.getAvailableStock());
             }
             if(request.getDescription() != null){
                 pe.setProductDescription(request.getDescription());
             }if(request.getName() != null){
                 pe.setProductName(request.getName());
             }if(request.getPrice() != null){
                 pe.setProductPrice(request.getPrice());
             }
               productRepository.save(pe);
               response.setResponseCode("00");
               response.setResponseMessage("Product updated successfully");
               response.setData(pe);
         }
         else
         {
             response.setResponseCode("01");
             response.setResponseMessage("Product not found");
             response.setData(request);
         }
         return response;
    }
    
    
   
}
