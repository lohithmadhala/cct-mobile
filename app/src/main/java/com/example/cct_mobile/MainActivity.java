package com.example.cct_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;
    EditText phoneNumberEditText;
    String phoneNumber;
    TextView redirectToSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditTextLogin);
        redirectToSignUp = findViewById(R.id.singUpTextView);

        redirectToSignUp.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.loginButton:
                if (isPhoneNumberValid()){
                    startActivity(new Intent(this, signup.class));
                } else {
                    Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.singUpTextView:
                startActivity(new Intent(this, signup.class));
                break;
        }
    }

    private boolean isPhoneNumberValid(){
        phoneNumber = phoneNumberEditText.getText().toString();
        if(phoneNumber.charAt(0) != '+') return false;
        if(phoneNumber.length()<11)  return false;
        return true;
    }




}