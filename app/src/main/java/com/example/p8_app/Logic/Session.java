package com.example.p8_app.Logic;


import com.example.p8_app.Models.CartModel;
import com.example.p8_app.Models.CustomerModel;
import com.example.p8_app.Models.FoodSelectionModel;

public class Session {
    //public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    private static CustomerModel _customerModel;
    private static CartModel _cartModel;
    //private static Date loginDate;
    private static FoodSelectionModel _foodSelectionModel;


    public static CartModel GetCart(){
        return _cartModel;
    }

    public static void setCustomerModel(CustomerModel customerModel){
        _customerModel = customerModel;
        _cartModel = new CartModel();
        //loginDate = new Date(System.currentTimeMillis());;
    }

    public static String getName(){
        return _customerModel.getName();
    }

    public static String getAuth(){
        //boolean moreThanDay = new Date(System.currentTimeMillis()) - loginDate > MILLIS_PER_DAY;
        return _customerModel.getAuthKey();
    }

    public static boolean IsAdmin(){
        return  _customerModel != null && _customerModel.IsAdmin();
    }
    public static boolean isLoggedIn(){
        return  _customerModel != null && !_customerModel.getAuthKey().equals("");
    }

    public static void destroy(){
        _customerModel = null;
    }

}
