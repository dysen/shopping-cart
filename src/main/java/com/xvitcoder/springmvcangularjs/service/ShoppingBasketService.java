package com.xvitcoder.springmvcangularjs.service;

import com.sun.javafx.binding.StringFormatter;
import com.xvitcoder.springmvcangularjs.beans.BasketItem;
import com.xvitcoder.springmvcangularjs.beans.BasketLineItem;
import com.xvitcoder.springmvcangularjs.beans.Item;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("basketService")
public class ShoppingBasketService {

    private List<Item> items;
    private Map<Item, Long> itemCountMap;
    private static final Double deliveryCostDefault = new Double(15);
    private Double deliveryCostActual;
    private static final Double discountLevel = new Double(20);
    private Double subTotal;
    private Double total;
    private static String deliveryMessage = "";

    public ShoppingBasketService() {
        this.items = new ArrayList<>();
    }

    private BasketItem shoppingBasketData;

    private List<Item> getAllItems() {
        return items;
    }


    public BasketItem getBasket() {
        createShoppingBasketItem();
        return shoppingBasketData;
    }

    private void createShoppingBasketItem() {
        getItemCountMap();
        calculateSubTotal();
        calculateDeliveryCost();
        calculateTotalAmount();
        getDeliveryMessage();

        shoppingBasketData = BasketItem.builder()
                .subTotal(subTotal)
                .delivery(deliveryCostActual)
                .totalAmount(total)
                .basketLineItems(getOrderDetails())
                .message(deliveryMessage)
                .build();
    }

    private List<BasketLineItem> getOrderDetails() {
        List<BasketLineItem> basketLineItems = new ArrayList<>();


        for (Map.Entry<Item, Long> entry : itemCountMap.entrySet()) {
            Item item = entry.getKey();
            Long quantity = getItemCount(item);
            Double price = item.getPrice();

            BasketLineItem basketLineItem = BasketLineItem.builder()
                    .item(item)
                    .quantity(quantity)
                    .price(price)
                    .amount(price * quantity)
                    .build();
            basketLineItems.add(basketLineItem);
        }
        return basketLineItems;

    }


    public void addItem(Item item) {
        items.add(item);
    }

    private void getItemCountMap() {
       // if (itemCountMap == null) {
            itemCountMap = getAllItems().stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //}
        //itemCountMap =  itemCountMap;
    }

    private Long getItemCount(Item item) {
        Long count = itemCountMap.get(item);
        return count == null ? 0 : count;
    }

    private void deleteAllItems() {
        items.clear();
    }

    public void deleteItem(Item item) {
        items.remove(item);
    }

    private void calculateSubTotal() {
        subTotal = itemCountMap.entrySet()
                .stream()
                .mapToDouble(item -> item.getKey().getPrice() * item.getValue()).sum();


    }


    private void calculateDeliveryCost() {
        Double finalDelivery = new Double(0);
        if (subTotal <= discountLevel) {
            finalDelivery = deliveryCostDefault;
        }

        deliveryCostActual = finalDelivery;
    }

    private void calculateTotalAmount() {
        total = subTotal + deliveryCostActual;
    }

    private void getDeliveryMessage() {
        String formatString = "You can order more items for ${0} to get free delivery";
        MessageFormat fmt = new MessageFormat(formatString);

        String message = "";
        if (subTotal <= discountLevel) {
            message = fmt.format(new Object[]{discountLevel - subTotal});
        }

        deliveryMessage = message;
    }

    public void removeItem(Item item) {
//        items.removeIf(itemInBasket -> itemInBasket.equals(item));

        items = items.stream().filter(addedItem -> !addedItem.getId().equals(item.getId())).collect(Collectors.toList());

        int y = 0;
    }
}
