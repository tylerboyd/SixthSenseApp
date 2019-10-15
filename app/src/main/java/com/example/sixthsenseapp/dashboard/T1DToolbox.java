package com.example.sixthsenseapp.dashboard;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.intervention.UserInformation;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.example.sixthsenseapp.settings.tab1;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.text.DecimalFormat;

public class T1DToolbox extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView highLimitTextView;
    private TextView lowLimitTextView;

    private ImageButton addButton;
    private ImageButton feedbackButton;
    private ImageButton insulinCalcButton;
    private ImageButton prescriptionsButton;
    private ImageButton libraryButton;
    private ImageButton achievementsButton;
    private ImageButton careCircleButton;

    private float highLimit;
    private float lowLimit;

    private String highLimitText;
    private String lowLimitText;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private FirebaseAuth mAuth;

    private UserInformation uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_t1dtoolbox);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        highLimitTextView = findViewById(R.id.highLimitText);
        lowLimitTextView = findViewById(R.id.lowLimitText);
        addButton = findViewById(R.id.addButton);
        feedbackButton = findViewById(R.id.feedbackButton);
        insulinCalcButton = findViewById(R.id.insulinCalculatorButton);
        prescriptionsButton = findViewById(R.id.prescriptionsButton);
        libraryButton = findViewById(R.id.libraryButton);
        achievementsButton = findViewById(R.id.achievementsButton);
        careCircleButton = findViewById(R.id.careCircleButton);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("T1D TOOLBOX");

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");

        highLimit = uInfo.getBloodSugarHighLimit();
        lowLimit = uInfo.getBloodSugarLowLimit();

        lowLimit = roundFloat(lowLimit);
        highLimit = roundFloat(highLimit);

        lowLimitText = String.valueOf(lowLimit);
        highLimitText = String.valueOf(highLimit);

        highLimitTextView.setText(""+highLimitText);
        lowLimitTextView.setText(""+lowLimitText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(T1DToolbox.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
            }
        });

        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(T1DToolbox.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
            }
        });

        insulinCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(T1DToolbox.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
            }
        });

        prescriptionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(T1DToolbox.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
            }
        });

        libraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(T1DToolbox.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
            }
        });

        achievementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(T1DToolbox.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
            }
        });

        careCircleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(T1DToolbox.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
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

                Intent intent = new Intent(this, Calibrate.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);

        }
        else if (id == R.id.nav_toolbox) {

                Intent intent = new Intent(this, T1DToolbox.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);

        }
        else if (id == R.id.nav_settings) {

                Intent intent = new Intent(this, tab1.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);

        }
        else if (id == R.id.nav_logout) {
            mAuth.getInstance().signOut();
            Toast.makeText(this, "Successfully logged out.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private float roundFloat(float d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.#");
        return Float.valueOf(twoDForm.format(d));
    }
}
