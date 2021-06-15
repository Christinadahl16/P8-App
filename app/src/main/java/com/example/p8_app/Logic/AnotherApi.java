package com.example.p8_app.Logic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.p8_app.Models.CartItem;
import com.example.p8_app.Models.CartModel;
import com.example.p8_app.Models.CustomerModel;
import com.example.p8_app.Models.FarmerModel;
import com.example.p8_app.Models.ProductModel;
import com.example.p8_app.Models.SalesModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnotherApi implements IApiInterface {

    private StateManagement stateManagement;
    private final Comm comm;
    private boolean forceServer;

    public AnotherApi(){
        stateManagement = Session.getStateManagement();
        this.comm = new Comm();
    }

    public void forceServer(boolean forceServerFlag) {
        forceServer = forceServerFlag;
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
            String response = postJob.sendSecurePost();

            JSONObject jsonObject = new JSONObject(response);

            stateManagement.AddState(FarmerModel.DataSource, jsonObject);

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

            String response = postJob.sendSecurePost();

            JSONObject jsonObject = new JSONObject(response);

            stateManagement.UpdateState(FarmerModel.DataSource, jsonObject);

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
            stateManagement.DeleteState(FarmerModel.DataSource, farmerModel.GetID());
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
            String address = FarmerModel.DataSource;

            JSONArray jsonArray  = stateManagement.GetState(address);

            if (jsonArray == null || forceServer)  {
                String response = comm.sendSecureGet("farmers", map);

                jsonArray = new JSONArray(response);
                stateManagement.SetState(address, jsonArray);
            }

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
        } finally {
            forceServer = false;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public FarmerModel GetFarmer(String id) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);

        try {

            JSONObject jsonObject = stateManagement.GetEntryByID(FarmerModel.DataSource, id);

            if (jsonObject == null || forceServer) {
                String response = comm.sendSecureGet("farmer", map);

                jsonObject = new JSONObject(response);
            }

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

            JSONObject jsonObject = stateManagement.GetEntryByID(ProductModel.DataSource, id);

            if (jsonObject == null || forceServer) {
                String response = comm.sendSecureGet("product", map);

                jsonObject = new JSONObject(response);
            }

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
    public List<ProductModel> GetCartProducts(String idList) throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        map.put("id", idList);

        List<ProductModel> products =  new ArrayList<ProductModel>();
        try {

            String address = CartModel.DataSource;

            JSONArray jsonArray  = stateManagement.GetState(address);

            if (jsonArray == null || forceServer)  {
                String response = comm.sendSecureGet("productsByID", map);

                jsonArray = new JSONArray(response);
                stateManagement.SetState(address, jsonArray);
            }

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
        }finally {
            forceServer = false;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public List<ProductModel> GetProducts(String FarmerID) throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        map.put("id", FarmerID);

        List<ProductModel> products =  new ArrayList<ProductModel>();
        try {

            String address = ProductModel.DataSource;

            JSONArray jsonArray  = stateManagement.GetState(address);

            boolean farmerFound = false;

            JSONArray otherFarmerObjects = new JSONArray();

            if (jsonArray != null && !forceServer) {
                int jsonArrayLength = jsonArray.length();

                for (int i = 0; i < jsonArrayLength; i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String productFramerID = jsonObject.getString("farmer_id");

                    if (productFramerID.equals(FarmerID)){
                        farmerFound = true;
                    }
                    else {
                        otherFarmerObjects.put(jsonObject);
                    }
                }
            }

            if (jsonArray == null || forceServer || !farmerFound)  {
                String response = comm.sendSecureGet("products", map);


                jsonArray = new JSONArray(response);

                for (int i = 0; i < otherFarmerObjects.length(); i++){
                    JSONObject jsonObject = otherFarmerObjects.getJSONObject(i);

                    jsonArray.put(jsonObject);
                }


                stateManagement.SetState(address, jsonArray);
            }

            int jsonArrayLength = jsonArray.length();

            for (int i = 0; i < jsonArrayLength; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String productFramerID = jsonObject.getString("farmer_id");

                if (!productFramerID.equals(FarmerID))
                    continue;

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
        }finally {
            forceServer = false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean DeleteProduct(ProductModel productModel) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", productModel.GetID());

        try {
            comm.sendSecureDelete("product", map);
            stateManagement.DeleteState(ProductModel.DataSource, productModel.GetID());
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
        postJob.AddText("farmer_id", productModel.GetFarmer());
        postJob.AddText("price", productModel.GetPrice().toString());

        try {
            String response = postJob.sendSecurePost();

            JSONObject jsonObject = new JSONObject(response);

            stateManagement.AddState(ProductModel.DataSource, jsonObject);

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
        postJob.AddText("farmer_id", productModel.GetFarmer());
        postJob.AddText("price", productModel.GetPrice().toString());


        try {
            String response = postJob.sendSecurePost();

            JSONObject jsonObject = new JSONObject(response);

            stateManagement.UpdateState(ProductModel.DataSource, jsonObject);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    //{"delivery" : "22/1/1860","product" : [ {"id":"1", "price":"2", "qty":"3"}, {"id":"1", "price":"2", "qty":"3"}] }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean CompleteTransaction(Collection<CartItem> itemCollection, String delivery) throws Exception {

        JSONArray productEntries = new JSONArray();

        for (CartItem item : itemCollection) {

            JSONObject productItem = new JSONObject();
            productItem.put("id", item.productModel.GetID());
            productItem.put("price", item.productModel.GetPrice().toString());
            productItem.put("qty", item.Quantity.toString());

            productEntries.put(productItem);
        }


        JSONObject products = new JSONObject();
        products.put("delivery", delivery);
        products.put("product", productEntries);

        String jsonParameter = products.toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("products", jsonParameter);

        try {
            String response = comm.sendSecurePost("cart", map);

            JSONArray jsonObject = new JSONArray(response);

            stateManagement.SetState(SalesModel.DataSource, jsonObject);

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
