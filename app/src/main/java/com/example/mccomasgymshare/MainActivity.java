package com.example.mccomasgymshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MusclesFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // Displays the home fragment when the app is started
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_workout:
                            selectedFragment = new WorkoutsFragment();
                            break;
                        case R.id.nav_muscle:
                            selectedFragment = new MusclesFragment();
                            break;
                        case R.id.nav_calendar:
                            selectedFragment = new CalendarFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
    @Override
    public void onButtonClicked(int infoID) {

        if (infoID == 0) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Back/Shoulder");
            startActivity(i1);

        } else if (infoID == 1) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Arms");
            startActivity(i1);

        } else if (infoID == 2) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Chest");
            startActivity(i1);

        } else if (infoID == 3) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Abs");
            startActivity(i1);

        } else if (infoID == 4) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Legs");
            startActivity(i1);

        }
    }

}