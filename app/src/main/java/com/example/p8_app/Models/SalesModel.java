package com.example.p8_app.Models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class SalesModel {
    Map<String, CartItem> cartItems = new HashMap<String, CartItem>();

    public static final String DataSource = "SalesModel";

    public String ProductIDS (){

        String idList = "";

        for (CartItem cartItem : cartItems.values()) {

            String id = cartItem.productModel.ID;

            if (cartItem.Quantity <= 0)
                continue;

            if (idList.contains(id))
                continue;

            if (!idList.equals(""))
                idList += ",";

            idList += id;

        }

        return idList;
    }

    public Collection<CartItem> GetItems(){
        return cartItems.values();
    }


    public void IncItem(ProductModel productModel){
        if (!cartItems.containsKey(productModel.ID)){
            CartItem cartItem  = new CartItem();
            cartItem.Quantity = 1;
            cartItem.productModel = productModel;

            cartItems.put(productModel.ID, cartItem);
        }

        CartItem cartItem = cartItems.get(productModel.ID);
        cartItem.Quantity++;
    }


    public Float GetTotal()
    {
        Float totalPrice = 0.0f;
        for (CartItem cartItem : cartItems.values()) {

            Float price = cartItem.productModel.Price;
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

    public void DecItem(ProductModel productModel){
        if (!cartItems.containsKey(productModel.ID)){
            CartItem cartItem  = new CartItem();
            cartItem.Quantity = 1;
            cartItem.productModel = productModel;

            cartItems.put(productModel.ID, cartItem);
        }

        CartItem cartItem = cartItems.get(productModel.ID);

        if (cartItem.Quantity > 0)
            cartItem.Quantity--;
    }
}
