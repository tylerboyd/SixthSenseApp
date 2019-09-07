package com.example.sixthsenseapp.setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class SetupUserInfo3 extends AppCompatActivity {

    private ImageView backgroundImage;
    private EditText gpNameField;
    private EditText gpNumberField;
    private ImageButton nextButton;
    private ImageButton backButton;
    private static String gpName = "";
    private static String gpNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_info3);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        gpNameField = findViewById(R.id.gpNameField);
        gpNumberField = findViewById(R.id.gpNumberField);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setEnabled(false);

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

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                gpName = gpNameField.getText().toString();
                gpNumber = gpNumberField.getText().toString();

                Intent intent = new Intent(SetupUserInfo3.this, SetupUserInfo4.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserInfo3.this, SetupUserInfo2.class);
                startActivity(intent);
            }
        });
    }

    private void checkTextFields(){
        if((!gpNameField.getText().toString().isEmpty()) && (!gpNumberField.getText().toString().isEmpty())){
            nextButton.setEnabled(true);
        }
        else{
            nextButton.setEnabled(false);
        }
    }

    public static String getGpName(){
        return gpName;
    }

    public static String getGpNumber(){
        return gpNumber;
    }
}
