package com.example.p8_app.Logic;

import com.example.p8_app.Models.CustomerModel;
import com.example.p8_app.Models.FarmerModel;

import java.util.List;

public interface IApiInterface {
     List<com.example.p8_app.Models.CustomerModel> getUsers();

     FarmerModel GetFarmer(String id) throws Exception;

     List<FarmerModel> GetFarmers() throws Exception;

     public boolean DeleteFarmer(FarmerModel farmerModel) throws Exception;

     boolean AddFarmer(FarmerModel farmerModel) throws Exception ;

     boolean UpdateFarmer(FarmerModel farmerModel) throws Exception ;

     boolean login(String username, String password) throws Exception;

     boolean Register(CustomerModel customerModel) throws Exception;
}
