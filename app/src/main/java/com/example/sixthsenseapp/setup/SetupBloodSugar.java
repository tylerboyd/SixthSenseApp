package com.example.sixthsenseapp.setup;

import android.content.Intent;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixthsenseapp.R;

import java.text.DecimalFormat;

public class SetupBloodSugar extends AppCompatActivity {

    private ImageButton addUpperLimit;
    private ImageButton subtractUpperLimit;
    private ImageButton addLowerLimit;
    private ImageButton subtractLowerLimit;
    private ImageButton nextButton;
    private ImageButton backButton;
    private TextView upperLimitText;
    private TextView lowerLimitText;
    private TextView errorMessage;
    private static float upperLimit = 5.0f;
    private static float lowerLimit = 5.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_blood_sugar);

        addUpperLimit = findViewById(R.id.addUpperLimit);
        subtractUpperLimit = findViewById(R.id.subtractUpperLimit);
        addLowerLimit = findViewById(R.id.addLowerLimit);
        subtractLowerLimit = findViewById(R.id.subtractLowerLimit);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        upperLimitText = findViewById(R.id.upperLimit);
        lowerLimitText = findViewById(R.id.lowerLimit);
        errorMessage = findViewById(R.id.errorMessage);

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
                    Intent intent = new Intent(SetupBloodSugar.this, SetupAddCaregiver.class);
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

    private float roundFloat(float d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.#");
        return Float.valueOf(twoDForm.format(d));
    }

    public static float getUpperLimit() {
        return upperLimit;
    }

    public static float getLowerLimit() {
        return lowerLimit;
    }
}
