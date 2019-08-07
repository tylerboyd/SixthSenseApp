package com.example.sixthsenseapp.Setup;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
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
    private ImageButton nextButton;
    private ImageButton backButton;
    private EditText dateOfBirthField;
    private EditText gpNameField;
    private EditText gpNumberField;
    private EditText emergencyNameField;
    private EditText emergencyNumberField;
    private TextView errorMessage;
    private CheckBox addCaregiver;
    private static String dateOfBirth = "";
    private static String gpName = "";
    private static String gpNumber = "";
    private static String emergencyName = "";
    private static String emergencyNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_info2);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);
        dateOfBirthField = (EditText) findViewById(R.id.dateOfBirthField);
        gpNameField = (EditText) findViewById(R.id.gpNameField);
        gpNumberField = (EditText) findViewById(R.id.gpNumberField);
        emergencyNameField = (EditText) findViewById(R.id.emergencyNameField);
        emergencyNumberField = (EditText) findViewById(R.id.emergencyNumberField);
        errorMessage = (TextView) findViewById(R.id.errorMessage);
        addCaregiver = (CheckBox) findViewById(R.id.addCaregiver);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setEnabled(false);

        if(SetupUserType.getUserType().equals("User")){
            addCaregiver.setVisibility(View.VISIBLE);
        }
        else if(SetupUserType.getUserType().equals("Caregiver")){
            addCaregiver.setVisibility(View.INVISIBLE);
        }

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
                dateOfBirth = dateOfBirthField.getText().toString();
                gpName = gpNameField.getText().toString();
                gpNumber = gpNumberField.getText().toString();
                emergencyName = emergencyNameField.getText().toString();
                emergencyNumber = emergencyNumberField.getText().toString();

                if(SetupUserType.getUserType().equals("User")){
                    if(addCaregiver.isChecked()){
                        Intent intent = new Intent(SetupUserInfo2.this, SetupAddCaregiver.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(SetupUserInfo2.this, SetupBloodSugar.class);
                        startActivity(intent);
                    }
                }
                else if(SetupUserType.getUserType().equals("Caregiver")){
                    Intent intent = new Intent(SetupUserInfo2.this, SetupCaregiverInfo.class);
                    startActivity(intent);
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
        if((!dateOfBirthField.getText().toString().isEmpty()) && (!gpNameField.getText().toString().isEmpty()) && (!gpNumberField.getText().toString().isEmpty())
                && (!emergencyNameField.getText().toString().isEmpty()) && (!emergencyNumberField.getText().toString().isEmpty())){
            nextButton.setEnabled(true);
        }
        else{
            nextButton.setEnabled(false);
        }
    }

    public static String getDateOfBirth(){
        return dateOfBirth;
    }

    public static String getGpName(){
        return gpName;
    }

    public static String getGpNumber(){
        return gpNumber;
    }

    public static String getEmergencyName(){
        return emergencyName;
    }

    public static String getEmergencyNumber(){
        return emergencyNumber;
    }
}
