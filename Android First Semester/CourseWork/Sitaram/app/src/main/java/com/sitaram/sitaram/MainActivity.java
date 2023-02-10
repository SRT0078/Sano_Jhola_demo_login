package com.sitaram.sitaram;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button;
    int counter = 1;
    FirstViewPagerFragment firstViewPagerFragment = new FirstViewPagerFragment();
    SecondViewPagerFragment secondViewPAgerFragment = new SecondViewPagerFragment();
    FinalViewPagerFragment finalViewPagerFragment = new FinalViewPagerFragment();
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial the button variable findViewById and go to first slider
        button = findViewById(R.id.btn_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layoutSlider, firstViewPagerFragment).commit();

        // button click to go the home FragmentRollActivity page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // using the if statement
                if (counter==1){
                    button.setText("Next");
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layoutSlider, secondViewPAgerFragment).commit();
                }else if(counter==2){
                    button.setText("Done");
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layoutSlider, finalViewPagerFragment).commit();
                } else {
                    // create and object the dialog box
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.custom_dialog_box);
                    dialog.show();

                    // initial the button variable where the button is come to the dialog bok so we get the the id form dialog box and create the setOnClock Listener methods
                    Button button = dialog.findViewById(R.id.btnOk);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // go to content activity
                            Intent intent = new Intent(MainActivity.this, ContentsActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
                counter++;
            }
        });
    }
}