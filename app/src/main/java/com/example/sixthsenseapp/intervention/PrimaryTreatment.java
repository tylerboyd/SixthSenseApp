package com.example.sixthsenseapp.intervention;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class PrimaryTreatment extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageView treatmentType;
    private String primaryTreatmentMethod;

    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_treatment);

        nextButton = findViewById(R.id.nextButton);
        treatmentType = findViewById(R.id.treatmentType);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");
        primaryTreatmentMethod = uInfo.getPrimaryTreatmentMethod();

        if(primaryTreatmentMethod.equals("Sugary Drink")){

        }
        else if(primaryTreatmentMethod.equals("Glucose Tablet")){

            int imageResource = getResources().getIdentifier("@drawable/glucosetabletred", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else if(primaryTreatmentMethod.equals("Confectionery")){

        }
        else{
            //TODO: Display Other Treatment Asset
        }

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent =  new Intent(PrimaryTreatment.this, TimerActivity.class);
                intent.putExtra("userInformation", uInfo);
                intent.putExtra("originClass", "PrimaryTreatment");
                startActivity(intent);
            }
        });
    }
}
