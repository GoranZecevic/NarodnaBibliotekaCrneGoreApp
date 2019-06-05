package com.androidapp.narodnabibliotekacrnegoreapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

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

        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        v_flipper = findViewById(R.id.v_flipper);

        for(int i=0; i<images.length; i++){
            flip_image(images[i]);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.oNama) {
            openContactPage();
        } else if (id == R.id.katalozi) {
            Toast.makeText(this, "Katalozi kliknuo", Toast.LENGTH_SHORT);

        } else if (id == R.id.usluge) {
            Toast.makeText(this, "Usluge kliknuo", Toast.LENGTH_SHORT);

        } else if (id == R.id.kolekcije) {
            Toast.makeText(this, "Kolekcije kliknuo", Toast.LENGTH_SHORT);

        } else if (id == R.id.dogadjaji) {
            Toast.makeText(this, "Dogadjaji kliknuo", Toast.LENGTH_SHORT);

        } else if (id == R.id.izdanja) {
            Toast.makeText(this, "Izdanja kliknuo", Toast.LENGTH_SHORT);

        } else if (id == R.id.kontakt) {
            Toast.makeText(this, "Kontakt kliknuo", Toast.LENGTH_SHORT);
        }


//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
//        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void openContactPage(){
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }
}
