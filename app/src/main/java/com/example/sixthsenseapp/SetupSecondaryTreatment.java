package com.example.sixthsenseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SetupSecondaryTreatment extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button nextButton;
    private Button backButton;
    private Button glucoseTabletButton;
    private Button glucoseGelButton;
    private Button sugaryDrinkButton;
    private TextView otherText;
    private String secondaryTreatment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_secondary_treatment);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        glucoseTabletButton = findViewById(R.id.glucoseTablet);
        glucoseGelButton = findViewById(R.id.glucoseGel);
        sugaryDrinkButton = findViewById(R.id.sugaryDrink);
        otherText = findViewById(R.id.other);

        int imageResource = getResources().getIdentifier("@drawable/secondarytreatmentsetup", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Gets text from other field
                secondaryTreatment = otherText.getText().toString();

                Intent intent = new Intent(SetupSecondaryTreatment.this, SetupWaitTimer.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupSecondaryTreatment.this, SetupPrimaryTreatment.class);
                startActivity(intent);
            }
        });

        glucoseTabletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryTreatment = "Glucose Tablet";
            }
        });

        glucoseGelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryTreatment = "Glucose Gel";
            }
        });

        sugaryDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryTreatment = "Sugary Drink";
            }
        });

        otherText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryTreatment = "";
            }
        });
    }
}
