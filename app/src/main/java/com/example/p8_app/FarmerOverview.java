package com.example.p8_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FarmerOverview extends AppCompatActivity implements View.OnClickListener {
    Button button2;
    Button button4;
    Button SignOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmeroverview);

        button2 = findViewById(R.id.button2);
        button4 = findViewById(R.id.button4);
        SignOut = findViewById(R.id.SignOut);

        button2.setOnClickListener(this);
        button4.setOnClickListener(this);
        SignOut.setOnClickListener(this);

    }


    /*onClickListeners for buttons in farmeroverview.xml*/
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button2){
            getSupportFragmentManager().beginTransaction().replace(R.id.farmeroverview, new ProductsFragment()).commit();
        }


        /*switch (v.getId()) {
            case R.id.button2:
            case R.id.button4:
                break;
            case R.id.SignOut:
                openSignOut();
                break;*/
        }

    /*SignOut button*/
    private void openSignOut() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}
