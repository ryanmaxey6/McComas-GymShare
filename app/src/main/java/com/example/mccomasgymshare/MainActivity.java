package com.example.mccomasgymshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, MusclesFragment.OnFragmentInteractionListener, CalendarFragment.OnFragmentInteractionListener {
    HomeFragment frag;
    CalendarFragment calFrag;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, String> user = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag = new HomeFragment();
        calFrag = new CalendarFragment();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // Displays the home fragment when the app is started
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                frag).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = frag;
                            break;
                        case R.id.nav_workout:
                            selectedFragment = new WorkoutsFragment();
                            break;
                        case R.id.nav_muscle:
                            selectedFragment = new MusclesFragment();
                            break;
                        case R.id.nav_calendar:
                            selectedFragment = calFrag;
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    @Override
    public void onButtonClicked(int infoID) {
        if(infoID == 0)
        {
            frag.setScreen();
        }
        else if(infoID == 1)
        {
            String username = frag.getUsername();
            String password = frag.getPassword();

            frag.resetScreen();
            user.put(username, password);
            db.collection("users")
                    .add(user)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                                Log.d("Hey","Document: " + documentReference.getId());
                        }
                    })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("Fail","Error: " + e);
                        }
                    });

        }
        else if (infoID == 2)
        {
            frag.resetScreen();
        }
        else if (infoID == 3)
        {
            db.collection("users")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful())
                            {
                                for (QueryDocumentSnapshot document : task.getResult())
                                {
                                    if (document.contains(frag.getUsername()))
                                    {
                                        if (document.get(frag.getUsername()).equals(frag.getPassword()))
                                        {
                                            int duration = Toast.LENGTH_LONG;
                                            Toast.makeText(getApplicationContext(), "Welcome " + frag.getUsername(), duration);

                                        }
                                    }
                                }
                            }
                        }
                    });
        }
    }


    @Override
    public void onButtonClickedMuscle(int infoID) {
        if (infoID == 0) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Back/Shoulder");
            i1.putExtra("muscle", 0);
            startActivity(i1);

        } else if (infoID == 1) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Arms");
            i1.putExtra("muscle", 1);
            startActivity(i1);

        } else if (infoID == 2) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Chest");
            i1.putExtra("muscle", 2);
            startActivity(i1);

        } else if (infoID == 3) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Abs");
            i1.putExtra("muscle", 3);
            startActivity(i1);

        } else if (infoID == 4) {
            Intent i1 = new Intent(this, MusclesActivity.class);
            i1.putExtra("muscleGroup", "Legs");
            i1.putExtra("muscle", 4);
            startActivity(i1);
        }
    }

    @Override
    public void onButtonClickedCalendar(int infoID) {


        if(infoID==0) {

            if (calFrag.getDesc().equals("") || calFrag.getDay() == -1 || calFrag.getMonth() ==-1) {
                Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            }
            else{
                /*Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, calFrag.getEvent());
                intent.putExtra(CalendarContract.Events.DESCRIPTION, calFrag.getDesc());
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "McComas Hall");
                intent.putExtra(CalendarContract.Events.ALL_DAY, true);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "There is no app that can support this action", Toast.LENGTH_SHORT).show();

                }*/

                int hour = -1;
                if(calFrag.getTime() == "PM"){
                    hour = calFrag.getHour()+12;
                }
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2021, calFrag.getMonth()-1, calFrag.getDay(), hour, calFrag.getMin());
                //Calendar endTime = Calendar.getInstance();
                //endTime.set(2021, 3, 28, 15, 30);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        //.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, "Workout")
                        .putExtra(CalendarContract.Events.DESCRIPTION, calFrag.getDesc())
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "McComas Hall")
                        .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
                startActivity(intent);


            }
        }

    }
}
