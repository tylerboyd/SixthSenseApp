package com.example.sixthsenseapp.setup;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class SetupUserInfo extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailAddressField;
    private EditText phoneNumberField;

    private static String firstName = "";
    private static String lastName = "";
    private static String emailAddress = "";
    private static String phoneNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_info);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        firstNameField = findViewById(R.id.firstNameField);
        lastNameField = findViewById(R.id.lastNameField);
        emailAddressField = findViewById(R.id.emailField);
        phoneNumberField = findViewById(R.id.phoneNumberField);

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
                phoneNumber = phoneNumberField.getText().toString();

                Intent intent = new Intent(SetupUserInfo.this, SetupUserInfo2.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserInfo.this, SetupUserType.class);
                startActivity(intent);
            }
        });
    }

    private void checkTextFields(){
        if((!firstNameField.getText().toString().isEmpty()) && (!lastNameField.getText().toString().isEmpty()) && (!emailAddressField.getText().toString().isEmpty())){
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

    public static String getPhoneNumber(){
        return phoneNumber;
    }
}
