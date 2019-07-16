package com.example.sixthsenseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetupVerification extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private DatabaseReference refPatient;
    private DatabaseReference refCaregiver;
    private Patient patient;
    private Caregiver caregiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_verification);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        patient = new Patient();
        caregiver = new Caregiver();

        refPatient = FirebaseDatabase.getInstance().getReference().child("patient");
        refCaregiver = FirebaseDatabase.getInstance().getReference().child("caregiver");

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                patient.setFirstName(SetupUserInfo.getFirstName());
                patient.setLastName(SetupUserInfo.getLastName());
                patient.setEmailAddress(SetupUserInfo.getEmailAddress());
                patient.setPassword(SetupUserInfo.getPassword());
                patient.setPhoneNumber(SetupUserInfo.getPhoneNumber());
                patient.setDateOfBirth(SetupUserInfo2.getDateOfBirth());
                patient.setGpName(SetupUserInfo2.getGpName());
                patient.setGpNumber(SetupUserInfo2.getGpNumber());
                patient.setEmergencyContactName(SetupUserInfo2.getEmergencyName());
                patient.setEmergencyContactNumber(SetupUserInfo2.getEmergencyNumber());
                patient.setPrimaryTreatmentMethod(SetupPrimaryTreatment.getPrimaryTreatment());
                patient.setSecondaryTreatmentMethod(SetupSecondaryTreatment.getSecondaryTreatment());
                patient.setHighBloodSugarTreatment(SetupHighBloodSugar.getHighBloodSugarTreatment());
                patient.setBloodSugarHighLimit(SetupBloodSugar.getUpperLimit());
                patient.setBloodSugarLowLimit(SetupBloodSugar.getLowerLimit());
                patient.setInterventionWaitTime(SetupWaitTimer.getWaitTime());
                //Set Patient ID TEMP Usage
                patient.setPatID();

                caregiver.setFirstName(SetupCaregiverInfo.getFirstName());
                caregiver.setLastName(SetupCaregiverInfo.getLastName());
                caregiver.setEmail(SetupCaregiverInfo.getEmailAddress());
                caregiver.setPassword(SetupCaregiverInfo.getPassword());
                caregiver.setPhoneNumber(SetupCaregiverInfo.getPhoneNumber());

                if(SetupUserType.getUserType().equals("User")){
                    refPatient.push().setValue(patient);
                }
                else if(SetupUserType.getUserType().equals("Caregiver")){
                    refPatient.push().setValue(patient);
                    refCaregiver.push().setValue(caregiver);
                }

                Toast.makeText(SetupVerification.this, "User account created succcessfully!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(SetupVerification.this, SetupComplete.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupVerification.this, SetupHighBloodSugar.class);
                startActivity(intent);
            }
        });
    }
}
