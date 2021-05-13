package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.p8_app.Logic.Session;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FrontpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }


    @Override
    protected void onResume() {

        super.onResume();
        tryReturnToLogin();
    }

    public void signOut(View v){
        Session.destroy();
        tryReturnToLogin();
    }

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

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.products:
                            selectedFragment = new ProductsFragment();
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
                            selectedFragment).commit();
                    return true;
                }
            };

    }





