package com.androidapp.narodnabibliotekacrnegoreapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.androidapp.narodnabibliotekacrnegoreapp.fragments.AboutFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.CatalogFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.CollectionsFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.ContactFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.EventsFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.HomeFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.OurEditionFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.ServicesFragment;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, toolbar, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }

    @Override
    public void onBackPressed() {
        if(mDrawerlayout.isDrawerOpen(GravityCompat.START)){
            mDrawerlayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    public void openHomePage(){
        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                break;

            case R.id.catalog:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CatalogFragment()).commit();
                break;
            case R.id.services:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ServicesFragment()).commit();
                break;
            case R.id.collections:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CollectionsFragment()).commit();
                break;
            case R.id.events:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EventsFragment()).commit();
                break;
            case R.id.our_edition:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OurEditionFragment()).commit();
                break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
            case R.id.crnogorski:
                Toast.makeText(this, "Crnogorski jezik kliknut", Toast.LENGTH_SHORT).show();
                break;
            case R.id.english:
                Toast.makeText(this, "Engleski jezik kliknut", Toast.LENGTH_SHORT).show();
                break;
        }
        mDrawerlayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
