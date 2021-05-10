package com.example.p8_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final Object TAG = "MainActivity";
    private static final String LOG = "DatabaseHelper";

    /*Ref to EditText and button in activity_login XML file*/
    EditText email;
    EditText password;
    Button login;

    /*Button customerAccount;*/

    Integer id;

    /*Ref to EditText and button in activity_food_selection_model XML file*/
    EditText foodItemName;
    EditText price;
    EditText origin;
    Button addToDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Link to activity_login XML file*/
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login1);
        /*customerAccount = findViewById(R.id.lv_customerList);*/

        /*Link to activity_food_selection XML file*/
        addToDatabase = (Button) findViewById(R.id.addToDatabase);

        /*onCLickListeners for login button and addToDatabase button*/
        //login.setOnClickListener(this);
        //addToDatabase.setOnClickListener(this);

        /*UDKOMMENTERET*/
        /*Login onClickListener
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

            }*/



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

        }

    @Override
    public void onClick(View v) {

        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

        switch(v.getId()){
            case R.id.login:
                CustomerModel customerModel;

                try {
                    customerModel = new CustomerModel(email.getText().toString(), password.getText().toString());
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    customerModel = new CustomerModel("Error", "Error");
                }

                boolean success = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "Success=" + success, Toast.LENGTH_SHORT).show();

                break;
            case R.id.addToDatabase:
                FoodSelectionModel foodSelectionModel;

                try {
                    foodSelectionModel = new FoodSelectionModel(foodItemName.getText().toString(), price.getText().toString(), origin.getText().toString());
                    Toast.makeText(MainActivity.this, foodSelectionModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Adding food item to database failed", Toast.LENGTH_SHORT).show();
                    foodSelectionModel = new FoodSelectionModel();
                }

                boolean added = dataBaseHelper.addItem(foodSelectionModel);
                Toast.makeText(MainActivity.this, "Food item=" + added, Toast.LENGTH_SHORT).show();
                break;
        }

    }
}