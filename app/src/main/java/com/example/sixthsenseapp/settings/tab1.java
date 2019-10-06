package com.example.sixthsenseapp.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.dashboard.Calibrate;
import com.example.sixthsenseapp.dashboard.Dashboard;
import com.example.sixthsenseapp.intervention.UserInformation;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tab1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button button1;
    private Button button2;
    private Button toolboxButton;
    private Button accountButton;
    private Button promptsButton;

    private TextView startTime;

    private Switch switch1;
    private Switch switch2;

    Boolean stateAutoActivate;
    Boolean stateNightLight;

    private int minutes = 0;
    private int hours = 0;

    private UserInformation uInfo;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private DatabaseReference ref;
    private String userID;

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
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        toolboxButton = findViewById(R.id.accountbutton);
        accountButton = findViewById(R.id.monitorbutton);
        promptsButton = findViewById(R.id.promptbutton);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                readData(dataSnapshot);
                Log.d("db", "READ");

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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


        startTime = findViewById(R.id.starttime);
        button1 = findViewById(R.id.buttonMinus);
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);

        startTime.setText(hours + ":" + minutes);

        button1.setOnClickListener(new View.OnClickListener() {
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

                minutes = minutes - 5;

                if(minutes < 0)
                {
                    minutes = 55;
                }
                startTime.setText(hours + ":" + minutes);
                Toast toast = Toast.makeText(v.getContext(), "Timer Minus 5 min. Hours: " +hours + " Minutes" + minutes, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        button2 = findViewById(R.id.buttonPlus);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(hours != 23 && minutes == 55)
                {
                    hours++;
                }
                else if(hours == 23 && minutes == 55)
                {
                    hours = 0;
                }

                minutes = minutes + 5;

                if(minutes == 60)
                {
                    minutes = 0;
                }
                startTime.setText(hours + ":" + minutes);
                Toast toast = Toast.makeText(v.getContext(), "Timer Plus 5 min. Hours:" +hours + "Minutes" + minutes, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    stateAutoActivate = true;
                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
                    toast.show();
                    stateAutoActivate = false;
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast toast = Toast.makeText(buttonView.getContext(), "ON", Toast.LENGTH_LONG);
                    toast.show();
                    stateNightLight = true;

                } else {
                    Toast toast = Toast.makeText(buttonView.getContext(), "OFF", Toast.LENGTH_LONG);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.nav_dashboard)
        {
            //Intent intent = new Intent(Fill Dashboard Connection Here);
            //startActivity(intent);
        }
        if(id == R.id.nav_calibrate)
        {
            //Create Toast Here
        }
        if(id == R.id.nav_toolbox)
        {
            //Create Toast Here
        }
        if(id == R.id.nav_settings)
        {
            //Intent intent = new Intent(Fill Settings Connection Here);
            //startActivity(intent);
        }
        if(id == R.id.nav_logout)
        {
            //Run Logout Activity Here
        }

        return super.onOptionsItemSelected(item);
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
            Toast.makeText(this, "Feature Not Yet Implemented", Toast.LENGTH_LONG).show();
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

    private void readData(DataSnapshot dataSnapshot){
        for(DataSnapshot ds : dataSnapshot.getChildren()){

            uInfo = new UserInformation();
            uInfo.setBloodSugarHighLimit(ds.child(userID).child("patient").getValue(UserInformation.class).getBloodSugarHighLimit());
            uInfo.setBloodSugarLowLimit(ds.child(userID).child("patient").getValue(UserInformation.class).getBloodSugarLowLimit());
            uInfo.setPrimaryTreatmentMethod(ds.child(userID).child("patient").getValue(UserInformation.class).getPrimaryTreatmentMethod());
            uInfo.setSecondaryTreatmentMethod(ds.child(userID).child("patient").getValue(UserInformation.class).getSecondaryTreatmentMethod());
            uInfo.setHighBloodSugarTreatment(ds.child(userID).child("patient").getValue(UserInformation.class).getHighBloodSugarTreatment());
            uInfo.setEmergencyContactName(ds.child(userID).child("patient").getValue(UserInformation.class).getEmergencyContactName());
            uInfo.setEmergencyContactNumber(ds.child(userID).child("patient").getValue(UserInformation.class).getEmergencyContactNumber());
            uInfo.setInterventionWaitTime(ds.child(userID).child("patient").getValue(UserInformation.class).getInterventionWaitTime());
        }
    }
}
