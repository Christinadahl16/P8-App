package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p8_app.Logic.AnotherApi;
import com.example.p8_app.Logic.IApiInterface;
import com.example.p8_app.Logic.IUserManager;
import com.example.p8_app.Logic.UserManager;

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
    }

    public void ShowCreateUserActivity(View view) {
        startActivity(new Intent(UserLogin.this, CreateActivity.class));
        finish();
    }


    public void TryLogin(View view) {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                String email = emailTextBox.getText().toString();

                IApiInterface api = new AnotherApi();


                IUserManager userManager = new UserManager(api);


                String password = passwordTextBox.getText().toString();

                try{

                    if (userManager.TryLogin(email , password)){
                        startActivity(new Intent(UserLogin.this, FrontpageActivity.class));
                        finish();
                    }
                }
                catch (Exception exception){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast toast = Toast.makeText(UserLogin.this, exception.getMessage(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            }
        });

        thread.start();
    }
}