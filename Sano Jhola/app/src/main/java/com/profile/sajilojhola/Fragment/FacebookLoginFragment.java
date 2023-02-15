package com.profile.sajilojhola.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.profile.sajilojhola.Activity.LoginActivity;
import com.profile.sajilojhola.R;

public class FacebookLoginFragment extends Fragment {
    // create the global variable
    Button btnBackLeftArrow, btnFacebookLogin;

    View facebookView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        facebookView =  inflater.inflate(R.layout.fragment_facebook_login, container, false);
        return facebookView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        // initialize the id findViewById for button
        btnBackLeftArrow = facebookView.findViewById(R.id.btnBackLeftArrow);
        btnFacebookLogin = facebookView.findViewById(R.id.btnFacebookLogin);

        // create the setOnClickListener method in btnBackLeftArrow login button where go Login page
        btnBackLeftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent LoginIntent = new Intent(getActivity(), LoginActivity.class);
//                startActivity(LoginIntent);
            }
        });

        // create the setOnClickListener method in btnFacebookLogin button where go Login page
        btnFacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

    }
}