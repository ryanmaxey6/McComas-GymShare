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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    TextView text;

    TextView text4, text5;
    EditText username;
    EditText password;
    View view;
    Button login, finishCreate, create;
    private OnFragmentInteractionListener mListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        login = view.findViewById(R.id.login);
        finishCreate = view.findViewById(R.id.createFinish);
        create = view.findViewById(R.id.create);


        text = view.findViewById(R.id.welcomeText);
        text4 = view.findViewById(R.id.text4);
        text5 = view.findViewById(R.id.text5);
        username = (EditText)view.findViewById(R.id.username);
        password = (EditText)view.findViewById(R.id.password);


        login.setOnClickListener(this);
        finishCreate.setOnClickListener(this);
        create.setOnClickListener(this);



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

    }

    public void setScreen()
    {
        username.setVisibility(view.VISIBLE);
        password.setVisibility(view.VISIBLE);
        finishCreate.setVisibility(view.VISIBLE);
        text4.setVisibility(view.VISIBLE);
        text5.setVisibility(view.VISIBLE);
        create.setVisibility(view.INVISIBLE);
        login.setVisibility(view.INVISIBLE);

    }

    public void resetScreen()
    {
        username.setVisibility(view.INVISIBLE);
        password.setVisibility(view.INVISIBLE);
        text4.setVisibility(view.INVISIBLE);
        text5.setVisibility(view.INVISIBLE);
        //username.setText("");
        //password.setText("");
        //create.setVisibility(View.INVISIBLE);
        login.setVisibility(View.VISIBLE);
        finishCreate.setVisibility(View.INVISIBLE);
    }

    public void loginSuccess(String s)
    {

        text.setText("Welcome Back: " + s + "!");
    }

    public boolean validate(String u, String p)
    {
        return false;
    }


    public interface OnFragmentInteractionListener{
        void onButtonClicked(int infoID);
    }
}
