package com.example.p8_app.Models;

public class FarmerModel {
    String Name;
    String Details;
    String ID;
    String Image;

    public FarmerModel(){

    }

    public FarmerModel(String name, String details, String imageID){
        SetDetails(details);
        SetName(name);
        SetImageUrl(imageID);
    }

    public FarmerModel(String id, String name, String details, String imageID){
        SetDetails(details);
        SetName(name);
        SetImageUrl(imageID);
        SetID(id);
    }


    public void SetDetails(String details){
        Details = details;
    }

    public void SetName(String name){
        Name = name;
    }

    public void SetID(String id){
        ID = id;
    }

    public String GetID(){
        return ID;
    }




    public void SetImageUrl(String imageID){
        Image = imageID;
    }

    public String GetImageUrl(){
        return Image;
    }
    public String GetName(){
        return Name;
    }

    public String GetDetails(){
        return Details;
    }

}
