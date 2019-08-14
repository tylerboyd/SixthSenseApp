package com.example.sixthsenseapp.Setup;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sixthsenseapp.R;

public class SetupWaitTimer extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private Button addTime;
    private Button subtractTime;
    private TextView waitTimeText;
    private static int waitTime = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_wait_timer);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        addTime = findViewById(R.id.addTime);
        subtractTime = findViewById(R.id.subtractTime);
        waitTimeText = findViewById(R.id.timerText);

        int imageResource = getResources().getIdentifier("@drawable/setupwaittimer", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

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