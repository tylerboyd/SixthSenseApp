package com.example.sixthsenseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button loginButton;
    private Button setupButton;
    private ImageView backgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);

        int imageResource = getResources().getIdentifier("@drawable/startscreen", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

        loginButton = (Button) findViewById(R.id.loginButton);
        setupButton = (Button) findViewById(R.id.setupButton);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        setupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, SetupActivity.class);
                startActivity(intent);
            }
        });

    }
}
