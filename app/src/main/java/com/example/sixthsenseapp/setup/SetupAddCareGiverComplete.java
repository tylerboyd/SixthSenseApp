package com.example.sixthsenseapp.setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class SetupAddCareGiverComplete extends AppCompatActivity {

    private ImageButton nextButton;
    private ImageButton addCaregiverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_add_care_giver_complete);


        nextButton = findViewById(R.id.nextButton);
        addCaregiverButton = findViewById(R.id.addCaregiverButton);



        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(SetupAddCareGiverComplete.this, SetupBloodSugar.class);
                startActivity(intent);
            }
        });

        addCaregiverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupAddCareGiverComplete.this, SetupAddCaregiver.class);
                startActivity(intent);
            }
        });
    }
}
