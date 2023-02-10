package com.profile.sajilojhola;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    LoginFragment loginFragment = new LoginFragment();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // auto replace the Login fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.LoginFrameContener, loginFragment).commit();
    }
}