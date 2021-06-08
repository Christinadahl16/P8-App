package com.example.p8_app.Models;

public class FarmerModel {
    String Name;
    int ImageID;
    String Details;
    String ID;

    public FarmerModel(){

    }

    public FarmerModel(String id, String name, String details, int imageID){
        SetDetails(details);
        SetName(name);
        SetImage(imageID);
        SetID(id);
    }

    public FarmerModel(String name, String details, int imageID){
        SetDetails(details);
        SetName(name);
        SetImage(imageID);
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

    public void SetImage(int imageID){
        ImageID = imageID;
    }

    public String GetName(){
        return Name;
    }

    public String GetDetails(){
        return Details;
    }
    public int GetImage(){
        return ImageID;
    }
}
