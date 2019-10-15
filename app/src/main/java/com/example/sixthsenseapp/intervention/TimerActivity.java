package com.example.sixthsenseapp.intervention;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Vibrator;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {

    private TextView timerText;
    private CountDownTimer demo;
    private ImageButton nextButton;
    private long minutesLeft;
    private long secondsLeft;
    private int timeLength;
    private int duration;
    private String originClass;
    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        timerText = findViewById(R.id.timerText);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setEnabled(false);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");
        originClass = (String)i.getSerializableExtra("originClass");
        timeLength = uInfo.getInterventionWaitTime();

        startTimer();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimerActivity.this, RetestBloodActivity.class);
                intent.putExtra("originClass", originClass);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        });
    }

    private void startTimer(){

        //change back to 60000 for 1 minute of partial time for calculation
        duration = timeLength * 60000;

        //Set to 1 second for testing interventions
        //duration = 1000;

        demo = new CountDownTimer(duration, 1000) {

            public void onTick(long millisUntilFinished) {
                minutesLeft = (millisUntilFinished / (60 * 1000) % 60);
                secondsLeft = (millisUntilFinished / 1000 % 60);

                String remainingTimeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutesLeft, secondsLeft);

                timerText.setText(remainingTimeFormatted);
            }

            public void onFinish() {

                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v.vibrate(500);
                }

                nextButton.setEnabled(true);
            }
        }.start();
    }
}


