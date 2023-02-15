package com.profile.sajilojhola.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.profile.sajilojhola.Activity.LoginActivity;
import com.profile.sajilojhola.R;

public class TwitterLoginFragment extends Fragment {

    Button btnTwitterLogin, btnBackLeftArrow;
    View twitterView;

    LoginFragment loginFragment = new LoginFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
                // create the object of class and call the SingUpFragment class
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, loginFragment).commit();

//                Intent intentLogin = new Intent(getActivity(), LoginActivity.class);
//                startActivity(intentLogin);
            }
        });

        // create the setOnClickListener method where go Login fragment
        btnTwitterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create the object of class and call the SingUpFragment class
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, loginFragment).commit();

//                Intent intentLogin = new Intent(getActivity(), LoginActivity.class);
//                startActivity(intentLogin);
            }
        });

    }
}