package com.example.sixthsenseapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RetestBloodActivity extends AppCompatActivity {

    private static SeekBar seekBar;
    private EditText bloodSugarField;
    private ImageButton nextButton;
    private View view;
    private RelativeLayout constraintLayout;
    private double bloodSugarValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retestblood_activity);

        seekBar = findViewById(R.id.seekBar);
        bloodSugarField = findViewById(R.id.bloodSugarField);
        nextButton = findViewById(R.id.nextButton);
        constraintLayout = findViewById(R.id.Layout);
        view = getWindow().getDecorView();

        constraintLayout.setBackgroundResource(R.color.gray);

        nextButton.setEnabled(false);

        bloodSugarField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String userinput = bloodSugarField.getText().toString().trim();

                    bloodSugarValue = Double.parseDouble(userinput);

                    if(!bloodSugarField.getText().toString().isEmpty()){
                        nextButton.setEnabled(true);
                    }
                    else if(bloodSugarField.getText().toString().isEmpty()) {
                        nextButton.setEnabled(false);
                    }

                Log.d("gsgsf", ""+bloodSugarValue);
            }
            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if(!TextUtils.isEmpty(text)){
                    //seekBar.setProgress(Double.parseDouble(text));
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress >= 10)
                {
                    constraintLayout.setBackgroundResource(R.color.red);
                }
                else if (progress<=4)
                {
                    constraintLayout.setBackgroundResource(R.color.red);
                }
                else
                {
                    constraintLayout.setBackgroundResource(R.color.gray);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(RetestBloodActivity.this, InterventionActivity.class);
                startActivity(intent);
            }
        });
    }
}

