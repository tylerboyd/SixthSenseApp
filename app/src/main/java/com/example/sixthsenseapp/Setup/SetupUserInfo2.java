package com.example.sixthsenseapp.Setup;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixthsenseapp.R;

public class SetupUserInfo2 extends AppCompatActivity {

    private ImageView backgroundImage;
    private EditText passwordField;
    private EditText retypePasswordField;
    private EditText dateOfBirthField;
    private ImageButton nextButton;
    private ImageButton backButton;
    private TextView errorMessage;
    private static String password = "";
    private static String retypePassword = "";
    private static String dateOfBirth = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_info2);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        errorMessage = findViewById(R.id.errorMessage);
        passwordField = findViewById(R.id.passwordField);
        retypePasswordField = findViewById(R.id.retypePasswordField);
        dateOfBirthField = findViewById(R.id.dateOfBirthField);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setEnabled(false);

        passwordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkTextFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        retypePasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkTextFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        dateOfBirthField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkTextFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                password = passwordField.getText().toString();
                retypePassword = retypePasswordField.getText().toString();
                dateOfBirth = dateOfBirthField.getText().toString();

                if(password.length() >= 8){
                    if(password.equals(retypePassword)){
                        Intent intent = new Intent(SetupUserInfo2.this, SetupUserInfo3.class);
                        startActivity(intent);
                    }
                    else{
                        errorMessage.setTextColor(Color.RED);
                        errorMessage.setText("Passwords do not match!");
                    }
                }
                else{
                    errorMessage.setTextColor(Color.RED);
                    errorMessage.setText("Password must be at least 8 characters!");
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserInfo2.this, SetupUserInfo.class);
                startActivity(intent);
            }
        });
    }

    private void checkTextFields(){
        if((!passwordField.getText().toString().isEmpty()) && (!retypePasswordField.getText().toString().isEmpty())
                && (!dateOfBirthField.getText().toString().isEmpty())){
            nextButton.setEnabled(true);
        }
        else{
            nextButton.setEnabled(false);
        }
    }

    public static String getPassword(){
        return password;
    }

    public static String getDateOfBirth(){
        return dateOfBirth;
    }
}
