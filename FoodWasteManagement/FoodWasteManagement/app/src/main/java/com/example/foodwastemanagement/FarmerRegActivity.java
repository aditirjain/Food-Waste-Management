package com.example.foodwastemanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FarmerRegActivity extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    TextView tv1, tv2;
    EditText ed_username, ed_password, ed_pwd;
    Button btn_register;
    RadioButton rbtn_farmer, rbtn_restaurant;
    RadioGroup radio_group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_reg);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        ed_pwd = findViewById(R.id.ed_pwd);
        btn_register = findViewById(R.id.btn_register);
        radio_group = findViewById(R.id.radio_group);
        rbtn_farmer = findViewById(R.id.rbtn_farmer);
        rbtn_restaurant = findViewById(R.id.rbtn_restaurant);
        openHelper = new DatabaseHelper(this);


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent mainActivityIntent = new Intent(FarmerRegActivity.this, MainActivity.class);
               startActivity(mainActivityIntent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = ed_username.getText().toString();
                String password = ed_password.getText().toString();
                String repassword = ed_pwd.getText().toString();
                db = openHelper.getWritableDatabase();

                if (rbtn_farmer.isChecked() && password.equals(repassword) && !username.isEmpty()){
                    insertData(username, password, repassword); 
                    Intent resaurantListActivity = new Intent(FarmerRegActivity.this,
                            AddFarmerProductsActivity.class);

                    startActivity(resaurantListActivity);

                    Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                }else if(rbtn_restaurant.isChecked() && password.equals(repassword) &&
                        !username.isEmpty() && !password.isEmpty()){
                    Intent farmerListIntent = new Intent(FarmerRegActivity.this, AddRestaurantRequirementActivity.class);
                    startActivity(farmerListIntent);
                }else {
                    Toast.makeText(FarmerRegActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void insertData(String usename, String password, String repassword){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_2, usename);
        contentValues.put(DatabaseHelper.COLUMN_3, password);
        contentValues.put(DatabaseHelper.COLUMN_4, repassword);

        long id = db.insert(DatabaseHelper.DATABASE_TABLE_FARMER, null, contentValues);
    }
}
