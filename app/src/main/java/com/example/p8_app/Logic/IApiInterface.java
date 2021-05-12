package com.example.p8_app.Logic;

import java.util.List;

public interface IApiInterface {
     List<com.example.p8_app.Models.CustomerModel> getUsers();

     boolean login(String username, String password);
}
