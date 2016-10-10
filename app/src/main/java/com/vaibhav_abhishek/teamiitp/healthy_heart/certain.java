package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.sql.Time;
import java.util.Calendar;


public class certain extends DialogFragment {
    private final int texts[] = {R.id.morning_time, R.id.afternoon_tie, R.id.evening_time, R.id.night_time};
    EditText title;
    private final int checkboxs[] = {R.id.morning, R.id.afternoon, R.id.evening, R.id.night};
    private CheckBox cb[];
    private Button done;
    private EditText hrs_certain[];
    private String titles[]={"morning","afternoon","evening","night"};
    public certain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_certain, container, false);
        title=(EditText)view.findViewById(R.id.title_certain);
        cb = new CheckBox[4];
        hrs_certain=new EditText[4];



        for (int i = 0; i < 4; i++) {
            cb[i] = (CheckBox) view.findViewById(checkboxs[i]);

        }

        for (int i = 0; i < 4; i++) {
            hrs_certain[i] = (EditText) view.findViewById(texts[i]);


        }


        done=(Button)view.findViewById(R.id.done_certain);
        set_alarm_certain(view);
        return view;
    }


    public void set_alarm_certain(View view) {



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("certain","yo");
                DbHandler dbHandler=new DbHandler(getActivity());


//                int RQS_1 = 1;
//
                for (int i = 0; i < 4; i++) {
//
                    if (cb[i].isChecked()) {


                        alarm_content alarmContent=new alarm_content(title.getText().toString(),hrs_certain[i].getText().toString(),titles[i]);
                        dbHandler.addAlarm(alarmContent);

//                        Calendar now = Calendar.getInstance();
//
//                        int min;
//                        Calendar inter = Calendar.getInstance();
//                        String string=hrs_certain[i].getText().toString();
//                        int indexofspecial=-1;
//                        if(string.contains(":")) {
//                            indexofspecial = string.indexOf(':');
//                            min = Integer.parseInt(string.substring(indexofspecial + 1, string.length()));
//                        }
//                        else {
//                            indexofspecial=string.length();
//                            min=0;
//                        }
//                        int hr=Integer.parseInt(string.substring(0,indexofspecial));
//
//
//
//
//                        inter.set(0, 0, 1, hr, min, 0);
//
//                        Intent intent = new Intent(getActivity().getBaseContext(), AlarmReceiver.class);
//                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), RQS_1, intent, 0);
//                        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
////        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
//                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, now.getTimeInMillis(), inter.getTimeInMillis(), pendingIntent);
                    }
                }
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content,new schedule())
                        .commit();
                getDialog().dismiss();
            }

        });

    }



}
