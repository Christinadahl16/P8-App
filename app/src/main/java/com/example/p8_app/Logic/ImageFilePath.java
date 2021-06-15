package com.example.p8_app.Logic;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;

public class ImageFilePath {

    private static String tempurl;

    public static Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, getSaltString(), null);
        return Uri.parse(path);
    }

    public static String getRealPathFromURI(Uri uri, ContentResolver resolver) {
        Cursor cursor = resolver.query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        tempurl = cursor.getString(idx);
        return tempurl;
    }

    public static void Cleanup(){
        File fdelete = new File(tempurl);
        if (fdelete.exists()) {
            if (fdelete.delete()) {
                System.out.println("file Deleted :" );
            } else {
                System.out.println("file not Deleted :");
            }
        }
    }


    private static  String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}