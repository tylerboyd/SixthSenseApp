package com.example.sixthsenseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class SetupUserType extends AppCompatActivity {

    private ImageView backgroundImage;
    private ToggleButton mineButton;
    private ToggleButton someoneElseButton;
    private Button nextButton;
    private Button backButton;
    private static String userType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_type);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        mineButton = (ToggleButton) findViewById(R.id.mineButton);
        someoneElseButton = (ToggleButton) findViewById(R.id.someoneElseButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        backButton = (Button) findViewById(R.id.backButton);

        int imageResource = getResources().getIdentifier("@drawable/usertype", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserType.this, SetupUserInfo.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserType.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mineButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userType = "User";
                    someoneElseButton.setChecked(false);
                }
            }
        });

        someoneElseButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    userType = "Caregiver";
                    mineButton.setChecked(false);
                }
            }
        });
    }

    public static String getUserType(){
        return userType;
    }
}
