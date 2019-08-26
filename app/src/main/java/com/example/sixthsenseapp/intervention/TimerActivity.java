package com.example.sixthsenseapp.intervention;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.setup.SetupWaitTimer;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {

    static SetupWaitTimer setupWaitTimer= new SetupWaitTimer();

    //Needs to get wait time from firebase
    //private static final long START_TIME_IN_MILLS = 900000;
    private static final long START_TIME_IN_MILLS = 30000;

    private long mTimerLeftInMills = START_TIME_IN_MILLS;
    private TextView mTextViewCountDown;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis;
    private long mEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        mTextViewCountDown = findViewById(R.id.timer);
    }

    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mTextViewCountDown.setText("Finished");
                Intent intent = new Intent(TimerActivity.this, InterventionActivity.class);
                startActivity(intent);
            }
        }.start();

        mTimerRunning = true;
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        Log.d("timer", ""+mTextViewCountDown);

        mTextViewCountDown.setText(timeLeftFormatted);
    }


    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);

        editor.apply();

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("dsfs", "RESUMED");

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        mTimeLeftInMillis = prefs.getLong("millisLeft", mTimerLeftInMills);
        mTimerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
            startTimer();

            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
            }
        }
        else {
            startTimer();
        }
    }
}