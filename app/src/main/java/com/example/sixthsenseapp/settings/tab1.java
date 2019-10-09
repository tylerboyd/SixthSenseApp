package com.example.sixthsenseapp.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.dashboard.Calibrate;
import com.example.sixthsenseapp.dashboard.Dashboard;
import com.example.sixthsenseapp.dashboard.T1DToolbox;
import com.example.sixthsenseapp.intervention.UserInformation;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class tab1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton addTimeButton;
    private ImageButton subtractTimeButton;
    private Button toolboxButton;
    private Button accountButton;
    private Button promptsButton;
    private ImageView nightlightImage;
    private TextView startTime;

    private Switch switch1;
    private Switch switch2;

    private UserInformation uInfo;

    boolean stateAutoActivate;
    boolean stateNightLight;

    private int minutes = 0;
    private int hours = 18;

    private String formattedTime;

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_tab1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("SETTINGS");

        mAuth = FirebaseAuth.getInstance();

        toolboxButton = findViewById(R.id.t1dButton);
        accountButton = findViewById(R.id.editAddButton);
        promptsButton = findViewById(R.id.editPromptsButton);
        startTime = findViewById(R.id.starttime);
        addTimeButton = findViewById(R.id.buttonMinus);
        subtractTimeButton = findViewById(R.id.buttonPlus);
        switch1 = findViewById(R.id.nightlightSwitch);
        switch2 = findViewById(R.id.autoActivationSwitch);
        nightlightImage = findViewById(R.id.nightlight);

        formattedTime = String.format(Locale.getDefault(), "%02d:%02d", hours, minutes);
        startTime.setText(formattedTime);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");

        toolboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab1.this, tab3.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        });

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab1.this, tab4.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        });

        promptsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab1.this, tab2.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        });

        addTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hours != 0 && minutes == 0)
                {
                    hours--;
                }
                else if(hours == 0 && minutes == 0)
                {
                    hours = 23;
                }

                minutes = minutes - 15;

                if(minutes < 0)
                {
                    minutes = 45;
                }
                formattedTime = String.format(Locale.getDefault(), "%02d:%02d", hours, minutes);
                startTime.setText(formattedTime);
            }
        });

        subtractTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(hours != 23 && minutes == 45)
                {
                    hours++;
                }
                else if(hours == 23 && minutes == 45)
                {
                    hours = 0;
                }

                minutes = minutes + 15;

                if(minutes == 60)
                {
                    minutes = 0;
                }
                formattedTime = String.format(Locale.getDefault(), "%02d:%02d", hours, minutes);
                startTime.setText(formattedTime);
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "Turned nightlight on", Toast.LENGTH_LONG);
                    toast.show();
                    stateAutoActivate = true;
                    nightlightImage.setImageResource(R.drawable.nightlight);
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "Turned nightlight off", Toast.LENGTH_LONG);
                    toast.show();
                    stateAutoActivate = false;
                    nightlightImage.setImageResource(R.drawable.nightlightdisabled);
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "Auto activation enabled", Toast.LENGTH_LONG);
                    toast.show();
                    stateNightLight = true;

                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "Auto activation disabled", Toast.LENGTH_LONG);
                    toast.show();
                    stateNightLight = false;
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            Intent intent = new Intent(this, Dashboard.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_calibrate) {
            Intent intent = new Intent(tab1.this, Calibrate.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_toolbox) {
            Intent intent = new Intent(tab1.this, T1DToolbox.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, tab1.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_logout) {
            mAuth.getInstance().signOut();
            Toast.makeText(tab1.this, "Successfully logged out.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(tab1.this, MainActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
