package com.example.sixthsenseapp.Setup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sixthsenseapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetupVerification extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private DatabaseReference refUsers;
    private DatabaseReference refUID;
    private DatabaseReference refPatient;
    private DatabaseReference refCaregiver;
    private FirebaseAuth mAuth;
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

        mAuth = FirebaseAuth.getInstance();
        refUsers = FirebaseDatabase.getInstance().getReference().child("users");

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //Gets data from each setup form
                setData();

                mAuth.createUserWithEmailAndPassword(patient.getEmailAddress(), patient.getPassword())
                        .addOnCompleteListener(SetupVerification.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SetupVerification.this, "Account created succcessfully!", Toast.LENGTH_LONG).show();

                                    if(SetupUserType.getUserType().equals("User")){
                                        String UID = mAuth.getCurrentUser().getUid();
                                        refUsers.child(UID).child("patient").setValue(patient);
                                    }
                                    else if(SetupUserType.getUserType().equals("Caregiver")){
                                        String UID = mAuth.getCurrentUser().getUid();
                                        refUsers.child(UID).child("patient").setValue(patient);
                                        refUsers.child(UID).child("caregiver").setValue(caregiver);
                                    }

                                    Intent intent = new Intent(SetupVerification.this, SetupComplete.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(SetupVerification.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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

    private void setData(){
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

        caregiver.setFirstName(SetupCaregiverInfo.getFirstName());
        caregiver.setLastName(SetupCaregiverInfo.getLastName());
        caregiver.setEmail(SetupCaregiverInfo.getEmailAddress());
        caregiver.setPassword(SetupCaregiverInfo.getPassword());
        caregiver.setPhoneNumber(SetupCaregiverInfo.getPhoneNumber());
    }
}
