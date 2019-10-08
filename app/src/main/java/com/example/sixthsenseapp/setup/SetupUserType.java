package com.example.sixthsenseapp.setup;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.intervention.EmergencyActivity;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.example.sixthsenseapp.R;

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

        backgroundImage = findViewById(R.id.backgroundImage);
        mineButton = findViewById(R.id.mineButton);
        someoneElseButton = findViewById(R.id.someoneElseButton);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);

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
