package com.sitaram.sitaram;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {

    // variable declare the button
    Button btnSearch;
    Button btnPhone;
    Button btnGmail;

    // variable declare of textFields
    private EditText tvSearch;

    private EditText tvTo, tvSubject, tvDescription;
    private View mainView;
    private EditText tvPhone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView =  inflater.inflate(R.layout.fragment_contact, container, false);
        return mainView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // getText find view by id for the text fields values
        tvSearch = mainView.findViewById(R.id.tvSearch);
        tvTo = mainView.findViewById(R.id.tvEmailAddress);
        tvSubject= mainView.findViewById(R.id.tvSubject);
        tvDescription = mainView.findViewById(R.id.tvDescriptions);
        tvPhone = mainView.findViewById(R.id.tvPhone);

        btnSearch = mainView.findViewById(R.id.btnSearch);
        btnPhone = mainView.findViewById(R.id.btnContact);
        btnGmail = mainView.findViewById(R.id.btnSend);

        // onClickListener methods call
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = tvPhone.getText().toString().trim();
                Intent call = new Intent(Intent.ACTION_DIAL);
                int totalDigit = phoneNumber.length();
                // using the if statement where total number is 10 and field is not empty the go to call
                if (totalDigit==10 && !(phoneNumber.isEmpty())){
                    call.setData(Uri.parse("tel:"+phoneNumber));
                    startActivity(call);
                }
            }
        });

        // google search anything
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searching = tvSearch.getText().toString();
                if (!searching.equals("")){
                    searchingNet(searching);
                }
            }
        });

        // some of message send by gmail
        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail(); // call the send email methods
            }
        });
    }

    // google search words
    private void searchingNet(String searchWords){
        try{
            Intent  intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, searchWords);
            startActivity(intent);
        }catch (Exception ex){
            ex.printStackTrace();
            searchingNet(searchWords); // recall the methods
        }
    }

    // email send the message
    private void sendMail(){
        String recipients_list =  tvTo.getText().toString();
        String [] recipients = recipients_list.split( ","); // one time send message for multiple email address

        // get the subject and message for text fields
        String subject = tvSubject.getText().toString();
        String message = tvDescription.getText().toString();

        // intent used to put details
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc8822");
        startActivity(Intent.createChooser(intent, "Choose your email?"));
    }
}