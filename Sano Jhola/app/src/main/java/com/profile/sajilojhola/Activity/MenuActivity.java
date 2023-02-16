package com.profile.sajilojhola.Activity;

import androidx.annotation.Nullable;
import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.profile.sajilojhola.R;


public class MenuActivity extends AppCompatActivity {

    private ImageView imageCapture;

    LoginActivity loginActivity = new LoginActivity();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageCapture = findViewById(R.id.profileImageCapture);

        //
        imageCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamera,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        Bitmap bitmap = (Bitmap) (data.getExtras().get("data"));
        imageCapture.setImageBitmap(bitmap);
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}