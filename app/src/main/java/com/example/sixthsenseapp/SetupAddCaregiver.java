package com.example.sixthsenseapp;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SetupAddCaregiver extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_add_caregiver);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupAddCaregiver.this, SetupBloodSugar.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupAddCaregiver.this, SetupBloodSugar.class);
                startActivity(intent);
            }
        });
    }
}
