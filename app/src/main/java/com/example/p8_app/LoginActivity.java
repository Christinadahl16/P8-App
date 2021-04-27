package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    /*Create variables for email, password and login button*/
    private EditText email;
    private EditText password;
    private Button login;

    /*Firebase authentication variable*/
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Link to activity_login XML file*/
        email =(EditText)findViewById(R.id.email);
        password =(EditText)findViewById(R.id.password);
        login =(Button)findViewById(R.id.login);

        /*Initialize auth variable*/
        auth = FirebaseAuth.getInstance();

        /*When login button is clicked, call */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Convert text to string*/
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                loginUser(txt_email, txt_password);



            }
        });
    }

    /*loginUser method*/
    private void loginUser(String txt_email, String txt_password) {
        /*Authenticate signing in with email and password*/
        auth.signInWithEmailAndPassword(txt_email, txt_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
                /*If login is successful, start MainActivity*/
                startActivity(new Intent(LoginActivity.this, FrontpageActivity.class));
                finish();

            }
        });
    }
}