package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vaibhav on 9/10/16.
 */
public class adapter_alarm extends ArrayAdapter<alarm_content> {

    public adapter_alarm(Context context, ArrayList<alarm_content> list)
    {
        super(context,0,list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        alarm_content alarm=getItem(position);


        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.single_element,parent,false);

        }
        TextView title=(TextView)convertView.findViewById(R.id.title);
        TextView time=(TextView)convertView.findViewById(R.id.time);
        TextView repeat=(TextView)convertView.findViewById(R.id.repeating_stat);

        title.setText(alarm.title);
        time.setText(alarm.time);
        repeat.setText(alarm.repeating_stat);

        return convertView;


    }
}