package com.example.sixthsenseapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {
    static SetupWaitTimer setupWaitTimer= new SetupWaitTimer();
    private static final long START_TIME_IN_MILLS= setupWaitTimer.waitTime;

    private long mTimerLeftInMills=START_TIME_IN_MILLS;
    private TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
         timer =findViewById(R.id.timer);
        new CountDownTimer(setupWaitTimer.waitTime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimerLeftInMills=millisUntilFinished;
               updateCountDownText();
            }
            @Override
            public void onFinish() {
                timer.setText("Finished");
                Intent intent = new Intent(TimerActivity.this, RetestBloodActivity.class);
                startActivity(intent);
            }
        }.start();
    }
    private void  updateCountDownText(){
        int minutes=(int)(mTimerLeftInMills)/1000/60;
        int seconds=(int)(mTimerLeftInMills)/1000%60;

        String timeLeftFormatted =String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timer.setText(timeLeftFormatted);
    }
    }

