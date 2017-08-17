package com.lastengineer.mapboxhidetest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mapbox.mapboxsdk.Mapbox;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    private MapViewFragment mapViewFragmentOne;
    private MapViewFragment mapViewFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapbox.getInstance(this, "pk.eyJ1IjoidG9tZWthbmN1IiwiYSI6ImNqNjU3bzBibjF5cTkzMm1vaWcwcXZ0enYifQ.NbdRZvylImTzF_Gx2yIioQ");
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        fragmentManager = getSupportFragmentManager();
        initBottomNavigation();


    }

    private void initBottomNavigation() {
        mapViewFragmentOne = MapViewFragment.newInstance(R.layout.fragment_map_view);
        mapViewFragmentTwo = MapViewFragment.newInstance(R.layout.fragment_map_view_two);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        showMapTabOne();
    }


    private void showMapTabOne() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, mapViewFragmentOne);
        transaction.commit();
    }


    private void showMapTabTwo() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, mapViewFragmentTwo);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_map_one:
                showMapTabOne();
                break;
            case R.id.action_map_two:
                showMapTabTwo();
                break;
        }
        return true;
    }
}
