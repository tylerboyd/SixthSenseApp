package com.example.sixthsenseapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SetupCaregiverInfo extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private EditText firstNameField;
    private EditText phoneNumberField;
    private EditText dateOfBirthField;
    private EditText gpNameField;
    private EditText gpNumberField;
    private EditText emergencyNameField;
    private EditText emergencyNumberField;
    private TextView errorMessage;
    private String firstName = "";
    private String phoneNumber = "";
    private String dateOfBirth;
    private String gpName = "";
    private String gpNumber = "";
    private String emergencyName = "";
    private String emergencyNumber = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_caregiver_info);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);
        firstNameField = (EditText) findViewById(R.id.firstNameField);
        phoneNumberField = (EditText) findViewById(R.id.phoneNumberField);
        dateOfBirthField = (EditText) findViewById(R.id.dateOfBirthField);
        gpNameField = (EditText) findViewById(R.id.gpNameField);
        gpNumberField = (EditText) findViewById(R.id.gpNumberField);
        emergencyNameField = (EditText) findViewById(R.id.emergencyNameField);
        emergencyNumberField = (EditText) findViewById(R.id.emergencyNumberField);
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

        gpNameField.addTextChangedListener(new TextWatcher() {
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

        gpNumberField.addTextChangedListener(new TextWatcher() {
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

        emergencyNameField.addTextChangedListener(new TextWatcher() {
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

        emergencyNumberField.addTextChangedListener(new TextWatcher() {
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
                phoneNumber = phoneNumberField.getText().toString();
                dateOfBirth = dateOfBirthField.getText().toString();
                gpName = gpNameField.getText().toString();
                gpNumber = gpNumberField.getText().toString();
                emergencyName = emergencyNameField.getText().toString();
                emergencyNumber = emergencyNumberField.getText().toString();


                Intent intent = new Intent(SetupCaregiverInfo.this, SetupAddCaregiver.class);
                startActivity(intent);
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
        if((!firstNameField.getText().toString().isEmpty()) && (!firstNameField.getText().toString().isEmpty()) && (!phoneNumberField.getText().toString().isEmpty()) && (!dateOfBirthField.getText().toString().isEmpty())
                && (!gpNameField.getText().toString().isEmpty()) && (!gpNumberField.getText().toString().isEmpty()) && (!emergencyNameField.getText().toString().isEmpty()) && (!emergencyNumberField.getText().toString().isEmpty())){
            nextButton.setEnabled(true);
        }
        else{
            nextButton.setEnabled(false);
        }
    }
}
