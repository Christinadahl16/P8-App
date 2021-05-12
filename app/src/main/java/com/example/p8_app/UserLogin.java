package com.example.p8_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.p8_app.Logic.AnotherApi;
import com.example.p8_app.Logic.DummyApi;
import com.example.p8_app.Logic.IApiInterface;
import com.example.p8_app.Logic.IUserManager;
import com.example.p8_app.Logic.UserManager;
import com.example.p8_app.Logic.UserManager_xml;

public class UserLogin extends AppCompatActivity {

    private Button createButton;
    private EditText emailTextBox;
    private EditText passwordTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        emailTextBox = findViewById(R.id.email);
        passwordTextBox = findViewById(R.id.password);
        createButton = findViewById(R.id.create);


        /*Add OnClickListeners to login and create button*/
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

    }
    public void ShowCreateUserActivity(View view) {
        startActivity(new Intent(UserLogin.this, CreateActivity.class));
        finish();
    }


    public void TryLogin(View view) {

        String email = emailTextBox.getText().toString();

        IApiInterface api;

        if (email.equals("root@admin.com") ){
            api = new AnotherApi();
        }
        else {
            api = new DummyApi();
        }

        IUserManager userManager = new UserManager(api);


        String password = passwordTextBox.getText().toString();

        try{
            userManager.TryLogin(email , password);
        }
        catch (Exception exception){

            Toast  toast = Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }
}