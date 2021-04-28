package com.example.mccomasgymshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MusclesActivity extends AppCompatActivity {
    TextView muscleGroup;
    Button back;
    private RecyclerView recyclerView;
    MuscleArrays muscleArrays;
    private RecyclerView.LayoutManager layoutManager;
    private MuscleGroupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscles);
        muscleGroup = (TextView) findViewById(R.id.tvMuscleGroup);

        Bundle b1 = getIntent().getExtras();
        SpannableString content = new SpannableString(b1.getString("muscleGroup"));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        muscleGroup.setText(content);

        back = (Button) findViewById(R.id.buttonReturn);
        muscleArrays = new MuscleArrays();

        recyclerView = findViewById(R.id.rvMuscles);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        int temp = b1.getInt("muscle");
        Log.i("Muscle", temp+"");
        Log.i("Muscle Group", b1.getString("muscleGroup"));

        switch(temp){
            case 0:
                Log.i("Back", "here");
                adapter = new MuscleGroupAdapter(muscleArrays.getBack(), muscleArrays.getBackText());
                break;
            case 1:
                Log.i("arms", "here");
                adapter = new MuscleGroupAdapter(muscleArrays.getArms(), muscleArrays.getArmsText());
                break;
            case 2:
                Log.i("chest", "here");
                adapter = new MuscleGroupAdapter(muscleArrays.getChest(), muscleArrays.getChestText());
                break;
            case 3:
                Log.i("abs", "here");
                adapter = new MuscleGroupAdapter(muscleArrays.getAbs(), muscleArrays.getAbsText());
                break;
            case 4:
                Log.i("legs", "here");
                adapter = new MuscleGroupAdapter(muscleArrays.getLegs(), muscleArrays.getLegsText());
                break;

        }
        recyclerView.setAdapter(adapter);




    }

    public void onClickBack(View view){
        finish();
        return;
    }
}