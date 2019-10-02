package com.example.sixthsenseapp.intervention;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RetestBloodActivity extends AppCompatActivity {

    private EditText bloodSugarField;
    private ImageButton nextButton;
    private double bloodSugarValue;
    private float bloodSugarUpperLimit;
    private float bloodSugarLowerLimit;
    private boolean proceed = false;
    private UserInformation uInfo;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private DatabaseReference ref;
    private String userID;
    private String originClass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_test);

        bloodSugarField = findViewById(R.id.bloodSugarField);
        nextButton = findViewById(R.id.nextButton);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        Intent i = getIntent();
        originClass = (String)i.getSerializableExtra("originClass");
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");

        nextButton.setEnabled(false);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    readData(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        bloodSugarField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String userinput = bloodSugarField.getText().toString().trim();

                    if(!bloodSugarField.getText().toString().isEmpty()){

                        bloodSugarValue = Double.parseDouble(userinput);
                        nextButton.setEnabled(true);
                    }
                    else if(bloodSugarField.getText().toString().isEmpty()) {
                        nextButton.setEnabled(false);
                    }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                bloodSugarUpperLimit = uInfo.getBloodSugarHighLimit();
                bloodSugarLowerLimit = uInfo.getBloodSugarLowLimit();
                if(proceed == true){
                    if(originClass == null)
                    {
                        if(bloodSugarValue > bloodSugarUpperLimit){
                            Intent intent = new Intent(RetestBloodActivity.this, HighBloodSugar.class);
                            intent.putExtra("userInformation", uInfo);
                            startActivity(intent);
                        }
                        else if(bloodSugarValue <= bloodSugarLowerLimit){
                            Intent intent = new Intent(RetestBloodActivity.this, PrimaryTreatment.class);
                            intent.putExtra("userInformation", uInfo);
                            startActivity(intent);
                        }
                        else{
                            Intent intent = new Intent(RetestBloodActivity.this, FineActivity.class);
                            startActivity(intent);
                        }
                    }
                    else {
                        Intent intent = new Intent(RetestBloodActivity.this, InterventionActivity.class);
                        intent.putExtra("originClass", originClass);
                        intent.putExtra("userInformation", uInfo);
                        startActivity(intent);
                    }
                }
            }
        });
    }


    @Override
    public void onResume(){
        super.onResume();
        nextButton.setEnabled(false);

    }

    private void readData(DataSnapshot dataSnapshot){
        for(DataSnapshot ds : dataSnapshot.getChildren()){

            uInfo = new UserInformation();
            uInfo.setBloodSugarHighLimit(ds.child(userID).child("patient").getValue(UserInformation.class).getBloodSugarHighLimit());
            uInfo.setBloodSugarLowLimit(ds.child(userID).child("patient").getValue(UserInformation.class).getBloodSugarLowLimit());
            uInfo.setPrimaryTreatmentMethod(ds.child(userID).child("patient").getValue(UserInformation.class).getPrimaryTreatmentMethod());
            uInfo.setSecondaryTreatmentMethod(ds.child(userID).child("patient").getValue(UserInformation.class).getSecondaryTreatmentMethod());
            uInfo.setHighBloodSugarTreatment(ds.child(userID).child("patient").getValue(UserInformation.class).getHighBloodSugarTreatment());
            uInfo.setEmergencyContactName(ds.child(userID).child("patient").getValue(UserInformation.class).getEmergencyContactName());
            uInfo.setEmergencyContactNumber(ds.child(userID).child("patient").getValue(UserInformation.class).getEmergencyContactNumber());
            uInfo.setInterventionWaitTime(ds.child(userID).child("patient").getValue(UserInformation.class).getInterventionWaitTime());

            proceed = true;
        }
    }
}

