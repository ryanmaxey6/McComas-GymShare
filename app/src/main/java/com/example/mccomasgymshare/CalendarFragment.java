package com.example.mccomasgymshare;

import android.content.Context;
import android.os.Bundle;
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

    EditText  description;
    Button addEvent;
    private CalendarFragment.OnFragmentInteractionListener mListener;
    String desc, time = "";
    TextView textView;
    ArrayList<Integer> days, months,hours, mins;
    ArrayList<String> times;
    ArrayAdapter<Integer> d, m, h, m2;
    ArrayAdapter<String> t;
    Spinner spinDay, spinMonth, spinHour, spinMin, spinTime;
    int day, month, hour, min = -1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        textView = (TextView) view.findViewById(R.id.tvTitle);


        description = (EditText) view.findViewById(R.id.etDescription);

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
        times.add("AM");
        times.add("PM");
        mins.add(0);

        for(int i = 1; i<61; i++){
            if(i<= 12){
                months.add(i);
                hours.add(i);
            }
            if(i<= 31) {
                days.add(i);
            }
            if(i%5 ==0) {
                mins.add(i);
            }
        }

        d = new ArrayAdapter<Integer>(this.getActivity(), android.R.layout.simple_spinner_item, days);
        d.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDay.setAdapter(d);
        m = new ArrayAdapter<Integer>(this.getActivity(), android.R.layout.simple_spinner_item, months);
        m.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMonth.setAdapter(m);
        h = new ArrayAdapter<Integer>(this.getActivity(), android.R.layout.simple_spinner_item, hours);
        h.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinHour.setAdapter(h);
        m2 = new ArrayAdapter<Integer>(this.getActivity(), android.R.layout.simple_spinner_item, mins);
        m2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMin.setAdapter(m2);
        t = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, times);
        t.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTime.setAdapter(t);


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

            desc = description.getText().toString();
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
