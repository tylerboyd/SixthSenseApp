package com.example.sixthsenseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SetupActivity extends AppCompatActivity {

    private ImageView backgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        backgroundImage = findViewById(R.id.backgroundImage);

        int imageResource = getResources().getIdentifier("@drawable/usertype", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);
    }
}
