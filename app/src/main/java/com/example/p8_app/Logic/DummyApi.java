package com.example.p8_app.Logic;


import com.example.p8_app.Models.CustomerModel;
import com.example.p8_app.Models.FarmerModel;
import com.example.p8_app.Models.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class DummyApi implements IApiInterface {
    @Override

    // select * from  users
    public List<CustomerModel> getUsers()
    {
        List<CustomerModel> customerModelList = new ArrayList<CustomerModel>();
        customerModelList.add(
          new CustomerModel("jane@doe.dk", "123456789")
        );
        customerModelList.add(
                new CustomerModel("john@doe.dk", "123456789")
        );
        customerModelList.add(
                new CustomerModel("peter@doe.dk", "123456789")
        );

        return customerModelList;
    }

    @Override
    public FarmerModel GetFarmer(String id) throws Exception {
        return null;
    }

    @Override
    public List<FarmerModel> GetFarmers() throws Exception {
        return null;
    }

    @Override
    public boolean DeleteFarmer(FarmerModel farmerModel) throws Exception {
        return false;
    }

    @Override
    public boolean AddFarmer(FarmerModel farmerModel) throws Exception {
        return false;
    }

    @Override
    public boolean UpdateFarmer(FarmerModel farmerModel) throws Exception {
        return false;
    }

    @Override
    public ProductModel GetProduct(String id) throws Exception {
        return null;
    }

    @Override
    public List<ProductModel> GetProducts() throws Exception {
        return null;
    }

    @Override
    public boolean DeleteProduct(ProductModel productModel) throws Exception {
        return false;
    }

    @Override
    public boolean AddProduct(ProductModel productModel) throws Exception {
        return false;
    }

    @Override
    public boolean UpdateProduct(ProductModel productModel) throws Exception {
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        List<CustomerModel>users =  getUsers();

        CustomerModel model = new CustomerModel(username, password);

        return users.indexOf(model) >= 0;
    }

    @Override
    public boolean Register(CustomerModel customerModel) throws Exception {
        return false;
    }
}