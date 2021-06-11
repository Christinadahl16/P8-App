package com.example.p8_app;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.p8_app.Logic.AnotherApi;
import com.example.p8_app.Logic.IApiInterface;
import com.example.p8_app.Logic.ImageFilePath;
import com.example.p8_app.Models.FarmerModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdditionActivity  extends AppCompatActivity {

    private EditText farmerName;
    private EditText farmerDetails;
    private ImageView farmerImageView;
    private Button submitChangesButton;
    private Button deleteButton;


    private String FarmerID = "";

    private String Url;
    public static final int PICK_IMAGE = 1;

    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framer_addition);

        farmerName = findViewById(R.id.farmer_name);
        farmerDetails = findViewById(R.id.farmer_details);
        farmerImageView = findViewById(R.id.farmer_image_view);
        submitChangesButton = findViewById(R.id.create_farmer);
        deleteButton = findViewById(R.id.delete_farmer);

        FarmerID = getIntent().getStringExtra("farmerID");

        if (FarmerID == null) FarmerID = "";


        if (!FarmerID.isEmpty()){
            FetchFramerData();

            submitChangesButton.setText("Update Farmer");
            deleteButton.setVisibility(View.VISIBLE);

        }else{
            submitChangesButton.setText("Create Farmer");
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }


    private void FetchFramerData(){


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    IApiInterface api = new AnotherApi();
                    FarmerModel farmerModel = api.GetFarmer(FarmerID);
                    ProductAdditionActivity.this.runOnUiThread(new Runnable() {
                        public void run() {

                            // farmerName = findViewById(R.id.farmer_name);
                            // farmerDetails = findViewById(R.id.farmer_details);
                            // farmerImageView = findViewById(R.id.farmer_image_view);
                            // submitChangesButton = findViewById(R.id.create_farmer);
                            farmerName.setText(farmerModel.GetName());
                            farmerDetails.setText(farmerModel.GetDetails());
                            Picasso.get().load(farmerModel.GetImageUrl()).into(farmerImageView);
                            submitChangesButton.setTag(FarmerID);
                            deleteButton.setTag(FarmerID);
                        }
                    });
                } catch (Exception ex){

                }
            }
        });

        thread.start();

    }

    public Intent buildPicturePickerIntent(PackageManager packageManager) {
        // Camera
        final List<Intent> cameraIntents = new ArrayList<>();
        final Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        final List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for (ResolveInfo res : listCam) {
            final String packageName = res.activityInfo.packageName;
            final Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(packageName);
            cameraIntents.add(intent);
        }
        // Filesystem
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        // Chooser of filesystem options
        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Select Source");
        // Add the camera options
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
                cameraIntents.toArray(new Parcelable[cameraIntents.size()]));
        // returning intent
        return chooserIntent;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {

            Uri uri = data.getData();
            // photo from gallery?
            if (uri != null) {
                // yes, photo from gallery
                farmerImageView.setImageURI(uri);

                Url = getImageUrl(farmerImageView);
                int a = 1;
            } else {
                // no, photo from camera
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Uri tempUri = ImageFilePath.getImageUri(getApplicationContext(), photo);
                // use path here
                Url = ImageFilePath.getRealPathFromURI(tempUri, getContentResolver());
            }


        }
    }

    private String getImageUrl(ImageView view){
        BitmapDrawable drawAbleBitmap =  (BitmapDrawable) view.getDrawable();
        Uri tempUri = ImageFilePath.getImageUri(getApplicationContext(), drawAbleBitmap.getBitmap());
        // use path here
        return ImageFilePath.getRealPathFromURI(tempUri, getContentResolver());
    }



    public void selectImage(View view){
        Intent intent = buildPicturePickerIntent(getPackageManager());
        startActivityForResult(intent, 100);

    }


    private int getImageID(String imageName){
        return this.getResources()
                .getIdentifier(imageName, "drawable", this.getPackageName());
    }

    public void deleteFarmer(View view){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                IApiInterface api = new AnotherApi();
                FarmerModel farmerModel = new FarmerModel();
                farmerModel.SetID(FarmerID);
                try{

                    if (api.DeleteFarmer(farmerModel)){
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast toast = Toast.makeText(ProductAdditionActivity.this, "Successfully Deleted", Toast.LENGTH_LONG);
                                toast.show();

                                Intent intent = new Intent(ProductAdditionActivity.this, FrontpageActivity.class);
                                intent.putExtra("fragmentName", "farmeroverview");
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                }
                catch (Exception exception){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast toast = Toast.makeText(ProductAdditionActivity.this, exception.getMessage(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            }
        });
        thread.start();
    }


    public void EditFarmer(View view){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                String name = farmerName.getText().toString();
                String details = farmerDetails.getText().toString();
                IApiInterface api = new AnotherApi();
                Url = getImageUrl(farmerImageView);
                FarmerModel farmerModel = new FarmerModel(FarmerID, name, details, Url);

                try{

                    if (api.UpdateFarmer(farmerModel)){
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast toast = Toast.makeText(ProductAdditionActivity.this, "Successfully Updated", Toast.LENGTH_LONG);
                                toast.show();
                            }
                        });
                    }
                }
                catch (Exception exception){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast toast = Toast.makeText(ProductAdditionActivity.this, exception.getMessage(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            }
        });
        thread.start();
    }

    public void CreateFarmer(View view) {

        if (!FarmerID.isEmpty()){
            EditFarmer(view);
            return;
        }

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                String name = farmerName.getText().toString();
                String details = farmerDetails.getText().toString();
                IApiInterface api = new AnotherApi();

                FarmerModel farmerModel = new FarmerModel(name, details, Url);

                try{
                    if (api.AddFarmer(farmerModel)){
                        Intent intent = new Intent(ProductAdditionActivity.this, FrontpageActivity.class);
                        intent.putExtra("fragmentName", "farmeroverview");
                        startActivity(intent);
                        finish();
                    }
                }
                catch (Exception exception){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast toast = Toast.makeText(ProductAdditionActivity.this, exception.getMessage(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            }
        });

        thread.start();
    }
}