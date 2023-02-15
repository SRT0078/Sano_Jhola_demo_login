package com.profile.sajilojhola.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.profile.sajilojhola.Fragment.LoginFragment;
import com.profile.sajilojhola.R;

public class PasswordForgotFragment extends Fragment {

    Button btnSave;
    View forgotView;
    private View view;

    LoginFragment loginFragment = new LoginFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        forgotView = inflater.inflate(R.layout.fragment_password_forgot, container, false);
        return forgotView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        // initialize the id findViewById for button
        btnSave = forgotView.findViewById(R.id.btnSave);

        // create the setOnClickListener method where go Login fragment
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create the object of class and call the SingUpFragment class
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, loginFragment).commit();
            }
        });

    }
}