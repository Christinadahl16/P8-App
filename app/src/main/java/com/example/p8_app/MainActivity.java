package com.example.p8_app;

import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;


public class MainActivity extends AppCompatActivity {

    private static final Object TAG = "MainActivity";
    private FirebaseAnalytics mFirebaseAnalytics;
    private String id;
    private String name;
    private String mName;
    private String price;
    private String origin;
    private String text;
    private ViewPager mViewPager;

    String mOrderId;
    String mOrder;
    String mOrderHistory;
    String orderId;
    String order;
    String orderHistory;
    String screenName;

    Object info;

    /*Set variable analytics*/
    FirebaseAnalytics analytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        BottomNavigationView.OnNavigationItemSelectedListener navListener = null;
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        Bundle params = new Bundle();
        params.putString("image_name", name);
        params.putString("full_text", text);
        mFirebaseAnalytics.logEvent("share_image", params);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        /*Set automatic user ID*/
        mFirebaseAnalytics.setUserId("user_pseudo_id");


    }

    /*Record ImageView*/
    private void recordImageView() {

        /*Set columns for database*/
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.PRICE, price);
        bundle.putString(FirebaseAnalytics.Param.ORIGIN, origin);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    /*Set property for customer*/
    private void setUserProperty(String name) {

        /*Set user property for customer*/
        mFirebaseAnalytics.setUserProperty("name", mName);
        mFirebaseAnalytics.setUserProperty("order_id", mOrderId);
        mFirebaseAnalytics.setUserProperty("order", mOrder);
        mFirebaseAnalytics.setUserProperty("order_history", mOrderHistory);

    }

    /*Record screen view*/
    private void recordScreenView() {

        // [START set_current_screen]
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        // [END set_current_screen]
    }




    /*Navigation bar*/
    BottomNavigationView.OnNavigationItemSelectedListener navListener =
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
}