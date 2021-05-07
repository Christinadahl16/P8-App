package com.example.p8_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static final Object TAG = "MainActivity";

    /*Ref to buttons*/
    EditText email;
    EditText password;
    Button login;
    Button customerAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Link to activity_login XML file*/
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login1);
        customerAccount = findViewById(R.id.lv_customerList);


        /*Login onClickListener*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerModel customerModel;

                try {
                    customerModel = new CustomerModel(email.getText().toString(), password.getText().toString());
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    customerModel = new CustomerModel("Error", "Error");
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                boolean success = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "Success=" + success, Toast.LENGTH_SHORT).show();

            }

                /*BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
                bottomNav.setOnNavigationItemSelectedListener(navListener);

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.products:
                            /*selectedFragment = new ProductsFragment();
                            break;
                        case R.id.aboutGrønttorvet:
                            selectedFragment = new AboutgtFragment();
                            break;
                        case R.id.AboutApp:
                            selectedFragment = new ThisappFragment();
                            break;

                        case R.id.Myprofile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment). commit();
                    return true;
                }
            };*/

        });
    }}