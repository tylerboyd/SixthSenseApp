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
import android.widget.Toast;

import com.example.sixthsenseapp.intervention.UserInformation;
import com.example.sixthsenseapp.mainMenu.LoginActivity;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.example.sixthsenseapp.R;

import com.example.sixthsenseapp.settings.tab1;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Calibrate extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private ImageButton connect;
    private ImageButton demo;

    private UserInformation uInfo;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference ref;
    private String userID;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_calibrate);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mAuth = LoginActivity.getFirebaseAuth();

        connect = findViewById(R.id.connectButton);
        demo = findViewById(R.id.viewDemoButton);

        Intent i = getIntent();
        uInfo = (UserInformation)i.getSerializableExtra("userInformation");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("CALIBRATE");

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Calibrate.this, "Feature Not Yet Implemented", Toast.LENGTH_LONG).show();
            }
        });

        demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Calibrate.this, "Feature Not Yet Implemented", Toast.LENGTH_LONG).show();
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
            Intent intent = new Intent(Calibrate.this, Dashboard.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_calibrate) {
            Intent intent = new Intent(Calibrate.this, Calibrate.class);
            intent.putExtra("userInformation", uInfo);
            startActivity(intent);
        }
        else if (id == R.id.nav_toolbox) {
            Intent intent = new Intent(Calibrate.this, T1DToolbox.class);
            intent.putExtra("userInformation", uInfo);
            startActivity(intent);
        }
        else if (id == R.id.nav_settings) {
            Intent intent = new Intent(Calibrate.this, tab1.class);
            intent.putExtra("userInformation", uInfo);
            startActivity(intent);
        }
        else if (id == R.id.nav_logout) {
            mAuth.getInstance().signOut();
            Toast.makeText(Calibrate.this, "Successfully logged out.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(Calibrate.this, MainActivity.class);
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
