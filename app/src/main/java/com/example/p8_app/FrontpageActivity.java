package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.p8_app.Logic.AnotherApi;
import com.example.p8_app.Logic.IApiInterface;
import com.example.p8_app.Logic.Session;
import com.example.p8_app.Models.CartItem;
import com.example.p8_app.Models.CartModel;
import com.example.p8_app.Models.ProductModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Collection;

import static android.widget.Toast.LENGTH_LONG;


public class FrontpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        String targetFragment  = getIntent().getStringExtra("fragmentName");

        if (targetFragment != null)
            JumpToFragment(targetFragment);



    }


    @Override
    protected void onResume() {

        super.onResume();
        tryReturnToLogin();


        CartModel cartModel= Session.GetCart();
        if (cartModel != null) {
            TextView totalPrice = findViewById(R.id.totalPrice);
            totalPrice.setText(cartModel.GetTotal().toString() + "  DKK");
        }
    }

    /*Signout button - when signing out, destroy current session*/
    public void signOut(View v){
        Session.destroy();
        tryReturnToLogin();
    }



    public void DecreaseOrder(View view) {

        View Parent = (View) view.getParent();

        CartModel cartModel= Session.GetCart();
        String productID = view.getTag().toString();

        IApiInterface api = new AnotherApi();
        try {
            ProductModel productModel = api.GetProduct(productID);

            cartModel.DecItem(productModel);

            TextView quantity = Parent.findViewById(R.id.product_quantity);

            quantity.setText(cartModel.GetQuantity(productID).toString());

            TextView totalPrice = findViewById(R.id.totalPrice);
            totalPrice.setText(cartModel.GetTotal().toString() + "  DKK");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public void IncreaseOrder(View view) {

        View Parent = (View) view.getParent();

        CartModel cartModel= Session.GetCart();
        String productID = view.getTag().toString();

        IApiInterface api = new AnotherApi();
        try {
            ProductModel productModel = api.GetProduct(productID);

            cartModel.IncItem(productModel);

            TextView quantity = Parent.findViewById(R.id.product_quantity);

            quantity.setText(cartModel.GetQuantity(productID).toString());

            TextView totalPrice = findViewById(R.id.totalPrice);
            totalPrice.setText(cartModel.GetTotal().toString() + "  DKK");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


    public void SelectFarmer(View view) {

        String id = view.getTag().toString();
        getIntent().putExtra("farmerID", id);

        JumpToFragment("productsOverview");

    }

    public void GoToCart(View view) {
        JumpToFragment("gotocart");
    }


    public void CompleteTransaction(View view) {
        IApiInterface api = new AnotherApi();

        EditText deliveryDataBox = findViewById(R.id.delivery_date);

        String deliveryDate = deliveryDataBox.getText().toString();

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                IApiInterface api = new AnotherApi();

                Collection<CartItem> items = Session.GetCart().GetItems();

                try{
                    if (deliveryDate.isEmpty()) {
                        throw new Exception("Delivery Date can not be empty");
                    }

                    Session.GetCart().DeliveryDate = deliveryDate;

                    if (api.CompleteTransaction(items, deliveryDate)){
                       TextView totalPrice =  findViewById(R.id.totalPrice);
                        totalPrice.setText("");
                        JumpToFragment("SalesFragment");
                    }
                    else {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast toast = Toast.makeText(FrontpageActivity.this, "Cannot Complete Transaction", LENGTH_LONG);
                                toast.show();
                            }
                        });
                    }
                }
                catch (Exception exception){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast toast = Toast.makeText(FrontpageActivity.this, exception.getMessage(), LENGTH_LONG);
                            toast.show();
                        }
                    });
                } finally {

                }
            }
        });

        thread.start();

    }


    public void editFarmer(View view) {

        Intent intent = new Intent(FrontpageActivity.this, FarmerAdditionActivity.class);
        String id = view.getTag().toString();

        intent.putExtra("farmerID", id);

        startActivity(intent);

    }

    public void EditProduct(View view) {
        Intent intent = new Intent(FrontpageActivity.this, ProductAdditionActivity.class);

        String farmerID = getIntent().getStringExtra("farmerID");
        String id = view.getTag().toString();

        intent.putExtra("farmerID", farmerID);
        intent.putExtra("productID", id);

        startActivity(intent);

    }



    public void AddProduct(View view) {
        Intent intent = new Intent(FrontpageActivity.this, ProductAdditionActivity.class);

        String farmerID = getIntent().getStringExtra("farmerID");

        intent.putExtra("farmerID", farmerID);

        startActivity(intent);

    }

    public void AddFarmer(View view) {
        startActivity(new Intent(FrontpageActivity.this, FarmerAdditionActivity.class));

    }

    /*If session is not logged in, start go to UserLogin class, else welcome the user with message*/
    private void tryReturnToLogin(){
        if (!Session.isLoggedIn()){
            startActivity(new Intent(FrontpageActivity.this, UserLogin.class));
            finish();
        }
        else
        {
            String username = Session.getName();

            TextView welcome = findViewById(R.id.welcomeMessage);
            welcome.setText("Welcome "+ username);
        }
    }

    private void JumpToFragment(String fragmentID) {
        Fragment selectedFragment = null;

        switch (fragmentID) {
            case "SalesFragment" :
                selectedFragment = new SalesFragment();
                break;
            case "productsOverview":
                selectedFragment = new ProductsFragment();
                break;
            case "farmeroverview":
                selectedFragment = new FarmerOverview();
                break;
            case "aboutGrønttorvet":
                selectedFragment = new AboutgtFragment();
                break;
            case "AboutApp":
                selectedFragment = new ThisappFragment();
                break;

            case "Myprofile":
                selectedFragment = new ProfileFragment();
                break;

            default:
                selectedFragment = new CartFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

    }

    /*Navigation bar*/
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.farmeroverview:
                            JumpToFragment("farmeroverview");
                            break;
                        case R.id.aboutGrønttorvet:
                            JumpToFragment("aboutGrønttorvet");
                            break;
                        case R.id.AboutApp:
                            JumpToFragment("AboutApp");
                            break;

                        case R.id.Myprofile:
                            JumpToFragment("Myprofile");
                            break;
                    }

                    return true;
                }
            };

    }





