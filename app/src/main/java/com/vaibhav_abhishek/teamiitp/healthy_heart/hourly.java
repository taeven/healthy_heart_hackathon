package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class hourly extends DialogFragment {

    public hourly() {
        // Required empty public constructor
    }

    EditText hours,title;

    String hrs,ttl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hourly, container, false);
        hours=(EditText)view.findViewById(R.id.hours_of_reppeated);
        title=(EditText)view.findViewById(R.id.title_for_reminder);

        hrs=hours.getText().toString();
        ttl=title.getText().toString();



        return view;

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
