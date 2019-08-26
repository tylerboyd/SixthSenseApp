package com.example.sixthsenseapp.setup;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class SetupPrimaryTreatment extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private ImageButton glucoseTabletButton;
    private ImageButton confectioneryButton;
    private ImageButton sugaryDrinkButton;
    private EditText otherText;
    private static String primaryTreatment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_primary_treatment);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        glucoseTabletButton = findViewById(R.id.glucoseTablet);
        confectioneryButton = findViewById(R.id.confectionery);
        sugaryDrinkButton = findViewById(R.id.sugaryDrink);
        otherText = findViewById(R.id.other);

        int imageResource = getResources().getIdentifier("@drawable/primarytreatmentsetup", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setEnabled(false);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(!otherText.getText().toString().equals("")){
                    primaryTreatment = otherText.getText().toString();
                }
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


        glucoseTabletButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                primaryTreatment = "Glucose Tablet";
                glucoseTabletButton.setBackgroundResource(R.drawable.glucosetabletyellowenabled);
                confectioneryButton.setBackgroundResource(R.drawable.confectionerydisabled);
                sugaryDrinkButton.setBackgroundResource(R.drawable.sugarydrinkyellowdisabled);
                otherText.setText("");
                nextButton.setEnabled(true);
            }
        });

        confectioneryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                primaryTreatment = "Confectionery";
                confectioneryButton.setBackgroundResource(R.drawable.confectioneryenabled);
                glucoseTabletButton.setBackgroundResource(R.drawable.glucosetabletyellowdisabled);
                sugaryDrinkButton.setBackgroundResource(R.drawable.sugarydrinkyellowdisabled);
                otherText.setText("");
                nextButton.setEnabled(true);
            }
        });

        sugaryDrinkButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                primaryTreatment = "Sugary Drink";
                sugaryDrinkButton.setBackgroundResource(R.drawable.sugarydrinkyellowenabled);
                glucoseTabletButton.setBackgroundResource(R.drawable.glucosetabletyellowdisabled);
                confectioneryButton.setBackgroundResource(R.drawable.confectionerydisabled);
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


                if(otherText.getText().toString().equals("") && primaryTreatment.equals("")){
                    nextButton.setEnabled(false);
                }
                else if(!otherText.getText().toString().equals("")){
                    nextButton.setEnabled(true);
                    glucoseTabletButton.setBackgroundResource(R.drawable.glucosetabletyellowdisabled);
                    sugaryDrinkButton.setBackgroundResource(R.drawable.sugarydrinkyellowdisabled);
                    confectioneryButton.setBackgroundResource(R.drawable.confectionerydisabled);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public static String getPrimaryTreatment(){
        return primaryTreatment;
    }
}
