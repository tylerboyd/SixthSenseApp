package com.example.sixthsenseapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class SetupPrimaryTreatment extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button nextButton;
    private Button backButton;
    private ToggleButton glucoseTabletButton;
    private ToggleButton confectioneryButton;
    private ToggleButton sugaryDrinkButton;
    private EditText otherText;
    private String primaryTreatment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_primary_treatment);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (Button) findViewById(R.id.nextButton);
        backButton = (Button) findViewById(R.id.backButton);
        glucoseTabletButton = (ToggleButton) findViewById(R.id.glucoseTablet);
        confectioneryButton = (ToggleButton) findViewById(R.id.confectionery);
        sugaryDrinkButton = (ToggleButton) findViewById(R.id.sugaryDrink);
        otherText = (EditText) findViewById(R.id.other);

        int imageResource = getResources().getIdentifier("@drawable/primarytreatmentsetup", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Gets text from other field
                primaryTreatment = otherText.getText().toString();

                if((glucoseTabletButton.isChecked()) || (confectioneryButton.isChecked()) || (sugaryDrinkButton.isChecked()) || (!TextUtils.isEmpty(primaryTreatment)) ){
                    Intent intent = new Intent(SetupPrimaryTreatment.this, SetupSecondaryTreatment.class);
                    startActivity(intent);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupPrimaryTreatment.this, SetupBloodSugar.class);
                startActivity(intent);
            }
        });

        glucoseTabletButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    primaryTreatment = "Glucose Tablet";
                    confectioneryButton.setChecked(false);
                    sugaryDrinkButton.setChecked(false);
                }
            }
        });

        confectioneryButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    primaryTreatment = "Confectionery";
                    glucoseTabletButton.setChecked(false);
                    sugaryDrinkButton.setChecked(false);
                }
            }
        });

        sugaryDrinkButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    primaryTreatment = "Sugary Drink";
                    glucoseTabletButton.setChecked(false);
                    confectioneryButton.setChecked(false);
                }
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
