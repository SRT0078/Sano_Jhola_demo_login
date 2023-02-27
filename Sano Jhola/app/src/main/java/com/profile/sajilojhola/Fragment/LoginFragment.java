package com.profile.sajilojhola.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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

import com.profile.sajilojhola.Activity.LoginActivity;
import com.profile.sajilojhola.Activity.MainActivity;
import com.profile.sajilojhola.R;

import java.util.ArrayList;

public class LoginFragment extends Fragment {

    private EditText tvUsername, tvPassword;
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

        // create an object of Fragment class
        SingUpFragment singUpFragment = new SingUpFragment();
        TwitterLoginFragment twitterLoginFragment = new TwitterLoginFragment();

        // initialize the variable findViewById for textFields
        tvUsername = loginView.findViewById(R.id.tvLoginUsername);
        tvPassword = loginView.findViewById(R.id.tvLoginPassword);

        // initial the global variable in button and text
        CheckBox btnCheckBox = loginView.findViewById(R.id.btnCheckBox);
        Button btnBackLeftArrow = loginView.findViewById(R.id.btnBackLeftArrow);
        Button btnLogin = loginView.findViewById(R.id.btnLogin);
        Button btnFacebook = loginView.findViewById(R.id.icFacebook);
        Button btnGoogle = loginView.findViewById(R.id.icGoogle);
        Button btnTwitter = loginView.findViewById(R.id.btnTwitter);
        TextView tvForgotPassword = loginView.findViewById(R.id.tvForgotPassword);
        TextView tvSignUp = loginView.findViewById(R.id.tvSignUp);

        // create a setOnClickListener methods in btnBackLeftArrow where click to go to Login Activity class
        btnBackLeftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(getActivity(), LoginActivity.class);
                startActivity(intentLogin);
            }
        });

        // create a setOnClickListener methods in btnCheckBox where click to toast message display
        final boolean[] check = {false};
        btnCheckBox.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!check[0]){
                    btnCheckBox.setText("Thanks for remember");
                    check[0] = true;
                } else {
                    btnCheckBox.setText("Remember Me!");
                    check[0] = false;
                }
            }
        });

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
                            // finish the fragment

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
                Dialog dialog = new Dialog(getActivity());
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.custom_dialog_password_forgot);
                dialog.show();
                // initialize the button from custom dialog box
                Button buttonDismiss = dialog.findViewById(R.id.btnDismiss);
                Button buttonSendRequest = dialog.findViewById(R.id.btnSendRequest);
                EditText editTextEmail = dialog.findViewById(R.id.editText_email);

                // create an setOnClickListener
                buttonDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                buttonSendRequest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String email = editTextEmail.getText().toString().trim();
                        if(!email.equals("")){
                            dialog.dismiss();
                            PasswordForgotFragment passwordForgotFragment = new PasswordForgotFragment();
                            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.LoginFrameContener, passwordForgotFragment).commit();
                        } else {
                            toastMassage("Please enter the valid email");
                        }
                    }
                });
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
                // intent used ot go the facebook page
                Intent followIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                startActivity(followIntent);
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

    // create the setData method where Sign up data are add in arrayList
    public void setDatabases(String phoneNum, String username, String password){
        loginArrayList.add(phoneNum);
        loginArrayList.add(username);
        loginArrayList.add(password);
    }
}