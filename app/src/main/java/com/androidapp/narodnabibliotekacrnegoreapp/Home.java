package com.androidapp.narodnabibliotekacrnegoreapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.androidapp.narodnabibliotekacrnegoreapp.fragments.AboutFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.CatalogFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.CollectionsFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.ContactFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.EventsFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.OurEditionFragment;
import com.androidapp.narodnabibliotekacrnegoreapp.fragments.ServicesFragment;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;

    ViewFlipper v_flipper;

    int[] images = {
            R.drawable.slide1,
            R.drawable.slide2,
            R.drawable.slide3
    };

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
                    new AboutFragment()).commit();
            navigationView.setCheckedItem(R.id.about);
        }

        v_flipper = findViewById(R.id.v_flipper);

        for(int i=0; i<images.length; i++){
            flip_image(images[i]);
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

    public void flip_image(int i){
        ImageView view  = new ImageView(this);
        view.setBackgroundResource(i);
        v_flipper.addView(view);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }




    public void openContactPage(){
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
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
