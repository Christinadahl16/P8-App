package com.example.p8_app.Logic;

import com.example.p8_app.Models.CustomerModel;

public interface IUserManager {
    boolean TryLogin(String email, String password) throws Exception;

    boolean TryRegister(CustomerModel customerModel) throws Exception;
}
