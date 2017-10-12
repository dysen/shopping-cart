package com.xvitcoder.springmvcangularjs.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class BasketItem {

    private Double delivery;
    private Double subTotal;
    private Double totalAmount;
    private List<BasketLineItem> basketLineItems;
    private String message;
}
