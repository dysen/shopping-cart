package com.xvitcoder.springmvcangularjs.controller;

import com.xvitcoder.springmvcangularjs.beans.BasketItem;
import com.xvitcoder.springmvcangularjs.beans.Item;
import com.xvitcoder.springmvcangularjs.service.ShoppingBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/basket")
public class ShoppingBasketController {

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public @ResponseBody void addItem(@PathVariable Item item){shoppingBasketService.addItem(item);}

    @RequestMapping("/current")
    public @ResponseBody
    BasketItem getItems(){
        BasketItem basket = shoppingBasketService.getBasket();

        return basket;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public @ResponseBody
    void removeItem(@RequestBody Item item){ shoppingBasketService.removeItem(item);}

    @RequestMapping("/layout")
    public String getRailwayStationPartialPage(ModelMap modelMap) {
        return "basket/layout";
    }
//#id Item # qauntity # price # sum#
//Total Articles (1)	€ 29.99
//Shipping cost Tooltip	Free
//    Total













}
