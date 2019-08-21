package com.example.sixthsenseapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RetestBloodActivity extends AppCompatActivity {
    private static SeekBar seekbar;
    EditText editText;
    ImageButton tickButton;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retestblood_activity);

        seekbar=findViewById(R.id.seekBar2);
        editText=findViewById(R.id.editText);
        tickButton=findViewById(R.id.tickbutton);
        final RelativeLayout constraintLayout=findViewById(R.id.Layout);
        view=getWindow().getDecorView();
        constraintLayout.setBackgroundResource(R.color.gray);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String userinput=editText.getText().toString().trim();
                    tickButton.setEnabled(!userinput.isEmpty());
            }
            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if(!TextUtils.isEmpty(text)){
                    seekbar.setProgress(Integer.parseInt(text));
                }
            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress >= 10){
                    constraintLayout.setBackgroundResource(R.color.red);
                }
                else if (progress<=4){
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
        tickButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(RetestBloodActivity.this, InterventionActivity.class);
                startActivity(intent);
            }
        });
    }





}

