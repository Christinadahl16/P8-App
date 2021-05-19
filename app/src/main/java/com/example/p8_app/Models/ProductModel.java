package com.example.p8_app.Models;

public class ProductModel {
    String Name;
    int ImageID;
    float Price;
    String Farmer;
    public ProductModel(){

    }

    public ProductModel(String name, float price, int imageID, String farmer){
        setPrice(price);
        SetName(name);
        SetImage(imageID);
        Farmer = farmer;
    }

    public void setFarmer(String farmer){
        Farmer = farmer;
    }

    public void setPrice(float price){
        Price = price;
    }

    public void SetName(String name){
        Name = name;
    }

    public void SetImage(int imageID){
        ImageID = imageID;
    }

    public String GetName(){
        return Name;
    }

    public String GetFarmer(){
        return Farmer;
    }

    public Float GetPrice()
    {
        return Price;
    }

    public int GetImage(){
        return ImageID;
    }
}
