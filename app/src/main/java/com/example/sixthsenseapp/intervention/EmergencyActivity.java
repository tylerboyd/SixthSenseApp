package com.example.sixthsenseapp.intervention;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.dashboard.Dashboard;

public class EmergencyActivity extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageButton call111Button;
    private ImageButton callContactButton;

    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        nextButton = findViewById(R.id.okButton);
        call111Button = findViewById(R.id.call111Button);
        callContactButton = findViewById(R.id.callContactButton);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");

        nextButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view){

                Intent intent =  new Intent(EmergencyActivity.this, Dashboard.class);
                startActivity(intent);

                return true;
            }
        });

        call111Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Toast.makeText(EmergencyActivity.this, "Festure not yet Implemented.", Toast.LENGTH_LONG).show();
            }
        });

        callContactButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Toast.makeText(EmergencyActivity.this, "Festure not yet Implemented.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
