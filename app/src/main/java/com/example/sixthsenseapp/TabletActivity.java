package com.example.sixthsenseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TabletActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet);
        ImageButton imageButton2 =findViewById(R.id.imageButton2);

        imageButton2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabletActivity.this, InterventionActivity.class);
                startActivity(intent);
            }
        });
    }
}
