package com.example.sixthsenseapp.intervention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class SecondaryTreatment extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageView treatmentType;
    private String secondaryTreatmentMethod;

    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_treatment);

        nextButton = findViewById(R.id.nextButton);
        treatmentType = findViewById(R.id.treatmentType);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");
        Log.w("hi", "ji");
        secondaryTreatmentMethod = uInfo.getSecondaryTreatmentMethod();

        if(secondaryTreatmentMethod.equals("Sugary Drink")){
            //TODO: Sugary Drink Asset
        }
        else if(secondaryTreatmentMethod.equals("Glucose Tablet")){

            int imageResource = getResources().getIdentifier("@drawable/glucosetabletred", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else if(secondaryTreatmentMethod.equals("Glucose Gel")){
            int imageResource = getResources().getIdentifier("@drawable/glucosegelred", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else{
            //TODO: Other Asset
        }

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent =  new Intent(SecondaryTreatment.this, TimerActivity.class);
                intent.putExtra("userInformation", uInfo);
                intent.putExtra("originClass", "SecondaryTreatment");
                startActivity(intent);
            }
        });
    }
}
