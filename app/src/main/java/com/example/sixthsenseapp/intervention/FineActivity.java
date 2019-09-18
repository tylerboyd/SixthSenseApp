package com.example.sixthsenseapp.intervention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.dashboard.Dashboard;

public class FineActivity extends AppCompatActivity {

    private ImageButton nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FineActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}
