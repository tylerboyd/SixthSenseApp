package com.example.sixthsenseapp.Setup;

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

import java.util.ArrayList;
import java.util.List;

public class SetupAddCaregiver extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText phoneNumberField;
    private EditText emailField;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private static List<Caregiver> careCircle = new ArrayList<Caregiver>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_add_caregiver);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        firstNameField = findViewById(R.id.firstNameField);
        lastNameField = findViewById(R.id.lastNameField);
        phoneNumberField = findViewById(R.id.phoneNumberField);
        emailField = findViewById(R.id.emailField);

        int imageResource = getResources().getIdentifier("@drawable/setupaddcaregiver", null, this.getPackageName());
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

        emailField.addTextChangedListener(new TextWatcher() {
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
                phoneNumber = phoneNumberField.getText().toString();
                email = emailField.getText().toString();

                Caregiver caregiver = new Caregiver();

                caregiver.setFirstName(firstName);
                caregiver.setLastName(lastName);
                caregiver.setPhoneNumber(phoneNumber);
                caregiver.setEmail(email);

                careCircle.add(caregiver);

                Intent intent = new Intent(SetupAddCaregiver.this, SetupAddCareGiverComplete.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(SetupAddCaregiver.this, SetupUserInfo4.class);
                startActivity(intent);
            }
        });
    }

    private void checkTextFields(){
        if((!firstNameField.getText().toString().isEmpty()) && (!lastNameField.getText().toString().isEmpty()) && (!phoneNumberField.getText().toString().isEmpty()) && (!emailField.getText().toString().isEmpty())){
            nextButton.setEnabled(true);
        }
        else{
            nextButton.setEnabled(false);
        }
    }

    public static int getNumberOfCaregivers(){
        int numberofCaregivers = 0;

        numberofCaregivers = careCircle.size();

        return numberofCaregivers;
    }

    public static List getCareCircle(){

        return careCircle;
    }
}
