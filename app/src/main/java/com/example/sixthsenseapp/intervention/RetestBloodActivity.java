package com.example.sixthsenseapp.intervention;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;

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
        ;
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
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                //if Blood sugar is out of range, send to primary treatment
                Intent intent = new Intent(RetestBloodActivity.this, PrimaryTreatment.class);
                startActivity(intent);
            }
        });
    }
}

