package com.example.sixthsenseapp.intervention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class HighBloodSugar extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageView treatmentType;
    private String highBloodSugarTreatmentMethod;

    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_blood_sugar);

        nextButton = findViewById(R.id.nextButton);
        treatmentType = findViewById(R.id.treatmentType);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");
        highBloodSugarTreatmentMethod = uInfo.getHighBloodSugarTreatment();

        if(highBloodSugarTreatmentMethod.equals("Insulin Pump")){
            //TODO: InsuLin Pump Asset
            int imageResource = getResources().getIdentifier("@drawable/redinsulinpen", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else if(highBloodSugarTreatmentMethod.equals("Insulin Pen")){
            int imageResource = getResources().getIdentifier("@drawable/redinsulinpen", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else{
            //TODO: OTHER TREATMENT
        }

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent =  new Intent(HighBloodSugar.this, TimerActivity.class);
                intent.putExtra("userInformation", uInfo);
                intent.putExtra("originClass", "HighBloodSugar");
                startActivity(intent);
            }
        });
    }
}
