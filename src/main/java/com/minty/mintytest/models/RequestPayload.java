/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minty.mintytest.models;

/**
 *
 * @author Developer
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "price",
        "description",
        "availableStock",
        "id",
        "orderId",
        "customerName",
        "customerPhonenumber",
        "orderQuantity",
        "productId"
})
public class RequestPayload {
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("description")
    private String description;
    @JsonProperty("availableStock")
    private Integer availableStock;
     @JsonProperty("id")
    private Long id;
     @JsonProperty("orderId")
    private String orderId;
     @JsonProperty("customerName")
    private String customerName;
     @JsonProperty("customerPhonenumber")
    private String customerPhonenumber;
      @JsonProperty("orderQuantity")
    private Double orderQuantity;
         @JsonProperty("productId")
    private Long productId;
}
