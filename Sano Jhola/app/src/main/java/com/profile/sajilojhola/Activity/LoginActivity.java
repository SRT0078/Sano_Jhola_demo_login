package com.profile.sajilojhola.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.profile.sajilojhola.Fragment.SingUpFragment;
import com.profile.sajilojhola.Fragment.LoginFragment;
import com.profile.sajilojhola.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    ImageView profileImageCapture;

    // create an object of LoginFragment and SingUpFragment class
    LoginFragment loginFragment = new LoginFragment();
    SingUpFragment singUpFragment = new SingUpFragment();

    // create an arrayList
    ArrayList<Object> loginArrayList = new ArrayList<>();
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // initial the global variable of Button
        profileImageCapture = findViewById(R.id.profileImageCapture);

        TextView btnLoginWithNewAccount = findViewById(R.id.btnLoginNewAccount);
        TextView btnCreateAccount = findViewById(R.id.btnCreateAccount);

        // create a setOnClickListener methods in btnLoginWithNewAccount where click to go login fragment class
        btnLoginWithNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.LoginFrameContener, loginFragment).commit();
            }
        });

        // create a setOnClickListener methods in btnLoginWithNewAccount where click to go sing up fragment class
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.LoginFrameContener, singUpFragment).commit();
            }
        });
    }

    // create a toastMassage method which accept the String parameter
    public void toastMassage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}


        // auto replace the Login fragment
//        getSupportFragmentManager().beginTransaction().replace(R.id.LoginFrameContener, loginFragment).commit();

        // initialize the variable findViewById for textFields
//        tvUsername = findViewById(R.id.tvLoginUsername);
//        tvPassword = findViewById(R.id.tvLoginPassword);
//
//        // initialize the id findViewById for button
//        btnCheckBox = findViewById(R.id.btnCheckBox);
//        btnLogin = findViewById(R.id.btnLogin);
//        btnFacebook = findViewById(R.id.icFacebook);
//        btnGoogle = findViewById(R.id.icGoogle);
//        btnTwitter = findViewById(R.id.btnTwitter);
//
//        // initialize the id findViewById for text
//        tvForgotPassword = findViewById(R.id.tvForgotPassword);
//        tvSignUp = findViewById(R.id.tvSignUp);
//
//        // create a setOnClickListener methods in btnCheckBox where click to toast message display where also create the list
//        final boolean[] check = {true};
//        btnCheckBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (check[0]){
//                    btnCheckBox.setText("Thanks for remember");
//                    check[0] = false;
//                } else {
//                    btnCheckBox.setText("Remember Me");
//                    check[0] = true;
//                }
//            }
//        });
//
//        // create a setOnClickListener methods in login button where click to go main activity
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            @SuppressLint("InflateParams")
//            public void onClick(View view) {
//                // getText user data from LoginFragment class
//                String loginUsername = tvUsername.getText().toString().trim();
//                String loginPassword = tvPassword.getText().toString().trim();
//
//                // check the editTextFields are empty or not
//                if (loginUsername.isEmpty()) {
//                    toastMassage("Enter your username?");
//                } else if(loginPassword.isEmpty()){
//                    toastMassage("Enter the password?");
//                } else {
////                    try {
//                        // get the user data from arrayList
//                        String signUpUsername = String.valueOf(loginArrayList.get(1));
//                        String signUpPassword = String.valueOf(loginArrayList.get(2));
//
//                        // is condition used to check the duplicate
//                        if (signUpUsername.equals(loginUsername) && signUpPassword.equals(loginPassword)) {
//                            // go to MainActivity by using the intent from Login Fragment to Main Activity
//                            Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intentMain);
//                            // create an object of LoginActivity then call the openApp() methods
//                            toastMassage("Welcome to Sano Jhola");
//                        } else {
//                            tvPassword.setTextColor(Color.RED);
//                            toastMassage("Invalid password");
//                        }
////                    }catch (Exception ex){
////
////                        tvPassword.setTextColor(Color.RED);
////                        toastMassage("Username and doesn't match!");
////                    }
//                }
//            }
//        });
//
//        // create the setOnClickListener methods where old password remove to set up new password
//        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.LoginFrameContener, passwordForgotFragment).commit();
//            }
//        });
//
//        // create the setOnClickListener methods where press to go the sing page
//        tvSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // create the object of class and call the SingUpFragment class
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.LoginFrameContener, singUpFragment).commit();
//            }
//        });
//
//        // create a setOnClickListener method which is used to google search
//        btnGoogle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentGoogle = new Intent(Intent.ACTION_WEB_SEARCH);
//                startActivity(intentGoogle);
//            }
//        });
//
//        // facebook button
//        btnFacebook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // create the object of class and call the FacebookLoginFragment class
////                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
////                fragmentTransaction.replace(R.id.LoginFrameContener, facebookLoginFragment).commit();
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.LoginFrameContener, facebookLoginFragment).commit();
//
//            }
//        });
//
//        btnTwitter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // create the object of class and call the FacebookLoginFragment class
////                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
////                fragmentTransaction.replace(R.id.LoginFrameContener, twitterLoginFragment).commit();
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.LoginFrameContener, twitterLoginFragment).commit();
//
//            }
//        });

