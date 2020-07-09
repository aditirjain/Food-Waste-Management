package com.example.foodwastemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "registerfarmerRestaurant.db";

    //TABLE NAMES
    public static final String DATABASE_TABLE_FARMER = "farmer";
    public static final String DATABASE_TABLE_RESTAURANT="restaurant";
    public static final String DATABASE_TABLE_PRODUCT="product";

    //COMMON COLUMN NAMES
    public static final String COLUMN_5 = "farmer_product";
    public static final String COLUMN_11 ="restuarant_product";

    //FARMER TABLE COLUMNS
    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 = "userName";
    public static final String COLUMN_3 = "password";
    public static final String COLUMN_4 = "re_password";
    public static final String COLUMN_6 ="quantity";

    //RESTAURANT TABLE COLUMNS
    public static final String COLUMN_7 = "ID";
    public static final String COLUMN_8 = "userName";
    public static final String COLUMN_9 = "password";
    public static final String COLUMN_10 = "re_password";
    public static final String COLUMN_12 ="quantity";

    //ORDER TABLE COLUMNS
    public static final String COLUMN_13 = "product_id";
    public static final String COLUMN_14 = "product";



    //CREATE TABLE CREATE STATEMENT FOR FARMER
    private static final String CREATE_TABLE_FARMER = "CREATE TABLE " + DATABASE_TABLE_FARMER
            + "(" + COLUMN_1 + " INTEGER PRIMARY KEY," + COLUMN_2 + " TEXT,"
            + COLUMN_3 + " TEXT," + COLUMN_5 + " TEXT," + COLUMN_6 + " INTEGER," + ")";


    private static final String CREATE_TABLE_RESTAURANT = "CREATE TABLE " + DATABASE_TABLE_RESTAURANT
            + "(" + COLUMN_7 + " INTEGER PRIMARY KEY," + COLUMN_8 + " TEXT,"
            + COLUMN_9 + " TEXT," +  COLUMN_11 + " TEXT," + COLUMN_12 + " INTEGER," + ")";


    private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE " + DATABASE_TABLE_PRODUCT
            + "(" + COLUMN_7 + " INTEGER PRIMARY KEY," + COLUMN_1 + " INTEGER,"
            + COLUMN_7 + " INTEGER," + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FARMER);
        db.execSQL(CREATE_TABLE_RESTAURANT);
        db.execSQL(CREATE_PRODUCT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE_FARMER);
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE_RESTAURANT);
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE_PRODUCT);

        onCreate(db);

    }

}
