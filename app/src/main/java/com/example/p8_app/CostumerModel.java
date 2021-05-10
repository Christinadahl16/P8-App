package com.example.p8_app;

class CustomerModel {
    private int email;
    private String password;

    /*Constructors*/
    public CustomerModel(int email, String password) {
        this.email = email;
        this.password = password;
    }


    /*We might use this*/
    public CustomerModel(int i, String s, int parseInt) {
    }

    public CustomerModel(String email, String password) {
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
    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}