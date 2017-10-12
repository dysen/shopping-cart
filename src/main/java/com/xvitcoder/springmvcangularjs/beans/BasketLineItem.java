package com.xvitcoder.springmvcangularjs.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BasketLineItem {
    private Item item;
    private Long quantity;
    private Double price;
    private Double amount;

}
