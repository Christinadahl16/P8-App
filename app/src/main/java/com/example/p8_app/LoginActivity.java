package com.example.p8_app;

<<<<<<< Updated upstream
=======
import android.annotation.SuppressLint;
>>>>>>> Stashed changes
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< Updated upstream
=======
import androidx.annotation.NonNull;
>>>>>>> Stashed changes
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {


    /*Create variables for email, password and login button*/
    private EditText email;
    private EditText password;
    private Button login;
    private static final String TAG = "login";


    /*Firebase authentication variable*/
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Link to activity_login XML file*/
        email =(EditText)findViewById(R.id.email);
        password =(EditText)findViewById(R.id.password);
        login =(Button)findViewById(R.id.login);

        /*Initialize auth variable*/
        auth = FirebaseAuth.getInstance();


        storeNewUsersData();

        /*When login button is clicked, call */
        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                /*Convert text to string*/
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                loginUser(txt_email, txt_password);


<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
            }
        });
    }

    /*loginUser method*/
    private void loginUser(String txt_email, String txt_password) {
        /*Authenticate signing in with email and password*/
        auth.signInWithEmailAndPassword(txt_email, txt_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
                /*If login is successful, start MainActivity*/
                startActivity(new Intent(LoginActivity.this, FrontpageActivity.class));
                finish();

            }
        });
    }

    private void storeNewUsersData() {

        // Reference to the database that stores the data
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");

        myRef.setValue("First record!");

        // The DataSnapshot instance contains data from the Database location.
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

}