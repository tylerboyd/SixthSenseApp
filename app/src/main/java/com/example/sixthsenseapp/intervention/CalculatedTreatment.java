package com.example.sixthsenseapp.intervention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.dashboard.Dashboard;

public class CalculatedTreatment extends AppCompatActivity {

    private ImageButton nextButton;
    private UserInformation uInfo;
    private String originClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_treatment);

        nextButton = findViewById(R.id.nextButton);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");
        originClass = (String)i.getSerializableExtra("originClass");

        nextButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                if(originClass.equals("HighBloodSugar")){
                    Intent intent = new Intent(CalculatedTreatment.this, TimerActivity.class);
                    intent.putExtra("userInformation", uInfo);
                    intent.putExtra("originClass", "CalculatedTreatment1");
                    startActivity(intent);
                }
                else if(originClass.equals("CalculatedTreatment1")){
                    Intent intent = new Intent(CalculatedTreatment.this, TimerActivity.class);
                    intent.putExtra("userInformation", uInfo);
                    intent.putExtra("originClass", "CalculatedTreatment2");
                    startActivity(intent);
                }

            }
        });
    }
}
