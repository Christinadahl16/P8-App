package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
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


        String targetFragment  = getIntent().getStringExtra("fragmentName");

        if (targetFragment != null)
            JumpToFragment(targetFragment);
    }


    @Override
    protected void onResume() {

        super.onResume();
        tryReturnToLogin();


    }

    /*Signout button - when signing out, destroy current session*/
    public void signOut(View v){
        Session.destroy();
        tryReturnToLogin();
    }

    public void editFarmer(View view) {

        ImageButton editFramer = findViewById(R.id.EditFarmerButton);

        Intent intent = new Intent(FrontpageActivity.this, FarmerAdditionActivity.class);
        String id = editFramer.getTag().toString();

        intent.putExtra("farmerID", id);

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
                return;
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





