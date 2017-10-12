package com.xvitcoder.springmvcangularjs.controller;

import com.xvitcoder.springmvcangularjs.beans.Item;
import com.xvitcoder.springmvcangularjs.service.ItemService;
import com.xvitcoder.springmvcangularjs.service.ItemServiceImpl;
import com.xvitcoder.springmvcangularjs.service.ShoppingBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @RequestMapping("/itemlist.json")
    public @ResponseBody
    List<Item> getItems(){return itemService.getAllItems();}

    @RequestMapping("/add")
    public @ResponseBody
    void addItem(@RequestBody Item item){ shoppingBasketService.addItem(item);}



    @RequestMapping("/layout")
    public String getRailwayStationPartialPage(ModelMap modelMap) {
        return "items/layout";
    }
}
