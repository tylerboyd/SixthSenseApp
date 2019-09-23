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

import com.example.sixthsenseapp.mainMenu.LoginActivity;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.intervention.RetestBloodActivity;
import com.example.sixthsenseapp.settings.tab1;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //private Button logOutButton;
    //private Button settingsButton;
    private ImageButton interventionButton;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        //logOutButton = findViewById(R.id.logoutButton);
        //settingsButton = findViewById(R.id.buttonsetting);
        interventionButton = findViewById(R.id.interventionButton);

        mAuth = LoginActivity.getFirebaseAuth();

        interventionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, RetestBloodActivity.class);
                startActivity(intent);
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
        navigationView.setVisibility(View.GONE);
        getSupportActionBar().setTitle("DASHBOARD");



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
}
