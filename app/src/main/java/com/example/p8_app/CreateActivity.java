package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p8_app.Logic.AnotherApi;
import com.example.p8_app.Logic.IApiInterface;
import com.example.p8_app.Logic.IUserManager;
import com.example.p8_app.Logic.UserManager;
import com.example.p8_app.Models.CustomerModel;

public class CreateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }

    public void TryRegister(View view) {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                IApiInterface api = new AnotherApi();
                IUserManager userManager = new UserManager(api);


                /*Link to activity_create XML file*/
                EditText nameTextBox =findViewById(R.id.name);
                EditText emailTextBox =findViewById(R.id.email);
                EditText passwordTextBox =findViewById(R.id.password);

                String email = emailTextBox.getText().toString();
                String password = passwordTextBox.getText().toString();
                String name = nameTextBox.getText().toString();

                try{
                    CustomerModel customerModel = new CustomerModel(email, password);
                    customerModel.SetName(name);


                    if (userManager.TryRegister(customerModel)){
                        startActivity(new Intent(CreateActivity.this, FrontpageActivity.class));
                        finish();
                    }
                }
                catch (Exception exception){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast toast = Toast.makeText(CreateActivity.this, exception.getMessage(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            }
        });

        thread.start();
    }
}