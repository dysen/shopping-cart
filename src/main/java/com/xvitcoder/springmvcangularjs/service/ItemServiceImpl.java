package com.xvitcoder.springmvcangularjs.service;

import com.xvitcoder.springmvcangularjs.beans.Item;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    private List<Item> items = new ArrayList<>();

//    public void ItemService(){
//        initData();
//    }

    @Override
    public List<Item> getAllItems() {
        items.clear();
        items.add(new Item(1L, "Box", "Description", new Double(1)));
        items.add(new Item(2L, "Box2", "Description2", new Double(3)));
        items.add(new Item(3L, "Box3", "Description3", new Double(5)));
        items.add(new Item(4L, "Box4", "Description4", new Double(4)));
        items.add(new Item(5L, "Box5", "Description5", new Double(6)));
        items.add(new Item(6L, "Box6", "Description6", new Double(8)));
        items.add(new Item(7L, "Box7", "Description7", new Double(9)));
        items.add(new Item(8L, "Box8", "Description8", new Double(10)));
        return items;
    }


}
