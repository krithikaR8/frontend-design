package com.example.signlanguageapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{


    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;


    SliderView Slider;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.slidebar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton cardBook = findViewById(R.id.cardBook);
        ImageButton cardCapture = findViewById(R.id.cardCapture);


        cardBook.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent BookActivityIntent = new Intent(getApplicationContext(), BookActivity.class);

                startActivity(BookActivityIntent);
            }
        });
        cardCapture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent CaptureActivityIntent = new Intent(getApplicationContext(), CaptureActivity.class);
                startActivity(CaptureActivityIntent);
            }
        });

        Slider = findViewById(R.id.sliderView);
        int[] images = {R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5};
        String[] caption = {"Slider 1", "Slider 2", "Slider 3", "Slider 4", "Slider 5"};

        SliderAdapter adapter = new SliderAdapter(images, caption);
        Slider.setSliderAdapter(adapter);
        Slider.setSliderTransformAnimation(SliderAnimations.CUBEINDEPTHTRANSFORMATION);
        Slider.startAutoCycle();

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_home:
                break;
            case R.id.nav_capture:
                Intent i = new Intent(getApplicationContext(), CaptureActivity.class);
                startActivity(i);
                break;
            case R.id.nav_book:
                Intent a = new Intent(getApplicationContext(), BookActivity.class);
                startActivity(a);
                break;
            case R.id.nav_book1:
                Intent e = new Intent(getApplicationContext(), Book11Activity.class);
                startActivity(e);
                break;
            case R.id.nav_book2:
                Intent b = new Intent(getApplicationContext(), Book22Activity.class);
                startActivity(b);
                break;
            case R.id.nav_book3:
                Intent c= new Intent(getApplicationContext(), Book33Activity.class);
                startActivity(c);
                break;
            case R.id.nav_book4:
                Intent d = new Intent(getApplicationContext(), Book44Activity.class);
                startActivity(d);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}