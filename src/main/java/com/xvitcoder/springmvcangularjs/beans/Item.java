package com.xvitcoder.springmvcangularjs.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;

import java.math.BigDecimal;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private String description;
    private Double price;

//    public Item(Long id, String name, String description, Double price) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//    }

    // Link to image - optional


}
