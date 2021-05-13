package com.example.p8_app.Logic;


import com.example.p8_app.Models.CustomerModel;

public class Session {
    //public final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    private static CustomerModel _customerModel;
    //private static Date loginDate;


    public static void setCustomerModel(CustomerModel customerModel){
        _customerModel = customerModel;
        //loginDate = new Date(System.currentTimeMillis());;
    }

    public static String getName(){
        return _customerModel.getName();
    }

    public static String getAuth(){
        //boolean moreThanDay = new Date(System.currentTimeMillis()) - loginDate > MILLIS_PER_DAY;
        return _customerModel.getAuthKey();
    }

    public static boolean isLoggedIn(){
        return  _customerModel != null && !_customerModel.getAuthKey().equals("");
    }

    public static void destroy(){
        _customerModel = null;
    }

}
