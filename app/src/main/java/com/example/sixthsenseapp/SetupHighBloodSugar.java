package com.example.sixthsenseapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SetupHighBloodSugar extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private static String highBloodSugarTreatment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_high_blood_sugar);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);

        int imageResource = getResources().getIdentifier("@drawable/setuphighbloodsugar", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupHighBloodSugar.this, SetupVerification.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupHighBloodSugar.this, SetupWaitTimer.class);
                startActivity(intent);
            }
        });
    }

    public static String getHighBloodSugarTreatment(){
        return highBloodSugarTreatment;
    }
}
