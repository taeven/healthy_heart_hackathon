package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class hourly extends DialogFragment {

    public hourly() {
        // Required empty public constructor
    }

    EditText hours,title;

    String hrs,ttl;
    Button done;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hourly, container, false);
        hours=(EditText)view.findViewById(R.id.hours_of_reppeated);
        title=(EditText)view.findViewById(R.id.title_for_reminder);

        done=(Button)view.findViewById(R.id.done_hourly);
        set_alarm_hourly(view);



        return view;

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void set_alarm_hourly(View view)
    {
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int RQS_1 = 1;
                Calendar now=Calendar.getInstance();


                Calendar inter=Calendar.getInstance();
                int hr=Integer.parseInt(hours.getText().toString());
                inter.set(0,0,0,hr,0,0);

                Intent intent = new Intent(getActivity().getBaseContext(), AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), RQS_1, intent, 0);
                AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,now.getTimeInMillis(),inter.getTimeInMillis(),pendingIntent);

            }
        });


    }
}
