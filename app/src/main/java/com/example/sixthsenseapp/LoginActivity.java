package com.example.sixthsenseapp;

import android.content.Intent;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private ImageView backgroundImage;
    private EditText emailField;
    private EditText passwordField;
    private ImageButton loginButton;
    private TextView errorMessage;
    private String storedEmail = "test";
    private String storedPassword = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        emailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        loginButton = (ImageButton) findViewById(R.id.loginButton);
        errorMessage = (TextView) findViewById(R.id.errorMessage);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validateData(emailField.getText().toString(), passwordField.getText().toString());
            }
        });
    }

    //NEEDS TO GET EMAIL AND PASSWORD DATA FROM DATABASE
    private void validateData(String userEmail, String userPassword){
        if((userEmail.equals(storedEmail)) && (userPassword.equals(storedPassword))){
            Intent intent =  new Intent(LoginActivity.this, Dashboard.class);
            startActivity(intent);
            errorMessage.setText("");
        }
        else{
            errorMessage.setTextColor(Color.RED);
            errorMessage.setText("Incorrect email address or password!");
        }
    }
}
