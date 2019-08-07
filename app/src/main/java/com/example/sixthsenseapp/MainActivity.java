package com.example.sixthsenseapp;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sixthsenseapp.Setup.SetupUserType;

public class MainActivity extends AppCompatActivity {

    private ImageView backgroundImage;
    private Button loginButton;
    private Button setupButton;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        loginButton = (Button) findViewById(R.id.loginButton);
        setupButton = (Button) findViewById(R.id.setupButton);

        int imageResource = getResources().getIdentifier("@drawable/startscreen", null, this.getPackageName());
        backgroundImage.setImageResource(imageResource);

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
                Intent intent = new Intent(MainActivity.this, SetupUserType.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){
        //Back Button disabled on Main screen
        Toast.makeText(getApplicationContext(), "Cannot go back, you are not logged in.", Toast.LENGTH_LONG).show();
    }
}
