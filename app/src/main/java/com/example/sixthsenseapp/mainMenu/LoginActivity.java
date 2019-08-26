package com.example.sixthsenseapp.mainMenu;

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

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.dashboard.Dashboard;
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
    private static FirebaseAuth mAuth;

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
                enteredEmail = emailField.getText().toString();
                enteredPassword = passwordField.getText().toString();
                //validateData(enteredEmail, enteredPassword);
                Intent intent =  new Intent(LoginActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

    private void validateData(String userEmail, String userPassword){
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


