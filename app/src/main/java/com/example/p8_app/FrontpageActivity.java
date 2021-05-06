package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FrontpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

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
                            selectedFragment). commit();
                    return true;
                }
            };
    public class FarmerOverview extends AppCompatActivity implements View.OnClickListener {
        private Button button2;
        private Button button4;
        private Button button5;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            button2 = (Button) findViewById(R.id.button2);
            button4 = (Button) findViewById(R.id.button4);
            button5 = (Button) findViewById(R.id.button5);

            button2.setOnClickListener(this);
            button4.setOnClickListener(this);
            button5.setOnClickListener(this);



            }

        @Override
        public void onClick(View v) {
            openProducts ();

        }
        public void openProducts() {
            Intent intent = new Intent(this, ProductsFragment.class);
            startActivity(intent);
        }
    }

       /* @Override
        public void onClick(View v) {

        });

        }

        /*Ved de 3 linjer nedenunder har vi lavet en "onclick"-funktion til de 3 knapper fra FarmerOverview.xml*/
        /*Linjen nedenunder hører til "Se udvalg" som henviser til Farmer XXX's udvalg*/
       /* public void button4(View view) {



        }
        /*Linjen nedenunder hører til "Se udvalg" som henviser til Farmer XXY's udvalg*/
        /*public void button2(View view) {
           ;
        }
        /*Linjen nedenunder henviser til knappen "Sign Out", som logger brugeren ud*/
        /*public void button5(View view) {
        }
    }*/
}

