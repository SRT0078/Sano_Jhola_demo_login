package com.profile.sajilojhola.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.profile.sajilojhola.Activity.LoginActivity;
import com.profile.sajilojhola.R;
import com.profile.sajilojhola.Activity.UserData;

import java.util.ArrayList;

public class SingUpFragment extends Fragment {

    private Button btnLeftBack, btnSingUp;
    private TextView tvLogin;
    private EditText tvPhoneNumber, tvUserName, tvPassWord;
    private View signUpView;

    LoginFragment loginFragment = new LoginFragment();

    // create an arrayList and object of UserData class
//     ArrayList<String> arrayList = new ArrayList<>();
    UserData userData = new UserData();

//    int phoneNum;
    String username;
    String password;
    String phoneNum;

    ArrayList<java.io.Serializable> arrayList = new ArrayList<java.io.Serializable>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        signUpView = inflater.inflate(R.layout.fragment_sing_up, container, false);
        return signUpView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        LoginActivity loginActivity = new LoginActivity();

        // initialize the id findViewById for button
        btnLeftBack = signUpView.findViewById(R.id.btnBackLeftArrow);
        btnSingUp = signUpView.findViewById(R.id.btnSignUp);
        tvLogin = signUpView.findViewById(R.id.tvLogin);

        // initialize the id findViewById for textFields
        tvPhoneNumber = signUpView.findViewById(R.id.tvPhoneNumber);
        tvUserName = signUpView.findViewById(R.id.tvSignUpUsername);
        tvPassWord = signUpView.findViewById(R.id.tvSignUpPassword);

        // create the setOnClickListener method where go Login fragment
        btnLeftBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, loginFragment).commit();

//                Intent singUpIntern = new Intent(getActivity(), LoginActivity.class);
//                startActivity(singUpIntern);
            }
        });

        // create the setOnClickListener method where go Login fragment
        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
                    tvPhoneNumber.setTextColor(Color.BLACK);
                    phoneNum = tvPhoneNumber.getText().toString().trim();
                    username = tvUserName.getText().toString().trim();
                    password = tvPassWord.getText().toString().trim();

                    // check the editTextFields are empty or not
                    if (phoneNum.isEmpty()) {
                        toastMassage("Enter the phone number");
                    } else if (username.isEmpty()) {
                        toastMassage("Enter the username");
                    } else if (password.isEmpty()) {
                        toastMassage("Enter the password");
                    } else {
                        // using the if statement where total number is 10 and field is not empty the go to call
                        int totalDigit = phoneNum.length();
                        if (totalDigit == 10) {
                            // user password are store in database
                            loginFragment.setDatabases(phoneNum, username, password);
                            toastMassage("New account created");
                            // create the object of class and call the SingUpFragment class
                            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.LoginFrameContener, loginFragment).commit();

//                            Intent singUpIntent = new Intent(getActivity(), LoginActivity.class);
//                            startActivity(singUpIntent);

                        } else {
                            // display the toast message and set the color in texField
                            toastMassage("Invalid number!");
                            tvPhoneNumber.setTextColor(Color.RED);
                        }
                    }
//                } catch (Exception ex){
//                    toastMassage("Invalid input!");
//                }
            }
        });

        // create the setOnClickListener method where go Login fragment
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create the object of class and call the SingUpFragment class
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, loginFragment).commit();

//                Intent singUpIntern = new Intent(getActivity(), LoginActivity.class);
//                startActivity(singUpIntern);
            }
        });
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}