package com.example.p8_app.Logic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.p8_app.Models.CustomerModel;
import com.example.p8_app.Models.FarmerModel;

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
    public boolean AddFarmer(FarmerModel farmerModel) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", farmerModel.GetName());
        map.put("description", farmerModel.GetDetails());
        map.put("image", Integer.toString(farmerModel.GetImage()));

        try {
            String response = comm.sendSecurePost("farmer", map);
            return true;
        } catch (Exception exception) {
            return false;
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
                        Integer.parseInt(jsonObject.getString("image"))
                        );
                farmers.add(farmerModel);
            }
            return farmers;
        } catch (Exception exception) {
            return new ArrayList<FarmerModel>();
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
