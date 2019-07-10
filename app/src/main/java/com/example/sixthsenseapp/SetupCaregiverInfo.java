package com.example.sixthsenseapp;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SetupCaregiverInfo extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailAddressField;
    private EditText passwordField;
    private EditText retypePasswordField;
    private EditText phoneNumberField;
    private TextView errorMessage;
    private static String firstName = "";
    private static String lastName = "";
    private static String emailAddress = "";
    private static String password = "";
    private static String retypePassword = "";
    private static String phoneNumber = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_caregiver_info);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);
        firstNameField = (EditText) findViewById(R.id.firstNameField);
        lastNameField = (EditText) findViewById(R.id.lastNameField);
        emailAddressField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        retypePasswordField = (EditText) findViewById(R.id.retypePasswordField);
        phoneNumberField = (EditText) findViewById(R.id.phoneNumberField);
        errorMessage = (TextView) findViewById(R.id.errorMessage);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setEnabled(false);

        firstNameField.addTextChangedListener(new TextWatcher() {
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

        lastNameField.addTextChangedListener(new TextWatcher() {
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

        emailAddressField.addTextChangedListener(new TextWatcher() {
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

        phoneNumberField.addTextChangedListener(new TextWatcher() {
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

                firstName = firstNameField.getText().toString();
                lastName = lastNameField.getText().toString();
                emailAddress = emailAddressField.getText().toString();
                password = passwordField.getText().toString();
                retypePassword = retypePasswordField.getText().toString();
                phoneNumber = phoneNumberField.getText().toString();

                if(password.equals(retypePassword)){
                    Intent intent = new Intent(SetupCaregiverInfo.this, SetupUserInfo2.class);
                    startActivity(intent);
                }
                else{
                    errorMessage.setTextColor(Color.RED);
                    errorMessage.setText("Passwords do not match!");
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupCaregiverInfo.this, SetupUserInfo.class);
                startActivity(intent);
            }
        });
    }

    private void checkTextFields(){
        if((!firstNameField.getText().toString().isEmpty()) && (!lastNameField.getText().toString().isEmpty()) && (!emailAddressField.getText().toString().isEmpty())
                && (!passwordField.getText().toString().isEmpty()) && (!retypePasswordField.getText().toString().isEmpty()) && (!phoneNumberField.getText().toString().isEmpty())){
            nextButton.setEnabled(true);
        }
        else{
            nextButton.setEnabled(false);
        }
    }

    public static String getFirstName(){
        return firstName;
    }

    public static String getLastName(){
        return lastName;
    }

    public static String getEmailAddress(){
        return emailAddress;
    }

    public static String getPassword(){
        return password;
    }

    public static String getPhoneNumber(){
        return phoneNumber;
    }
}
