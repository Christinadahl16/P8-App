package com.example.p8_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class StartActivity extends AppCompatActivity {

    /*Create variable login button
    * Create variable account button */
    private Button login;
    private Button create;
    private EditText email;
    private EditText password;
    private ViewPager viewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);
      Toolbar toolbar = findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      /*Connect buttons to XML file*/
      login =findViewById(R.id.login1);
      create =findViewById(R.id.create1);
      email =findViewById(R.id.email);
      password =findViewById(R.id.password);

      /*Add OnClickListeners to login and create button*/
      create.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(StartActivity.this, CreateActivity.class));
              finish();
          }
      });

 }

 /**/
  private void loginCustomer(String txt_email, String txt_password) {
  }
 public void login1(View v) {
      String txt_email = email.getText().toString();
      String txt_password = password.getText().toString();

      /*Create account verification of email and password*/
     if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
         Toast message = Toast.makeText(this, "Invalid e-mail", Toast.LENGTH_SHORT);
         message.show();
     } else if (txt_password.length() < 8) {
        Toast message = Toast.makeText(this, "Password is too short", Toast.LENGTH_SHORT);
         message.show();
     } else {
          loginCustomer(txt_email, txt_password);
      }
}

}
