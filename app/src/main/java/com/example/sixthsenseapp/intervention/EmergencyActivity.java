package com.example.sixthsenseapp.intervention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.dashboard.Dashboard;

public class EmergencyActivity extends AppCompatActivity {

    private ImageButton nextButton;
    private TextView emergencyContactNameField;
    private TextView emergencyContactNumberField;

    private String emergencyContactName;
    private String emergencyContactNumber;

    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        nextButton = findViewById(R.id.nextButton);
        emergencyContactNameField = findViewById(R.id.emergencyContactName);
        emergencyContactNumberField = findViewById(R.id.emergencyContactNumber);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");

        emergencyContactName = uInfo.getEmergencyContactName();
        emergencyContactNumber = uInfo.getEmergencyContactNumber();

        emergencyContactNameField.setText("Emergency Contact: " + emergencyContactName);
        emergencyContactNumberField.setText("Contact Number: " + emergencyContactNumber);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent =  new Intent(EmergencyActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });



    }
}
