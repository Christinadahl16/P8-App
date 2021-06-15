package com.example.p8_app.Models;

public class ProductModel {
    String Name;
    String Image;
    float Price;
    String Farmer;
    String Details;
    String ID;

    public static final String DataSource = "Products";

    public ProductModel(){

    }


    public ProductModel(String ID, String name, float price, String details, String imageID, String farmer){
        setPrice(price);
        SetName(name);
        SetImage(imageID);
        SetID(ID);
        SetDetails(details);
        setFarmer(farmer);
    }

    public ProductModel(String name, float price, String details, String imageID, String farmer){
        setPrice(price);
        SetName(name);
        SetImage(imageID);
        SetDetails(details);
        setFarmer(farmer);
    }



    public void SetID(String id){
        ID = id;
    }

    public String GetID(){
        return ID;
    }

    public void SetDetails(String details){
        Details = details;
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

    public void SetImage(String imageID){
        Image = imageID;
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

    public String GetDetails(){
        return Details;
    }

    public String GetImage(){
        return Image;
    }
}
