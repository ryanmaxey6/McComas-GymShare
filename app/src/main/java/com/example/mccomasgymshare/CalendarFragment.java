package com.example.mccomasgymshare;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class CalendarFragment extends Fragment implements View.OnClickListener {

    Spinner  description;
    Button addEvent;
    private CalendarFragment.OnFragmentInteractionListener mListener;
    String desc, time = "";
    TextView textView;
    ArrayList<String> days, months,hours, mins, workouts;
    ArrayList<String> times;
    ArrayAdapter<String> d, m, h, m2, w;
    ArrayAdapter<String> t;
    Spinner spinDay, spinMonth, spinHour, spinMin, spinTime;
    int day, month, hour, min = -1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        textView = (TextView) view.findViewById(R.id.tvSchedule);
        String temp = textView.getText().toString();
        SpannableString content = new SpannableString(temp);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);


        description = (Spinner) view.findViewById(R.id.spinnerDescription);

        addEvent = (Button) view.findViewById(R.id.buttonAdd);
        addEvent.setOnClickListener(this);

        spinDay = (Spinner) view.findViewById(R.id.spinnerDay);
        spinMonth = (Spinner) view.findViewById(R.id.spinnerMonth);
        spinHour = (Spinner) view.findViewById(R.id.spinnerHour);
        spinMin = (Spinner) view.findViewById(R.id.spinnerMin);
        spinTime = (Spinner) view.findViewById(R.id.spinnerTime);

        months = new ArrayList<>();
        days = new ArrayList<>();
        hours = new ArrayList<>();
        mins = new ArrayList<>();
        times = new ArrayList<>();
        workouts = new ArrayList<>();
        times.add("AM");
        times.add("PM");
        mins.add("00");
        mins.add("05");
        workouts.add("Beginner-Abs");
        workouts.add("Beginner-Arms");
        workouts.add("Beginner-Back");
        workouts.add("Beginner-Chest");
        workouts.add("Beginner-Legs");
        workouts.add("Intermediate-Abs");
        workouts.add("Intermediate-Arms");
        workouts.add("Intermediate-Back");
        workouts.add("Intermediate-Chest");
        workouts.add("Intermediate-Legs");
        workouts.add("Advanced-Abs");
        workouts.add("Advanced-Arms");
        workouts.add("Advanced-Back");
        workouts.add("Advanced-Chest");
        workouts.add("Advanced-Legs");


        for(int i = 1; i<61; i++){
            if(i<10){
                months.add("0" +i);
                hours.add("0" +i);
                days.add("0" +i);
            }
            if(i >= 10 &&i<= 12){
                months.add(""+i);
                hours.add(""+i);
            }
            if(i >= 10 &&i<= 31) {
                days.add(""+i);
            }
            if(i>= 9 && i%5 ==0) {
                mins.add(""+i);
            }
        }

        d = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, days);
        d.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDay.setAdapter(d);
        m = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, months);
        m.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMonth.setAdapter(m);
        h = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, hours);
        h.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinHour.setAdapter(h);
        m2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, mins);
        m2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMin.setAdapter(m2);
        t = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, times);
        t.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTime.setAdapter(t);
        w = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, workouts);
        w.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        description.setAdapter(w);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof CalendarFragment.OnFragmentInteractionListener){
            this.mListener= (CalendarFragment.OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()+" must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == addEvent.getId()){




            desc="";
            day = -1;
            month = -1;

            desc = description.getSelectedItem().toString();
            day = parseInt(spinDay.getSelectedItem().toString());
            month = parseInt(spinMonth.getSelectedItem().toString());
            time = spinTime.getSelectedItem().toString();
            hour = parseInt(spinHour.getSelectedItem().toString());
            min = parseInt(spinMin.getSelectedItem().toString());


            mListener.onButtonClickedCalendar(0);
        }




    }



    public String getDesc() {
        return desc;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public String getTime() {
        return time;
    }

    public interface OnFragmentInteractionListener{
        void onButtonClickedCalendar(int infoID);
    }
}
