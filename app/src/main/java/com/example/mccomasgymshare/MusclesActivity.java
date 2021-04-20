package com.example.mccomasgymshare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MusclesActivity extends AppCompatActivity {
    TextView muscleGroup;
    Button back;
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


    }

    public void onClickBack(View view){
        finish();
        return;
    }
}