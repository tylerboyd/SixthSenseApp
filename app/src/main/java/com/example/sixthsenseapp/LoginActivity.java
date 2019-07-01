package com.example.sixthsenseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private ImageView backgroundImage;
    private EditText email;
    private EditText password;
    private Button loginButton;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backgroundImage = findViewById(R.id.backgroundImage);
        email = (EditText)findViewById(R.id.emailField);
        password = (EditText)findViewById(R.id.passwordField);
        loginButton = (Button)findViewById(R.id.loginButton);
        errorMessage = (TextView)findViewById(R.id.errorMessage);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validateData(email.getText().toString(), password.getText().toString());
            }
        });
    }

    //NEEDS TO GET EMAIL AND PASSWORD DATA FROM DATABASE
    private void validateData(String userEmail, String userPassword){
        if((userEmail.equals("test")) && (userPassword.equals("test"))){
            //Intent intent =  new Intent(LoginActivity.this, DashboardActivity.class);
            //startActivity(intent);
            Log.i("LoginSuccess", "Correct Email and Password!");
            errorMessage.setText("");
        }
        else{
            Log.i("LoginFailure", "Incorrect Email or Password!");
            errorMessage.setText("Incorrect email or password!");
        }
    }
}
