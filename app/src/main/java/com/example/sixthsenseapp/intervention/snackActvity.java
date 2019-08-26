package com.example.sixthsenseapp.intervention;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.dashboard.Dashboard;

public class snackActvity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.snack_actvity);
        ImageButton nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(snackActvity.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}
