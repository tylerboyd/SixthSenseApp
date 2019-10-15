package com.example.sixthsenseapp.setup;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sixthsenseapp.R;

public class SetupSecondaryTreatment extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageButton backButton;
    private ImageButton glucoseTabletButton;
    private ImageButton glucoseGelButton;
    private ImageButton sugaryDrinkButton;
    private TextView otherText;
    private static String secondaryTreatment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_secondary_treatment);

        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        glucoseTabletButton = findViewById(R.id.glucoseTablet);
        glucoseGelButton = findViewById(R.id.glucoseGel);
        sugaryDrinkButton = findViewById(R.id.sugaryDrink);
        otherText = findViewById(R.id.other);

        nextButton.setEnabled(false);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!otherText.getText().toString().equals("")){
                    secondaryTreatment = otherText.getText().toString();
                }

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
                glucoseTabletButton.setBackgroundResource(R.drawable.glucosetabletblueenabled);
                glucoseGelButton.setBackgroundResource(R.drawable.glucosegeldisabled);
                sugaryDrinkButton.setBackgroundResource(R.drawable.sugarydrinkbluedisabled);
                otherText.setText("");
                nextButton.setEnabled(true);
            }
        });

        glucoseGelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryTreatment = "Glucose Gel";
                glucoseGelButton.setBackgroundResource(R.drawable.glucosegelenabled);
                glucoseTabletButton.setBackgroundResource(R.drawable.glucosetabletbluedisabled);
                sugaryDrinkButton.setBackgroundResource(R.drawable.sugarydrinkbluedisabled);
                otherText.setText("");
                nextButton.setEnabled(true);
            }
        });

        sugaryDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondaryTreatment = "Sugary Drink";
                sugaryDrinkButton.setBackgroundResource(R.drawable.sugarydrinkblueenabled);
                glucoseTabletButton.setBackgroundResource(R.drawable.glucosetabletbluedisabled);
                glucoseGelButton.setBackgroundResource(R.drawable.glucosegeldisabled);
                otherText.setText("");
                nextButton.setEnabled(true);
            }
        });

        otherText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(otherText.getText().toString().equals("") && secondaryTreatment.equals("")){
                    nextButton.setEnabled(false);
                }
                else if(!otherText.getText().toString().equals("")){
                    nextButton.setEnabled(true);
                    glucoseTabletButton.setBackgroundResource(R.drawable.glucosetabletbluedisabled);
                    sugaryDrinkButton.setBackgroundResource(R.drawable.sugarydrinkbluedisabled);
                    glucoseGelButton.setBackgroundResource(R.drawable.glucosegeldisabled);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public static String getSecondaryTreatment(){
        return secondaryTreatment;
    }
}
