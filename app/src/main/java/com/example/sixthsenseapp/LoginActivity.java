package com.example.sixthsenseapp;

import android.content.Intent;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private ImageView backgroundImage;
    private EditText emailField;
    private EditText passwordField;
    private ImageButton loginButton;
    private TextView errorMessage;
    private String enteredEmail;
    private String enteredPassword;
    private String storedEmail = "test";
    private String storedPassword = "test";
    private static FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

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
                enteredEmail = emailField.getText().toString();
                enteredPassword = passwordField.getText().toString();
                validateData(enteredEmail, enteredPassword);
            }
        });
    }

    //NEEDS TO GET EMAIL AND PASSWORD DATA FROM DATABASE
    private void validateData(String userEmail, String userPassword){
        /*if((userEmail.equals(storedEmail)) && (userPassword.equals(storedPassword))){
            Intent intent =  new Intent(LoginActivity.this, Dashboard.class);
            startActivity(intent);
            errorMessage.setText("");
        }
        else{
            errorMessage.setTextColor(Color.RED);
            errorMessage.setText("Incorrect email address or password!");
        }*/



        mAuth.signInWithEmailAndPassword(enteredEmail, enteredPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Successfully Logged in.", Toast.LENGTH_LONG).show();
                            Intent intent =  new Intent(LoginActivity.this, Dashboard.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Login failed.", Toast.LENGTH_LONG).show();
                            errorMessage.setTextColor(Color.RED);
                            errorMessage.setText("Failed to Logjn.");
                        }
                    }
                });
    }


    public static FirebaseAuth getFirebaseAuth() {
        return mAuth;
    }
}


