package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        final DbHandler dbHandler=new DbHandler(getActivity());
        ArrayList<alarm_content> al;
        al=dbHandler.getAlarm();

        adapter_alarm adapterAlarm=new adapter_alarm(getActivity(),al);
        final ListView listView=(ListView)view.findViewById(R.id.alarm_cont);
        listView.setAdapter(adapterAlarm);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, int i, long l) {

                final String to_be_deleted=((alarm_content)listView.getItemAtPosition(i)).title;

                Log.d("selected: ",Integer.toString(i)+" "+to_be_deleted);

                AlertDialog.Builder ab=new AlertDialog.Builder(getActivity());
                ab.setTitle("delete this schedule..!!!");
                String choices[]={"delete"};
                ab.setItems(choices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {




                        dbHandler.delete_alarm(to_be_deleted);

                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content,new schedule())
                                .commit();



                    }
                });


                AlertDialog alertDialog=ab.create();
                alertDialog.show();

                return false;
            }
        });

        return  view;
    }






}
