package com.example.sixthsenseapp;

import android.content.Intent;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SetupBloodSugar extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button addUpperLimit;
    private Button subtractUpperLimit;
    private Button addLowerLimit;
    private Button subtractLowerLimit;
    private ImageButton nextButton;
    private ImageButton backButton;
    private TextView upperLimitText;
    private TextView lowerLimitText;
    private TextView errorMessage;
    private float upperLimit = 5.0f;
    private float lowerLimit = 5.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_blood_sugar);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        addUpperLimit = (Button) findViewById(R.id.addUpperLimit);
        subtractUpperLimit = (Button) findViewById(R.id.subtractUpperLimit);
        addLowerLimit = (Button) findViewById(R.id.addLowerLimit);
        subtractLowerLimit = (Button) findViewById(R.id.subtractLowerLimit);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);
        upperLimitText = (TextView) findViewById(R.id.upperLimit);
        lowerLimitText = (TextView) findViewById(R.id.lowerLimit);
        errorMessage = (TextView) findViewById(R.id.errorMessage);

        int imageResource = getResources().getIdentifier("@drawable/bloodsugarsetup", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setEnabled(false);

        upperLimitText.setText(""+upperLimit);
        lowerLimitText.setText(""+lowerLimit);

        addUpperLimit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                upperLimit += 0.1f;
                upperLimit = roundFloat(upperLimit);
                upperLimitText.setText(""+upperLimit);
                nextButton.setEnabled(true);
            }
        });

        subtractUpperLimit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                upperLimit -= 0.1f;
                upperLimit = roundFloat(upperLimit);
                if(upperLimit < 0.1){
                    upperLimit = 0.1f;
                }
                upperLimitText.setText(""+upperLimit);
                nextButton.setEnabled(true);
            }
        });

        addLowerLimit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lowerLimit += 0.1f;
                lowerLimit = roundFloat(lowerLimit);
                lowerLimitText.setText(""+lowerLimit);
                nextButton.setEnabled(true);
            }
        });

        subtractLowerLimit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lowerLimit -= 0.1f;
                lowerLimit = roundFloat(lowerLimit);
                if(lowerLimit < 0.1){
                    lowerLimit = 0.1f;
                }
                lowerLimitText.setText(""+lowerLimit);
                nextButton.setEnabled(true);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                boolean proceed = validateData(upperLimit, lowerLimit);
                if(proceed){
                    Intent intent = new Intent(SetupBloodSugar.this, SetupPrimaryTreatment.class);
                    startActivity(intent);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(SetupUserType.getUserType().equals("User")){
                    Intent intent = new Intent(SetupBloodSugar.this, SetupUserInfo2.class);
                    startActivity(intent);
                }
                else if(SetupUserType.getUserType().equals("Caregiver")){
                    Intent intent = new Intent(SetupBloodSugar.this, SetupCaregiverInfo.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateData(float uLimit, float lLimit){
        boolean proceed = false;
        if(lowerLimit >= upperLimit){
            errorMessage.setTextColor(Color.RED);
            errorMessage.setText("Lower limit cannot be greater or the same as upper limit.");
        }
        else{
            errorMessage.setText("");
            proceed = true;
        }
        return proceed;
    }

    public float roundFloat(float d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.#");
        return Float.valueOf(twoDForm.format(d));
    }
}
