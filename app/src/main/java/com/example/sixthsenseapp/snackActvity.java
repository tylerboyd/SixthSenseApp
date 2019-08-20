package com.example.sixthsenseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class snackActvity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snack_actvity);
        ImageButton imageButton =findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(snackActvity.this, DashboadActivity.class);
                startActivity(intent);
            }
        });
    }

}
