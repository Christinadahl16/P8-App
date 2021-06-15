package com.example.p8_app.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class FoodSelectionModel {
    private String foodItemName;
    private String price;
    private String origin;


    /*Constructor*/
    public FoodSelectionModel(String foodItemName, String price, String origin) {
        this.foodItemName = foodItemName;
        this.price = price;
        this.origin = origin;
    }

    /*Getters and setters*/



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodSelectionModel that = (FoodSelectionModel) o;
        return Objects.equals(foodItemName, that.foodItemName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(origin, that.origin);
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(foodItemName, price, origin);
    }


}
