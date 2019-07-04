package com.example.sixthsenseapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SetupUserInfo extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button nextButton;
    private Button backButton;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailAddressField;
    private EditText passwordField;
    private EditText retypePasswordField;
    private TextView errorMessage;
    private String firstName = "";
    private String lastName = "";
    private String emailAddress = "";
    private String password = "";
    private String retypePassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_info);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (Button) findViewById(R.id.nextButton);
        backButton = (Button) findViewById(R.id.backButton);
        firstNameField = (EditText) findViewById(R.id.firstNameField);
        lastNameField = (EditText) findViewById(R.id.lastNameField);
        emailAddressField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        retypePasswordField = (EditText) findViewById(R.id.retypePasswordField);
        errorMessage = (TextView) findViewById(R.id.errorMessage);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                firstName = firstNameField.getText().toString();
                lastName = lastNameField.getText().toString();
                emailAddress = emailAddressField.getText().toString();
                password = passwordField.getText().toString();
                retypePassword = retypePasswordField.getText().toString();

                if((!TextUtils.isEmpty(firstName))&& (!TextUtils.isEmpty(lastName)) && (!TextUtils.isEmpty(emailAddress)) && (!TextUtils.isEmpty(password)) && (!TextUtils.isEmpty(retypePassword))){
                    if(password.equals(retypePassword)){
                        Intent intent = new Intent(SetupUserInfo.this, SetupUserInfo2.class);
                        startActivity(intent);
                    }
                    else{
                        errorMessage.setText("Passwords do not match!");
                    }
                }
                else{
                    errorMessage.setText("Please fill out all fields!");
                }
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
}
