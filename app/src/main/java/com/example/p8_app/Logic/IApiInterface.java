package com.example.p8_app.Logic;

import com.example.p8_app.Models.CartItem;
import com.example.p8_app.Models.CustomerModel;
import com.example.p8_app.Models.FarmerModel;
import com.example.p8_app.Models.ProductModel;

import java.util.Collection;
import java.util.List;

public interface IApiInterface {
     List<com.example.p8_app.Models.CustomerModel> getUsers();

     void forceServer(boolean forceServerFlag);
     public List<ProductModel> GetCartProducts(String idList) throws Exception;
     /// farmer
     FarmerModel GetFarmer(String id) throws Exception;

     List<FarmerModel> GetFarmers() throws Exception;

     boolean DeleteFarmer(FarmerModel farmerModel) throws Exception;

     boolean AddFarmer(FarmerModel farmerModel) throws Exception ;

     boolean UpdateFarmer(FarmerModel farmerModel) throws Exception ;

     //sales
     boolean CompleteTransaction(Collection<CartItem> itemCollection, String delivery) throws Exception;

     // products


     ProductModel GetProduct(String id) throws Exception;

     List<ProductModel> GetProducts(String FramerID) throws Exception;

     boolean DeleteProduct(ProductModel productModel) throws Exception;

     boolean AddProduct(ProductModel productModel) throws Exception ;

     boolean UpdateProduct(ProductModel productModel) throws Exception ;


     // user
     boolean login(String username, String password) throws Exception;

     boolean Register(CustomerModel customerModel) throws Exception;
}
