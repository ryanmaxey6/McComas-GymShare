package com.example.mccomasgymshare;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    TextView text;
    EditText username;
    EditText password;
    View view;
    Button login, finishCreate, create, loginAttempt;
    private OnFragmentInteractionListener mListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        login = view.findViewById(R.id.login);
        finishCreate = view.findViewById(R.id.createFinish);
        create = view.findViewById(R.id.create);
        loginAttempt = view.findViewById(R.id.loginAttempt);

        text = view.findViewById(R.id.welcomeText);
        username = (EditText)view.findViewById(R.id.username);
        password = (EditText)view.findViewById(R.id.password);


        login.setOnClickListener(this);
        finishCreate.setOnClickListener(this);
        loginAttempt.setOnClickListener(this);
        create.setOnClickListener(this);
        //username.setOnClickListener(this);
        //password.setOnClickListener(this);


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

    public String getUsername()
    {
        return username.getText().toString();
    }

    public String getPassword()
    {
        return password.getText().toString();
    }

    public void settUsername(String s)
    {
        username.setText(s);
    }

    public void setPassword(String s)
    {
        password.setText(s);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == create.getId()){
            mListener.onButtonClicked(0);
        }
        else if(v.getId() == finishCreate.getId())
        {
            if(username.getText().toString().isEmpty())
            {
                Log.v("Error", "Please enter a username");
            }
            else if(password.getText().toString().isEmpty())
            {
                Log.v("Error", "Please enter a password");
            }
            else if(password.getText().toString().isEmpty() && username.getText().toString().isEmpty())
            {
                Log.v("Error", "Please enter a username and password");
            }
            else
            {
                mListener.onButtonClicked(1);
            }

        }
        else if (v.getId() == login.getId())
        {
            mListener.onButtonClicked(2);
        }
        else if (v.getId() == loginAttempt.getId())
        {
            mListener.onButtonClicked(3);
        }
    }

    public void setScreen()
    {
        username.setVisibility(view.VISIBLE);
        password.setVisibility(view.VISIBLE);
        finishCreate.setVisibility(view.VISIBLE);
        create.setVisibility(view.INVISIBLE);
        login.setVisibility(view.INVISIBLE);
    }

    public void resetScreen()
    {
        username.setVisibility(view.VISIBLE);
        password.setVisibility(view.VISIBLE);
        username.setText("");
        password.setText("");
        create.setVisibility(View.INVISIBLE);
        login.setVisibility(View.INVISIBLE);
        loginAttempt.setVisibility(View.VISIBLE);
        finishCreate.setVisibility(View.INVISIBLE);
    }


    public boolean validate(String u, String p)
    {
        return false;
    }


    public interface OnFragmentInteractionListener{
        void onButtonClicked(int infoID);
    }
}
