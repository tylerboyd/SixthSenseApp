package com.example.sixthsenseapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SetupUserType extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton mineButton;
    private ImageButton someoneElseButton;
    private ImageButton nextButton;
    private ImageButton backButton;
    private static String userType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_type);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        mineButton = (ImageButton) findViewById(R.id.mineButton);
        someoneElseButton = (ImageButton) findViewById(R.id.someoneElseButton);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);

        int imageResource = getResources().getIdentifier("@drawable/usertype", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setEnabled(false);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!userType.equals("")){
                    Intent intent = new Intent(SetupUserType.this, SetupUserInfo.class);
                    startActivity(intent);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserType.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                userType = "User";

                nextButton.setEnabled(true);
            }
        });

        someoneElseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                userType = "Caregiver";

                nextButton.setEnabled(true);
            }
        });
    }

    public static String getUserType(){
        return userType;
    }
}
