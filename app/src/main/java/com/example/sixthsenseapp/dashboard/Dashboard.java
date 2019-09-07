package com.example.sixthsenseapp.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sixthsenseapp.mainMenu.LoginActivity;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.intervention.RetestBloodActivity;
import com.example.sixthsenseapp.settings.Tabs;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    private Button logOutButton;
    private Button settingsButton;
    private Button interventionButton;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        logOutButton = findViewById(R.id.logoutButton);
        settingsButton = findViewById(R.id.buttonsetting);
        interventionButton = findViewById(R.id.interventionButton);

        mAuth = LoginActivity.getFirebaseAuth();

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.getInstance().signOut();
                Toast.makeText(Dashboard.this, "Successfully logged out.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Tabs.class);
                startActivity(intent);
            }
        });

        interventionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, RetestBloodActivity.class);
                startActivity(intent);
            }
        });




    }


}
