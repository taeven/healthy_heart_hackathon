package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class bmi_calculator extends Fragment {

    EditText weight,height;
    Button calculate;
    String wgt,hgt;
    TextView result1,result2;
    float w,h,bmi_cal;

    public bmi_calculator() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_bmi_calculator, container, false);

        weight=(EditText)v.findViewById(R.id.weight);
        height=(EditText)v.findViewById(R.id.height);
        calculate=(Button)v.findViewById(R.id.calculate);
        result1=(TextView)v.findViewById(R.id.view_result_1);
        result2=(TextView)v.findViewById(R.id.view_result_2) ;

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wgt=weight.getText().toString();
                hgt=height.getText().toString();
                if(wgt.isEmpty()) {
                    result1.setText("Enter the weight");
                    result2.setText(" ");
                }
                else if(hgt.isEmpty()) {
                    result1.setText("Enter the height");

                    result2.setText(" ");
                }
                else
                {
                    w=Float.parseFloat(wgt);
                    h=Float.parseFloat(hgt);
                    bmi_cal=calculateBMI(w,h);

                    result1.setText("BMI : "+ bmi_cal );
                    result2.setText(interpretBMI(bmi_cal));

                }

            }
        });


        return v;
    }



    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }

}
