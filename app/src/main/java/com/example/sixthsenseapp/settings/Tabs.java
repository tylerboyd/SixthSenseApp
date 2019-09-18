package com.example.sixthsenseapp.settings;

import android.content.Intent;
import android.os.Bundle;

import com.example.sixthsenseapp.dashboard.Dashboard;
import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.mainMenu.LoginActivity;
import com.example.sixthsenseapp.mainMenu.MainActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tabs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_settings);
        com.example.sixthsenseapp.settings.SectionsPagerAdapter sectionsPagerAdapter = new com.example.sixthsenseapp.settings.SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        mAuth = LoginActivity.getFirebaseAuth();

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
            Intent intent = new Intent(this, Tabs.class);
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
}