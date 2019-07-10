package com.example.sixthsenseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetupVerification extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private String patientFirstName;
    private String patientLastName;
    private String patientEmailAddress;
    private String patientPassword;
    private String phoneNumber;
    private String dateOfBirth;
    private String patientFullName;
    private String gpName;
    private String gpNumber;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String primaryTreatmentMethod;
    private String secondaryTreatmentMethod;
    private String highBloodSugarTreatment;
    private String caregiverFullName;
    private String caregiverEmail;
    private String caregiverPassword;
    private String caregiverPhoneNumber;
    private float bloodSugarHighLimit;
    private float bloodSugarLowLimit;
    private int interventionWaitTime;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_verification);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);

        int imageResource = getResources().getIdentifier("@drawable/loginbackground", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        ref = FirebaseDatabase.getInstance().getReference().child("patient");

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                patientFirstName = SetupUserInfo.getFirstName();
                patientLastName = SetupUserInfo.getLastName();
                patientEmailAddress = SetupUserInfo.getEmailAddress()
                patientPassword = SetupUserInfo.getPassword();
                phoneNumber = SetupUserInfo.getPhoneNumber();
                dateOfBirth = SetupUserInfo2.getDateOfBirth();
                patientFullName = patientFirstName + " " + patientLastName;
                gpName = SetupUserInfo2.getGpName();
                gpNumber = SetupUserInfo2.getGpNumber();
                emergencyContactName = SetupUserInfo2.getEmergencyName();
                emergencyContactNumber = SetupUserInfo2.getEmergencyNumber();
                primaryTreatmentMethod = SetupPrimaryTreatment.getPrimaryTreatement();
                secondaryTreatmentMethod = SetupSecondaryTreatment.getSecondaryTreatment();
                highBloodSugarTreatment = SetupHighBloodSugar.getHighBloodSugarTreatment();
                //caregiverFullName = SetupCaregiverInfo.get;
                //caregiverEmail;
                //caregiverPassword;
                //caregiverPhoneNumber;
                //bloodSugarHighLimit = Se;
                bloodSugarLowLimit = SetupBloodSugar;
                interventionWaitTime = SetupWaitTimer.getWaitTime();





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
