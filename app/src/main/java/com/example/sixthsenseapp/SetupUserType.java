package com.example.sixthsenseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SetupUserType extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button mineButton;
    private Button someoneElseButton;
    private Button nextButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_user_type);

        backgroundImage = findViewById(R.id.backgroundImage);
        int imageResource = getResources().getIdentifier("@drawable/usertype", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        //mineButton = findViewById(R.id.setupButton);
        //someoneElseButton = findViewById(R.id.setupButton);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserType.this, SetupBloodSugar.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SetupUserType.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
