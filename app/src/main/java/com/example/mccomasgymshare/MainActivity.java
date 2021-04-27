package com.example.mccomasgymshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener {
    HomeFragment frag = new HomeFragment();

    public static final FirebaseFirestore db = FirebaseFirestore.getInstance();
    Map<String, String> user = new HashMap<>();
    int check = 0;
    boolean checker = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //frag = new HomeFragment();



        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // Displays the home fragment when the app is started
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                frag).commit();

        if (getIntent().getExtras() != null)
        {

            String s = getIntent().getStringExtra("User");
            frag.loginSuccess(s);
        }
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
        if(infoID == 0)
        {
            frag.setScreen();
        }
        else if(infoID == 1)
        {
            String username = frag.getUsername();
            String password = frag.getPassword();

            Toast toast = Toast.makeText(getApplicationContext(), "Account Successfully created!" , Toast.LENGTH_LONG);
            toast.show();

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
            checker = true;
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            //frag.setScreen();
        }
        
    }
}
