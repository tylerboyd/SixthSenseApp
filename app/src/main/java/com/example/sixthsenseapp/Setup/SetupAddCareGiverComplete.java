package com.example.sixthsenseapp.Setup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.sixthsenseapp.R;

public class SetupAddCareGiverComplete extends AppCompatActivity {

    private ImageView backgroundImage;
    private ImageButton nextButton;
    private ImageButton backButton;
    private Button addCaregiverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_add_care_giver_complete);

        backgroundImage = findViewById(R.id.backgroundImage);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        addCaregiverButton = findViewById(R.id.addCaregiverButton);

        int imageResource = getResources().getIdentifier("@drawable/setupaddcaregivercomplete", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);


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
