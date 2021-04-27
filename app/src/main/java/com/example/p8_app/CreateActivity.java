package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateActivity extends AppCompatActivity {

    /*Create variables for email, password and create button*/
    private EditText email;
    private EditText password;
    private Button create;
    private Button login;

    /*Firebase authentication variable*/
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        /*Link to activity_create2 XML file*/
        email =findViewById(R.id.email);
        password =findViewById(R.id.password);
        create =findViewById(R.id.login1);

        /*Initialize auth variable*/
        auth = FirebaseAuth.getInstance();

        /*Convert from text to a string*/
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                /*Create account verification of email and password*/
                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(CreateActivity.this, "Invalid e-mail", Toast.LENGTH_SHORT).show();
                } else if (txt_password.length() < 8) {
                    Toast.makeText(CreateActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
                } else {
                    createAccount(txt_email, txt_password);
                }
            }
        });
    }

    /*Create account method*/
    private void createAccount(String txt_email, String txt_password) {

        /*Create account*/
        auth.createUserWithEmailAndPassword(txt_email, txt_password).addOnCompleteListener(CreateActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                /*If task is successful, then account created
                * else the create account failed*/
                if (task.isSuccessful()){
                    Toast.makeText(CreateActivity.this, "Account created", Toast.LENGTH_SHORT).show();
                    /*If create account is successful, start MainActivity*/
                    startActivity(new Intent(CreateActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(CreateActivity.this, "Create account failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}