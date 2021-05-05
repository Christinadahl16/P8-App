package com.example.p8_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FarmerOverview extends AppCompatActivity {
@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
setContentView(R.layout.activity_farmeroverview);

}

/*Ved de 3 linjer nedenunder har vi lavet en "onclick"-funktion til de 3 knapper fra FarmerOverview.xml*/
/*Linjen nedenunder hører til "Se udvalg" som henviser til Farmer XXX's udvalg*/
    public void button4(View view) {
        findViewById(R.id.products);
    }
/*Linjen nedenunder hører til "Se udvalg" som henviser til Farmer XXY's udvalg*/
    public void button2(View view) {
    }
/*Linjen nedenunder henviser til knappen "Sign Out", som logger brugeren ud*/
    public void button5(View view) {
    }
}
