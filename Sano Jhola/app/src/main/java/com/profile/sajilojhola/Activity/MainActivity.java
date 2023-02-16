package com.profile.sajilojhola.Activity;

import androidx.activity.result.ActivityResultLauncher;
import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import com.profile.sajilojhola.R;

public class MainActivity extends AppCompatActivity {

    private Button btnMenu;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the variable in findViewById of menu button
        btnMenu = findViewById(R.id.btnMenu);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // create an setOnItemSelectedListener methods where buttonNavicationBar button to go the fragment
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.btnNavbar_search) {// display the hobbies fragment layout show to toast message
                    toastMassage("This is hobbies page");
                    Intent intentQRScan = new Intent(MainActivity.this, QRScanActivity.class);
                    startActivity(intentQRScan);
                    return true;
                }

//                switch (item.getItemId()) {
//                    case R.id.navbar_ic_profile:
//                        // display the  profile fragment layout
//                        toastMassage("This is profile page");
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, profileFragment).commit();
//                        return true;
//                    case R.id.navbar_ic_content:
//                        // augment layout and show to toast message
//                        toastMassage("This is contact page");
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, contactFragment).commit();
//                        return true;
//                    case R.id.navbar_ic_skill:
//                        // display the skill fragment layout show to toast message
//                        toastMassage("This is skill page");
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, skillsFragment).commit();
//                        return true;
//                    case R.id.btnNavbar_search:
//                        // display the hobbies fragment layout show to toast message
//                        toastMassage("This is hobbies page");
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, skillsFragment).commit();
//                        return true;
//                    default:
//                        // when click the home display the home fragment layout show to toast message
//                        toastMassage("This is home page");
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
//                        return true;
//                }
                return false;
            }
        });

        // create a method where go the menu activity
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(menuIntent);
            }
        });

    }

    // create the toastMassage method
    public void toastMassage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}