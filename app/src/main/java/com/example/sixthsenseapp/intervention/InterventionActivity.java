package com.example.sixthsenseapp.intervention;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;

public class InterventionActivity extends AppCompatActivity {

    private ImageButton thumbsUpButton;
    private ImageButton thumbsDownButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention);

        thumbsUpButton = findViewById(R.id.thumbsUpButton);
        thumbsDownButton = findViewById(R.id.thumbsDownButton);

        thumbsUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent =  new Intent(InterventionActivity.this, snackActvity.class);
                startActivity(intent);
            }
        });

        thumbsDownButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent =  new Intent(InterventionActivity.this, SecondaryTreatment.class);
                startActivity(intent);
            }
        });


    }
}
