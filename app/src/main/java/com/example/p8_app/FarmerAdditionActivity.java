package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.p8_app.Logic.AnotherApi;
import com.example.p8_app.Logic.IApiInterface;
import com.example.p8_app.Models.FarmerModel;

public class FarmerAdditionActivity  extends AppCompatActivity {

    private EditText farmerName;
    private EditText farmerDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framer_addition);

        farmerName = findViewById(R.id.farmer_name);
        farmerDetails = findViewById(R.id.farmer_details);
    }


    private int getImageID(String imageName){
        return this.getResources()
                .getIdentifier(imageName, "drawable", this.getPackageName());
    }

    public void CreateFarmer(View view) {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                String name = farmerName.getText().toString();
                String details = farmerDetails.getText().toString();
                IApiInterface api = new AnotherApi();

                FarmerModel farmerModel = new FarmerModel(name, details, getImageID("farmer1"));

                try{

                    if (api.AddFarmer(farmerModel)){
                        startActivity(new Intent(FarmerAdditionActivity.this, FarmerOverview.class));
                        finish();
                    }
                }
                catch (Exception exception){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast toast = Toast.makeText(FarmerAdditionActivity.this, exception.getMessage(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            }
        });

        thread.start();
    }
}