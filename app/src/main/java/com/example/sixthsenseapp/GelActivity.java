package com.example.sixthsenseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class GelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gel);
        ImageButton imageButton3 =findViewById(R.id.imageButton3);

        imageButton3.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GelActivity.this, InterventionActivity.class);
                startActivity(intent);
            }
        });
    }
}
