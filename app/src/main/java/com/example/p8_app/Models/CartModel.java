package com.example.p8_app.Models;

import java.util.HashMap;
import java.util.Map;



public class CartModel {
    Map<String, CartItem> cartItems = new HashMap<String, CartItem>();


    public void IncItem(String ProductID, Float price){
        if (!cartItems.containsKey(ProductID)){
            CartItem cartItem  = new CartItem();
            cartItem.Quantity = 1;
            cartItem.Price = price;
            cartItem.ID = ProductID;

            cartItems.put(ProductID, cartItem);
        }

        CartItem cartItem = cartItems.get(ProductID);
        cartItem.Quantity++;
    }


    public Float GetTotal()
    {
        Float totalPrice = 0.0f;
        for (CartItem cartItem : cartItems.values()) {

            Float price = cartItem.Price;
            Integer qty = cartItem.Quantity;

            Float productTotal = price * qty;
            totalPrice += productTotal;
        }

        return  totalPrice;
    }


    public Integer GetQuantity(String ProductID)
    {
        if (cartItems.containsKey(ProductID)){
             return cartItems.get(ProductID).Quantity;
        }
        return 0;
    }

    public void DecItem(String ProductID, Float price){
        if (!cartItems.containsKey(ProductID)){
            CartItem cartItem  = new CartItem();
            cartItem.Quantity = 1;
            cartItem.Price = price;
            cartItem.ID = ProductID;

            cartItems.put(ProductID, cartItem);
        }

        CartItem cartItem = cartItems.get(ProductID);

        if (cartItem.Quantity > 0)
            cartItem.Quantity--;
    }
}
