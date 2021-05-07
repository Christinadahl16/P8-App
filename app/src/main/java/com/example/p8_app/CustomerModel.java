package com.example.p8_app;

public class CustomerModel {
    private String email;
    private String password;

    /*Constructors*/
    public CustomerModel(String email, String password) {
        this.email = email;
        this.password = password;
    }


    /*We might use this*/
    public CustomerModel() {
    }

    /*toString method*/
    @Override
    public String toString() {
        return "CustomerModel{" +
                "email='" + this.email + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }

    /*Getters and setters*/
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

}
