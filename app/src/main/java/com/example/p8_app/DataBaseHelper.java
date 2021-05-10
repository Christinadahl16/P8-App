package com.example.p8_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_EMAIL = "CUSTOMER_EMAIL";
    public static final String COLUMN_CUSTOMER_PASSWORD = "CUSTOMER_PASSWORD";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    /*First time db is accessed*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_EMAIL + " TEXT, " + COLUMN_CUSTOMER_PASSWORD + " BOOL)";

        db.execSQL(createTableStatement);
    }

    /*Db version number method*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(CustomerModel customerModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CUSTOMER_EMAIL, customerModel.getEmail());
        cv.put(COLUMN_CUSTOMER_PASSWORD, customerModel.getPassword());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public List<CustomerModel> getEveryone(){
        List<CustomerModel> returnList = new ArrayList<>();

        /*Get data from db*/
        String queryString = "SELECT * FROM " + CUSTOMER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            do{
                String email = cursor.getString(0);
                String password = cursor.getString(1);

                CustomerModel newCustomer = new CustomerModel(email, password);
                returnList.add(newCustomer);

            } while (cursor.moveToNext());

        }

        else {
            /*Leave empty. Add nothing if add customer fails*/
        }

        /*Close cursor and database when done*/
        cursor.close();
        db.close();
        return returnList;
    }

    public void deleteOne(CustomerModel clickedCustomer) {
    }
}