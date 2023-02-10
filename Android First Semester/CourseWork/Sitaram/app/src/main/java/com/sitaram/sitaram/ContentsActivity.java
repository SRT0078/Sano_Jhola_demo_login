package com.sitaram.sitaram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ContentsActivity extends AppCompatActivity {

    // create an variable
    Button btnMenu;
    Button btnLogout;
    Button btnClose;

    BottomNavigationView bottomNavigationView;
    TextView textView;

    // create the object of all the fragment class
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    ContactFragment contactFragment = new ContactFragment();
    SkillsFragment skillsFragment = new SkillsFragment();
    HobbiesFragment hobbiesFragment = new HobbiesFragment();

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);

        // initial the  variable
        btnMenu = findViewById(R.id.btnMenu);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        textView = findViewById(R.id.tvTitle);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },100);

        // set the automatic home page
        toastMassage("Welcome to my Portfolio App !!");
        textView.setText("Home View");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navbar_ic_profile:
                        // display the  profile fragment layout
                        toastMassage("This is profile page");
                        textView.setText("Profile View");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, profileFragment).commit();
                        return true;
                    case R.id.navbar_ic_content:
                        // display the contact fr
                        // agment layout and show to toast message
                        toastMassage("This is contact page");
                        textView.setText("Contact View");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, contactFragment).commit();
                        return true;
                    case R.id.navbar_ic_skill:
                        // display the skill fragment layout show to toast message
                        toastMassage("This is skill page");
                        textView.setText("Skill View");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, skillsFragment).commit();
                        return true;
                    case R.id.navbar_ic_hobbies:
                        // display the hobbies fragment layout show to toast message
                        toastMassage("This is hobbies page");
                        textView.setText("Hobbies View");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, hobbiesFragment).commit();
                        return true;
                    default:
                        // when click the home display the home fragment layout show to toast message
                        toastMassage("This is home page");
                        textView.setText("Home View");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
                        return true;
                }
            }
        });

        // logout the app press the btnSetting
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an object of dialog box
                Dialog dialog = new Dialog(ContentsActivity.this);
                dialog.setContentView(R.layout.menus_layout);
                dialog.show();

                // initialize the variable for fiend view by id
                btnClose = dialog.findViewById(R.id.btnClose);
                btnLogout = dialog.findViewById(R.id.btnLogout);

                // create the setOnClickListener method for dismiss the dialog
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                // create the setOnClickListener method for logout
                btnLogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // display the AlertDialog box for app log out option
                        AlertDialog.Builder builder = new AlertDialog.Builder(ContentsActivity.this);
                        builder.setTitle("Logout");
                        builder.setMessage("Are you sure you want to logout?");
                        // press the yes the logout the app
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Toast.makeText(ContentsActivity.this, "Successfully logout.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                        // press the No then cancel to logout the app
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.show();
                    }
                });
            }
        });
    }

    // set ht toast message
    public void toastMassage(String message) {
        // display the profile profile fragment layout and show to toast message
        Toast.makeText(ContentsActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}