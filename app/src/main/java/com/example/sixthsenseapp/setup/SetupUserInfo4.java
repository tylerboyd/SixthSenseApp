package com.example.sixthsenseapp.setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.sixthsenseapp.R;

public class SetupUserInfo4 extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageButton backButton;
    private EditText emergencyNameField;
    private EditText emergencyNumberField;
    private static String emergencyName = "";
    private static String emergencyNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_info4);

        emergencyNameField = findViewById(R.id.emergencyNameField);
        emergencyNumberField = findViewById(R.id.emergencyNumberField);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);

        nextButton.setEnabled(false);

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

                emergencyName = emergencyNameField.getText().toString();
                emergencyNumber = emergencyNumberField.getText().toString();

                if(SetupUserType.getUserType().equals("User")){
                    Intent intent = new Intent(SetupUserInfo4.this, SetupAskCaregiver.class);
                    startActivity(intent);
                }
                else if(SetupUserType.getUserType().equals("Caregiver")){
                    Intent intent = new Intent(SetupUserInfo4.this, SetupAddCaregiver.class);
                    startActivity(intent);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserInfo4.this, SetupUserInfo3.class);
                startActivity(intent);
            }
        });
    }

    private void checkTextFields(){
        if((!emergencyNameField.getText().toString().isEmpty()) && (!emergencyNumberField.getText().toString().isEmpty())){
            nextButton.setEnabled(true);
        }
        else{
            nextButton.setEnabled(false);
        }
    }

    public static String getEmergencyName(){
        return emergencyName;
    }

    public static String getEmergencyNumber(){
        return emergencyNumber;
    }
}
