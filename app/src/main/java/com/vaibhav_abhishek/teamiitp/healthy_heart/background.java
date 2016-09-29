package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by vaibhav on 14/8/16.
 */
public class background extends AsyncTask<String,Void,String>
{
    public String result,what;
    private Context context;
    private String page;

    public boolean check_end;

    background(Context context)
    {
        result="";
        this.context=context;

    }

    @Override
    protected String doInBackground(String... strings)
    {


       what = strings[0];
        String data;
        if(what.equals("login")) {
            String line;
            String username;
            String password;
            username = strings[1];
            password = strings[2];
            page = "http://babaplant.com/app_php/login.php";

            try {
              URL  url = new URL(page);

            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();



            data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                    URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));
            bw.write(data);
            bw.flush();
            bw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((line = br.readLine()) != null)
                result = result + line;
            br.close();


        } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(what.equals("register"))
        {        page = "http://babaplant.com/app_php/register.php";
            try {
                URL url=new URL(page);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                String username,password,name,phone;
                username=strings[2];
                password=strings[3];
                name=strings[1];
                phone=strings[4];
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                data =URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8");
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line;
                while ((line=bufferedReader.readLine())!=null)
                {
                    result=result+line;
                }
                bufferedReader.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return result;

    }

    @Override
    protected void onPreExecute() {
        /////
    }

    @Override
    protected void onPostExecute(String s) {

         if(what.equals("login"))
         {
             if(result.equals("login success"))
             {
                 Intent i =new Intent("com.incals.vaibhav.incals.main_content");
                 context.startActivity(i);
             }else
             {
                 Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
             }
         }
        else if(what.equals("register"))
         {
             if(result.equals("register success"))
             {   Toast.makeText(context,"registered successfully...",Toast.LENGTH_SHORT).show();
                 Intent i =new Intent("com.incals.vaibhav.incals.login");
                 context.startActivity(i);
             }
             else
             {
                 Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
             }
         }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        ///
    }
}
