package com.example.p8_app.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class CustomerModel {
    private String email;
    private String password;

    /*Constructors*/
    public CustomerModel(String email, String password) {
        this.email = email;
        this.password = password;
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
