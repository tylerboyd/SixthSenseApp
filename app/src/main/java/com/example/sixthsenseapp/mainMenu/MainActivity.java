package com.example.sixthsenseapp.mainMenu;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.setup.SetupUserType;

public class MainActivity extends AppCompatActivity {

    private ImageButton loginButton;
    private ImageButton setupButton;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        setupButton = findViewById(R.id.setupButton);

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
        //Back Button disabled on Main screen to prevent illegal account access
        Toast.makeText(getApplicationContext(), "Cannot go back, you are not logged in.", Toast.LENGTH_LONG).show();
    }
}
