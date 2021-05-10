package com.example.p8_app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private static final Object TAG = "MainActivity";

    TextView Produkter;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        Produkter = (TextView) findViewById(R.id.products1);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        BottomNavigationView.OnNavigationItemSelectedListener navListener = null;
        bottomNav.setOnNavigationItemSelectedListener(navListener);



    }

    public void increase (View v) {
        count++;
        Produkter.setText("" + count);
    }

    public void decrease (View v) {
        if(count <= 0) count = 0;
        else count--;

        Produkter.setText("" + count);

    }








    /*products.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(StartActivity.this, FrontpageActivity.class));
            finish();
        }
    });



    /*Navigation bar*/
    /*BottomNavigationView.OnNavigationItemSelectedListener navListener =
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
            }; */

}