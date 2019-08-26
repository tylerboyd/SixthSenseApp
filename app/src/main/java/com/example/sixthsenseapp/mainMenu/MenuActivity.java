package com.example.sixthsenseapp.mainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.sixthsenseapp.R;
import com.example.sixthsenseapp.intervention.callibrateActivity;
import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout drawer;
    NavigationView navigationView = findViewById(R.id.nav_view);
    //NavigationView.setNavigationItemSelectedListener(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //To ensure process is not killed or behavior state does not change it
        /*if (savedInstanceState == null)
        {
            //When login finished or when start up
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
            //navigationView.setCheckedItem(R.id.navigation_dashboard);
        }*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.navigation_dashboard:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ()).commit();
                Toast.makeText(this, "dashboard", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_calibrate:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
                Intent i = new Intent(MenuActivity.this, callibrateActivity.class);
                startActivity(i);
                Toast.makeText(this, "calibrate", Toast.LENGTH_SHORT).show();
                break;
                case R.id.navigation_t1dtoolbox:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
                    Toast.makeText(this, "t1dtooldbox", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_settings:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer((GravityCompat.START));
        return true;
    }

    @Override
    public void onBackPressed()
    {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);

        }
        else
        {
            super.onBackPressed();
        }
    }
}
