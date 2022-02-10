/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minty.mintytest.dbentities;

/**
 *
 * @author Developer
 */
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity

@Table(name = "tbl_products")
public class ProductEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private Double productPrice;
    @Column(name = "product_available_stock")
    private int availableStock;
    @Column(name = "product_description")
    private String productDescription;
   
    
    
}
