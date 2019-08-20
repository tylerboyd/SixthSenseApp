package com.example.sixthsenseapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    private FirebaseAuth mAuth;
    private String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        backgroundImage = findViewById(R.id.backgroundImage);
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);
        errorMessage = findViewById(R.id.errorMessage);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validateData(emailField.getText().toString(), passwordField.getText().toString());
            }
        });
    }
    public LoginActivity(Context context)
    {

    }

    //NEEDS TO GET EMAIL AND PASSWORD DATA FROM DATABASE
     String validateData(String userEmail, String userPassword)
     {

         /*if(userEmail.equals(userEmail) && userPassword.equals(userPassword))
             return "Login was successful";
         else
             return "Invalid login!";*/
        /*if((userEmail.equals(storedEmail)) && (userPassword.equals(storedPassword))){
            Intent intent =  new Intent(LoginActivity.this, Dashboard.class);
            startActivity(intent);
            errorMessage.setText("");

        else{
            errorMessage.setTextColor(Color.RED);
            errorMessage.setText("Incorrect email address or password!");
        }*/

        mAuth.signInWithEmailAndPassword(enteredEmail, enteredPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    result = "Successfully Logged in.";
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                    Intent intent =  new Intent(LoginActivity.this, Dashboard.class);
                    startActivity(intent);
                }
                else {
                    result = "Login failed.";
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                    errorMessage.setTextColor(Color.RED);
                    errorMessage.setText("Failed to Logjn.");
                }
            }
        });
      return result;
    }
}
