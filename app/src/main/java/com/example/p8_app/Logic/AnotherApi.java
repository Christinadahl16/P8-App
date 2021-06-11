package com.example.p8_app.Logic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.p8_app.Models.CustomerModel;
import com.example.p8_app.Models.FarmerModel;
import com.example.p8_app.Models.ProductModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnotherApi implements IApiInterface {

    private final Comm comm;
    public AnotherApi(){

        this.comm = new Comm();
    }

    // select * from  users
    public List<CustomerModel> getUsers()
    {
        List<CustomerModel> customerModelList = new ArrayList<CustomerModel>();

        return customerModelList;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean AddFarmer(FarmerModel farmerModel) throws Exception {

        PostJob postJob = new PostJob("farmer");
        postJob.AddText("name", farmerModel.GetName());
        postJob.AddText("description", farmerModel.GetDetails());
        postJob.SetImage("image", farmerModel.GetImageUrl());


        try {
            postJob.sendSecurePost();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean UpdateFarmer(FarmerModel farmerModel) throws Exception {

        PostJob postJob = new PostJob("farmer");
        postJob.setID(farmerModel.GetID());

        postJob.AddText("name", farmerModel.GetName());
        postJob.AddText("description", farmerModel.GetDetails());
        postJob.SetImage("image", farmerModel.GetImageUrl());


        try {
            postJob.sendSecurePost();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean DeleteFarmer(FarmerModel farmerModel) throws Exception {

        Map<String, String> map = new HashMap<String, String>();
        map.put("id", farmerModel.GetID());

        try {
            comm.sendSecureDelete("farmer", map);

            return true;

        } catch (Exception exception) {
            return  false;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public List<FarmerModel> GetFarmers() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        List<FarmerModel> farmers =  new ArrayList<FarmerModel>();
        try {
            String response = comm.sendSecureGet("farmers", map);

            JSONArray jsonArray = new JSONArray(response);
            int jsonArrayLength = jsonArray.length();

            for (int i = 0; i < jsonArrayLength; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                FarmerModel farmerModel = new FarmerModel(
                        jsonObject.getString("id"),
                        jsonObject.getString("name"),
                        jsonObject.getString("description"),
                        jsonObject.getString("imageStr")
                        );
                farmers.add(farmerModel);
            }
            return farmers;
        } catch (Exception exception) {
            return new ArrayList<FarmerModel>();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public FarmerModel GetFarmer(String id) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);

        try {
            String response = comm.sendSecureGet("farmer", map);

            JSONObject jsonObject = new JSONObject(response);

            return new FarmerModel(
                    jsonObject.getString("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("description"),
                    jsonObject.getString("imageStr")
            );



        } catch (Exception exception) {
            return new FarmerModel();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public ProductModel GetProduct(String id) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);

        try {
            String response = comm.sendSecureGet("product", map);

            JSONObject jsonObject = new JSONObject(response);

            return new ProductModel(
                    jsonObject.getString("id"),
                    jsonObject.getString("name"),
                    Float.parseFloat(jsonObject.getString("price")),
                    jsonObject.getString("description"),
                    jsonObject.getString("imageStr"),
                    jsonObject.getString("farmer_id")
            );



        } catch (Exception exception) {
            return new ProductModel();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public List<ProductModel> GetProducts() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        List<ProductModel> products =  new ArrayList<ProductModel>();
        try {
            String response = comm.sendSecureGet("products", map);

            JSONArray jsonArray = new JSONArray(response);
            int jsonArrayLength = jsonArray.length();

            for (int i = 0; i < jsonArrayLength; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                ProductModel productModel = new  ProductModel(
                        jsonObject.getString("id"),
                        jsonObject.getString("name"),
                        Float.parseFloat(jsonObject.getString("price")),
                        jsonObject.getString("description"),
                        jsonObject.getString("imageStr"),
                        jsonObject.getString("farmer_id")
            );
                products.add(productModel);
            }
            return products;
        } catch (Exception exception) {
            return new ArrayList<ProductModel>();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean DeleteProduct(ProductModel productModel) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", productModel.GetID());

        try {
            comm.sendSecureDelete("product", map);

            return true;

        } catch (Exception exception) {
            return  false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean AddProduct(ProductModel productModel) throws Exception {
        PostJob postJob = new PostJob("product");
        postJob.AddText("name", productModel.GetName());
        postJob.AddText("description", productModel.GetDetails());
        postJob.SetImage("image", productModel.GetImage());
        postJob.SetImage("farmer_id", productModel.GetFarmer());
        postJob.SetImage("price", productModel.GetPrice().toString());

        try {
            postJob.sendSecurePost();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean UpdateProduct(ProductModel productModel) throws Exception {
        PostJob postJob = new PostJob("product");
        postJob.setID(productModel.GetID());

        postJob.AddText("name", productModel.GetName());
        postJob.AddText("description", productModel.GetDetails());
        postJob.SetImage("image", productModel.GetImage());
        postJob.SetImage("farmer_id", productModel.GetFarmer());
        postJob.SetImage("price", productModel.GetPrice().toString());


        try {
            postJob.sendSecurePost();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }




    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean login(String email, String password) {


        Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        map.put("password", password);

        try {
            String response = comm.sendPost("login", map);
            JSONObject obj = new JSONObject(response);

            JSONObject user = obj.getJSONObject("user");
            String token = obj.getString("access_token");

            Session.setCustomerModel(new CustomerModel(user.getString("email"),
                    user.getString("name"),
                    token
            ));

            return true;
        } catch (Exception exception) {
            return false;
        }

    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean Register(CustomerModel customerModel) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", customerModel.getEmail());
        map.put("password", customerModel.getPassword());
        map.put("name", customerModel.getName());

        try {
            String response = comm.sendPost("register", map);
            JSONObject obj = new JSONObject(response);

            JSONObject user = obj.getJSONObject("user");
            String token = obj.getString("access_token");

            Session.setCustomerModel(new CustomerModel(user.getString("email"),
                    user.getString("name"),
                    token
            ));

            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
