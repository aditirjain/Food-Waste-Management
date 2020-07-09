package com.example.foodwastemanagement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddRestaurantRequirementActivity extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    TextView tv_des;
    Spinner spinner;
    EditText ed_quantity;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_requirement);

        tv_des = findViewById(R.id.tv_des);
        spinner = findViewById(R.id.spinner);
        ed_quantity = findViewById(R.id.ed_quantity);
        btn_submit = findViewById(R.id.btn_submit);
        openHelper = new DatabaseHelper(this);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String item = spinner.getSelectedItem().toString();
                final String quantity = ed_quantity.toString();
                final int q = Integer.parseInt(quantity);
                db = openHelper.getWritableDatabase();
                insertProduct(item, q);

            }
        });

    }
        public void insertProduct(String item, int quantity){
            ContentValues contentValues = new ContentValues();


        }
    }
