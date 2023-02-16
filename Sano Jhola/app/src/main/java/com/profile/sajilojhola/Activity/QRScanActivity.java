package com.profile.sajilojhola.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanIntentResult;
import com.journeyapps.barcodescanner.ScanOptions;
import com.profile.sajilojhola.R;

public class QRScanActivity extends AppCompatActivity {

    // create an global variable of Button
    Button btnScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscan);

        // initialize the variable findViewById for textFields
        btnScan = findViewById(R.id.btnScan);

        // create an setOnClickListener in btnScan
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call the scanCode methods
//                scanCode();
                ScanOptions options = new ScanOptions();
                options.setPrompt("Volume up to flash on");
                options.setOrientationLocked(true);
                options.setCaptureActivity(CaptureAct.class);
                // used the ActivityResultLauncher method's object
                barLuncher.launch(options);
            }
        });
    }

    // the result is display the dialog box
    ActivityResultLauncher<ScanOptions> barLuncher = registerForActivityResult(new ScanContract(), (ScanIntentResult result) -> {
        // used to if statement where check the result.getContents() are null or not
        if(result.getContents()!=null){
            AlertDialog.Builder builder = new AlertDialog.Builder(QRScanActivity.this); // create an object of AlertDialog box
            builder.setTitle("result");
            builder.setMessage(result.getContents()); // show the all scan result
            // press the Ok button then go to google search
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // call the searchingNet methods
                    searchingNet(result.getContents());
                    dialog.dismiss();
                }
            });
            // press the No then cancel
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });

    // google search words
    private void searchingNet(String searchWords){
        try{
            Intent intentWebSearch = new Intent(Intent.ACTION_WEB_SEARCH);
            intentWebSearch.putExtra(SearchManager.QUERY, searchWords);
            startActivity(intentWebSearch);
        }catch (Exception ex){
            ex.printStackTrace();
            searchingNet(searchWords); // recall the methods // recursive methods
        }
    }

    //    // create scan methods which is scan the QR code
//    private void scanCode(){
//        ScanOptions options = new ScanOptions();
//        options.setPrompt("Volume up to flash on");
//        options.setOrientationLocked(true);
//        options.setCaptureActivity(CaptureAct.class);
//        // used the ActivityResultLauncher method's object
//        barLuncher.launch(options);
//    }
}