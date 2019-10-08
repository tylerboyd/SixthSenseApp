package com.example.sixthsenseapp.setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.sixthsenseapp.R;

public class SetupAddEmergencyContact extends AppCompatActivity {

    private ImageButton addContactButton;
    private ImageButton dontAddContactButton;
    private ImageButton nextButton;
    private ImageButton backButton;

    private boolean addContact = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_add_emergency_contact);

        addContactButton = findViewById(R.id.addContactButton);
        dontAddContactButton = findViewById(R.id.noJustMeButton);
        backButton = findViewById(R.id.backButton);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setEnabled(false);

        addContactButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //TODO: Add Enabled Icon
                nextButton.setEnabled(true);
                addContact = true;
            }
        });

        dontAddContactButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //TODO: Add Enabled Icon
                nextButton.setEnabled(true);
                addContact = false;
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(addContact == true){
                    Intent intent = new Intent(SetupAddEmergencyContact.this, SetupUserInfo4.class);
                    startActivity(intent);
                }
                else {
                    if(SetupUserType.getUserType().equals("User")){
                        Intent intent = new Intent(SetupAddEmergencyContact.this, SetupAskCaregiver.class);
                        startActivity(intent);
                    }
                    else if(SetupUserType.getUserType().equals("Caregiver")){
                        Intent intent = new Intent(SetupAddEmergencyContact.this, SetupAddCaregiver.class);
                        startActivity(intent);
                    }
                }

            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(SetupAddEmergencyContact.this, SetupUserInfo3.class);
                startActivity(intent);
            }
        });
    }
}
