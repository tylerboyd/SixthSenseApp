package com.example.sixthsenseapp.setup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixthsenseapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class SetupVerification extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private CheckBox acceptTOSBox;
    private TextView termsOfService;
    private DatabaseReference refUsers;
    private FirebaseAuth mAuth;
    private Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_verification);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        termsOfService = findViewById(R.id.termsofservice);
        acceptTOSBox = findViewById(R.id.acceptbox);

        nextButton.setEnabled(false);

        InputStream inputStream = getResources().openRawResource(R.raw.termsofservice);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1)
            {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        termsOfService.setText(byteArrayOutputStream.toString());
        termsOfService.setMovementMethod(new ScrollingMovementMethod());

        acceptTOSBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    nextButton.setEnabled(true);
                }
                else{
                    nextButton.setEnabled(false);
                }
            }
        });

        int imageResource = getResources().getIdentifier("@drawable/background_no_logo", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        patient = new Patient();

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

                                        //Get User ID
                                        String UID = mAuth.getCurrentUser().getUid();

                                        //Push patient data
                                        refUsers.child(UID).child("patient").setValue(patient);

                                        if(SetupAddCaregiver.getNumberOfCaregivers() > 0){
                                            //Push each caregiver data
                                            for(int i = 0; i < SetupAddCaregiver.getNumberOfCaregivers(); i++){
                                                refUsers.child(UID).child("caregivers").child("caregiver_" + i).setValue(SetupAddCaregiver.getCareCircle().get(i));
                                            }
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
        patient.setPassword(SetupUserInfo2.getPassword());
        patient.setPhoneNumber(SetupUserInfo.getPhoneNumber());
        patient.setDateOfBirth(SetupUserInfo2.getDateOfBirth());
        patient.setGpName(SetupUserInfo3.getGpName());
        patient.setGpNumber(SetupUserInfo3.getGpNumber());
        patient.setEmergencyContactName(SetupUserInfo4.getEmergencyName());
        patient.setEmergencyContactNumber(SetupUserInfo4.getEmergencyNumber());
        patient.setPrimaryTreatmentMethod(SetupPrimaryTreatment.getPrimaryTreatment());
        patient.setSecondaryTreatmentMethod(SetupSecondaryTreatment.getSecondaryTreatment());
        patient.setHighBloodSugarTreatment(SetupHighBloodSugar.getHighBloodSugarTreatment());
        patient.setBloodSugarHighLimit(SetupBloodSugar.getUpperLimit());
        patient.setBloodSugarLowLimit(SetupBloodSugar.getLowerLimit());
        patient.setInterventionWaitTime(SetupWaitTimer.getWaitTime());
    }
}
