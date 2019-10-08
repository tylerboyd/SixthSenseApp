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

public class SetupHighBloodSugar extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageButton backButton;
    private ImageButton insulinPumpButton;
    private ImageButton insulinPenButton;
    private EditText otherText;
    private static String highBloodSugarTreatment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_high_blood_sugar);

        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        insulinPumpButton = findViewById(R.id.insulinPump);
        insulinPenButton = findViewById(R.id.insulinPen);
        otherText = findViewById(R.id.other);

        nextButton.setEnabled(false);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(!otherText.getText().toString().equals("")){
                    highBloodSugarTreatment = otherText.getText().toString();
                }

                Intent intent = new Intent(SetupHighBloodSugar.this, SetupVerification.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupHighBloodSugar.this, SetupWaitTimer.class);
                startActivity(intent);
            }
        });

        insulinPumpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                highBloodSugarTreatment = "Insulin Pump";
                insulinPumpButton.setBackgroundResource(R.drawable.insulinpumpenabled);
                insulinPenButton.setBackgroundResource(R.drawable.insulinpendisabled);
                otherText.setText("");
                nextButton.setEnabled(true);
            }
        });

        insulinPenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                highBloodSugarTreatment = "Insulin Pen";
                insulinPenButton.setBackgroundResource(R.drawable.insulinpenenabled);
                insulinPumpButton.setBackgroundResource(R.drawable.insulinpumpdisabled);
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

                if(otherText.getText().toString().equals("") && highBloodSugarTreatment.equals("")){
                    nextButton.setEnabled(false);
                }
                else if(!otherText.getText().toString().equals("")){
                    nextButton.setEnabled(true);
                    insulinPenButton.setBackgroundResource(R.drawable.insulinpendisabled);
                    insulinPumpButton.setBackgroundResource(R.drawable.insulinpumpdisabled);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public static String getHighBloodSugarTreatment(){
        return highBloodSugarTreatment;
    }
}
