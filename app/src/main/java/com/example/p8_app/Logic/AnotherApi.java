package com.example.p8_app.Logic;

import com.example.p8_app.Models.CustomerModel;

import java.util.ArrayList;
import java.util.List;

public class AnotherApi implements IApiInterface {

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
    public boolean login(String username, String password) {
        List<CustomerModel>users =  getUsers();
        CustomerModel model = new CustomerModel(username, password);

        return true;
    }
}
