package com.vaibhav_abhishek.teamiitp.healthy_heart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by vaibhav on 9/10/16.
 */
public class DbHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "alarm_scheduling";
    public final String TABLE_NAME = "table_alarm";
    public final String TITLE = "title";
    public final String TIME = "time";
    public static final int DB_VERSION = 1;
    public final String REPEATING = "repeating";

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.d("create: ", "creating db");

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + TITLE + " TEXT, " + TIME + " TEXT, " + REPEATING + " TEXT )";
        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(sqLiteDatabase);


    }

    public void addAlarm(alarm_content alarmContent) {
        Log.d("adding", "adding alarm");
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, alarmContent.title);
        contentValues.put(TIME, alarmContent.time);
        contentValues.put(REPEATING, alarmContent.repeating_stat);
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

    }

    public ArrayList<alarm_content> getAlarm() {
        Log.d("getting list: ", "getting");
        ArrayList<alarm_content> alarm_data = new ArrayList<alarm_content>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                alarm_content alarmContent = new alarm_content(cursor.getString(0), cursor.getString(1), cursor.getString(2));
                alarm_data.add(alarmContent);
            } while (cursor.moveToNext());

        }
        cursor.close();
        Log.d("return: ", "ready to return");

        return alarm_data;
    }

    public void delete_alarm(String to_be_deleted)
    {
        Log.d("Deleting: ","preparing to delete "+to_be_deleted);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,TITLE+" = ? ",new String[]{to_be_deleted});
        Log.d("Deleting: ","deleted");


    }
}
