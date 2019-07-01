package com.example.sixthsenseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class SetupBloodSugar extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button addUpperLimit;
    private Button subtractUpperLimit;
    private Button addLowerLimit;
    private Button subtractLowerLimit;
    private Button nextButton;
    private Button backButton;
    private TextView upperLimitText;
    private TextView lowerLimitText;
    private TextView errorMessage;
    private float upperLimit = 5.0f;
    private float lowerLimit = 5.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_blood_sugar);

        backgroundImage = findViewById(R.id.backgroundImage);
        addUpperLimit = findViewById(R.id.addUpperLimit);
        subtractUpperLimit = findViewById(R.id.subtractUpperLimit);
        addLowerLimit = findViewById(R.id.addLowerLimit);
        subtractLowerLimit = findViewById(R.id.subtractLowerLimit);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        upperLimitText = findViewById(R.id.upperLimit);
        lowerLimitText = findViewById(R.id.lowerLimit);
        errorMessage = findViewById(R.id.errorMessage);

        int imageResource = getResources().getIdentifier("@drawable/bloodsugarsetup", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        upperLimitText.setText(""+upperLimit);
        lowerLimitText.setText(""+lowerLimit);
        errorMessage.setText("");

        addUpperLimit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                upperLimit += 0.1f;
                upperLimit = roundFloat(upperLimit);
                upperLimitText.setText(""+upperLimit);
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
            }
        });

        addLowerLimit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lowerLimit += 0.1f;
                lowerLimit = roundFloat(lowerLimit);
                lowerLimitText.setText(""+lowerLimit);
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
                Intent intent = new Intent(SetupBloodSugar.this, SetupUserType.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateData(float uLimit, float lLimit){
        boolean proceed = false;
        if(lowerLimit > upperLimit){
            errorMessage.setText("Lower limit cannot be greater than upper limit!");
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
