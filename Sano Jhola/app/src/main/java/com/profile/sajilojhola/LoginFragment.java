package com.profile.sajilojhola;

import android.annotation.SuppressLint;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginFragment extends Fragment {

    // initial the global variable
    private Button btnLogin, btnFacebook, btnGoogle, btnTwitter;
    private TextView tvForgotPassword, tvSignUp;
    private EditText tvUsername, tvPassword;
    private CheckBox btnCheckBox;

    private boolean check = true;
    private View loginView;

    ArrayList<java.io.Serializable> loginArrayList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loginView = inflater.inflate(R.layout.fragment_login, container, false);
        return loginView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SingUpFragment singUpFragment = new SingUpFragment();
        FacebookLoginFragment facebookLoginFragment = new FacebookLoginFragment();
        TwitterLoginFragment twitterLoginFragment = new TwitterLoginFragment();

        // initialize the id findViewById for button
        btnLogin = loginView.findViewById(R.id.btnLogin);
        btnFacebook = loginView.findViewById(R.id.icFacebook);
        btnGoogle = loginView.findViewById(R.id.icGoogle);
        btnTwitter = loginView.findViewById(R.id.btnTwitter);
        btnCheckBox = loginView.findViewById(R.id.btnCheckBox);

        // initialize the id findViewById for text
        tvForgotPassword = loginView.findViewById(R.id.tvForgotPassword);
        tvSignUp = loginView.findViewById(R.id.tvSignUp);

        // initialize the variable findViewById for textFields
        tvUsername = loginView.findViewById(R.id.tvLoginUsername);
        tvPassword = loginView.findViewById(R.id.tvLoginPassword);

        // create a setOnClickListener methods in login button where click to go main activity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint("InflateParams")
            public void onClick(View view) {
                // getText user data from LoginFragment class
                String loginUsername = tvUsername.getText().toString().trim();
                String loginPassword = tvPassword.getText().toString().trim();

                // check the editTextFields are empty or not
                if (loginUsername.isEmpty()) {
                    toastMassage("Enter your username?");
                } else if(loginPassword.isEmpty()){
                    toastMassage("Enter the password?");
                } else {
                    try {
                        // get the user data from arrayList
                        String signUpUsername = String.valueOf(loginArrayList.get(1));
                        String signUpPassword = String.valueOf(loginArrayList.get(2));

                        // is condition used to check the duplicate
                        if (signUpUsername.equals(loginUsername) && signUpPassword.equals(loginPassword)) {
                            // go to MainActivity by using the intent from Login Fragment to Main Activity
                            Intent intentMain = new Intent(getActivity(), MainActivity.class);
                            startActivity(intentMain);
                            // create an object of LoginActivity then call the openApp() methods
                            toastMassage("Welcome to Sano Jhola");
                        } else {
                            tvPassword.setTextColor(Color.RED);
                            toastMassage("Invalid password");
                        }
                    }catch (Exception ex){
                        tvPassword.setTextColor(Color.RED);
                        toastMassage("Invalid password!");
                    }
                }
            }
        });

        // create the setOnClickListener methods where old password remove to set up new password
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create the object of class and call the SingUpFragment class
                PasswordForgotFragment passwordForgotFragment = new PasswordForgotFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, passwordForgotFragment).commit();
            }
        });

        // create the setOnClickListener methods where press to go the sing page
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create the object of class and call the SingUpFragment class
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, singUpFragment).commit();

//                getSupportFragmentManager().beginTransaction().replace(R.id.loginFrameLayout, singUpFragment).commit();
            }
        });

        // create a setOnClickListener method which is used to google search
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoogle = new Intent(Intent.ACTION_WEB_SEARCH);
                startActivity(intentGoogle);
            }
        });

        // facebook button
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create the object of class and call the FacebookLoginFragment class
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, facebookLoginFragment).commit();
            }
        });

        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create the object of class and call the FacebookLoginFragment class
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.LoginFrameContener, twitterLoginFragment).commit();
            }
        });
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    // check the duplicated data (this methods recently unused)
    public boolean isDuplicateUsernamePassword(String loginUsername, String loginPassword){
        // get the user data from arrayList
        String signUpUsername = String.valueOf(loginArrayList.get(1));
        String signUpPassword = String.valueOf(loginArrayList.get(2));

        // is condition used to check the duplicate
        if (!signUpUsername.equals(loginUsername)) {
            toastMassage("Invalid username");
        } else {
            if (!signUpPassword.equals(loginPassword)){
                toastMassage("Invalid password");
            } else {
                return true;
            }
        }
        return false;
    }

    // create the setData method where Sign up data are add in arrayList
    public void setDatabases(String phoneNum, String username, String password){
        loginArrayList.add(phoneNum);
        loginArrayList.add(username);
        loginArrayList.add(password);
    }
}