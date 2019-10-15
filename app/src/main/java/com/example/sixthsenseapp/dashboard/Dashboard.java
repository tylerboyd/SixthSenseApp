package com.example.sixthsenseapp.dashboard;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.example.sixthsenseapp.intervention.UserInformation;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.intervention.RetestBloodActivity;
import com.example.sixthsenseapp.settings.tab1;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton interventionButton;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private UserInformation uInfo;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private DatabaseReference ref;
    private String userID;

    private boolean isDataRead = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        interventionButton = findViewById(R.id.interventionButton);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        interventionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Begin Intervention Process
                if(isDataRead == true){
                    Intent intent = new Intent(Dashboard.this, RetestBloodActivity.class);
                    intent.putExtra("userInformation", uInfo);
                    startActivity(intent);
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("DASHBOARD");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                readData(dataSnapshot);
                Toast.makeText(Dashboard.this, "Data Read", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
            if(isDataRead == true) {
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_calibrate) {
            if(isDataRead == true) {
                Intent intent = new Intent(Dashboard.this, Calibrate.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_toolbox) {
            if(isDataRead == true) {
                Intent intent = new Intent(Dashboard.this, T1DToolbox.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_settings) {
            if(isDataRead == true) {
                Intent intent = new Intent(this, tab1.class);
                intent.putExtra("userInformation", uInfo);
                startActivity(intent);
            }
        }
        else if (id == R.id.nav_logout) {
            mAuth.getInstance().signOut();
            Toast.makeText(Dashboard.this, "Successfully logged out.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(Dashboard.this, MainActivity.class);
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

            isDataRead = true;
        }
    }
}
