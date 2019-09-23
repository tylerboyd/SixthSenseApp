package com.example.sixthsenseapp.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixthsenseapp.R;
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

public class tab2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button minusButtonLow;
    private Button plusButtonLow;
    private Button minusButtonHigh;
    private Button plusButtonHigh;
    private Button waitTimerMinus;
    private Button waitTimerPlus;

    private boolean proceed = false;

    private Button toolboxButton;
    private Button accountButton;
    private Button monitorButton;

    private TextView lowBS;
    private TextView highBS;
    private TextView waitInterval;

    private String textLowBS;
    private String textHighBS;
    private String waitTimer;

    private float highEnd;
    private float lowEnd;
    private int waitInter;
//12:57 close
    private UserInformation uInfo;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener m;
    private DatabaseReference ref;
    private String userID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_tab2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setVisibility(View.GONE);
        getSupportActionBar().setTitle("SETTINGS");

        lowBS = findViewById(R.id.lowbloodrange);
        highBS = findViewById(R.id.highbloodrange);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                readData(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //lowEnd = uInfo.getBloodSugarLowLimit();
        //highEnd = uInfo.getBloodSugarHighLimit();
        //waitInter = uInfo.getInterventionWaitTime();

        //textLowBS = String.valueOf(lowEnd);
        //textHighBS = String.valueOf(highEnd);



        toolboxButton = findViewById(R.id.promptbutton);
        accountButton = findViewById(R.id.accountbutton);
        monitorButton = findViewById(R.id.monitorbutton);
        waitInterval = findViewById(R.id.editText3);

        toolboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab2.this, tab3.class);
                startActivity(intent);
            }
        });

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab2.this, tab4.class);
                startActivity(intent);
            }
        });

        monitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab2.this, tab1.class);
                startActivity(intent);
            }
        });



        minusButtonLow = findViewById(R.id.minusbuttonlow);
        minusButtonLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lowEnd = lowEnd--;
                //textLowBS = String.valueOf(lowEnd);
                //lowBS.setText(textLowBS);
            }
        });

        plusButtonLow = findViewById(R.id.plusbuttonlow);
        plusButtonLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lowEnd = lowEnd++;
                //textLowBS = String.valueOf(lowEnd);
                //lowBS.setText(textLowBS);
            }
        });

        minusButtonHigh = findViewById(R.id.minusbuttonhigh);
        minusButtonHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //highEnd = highEnd--;
                //textHighBS = String.valueOf(highEnd);
                //highBS.setText(textHighBS);
            }
        });

        plusButtonHigh = findViewById(R.id.plusbuttonhigh);
        plusButtonHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //highEnd = highEnd++;
                //textHighBS = String.valueOf(highEnd);
                //highBS.setText(textHighBS);
            }
        });

        waitTimerMinus = findViewById(R.id.waittimerminus);
        waitTimerMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //waitInter = waitInter--;
                //waitInterval.setText(waitInter);
            }
        });

        waitTimerPlus = findViewById(R.id.waittimerplus);
        waitTimerPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //waitInter = waitInter++;
                //waitInterval.setText(waitInter);
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
            Toast.makeText(this, "Feature Not Yet Implemented", Toast.LENGTH_LONG).show();
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

            proceed = true;
        }
    }
}
