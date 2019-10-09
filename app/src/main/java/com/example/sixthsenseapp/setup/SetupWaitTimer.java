package com.example.sixthsenseapp.setup;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sixthsenseapp.R;

public class SetupWaitTimer extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageButton backButton;
    private ImageButton addTime;
    private ImageButton subtractTime;
    private TextView waitTimeText;
    private static int waitTime = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_wait_timer);

        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        addTime = findViewById(R.id.addTime);
        subtractTime = findViewById(R.id.subtractTime);
        waitTimeText = findViewById(R.id.timerText);

        waitTimeText.setText(""+waitTime);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupWaitTimer.this, SetupHighBloodSugar.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupWaitTimer.this, SetupSecondaryTreatment.class);
                startActivity(intent);
            }
        });

        addTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                waitTime++;
                waitTimeText.setText(""+waitTime);
            }
        });

        subtractTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(waitTime > 0){
                    waitTime--;
                    waitTimeText.setText(""+waitTime);
                }
            }
        });
    }

    public static int getWaitTime(){
        return waitTime;
    }
}
