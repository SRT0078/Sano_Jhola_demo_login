package com.profile.sajilojhola.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.profile.sajilojhola.R;

public class SliderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

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