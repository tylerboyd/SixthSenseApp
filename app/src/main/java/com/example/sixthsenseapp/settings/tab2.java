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
import android.widget.ImageButton;
import android.widget.ImageView;
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

import java.text.DecimalFormat;

public class tab2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton minusButtonLow;
    private ImageButton plusButtonLow;
    private ImageButton minusButtonHigh;
    private ImageButton plusButtonHigh;
    private ImageButton waitTimerMinus;
    private ImageButton waitTimerPlus;
    private ImageButton personaliseButton;

    private Button toolboxButton;
    private Button accountButton;
    private Button monitorButton;

    private TextView lowBS;
    private TextView highBS;
    private TextView waitInterval;
    private TextView primaryTextField;
    private TextView secondaryTextField;
    private TextView highBSTextField;

    private ImageView primaryTreatmentIcon;
    private ImageView secondaryTreatmentIcon;
    private ImageView highBloodSugarIcon;

    private String textLowBS;
    private String textHighBS;
    private String primaryText;
    private String secondaryText;
    private String highBSText;

    private DrawerLayout drawer;
    private NavigationView navigationView;

    private float highEnd;
    private float lowEnd;
    private int waitTime;

    private UserInformation uInfo;

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_tab2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");

        lowBS = findViewById(R.id.lowbloodnumber);
        highBS = findViewById(R.id.highbloodnumber);
        toolboxButton = findViewById(R.id.t1dButton);
        accountButton = findViewById(R.id.editAddButton);
        monitorButton = findViewById(R.id.myMonitorButton);
        waitInterval = findViewById(R.id.waitTimeText);
        primaryTextField = findViewById(R.id.primaryText);
        secondaryTextField = findViewById(R.id.secondaryText);
        highBSTextField = findViewById(R.id.highText);
        minusButtonLow = findViewById(R.id.lowerLimitSubtract);
        plusButtonLow = findViewById(R.id.lowerLimitAdd);
        minusButtonHigh = findViewById(R.id.upperLimitSubtract);
        plusButtonHigh = findViewById(R.id.upperLimitAdd);
        waitTimerMinus = findViewById(R.id.waitingTimeSubtract);
        waitTimerPlus = findViewById(R.id.waitingTimeAdd);
        personaliseButton = findViewById(R.id.personaliseButton);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        primaryTreatmentIcon = findViewById(R.id.primaryTreatmentIcon);
        secondaryTreatmentIcon = findViewById(R.id.secondaryTreatmentIcon);
        highBloodSugarIcon = findViewById(R.id.highBloodSugarTreatmentIcon);

        mAuth = FirebaseAuth.getInstance();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("SETTINGS");

        lowEnd = uInfo.getBloodSugarLowLimit();
        highEnd = uInfo.getBloodSugarHighLimit();
        waitTime = uInfo.getInterventionWaitTime();
        primaryText = uInfo.getPrimaryTreatmentMethod();
        secondaryText = uInfo.getSecondaryTreatmentMethod();
        highBSText = uInfo.getHighBloodSugarTreatment();

        textLowBS = String.valueOf(lowEnd);
        textHighBS = String.valueOf(highEnd);

        lowBS.setText(textLowBS);
        highBS.setText(textHighBS);
        waitInterval.setText(""+ waitTime);
        primaryTextField.setText(primaryText);
        secondaryTextField.setText(secondaryText);
        highBSTextField.setText(highBSText);

        if(primaryText.equals("Glucose Tablet")){
            primaryTreatmentIcon.setImageResource(R.drawable.settings_glucose_tablet_icon);
        }
        else if(primaryText.equals("Confectionery")){
            primaryTreatmentIcon.setImageResource(R.drawable.settings_confectionery_icon);
        }
        else if(primaryText.equals("Sugary Drink")){
            primaryTreatmentIcon.setImageResource(R.drawable.settings_sugary_drink_icon);
        }
        else {
            primaryTreatmentIcon.setImageResource(R.drawable.settings_other_icon);
        }

        if(secondaryText.equals("Glucose Tablet")){
            secondaryTreatmentIcon.setImageResource(R.drawable.settings_glucose_tablet_icon);
        }
        else if(secondaryText.equals("Glucose Gel")){
            secondaryTreatmentIcon.setImageResource(R.drawable.settings_glucose_gel_icon);
        }
        else if(secondaryText.equals("Sugary Drink")){
            secondaryTreatmentIcon.setImageResource(R.drawable.settings_sugary_drink_icon);
        }
        else {
            secondaryTreatmentIcon.setImageResource(R.drawable.settings_other_icon);
        }

        if(highBSText.equals("Insulin Pump")){
            highBloodSugarIcon.setImageResource(R.drawable.settings_insulin_pump_icon);
        }
        else if(highBSText.equals("Insulin Pen")){
            highBloodSugarIcon.setImageResource(R.drawable.settings_insulin_pen_icon);
        }
        else {
            highBloodSugarIcon.setImageResource(R.drawable.settings_other_icon);
        }

        toolboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab2.this, tab3.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        });

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab2.this, tab4.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        });

        monitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab2.this, tab1.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        });

        minusButtonLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowEnd -= 0.1;
                lowEnd = roundFloat(lowEnd);

                if(lowEnd < 0.1f){
                    lowEnd = 0f;
                }

                textLowBS = String.valueOf(lowEnd);
                lowBS.setText(textLowBS);
            }
        });

        plusButtonLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowEnd += 0.1;
                lowEnd = roundFloat(lowEnd);
                textLowBS = String.valueOf(lowEnd);
                lowBS.setText(textLowBS);
            }
        });

        minusButtonHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highEnd -= 0.1;
                highEnd = roundFloat(highEnd);

                if(highEnd < 0.1f){
                    highEnd = 0f;
                }

                textHighBS = String.valueOf(highEnd);
                highBS.setText(textHighBS);
            }
        });

        plusButtonHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highEnd += 0.1;
                highEnd = roundFloat(highEnd);
                textHighBS = String.valueOf(highEnd);
                highBS.setText(textHighBS);
            }
        });

        waitTimerMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waitTime--;
                if(waitTime < 0){
                    waitTime = 0;
                }
                waitInterval.setText(""+ waitTime);
            }
        });

        waitTimerPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waitTime++;
                waitInterval.setText(""+ waitTime);
            }
        });

        personaliseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Feature Not Implemented", Toast.LENGTH_LONG).show();
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
            Intent intent = new Intent(tab2.this, Calibrate.class);
            intent.putExtra("userInformation", uInfo);
            startActivity(intent);
        }
        else if (id == R.id.nav_toolbox) {
            Intent intent = new Intent(tab2.this, T1DToolbox.class);
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
            Toast.makeText(tab2.this, "Successfully logged out.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(tab2.this, MainActivity.class);
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
