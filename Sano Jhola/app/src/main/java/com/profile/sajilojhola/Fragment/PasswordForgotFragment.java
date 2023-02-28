package com.profile.sajilojhola.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.profile.sajilojhola.Fragment.LoginFragment;
import com.profile.sajilojhola.R;

import java.util.Random;

public class PasswordForgotFragment extends Fragment {

    Button btnBackLeftArrow,btnSendPassword;
    private EditText editTextOtpCode, editTextEmail, editTextPassword;
    private TextView txtOtpCode;
    private View forgotView;
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

        // initialize the variable
        btnBackLeftArrow = forgotView.findViewById(R.id.btnBackLeftArrow);
        btnSendPassword = forgotView.findViewById(R.id.btnSendPassword);
        editTextOtpCode = forgotView.findViewById(R.id.editTextOtpCode);
        editTextEmail = forgotView.findViewById(R.id.editTextEmail);
        editTextPassword = forgotView.findViewById(R.id.editTextPassword);
        txtOtpCode = forgotView.findViewById(R.id.txtOtpCode);

        // create an object of random class and generated the number
        Random random = new Random();
        @SuppressLint("DefaultLocale")
        String randomNumber = String.format("%04d", random.nextInt(1001));
        toastMassage("OTP code: "+randomNumber);
        btnSendPassword.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // getText user data from LoginFragment class
                String otpCode = editTextOtpCode.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                if (otpCode.isEmpty() || !otpCode.equals(randomNumber)) {
                    editTextOtpCode.setTextColor(Color.RED);;
                    toastMassage("Check the OTP code");
                }else if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextEmail.setTextColor(Color.RED); // color set
                    toastMassage("Enter the valid email!");
                } else if (password.isEmpty()){
                    toastMassage("Enter the strong password");
                } else {
                    // password are change in databases and go to login page
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.LoginFrameContener, loginFragment).commit();
                }
            }
        });

        // show the otp number
        txtOtpCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtOtpCode.setText(randomNumber); // set the generated random number
            }
        });

        // right back button
        btnBackLeftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to the  login fragment  class
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, loginFragment).commit();
            }
        });
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}