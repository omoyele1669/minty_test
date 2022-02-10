/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minty.mintytest.dbentities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity

@Table(name = "tbl_orders")
public class OrderEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    @Column(name = "customer_name")
    private String customername;
    @Column(name = "customer_phonenumber")
    private String customerphonenumber;
    @Column(name = "order_quantity")
    private Double orderquantity;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "total_price")
    private Double totalPrice;
    
    
}
