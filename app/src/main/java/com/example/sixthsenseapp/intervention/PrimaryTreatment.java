package com.example.sixthsenseapp.intervention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixthsenseapp.R;

public class PrimaryTreatment extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageView treatmentType;
    private ImageView otherBox;
    private TextView otherText;
    private String primaryTreatmentMethod;
    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_treatment);

        nextButton = findViewById(R.id.nextButton);
        treatmentType = findViewById(R.id.treatmentType);
        otherText = findViewById(R.id.otherText);
        otherBox = findViewById(R.id.otherBox);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");
        primaryTreatmentMethod = uInfo.getPrimaryTreatmentMethod();

        otherBox.setVisibility(View.INVISIBLE);

        if(primaryTreatmentMethod.equals("Sugary Drink")){
            int imageResource = getResources().getIdentifier("@drawable/redsugarydrink", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else if(primaryTreatmentMethod.equals("Glucose Tablet")){
            int imageResource = getResources().getIdentifier("@drawable/glucosetabletred", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else if(primaryTreatmentMethod.equals("Confectionery")){
            //TODO: Confectionery asset
            int imageResource = getResources().getIdentifier("", null, getPackageName());
            treatmentType.setImageResource(imageResource);
        }
        else{
            otherText.setText(primaryTreatmentMethod);
            otherBox.setVisibility(View.VISIBLE);
            int imageResource = getResources().getIdentifier("@drawable/redothertreatment", null, getPackageName());
            treatmentType.setImageResource(imageResource);
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
