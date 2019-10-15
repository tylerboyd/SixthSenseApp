package com.example.sixthsenseapp.setup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.mainMenu.MainActivity;

public class SetupUserType extends AppCompatActivity {

    private ImageButton mineButton;
    private ImageButton someoneElseButton;
    private ImageButton nextButton;
    private ImageButton backButton;
    private static String userType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_type);

        mineButton = findViewById(R.id.mineButton);
        someoneElseButton = findViewById(R.id.someoneElseButton);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);

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
                mineButton.setBackgroundResource(R.drawable.mineiconenabled);
                someoneElseButton.setBackgroundResource(R.drawable.someoneelseicondisabled);
                nextButton.setEnabled(true);
            }
        });

        someoneElseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                userType = "Caregiver";
                someoneElseButton.setBackgroundResource(R.drawable.someoneelseiconenabled);
                mineButton.setBackgroundResource(R.drawable.mineicondisabled);
                nextButton.setEnabled(true);
            }
        });
    }

    public static String getUserType(){
        return userType;
    }
}
