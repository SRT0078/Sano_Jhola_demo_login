package com.profile.sajilojhola;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TwitterLoginFragment extends Fragment {

    Button btnTwitterLogin, btnBackLeftArrow;
    View twitterView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        twitterView = inflater.inflate(R.layout.fragment_twitter_login, container, false);
        return twitterView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnBackLeftArrow = twitterView.findViewById(R.id.btnBackLeftArrow);
        btnTwitterLogin = twitterView.findViewById(R.id.btnTwitterLogin);

        // create the setOnClickListener method where go Login page
        btnBackLeftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(getActivity(), LoginActivity.class);
                startActivity(intentLogin);
            }
        });

        // create the setOnClickListener method where go Login fragment
        btnTwitterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(getActivity(), LoginActivity.class);
                startActivity(intentLogin);
            }
        });

    }
}