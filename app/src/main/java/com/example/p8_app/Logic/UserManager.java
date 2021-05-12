package com.example.p8_app.Logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements IUserManager {

    private IApiInterface _apiInterface;

    public UserManager(IApiInterface apiInterface){
        _apiInterface = apiInterface;
    }

    private void PasswordValidToException(String password) throws Exception{
        if (password.length() < 8){
            throw new Exception("Password Too Short");
        }
    }

    private void EmailValidToException(String email) throws Exception{
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()){
            throw new Exception("Incorrect Email Format");
        }
    }

    @Override
    public void TryLogin(String email, String password) throws Exception {
        EmailValidToException(email);
        PasswordValidToException(password);

        boolean loggedIn = _apiInterface.login(email, password);

        if (!loggedIn){
            throw new Exception("Wrong Email/Password");
        }
    }

}