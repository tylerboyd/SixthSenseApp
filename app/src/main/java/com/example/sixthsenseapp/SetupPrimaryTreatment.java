package com.example.sixthsenseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SetupPrimaryTreatment extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button nextButton;
    private Button backButton;
    private Button glucoseTabletButton;
    private Button confectioneryButton;
    private Button sugaryDrinkButton;
    private TextView otherText;
    private String primaryTreatment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_primary_treatment);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (Button) findViewById(R.id.nextButton);
        backButton = (Button) findViewById(R.id.backButton);
        glucoseTabletButton = (Button) findViewById(R.id.glucoseTablet);
        confectioneryButton = (Button) findViewById(R.id.confectionery);
        sugaryDrinkButton = (Button) findViewById(R.id.sugaryDrink);
        otherText = (TextView) findViewById(R.id.other);

        int imageResource = getResources().getIdentifier("@drawable/primarytreatmentsetup", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Gets text from other field
                primaryTreatment = otherText.getText().toString();

                Intent intent = new Intent(SetupPrimaryTreatment.this, SetupSecondaryTreatment.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupPrimaryTreatment.this, SetupBloodSugar.class);
                startActivity(intent);
            }
        });

        glucoseTabletButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaryTreatment = "Glucose Tablet";
            }
        });

        confectioneryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaryTreatment = "Confectionery";
            }
        });

        sugaryDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaryTreatment = "Sugary Drink";
            }
        });

        otherText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaryTreatment = "";
            }
        });
    }
}
