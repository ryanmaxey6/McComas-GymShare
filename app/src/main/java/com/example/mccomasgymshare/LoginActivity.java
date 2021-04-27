package com.example.mccomasgymshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText user, password;

    HomeFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.loginActiv);
        user = findViewById(R.id.usernameSecond);
        password  = findViewById(R.id.passwordSecond);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().isEmpty())
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter a Username" , Toast.LENGTH_LONG);
                    toast.show();

                }
                else if(password.getText().toString().isEmpty())
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter a Password" , Toast.LENGTH_LONG);
                    toast.show();

                }
                else if(password.getText().toString().isEmpty() && user.getText().toString().isEmpty())
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter a Username and Password" , Toast.LENGTH_LONG);
                    toast.show();

                }
                else
                {
                    MainActivity.db.collection("users")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful())
                                    {
                                        for (QueryDocumentSnapshot document : task.getResult())
                                        {
                                            if (document.contains(user.getText().toString()))
                                            {

                                                if (document.get(user.getText().toString()).equals(password.getText().toString()))
                                                {
                                                    newMain(user.getText().toString());

                                                    int duration = Toast.LENGTH_LONG;
                                                    //Toast.makeText(getApplicationContext(), "Welcome " + frag.getUsername(), duration);

                                                }
                                            }
                                        }
                                    }
                                }
                            });
                }
            }
        });
    }

    public void newMain(String s)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("User", s);
        startActivity(intent);
    }

}
