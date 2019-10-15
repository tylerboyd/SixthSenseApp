package com.example.sixthsenseapp.intervention;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;

public class InterventionActivity extends AppCompatActivity {

    private ImageButton thumbsUpButton;
    private ImageButton thumbsDownButton;
    private UserInformation uInfo;
    private String originClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention);

        thumbsUpButton = findViewById(R.id.thumbsUpButton);
        thumbsDownButton = findViewById(R.id.thumbsDownButton);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");
        originClass = (String)i.getSerializableExtra("originClass");

        thumbsUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent =  new Intent(InterventionActivity.this, SnackReminderActivity.class);
                startActivity(intent);
            }
        });

        thumbsDownButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(originClass.equals("PrimaryTreatment")){
                    Intent intent =  new Intent(InterventionActivity.this, SecondaryTreatment.class);
                    intent.putExtra("userInformation", uInfo);
                    startActivity(intent);
                }
                else if(originClass.equals("SecondaryTreatment")){
                    Intent intent =  new Intent(InterventionActivity.this, EmergencyActivity.class);
                    intent.putExtra("userInformation", uInfo);
                    startActivity(intent);
                }
                else if(originClass.equals("HighBloodSugar")){
                    Intent intent =  new Intent(InterventionActivity.this, CalculatedTreatment.class);
                    intent.putExtra("userInformation", uInfo);
                    intent.putExtra("originClass", originClass);
                    startActivity(intent);
                }
                else if(originClass.equals("CalculatedTreatment1")){
                    Intent intent =  new Intent(InterventionActivity.this, CalculatedTreatment.class);
                    intent.putExtra("userInformation", uInfo);
                    intent.putExtra("originClass", originClass);
                    startActivity(intent);
                }
                else if(originClass.equals("CalculatedTreatment2")){
                    Intent intent =  new Intent(InterventionActivity.this, EmergencyActivity.class);
                    intent.putExtra("userInformation", uInfo);
                    startActivity(intent);
                }
            }
        });
    }
}
