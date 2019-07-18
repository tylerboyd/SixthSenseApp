package com.example.sixthsenseapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RetestBloodActivity extends AppCompatActivity {
    private static SeekBar seekbar;
    EditText editText;
    ImageButton tickButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retestblood_activity);

        seekbar=findViewById(R.id.seekBar2);
        editText=findViewById(R.id.editText);
        tickButton=findViewById(R.id.tickbutton);
        final ConstraintLayout constraintLayout=findViewById(R.id.Layout);

        constraintLayout.setBackgroundColor(Color.LTGRAY);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    tickButton.setEnabled(false);
                } else {
                    tickButton.setEnabled(true);

                }
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
                    constraintLayout.setBackgroundColor(Color.RED);
                }
                else if (progress<=4){
                    constraintLayout.setBackgroundColor(Color.RED);
                }
                else if  (progress>4 && progress<10)
                {
                    constraintLayout.setBackgroundColor(Color.LTGRAY);
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }





}

