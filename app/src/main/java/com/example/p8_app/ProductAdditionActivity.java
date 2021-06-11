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
import com.example.p8_app.Models.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdditionActivity  extends AppCompatActivity {

    private EditText ProductName;
    private EditText ProductDetails;
    private EditText ProductPrice;
    private ImageView ProductImageView;
    private Button submitChangesButton;
    private Button deleteButton;


    private String productID = "";
    private String farmerID = "";

    private String Url;
    public static final int PICK_IMAGE = 11;

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
        setContentView(R.layout.activity_product_addition);

        ProductName = findViewById(R.id.Product_name);
        ProductDetails = findViewById(R.id.Product_details);
        ProductImageView = findViewById(R.id.product_image_view);
        ProductPrice = findViewById(R.id.product_price);


        submitChangesButton = findViewById(R.id.create_product);
        deleteButton = findViewById(R.id.delete_product);

        productID = getIntent().getStringExtra("productID");
        farmerID = getIntent().getStringExtra("farmerID");

        if (productID == null) productID = "";

        if (farmerID == null) {
            Toast toast = Toast.makeText(ProductAdditionActivity.this, "No Farmer Selected", Toast.LENGTH_LONG);
            toast.show();

            Intent intent = new Intent(ProductAdditionActivity.this, FrontpageActivity.class);
            intent.putExtra("fragmentName", "farmeroverview");
            startActivity(intent);
            finish();
        }


        if (!productID.isEmpty()){
            FetchProductData();

            submitChangesButton.setText("Update Product");
            deleteButton.setVisibility(View.VISIBLE);

        }else{
            submitChangesButton.setText("Create Product");
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }




    private void FetchProductData(){


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    IApiInterface api = new AnotherApi();
                    ProductModel productModel = api.GetProduct(productID);
                    ProductAdditionActivity.this.runOnUiThread(new Runnable() {
                        public void run() {

                            ProductName.setText(productModel.GetName());
                            ProductDetails.setText(productModel.GetDetails());
                            Picasso.get().load(productModel.GetImage()).into(ProductImageView);
                            ProductPrice.setText(productModel.GetPrice().toString());
                            submitChangesButton.setTag(productID);
                            deleteButton.setTag(productID);
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
                ProductImageView.setImageURI(uri);

                Url = getImageUrl(ProductImageView);
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



    public void closeProductEditView(View view){

        Intent intent = new Intent(ProductAdditionActivity.this, FarmerAdditionActivity.class);
        intent.putExtra("farmerID", farmerID);

        startActivity(intent);

    }

    public void selectImage(View view){
        Intent intent = buildPicturePickerIntent(getPackageManager());
        startActivityForResult(intent, 100);

    }


    private int getImageID(String imageName){
        return this.getResources()
                .getIdentifier(imageName, "drawable", this.getPackageName());
    }

    public void deleteProduct(View view){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                IApiInterface api = new AnotherApi();
                ProductModel productModel = new ProductModel();
                productModel.SetID(productID);
                try{

                    if (api.DeleteProduct(productModel)){
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast toast = Toast.makeText(ProductAdditionActivity.this, "Successfully Deleted", Toast.LENGTH_LONG);
                                toast.show();

                                Intent intent = new Intent(ProductAdditionActivity.this, FrontpageActivity.class);
                                intent.putExtra("fragmentName", "productsOverview");
                                intent.putExtra("farmerID", farmerID);
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


    public void EditProduct(View view){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                String name = ProductName.getText().toString();
                String details = ProductDetails.getText().toString();
                Float price = Float.parseFloat(ProductPrice.getText().toString());
                Url = getImageUrl(ProductImageView);
                IApiInterface api = new AnotherApi();

                ProductModel productModel = new ProductModel(productID, name, price,details,Url, farmerID);

                try{
                    // todo : redirect to activity
                    if (api.UpdateProduct(productModel)){
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
                } finally {

                }
            }
        });
        thread.start();
    }

    public void createProduct(View view) {

        if (!productID.isEmpty()){
            EditProduct(view);
            return;
        }

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                String name = ProductName.getText().toString();
                String details = ProductDetails.getText().toString();
                Float price = Float.parseFloat(ProductPrice.getText().toString());
                IApiInterface api = new AnotherApi();

                ProductModel productModel = new ProductModel(name, price,details,Url, farmerID);

                try{
                    if (api.AddProduct(productModel)){

                        // todo : redirect to activity

                        Intent intent = new Intent(ProductAdditionActivity.this, FrontpageActivity.class);
                        intent.putExtra("fragmentName", "productsOverview");
                        intent.putExtra("farmerID", farmerID);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast toast = Toast.makeText(ProductAdditionActivity.this, "Error", Toast.LENGTH_LONG);
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
                } finally {

                }
            }
        });

        thread.start();
    }
}