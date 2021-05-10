package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.Map;

/*public class LoginActivity extends AppCompatActivity {

        /*Create variables for email, password and create button
        private EditText email;
        private EditText password;
        private Button login;

        /*@Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                /*Link to activity_create2 XML file
                email =findViewById(R.id.email);
                password =findViewById(R.id.password);
                login =findViewById(R.id.login1);


                /*login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Convert from text to a string
                                String txt_email = email.getText().toString();
                                String txt_password = password.getText().toString();

                                /*Create account verification of email and password
                                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                                        Toast.makeText(LoginActivity.this, "Invalid e-mail", Toast.LENGTH_SHORT).show();
                                } else if (txt_password.length() < 8) {
                                        Toast.makeText(LoginActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
                                } else {
                                        loginCustomer(txt_email, txt_password);
                                }
                        }
                });
        }

        private void loginCustomer(String txt_email, String txt_password) {
        }

                 */