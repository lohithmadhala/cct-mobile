package com.example.cct_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity implements View.OnClickListener{

    Button signupButton;
    EditText phoneNumberEditText;
    String phoneNumber;
    TextView redirectToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        signupButton = findViewById(R.id.signupButton);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditTextSignUp);
        redirectToLogin = findViewById(R.id.redirectToLoginTextView);

        redirectToLogin.setOnClickListener(this);
        signupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signupButton:
                phoneNumber = phoneNumberEditText.getText().toString();
                if(isPhoneNumberValid()){
                    signUpUser();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "Invalid Phone number", Toast.LENGTH_SHORT).show();
                }
            case R.id.redirectToLoginTextView:
                startActivity(new Intent(this, MainActivity.class));

        }
    }

    private boolean isPhoneNumberValid(){
        if(phoneNumber.charAt(0) != '+') return false;
        if(phoneNumber.length()<11)  return false;
        return true;
    }

    public void signUpUser(){

    }
}