package com.profile.sajilojhola.Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.profile.sajilojhola.R;

public class SliderActivity extends AppCompatActivity {

    TextView tvFirst, tvSecond, tvThird, tvFourth;

    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        tvFirst = findViewById(R.id.tvFirst);
        tvSecond = findViewById(R.id.tvSecond);
        tvThird = findViewById(R.id.tvThird);
        tvFourth = findViewById(R.id.tvFourth);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tvFirst.setBackgroundColor(android.R.color.holo_blue_light);
//            }
//        },500);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tvSecond.setBackgroundColor(android.R.color.holo_blue_light);
//            }
//        },1500);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tvThird.setBackgroundColor(android.R.color.holo_blue_light);
//            }
//        },2000);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tvFourth.setBackgroundColor(android.R.color.holo_blue_light);
//            }
//        },2500);

        // go to the Login activity class
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentLogin = new Intent(SliderActivity.this, LoginActivity.class);
                startActivity(intentLogin);
                finish();
            }
        },2000);
    }
}