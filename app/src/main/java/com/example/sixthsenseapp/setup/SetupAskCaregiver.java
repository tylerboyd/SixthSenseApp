package com.example.sixthsenseapp.setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.sixthsenseapp.R;

public class SetupAskCaregiver extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageButton backButton;
    private ImageButton noJustMeButton;
    private ImageButton addCaregiverButton;

    private boolean addCaregiver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_ask_caregiver);

        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        noJustMeButton = findViewById(R.id.noJustMeButton);
        addCaregiverButton = findViewById(R.id.addCaregiverButton);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(addCaregiver == true){
                    Intent intent = new Intent(SetupAskCaregiver.this, SetupAddCaregiver.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(SetupAskCaregiver.this, SetupBloodSugar.class);
                    startActivity(intent);
                }

            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupAskCaregiver.this, SetupAddEmergencyContact.class);
                startActivity(intent);
            }
        });

        addCaregiverButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addCaregiver = true;
                addCaregiverButton.setBackgroundResource(R.drawable.setup_add_caregiver_button_enabled);
                noJustMeButton.setBackgroundResource(R.drawable.setup_no_just_me_button_disabled);
            }
        });

        noJustMeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addCaregiver = false;
                noJustMeButton.setBackgroundResource(R.drawable.setup_no_just_me_button_enabled);
                addCaregiverButton.setBackgroundResource(R.drawable.setup_add_caregiver_button_disabled);
            }
        });

    }
}
