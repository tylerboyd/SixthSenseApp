package com.example.sixthsenseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class SetupUserInfo2 extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button nextButton;
    private Button backButton;
    private EditText phoneNumberField;
    private EditText dateOfBirthField;
    private EditText gpNameField;
    private EditText gpNumberField;
    private EditText emergencyNameField;
    private EditText emergencyNumberField;
    private TextView errorMessage;
    private String phoneNumber = "";
    private String dateOfBirth;
    private String gpName = "";
    private String gpNumber = "";
    private String emergencyName = "";
    private String emergencyNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_info2);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (Button) findViewById(R.id.nextButton);
        backButton = (Button) findViewById(R.id.backButton);
        phoneNumberField = (EditText) findViewById(R.id.phoneNumberField);
        dateOfBirthField = (EditText) findViewById(R.id.dateOfBirthField);
        gpNameField = (EditText) findViewById(R.id.gpNameField);
        gpNumberField = (EditText) findViewById(R.id.gpNumberField);
        emergencyNameField = (EditText) findViewById(R.id.emergencyNameField);
        emergencyNumberField = (EditText) findViewById(R.id.emergencyNumberField);
        errorMessage = (TextView) findViewById(R.id.errorMessage);


        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                phoneNumber = phoneNumberField.getText().toString();
                dateOfBirth = dateOfBirthField.getText().toString();
                gpName = gpNameField.getText().toString();
                gpNumber = gpNumberField.getText().toString();
                emergencyName = emergencyNameField.getText().toString();
                emergencyNumber = emergencyNumberField.getText().toString();

                if((!TextUtils.isEmpty(phoneNumber))&& (!TextUtils.isEmpty(dateOfBirth)) && (!TextUtils.isEmpty(gpName)) && (!TextUtils.isEmpty(gpNumber))
                        && (!TextUtils.isEmpty(emergencyName)) && (!TextUtils.isEmpty(emergencyNumber)) ){
                    Intent intent = new Intent(SetupUserInfo2.this, SetupBloodSugar.class);
                    startActivity(intent);
                }
                else{
                    errorMessage.setText("Please fill out all fields!");
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
}
