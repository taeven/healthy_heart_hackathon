package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class schedule extends Fragment {


    ListView listView;
    public schedule() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_schedule, container, false);
        listView=(ListView)view.findViewById(R.id.alarm_cont);

        DbHandler dbHandler=new DbHandler(getActivity());
        ArrayList<alarm_content> al;
        al=dbHandler.getAlarm();
        adapter_alarm adapterAlarm=new adapter_alarm(getActivity(),al);
        ListView listView=(ListView)view.findViewById(R.id.alarm_cont);
        listView.setAdapter(adapterAlarm);

        return  view;
    }






}
