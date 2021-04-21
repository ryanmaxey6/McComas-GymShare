package com.example.mccomasgymshare;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    TextView text;
    ImageView image;
    Button login, searchMuscle, findWorkout;
    private OnFragmentInteractionListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        login = view.findViewById(R.id.login);
        searchMuscle = view.findViewById(R.id.searchButton);
        findWorkout = view.findViewById(R.id.findButton);
        text = view.findViewById(R.id.welcomeText);
        image = view.findViewById(R.id.homeImage);

        searchMuscle.setOnClickListener(this);
        findWorkout.setOnClickListener(this); 
        login.setOnClickListener(this);
        image.setImageResource(R.drawable.weightlift);
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
    public void onClick(View v) {
        if(v.getId() == login.getId()){
            mListener.onButtonClicked(0);
        }
        else if(v.getId() == findWorkout.getId()){
            mListener.onButtonClicked(1);
        }
        else if(v.getId() == searchMuscle.getId()) {
            mListener.onButtonClicked(2);
        }
    }

    public interface OnFragmentInteractionListener{
        void onButtonClicked(int infoID);
    }
}
