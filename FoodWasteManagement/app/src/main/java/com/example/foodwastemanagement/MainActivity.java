package com.example.foodwastemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    EditText ed_username, ed_passsword;
    Button btn_login;
    RadioButton rbtn_farmer, rbtn_restaurant;
    RadioGroup radio_group;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = new DatabaseHelper(this);
        ed_username = findViewById(R.id.ed_username);
        ed_passsword = findViewById(R.id.ed_password);
        rbtn_farmer = findViewById(R.id.rbtn_farmer);
        rbtn_restaurant = findViewById(R.id.rbtn_restaurant);
        radio_group = findViewById(R.id.radio_group);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        btn_login = findViewById(R.id.btn_login);


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtn_farmer.isChecked()){
                    Intent farmerRegIntent = new Intent(MainActivity.this, FarmerRegActivity.class);
                    startActivity(farmerRegIntent);
                }else if (rbtn_restaurant.isChecked()){
                    Intent restaurantRegIntent = new Intent(MainActivity.this, RestaurantRegActivity.class);
                    startActivity(restaurantRegIntent);
                }else {
                    Toast.makeText(MainActivity.this, "Please select one user type", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbtn_farmer.isChecked() && !ed_username.getText().toString().isEmpty() && !ed_passsword.getText().toString().isEmpty()){
                    String username = ed_username.getText(). toString().trim();
                    String password = ed_passsword.getText().toString().trim();
//                    Boolean res = db.checkFarmer(username, password);
//                    if(res == true) {
                        Intent farmerLoginIntent = new Intent(MainActivity.this, AddFarmerProductsActivity.class);
                        startActivity(farmerLoginIntent);
//                    }else {
//                        Toast.makeText(MainActivity.this,"Login Error!", Toast.LENGTH_SHORT).show();
//                    }
                }else if(rbtn_restaurant.isChecked()){
                    Intent restaurantLoginIntent = new Intent(MainActivity.this, AddRestaurantRequirementActivity.class);
                    startActivity(restaurantLoginIntent);
                }else {
                    Toast.makeText(MainActivity.this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
