package com.example.p8_app.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class CustomerModel {
    private String email;
    private String password;
    private String name;
    private String authKey;

    public boolean IsAdmin (){
        return this.email.equals("test@test.com");
    }

    /*Constructors*/
    public CustomerModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public CustomerModel(String email, String name, String authKey) {
        this.email = email;
        this.name = name;
        this.authKey = authKey;
    }

    /*Setters and getters*/
    public String getAuthKey(){
        return authKey;
    }
    
    public String getName() {

        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    /*Minimum required API for application to run*/
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerModel that = (CustomerModel) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
