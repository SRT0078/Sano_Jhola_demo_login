package com.profile.sajilojhola.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import com.profile.sajilojhola.R;

public class QRScanActivity extends AppCompatActivity {

    Button btnScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscan);

        btnScan =findViewById(R.id.btnScan);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call the scanCode methods
                scanCode();
            }

        });
    }

    // create scan methods which is scan the QR code
    private void scanCode(){
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        // used the ActivityResultLauncher method's object
        barLuncher.launch(options);
    }

    // the result is display the dialog box
    ActivityResultLauncher<ScanOptions> barLuncher = registerForActivityResult(new ScanContract(), result -> {

        if(result.getContents()!=null){
            AlertDialog.Builder builder = new AlertDialog.Builder(QRScanActivity.this);
            builder.setTitle("result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }
    });
}