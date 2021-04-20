package com.example.mccomasgymshare;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MusclesFragment extends Fragment implements View.OnClickListener {
    TextView text;
    Button back, arms, chest, abs, legs;
    private OnFragmentInteractionListener mListener;

    public MusclesFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_muscles, container, false);
        back = (Button) view.findViewById(R.id.buttonBack);
        arms = (Button) view.findViewById(R.id.buttonArms);
        chest = (Button) view.findViewById(R.id.buttonChest);
        abs = (Button) view.findViewById(R.id.buttonAbs);
        legs = (Button) view.findViewById(R.id.buttonLegs);


        back.setOnClickListener(this);
        arms.setOnClickListener(this);
        chest.setOnClickListener(this);
        abs.setOnClickListener(this);
        legs.setOnClickListener(this);

        text = (TextView) view.findViewById(R.id.tvMuscles);
        String temp = text.getText().toString();
        SpannableString content = new SpannableString(temp);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        text.setText(content);



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof OnFragmentInteractionListener){
            this.mListener= (OnFragmentInteractionListener) context;
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
        if(view.getId() == back.getId()){
            mListener.onButtonClicked(0);
        }
        else if(view.getId() == arms.getId()){
            mListener.onButtonClicked(1);
        }
        else if(view.getId() == chest.getId()){
            mListener.onButtonClicked(2);
        }
        else if(view.getId() == abs.getId()){
            mListener.onButtonClicked(3);
        }
        else if(view.getId() == legs.getId()){
            mListener.onButtonClicked(4);
        }
    }



    public interface OnFragmentInteractionListener{
        void onButtonClicked(int infoID);
    }
}
