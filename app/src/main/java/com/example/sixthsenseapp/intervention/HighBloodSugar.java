package com.example.sixthsenseapp.intervention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixthsenseapp.R;

public class HighBloodSugar extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageView treatmentType;
    private ImageView otherBox;
    private TextView otherText;
    private String highBloodSugarTreatmentMethod;
    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_blood_sugar);

        nextButton = findViewById(R.id.nextButton);
        treatmentType = findViewById(R.id.treatmentType);
        otherBox = findViewById(R.id.otherBox);
        otherText = findViewById(R.id.otherText);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");
        highBloodSugarTreatmentMethod = uInfo.getHighBloodSugarTreatment();

        otherBox.setVisibility(View.INVISIBLE);

        if(highBloodSugarTreatmentMethod.equals("Insulin Pump")){
            //TODO: InsuLin Pump Asset
            int imageResource = getResources().getIdentifier("", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else if(highBloodSugarTreatmentMethod.equals("Insulin Pen")){
            int imageResource = getResources().getIdentifier("@drawable/redinsulinpen", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else{
            otherText.setText(highBloodSugarTreatmentMethod);
            otherBox.setVisibility(View.VISIBLE);
            int imageResource = getResources().getIdentifier("@drawable/redothertreatment", null, getPackageName());
            treatmentType.setImageResource(imageResource);
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
