package com.example.mccomasgymshare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String WORKOUT_TABLE = "WORKOUT_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TITLE = "TITLE";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "workouts.db", null, 1);
    }

    // called the first time a database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + WORKOUT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT)";

        db.execSQL(createTableStatement);

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, "Beginner-Abs");
        cv.put(COLUMN_DESCRIPTION, "10 crunches\n10 air bike crunches\n10 sitting twists");
        db.insert(WORKOUT_TABLE, null, cv);

        cv = new ContentValues();
        cv.put(COLUMN_TITLE, "Beginner-Legs");
        cv.put(COLUMN_DESCRIPTION, "10 squats\n10 calf raises\n10 lunges");
        db.insert(WORKOUT_TABLE, null, cv);

        cv = new ContentValues();
        cv.put(COLUMN_TITLE, "Beginner-Chest");
        cv.put(COLUMN_DESCRIPTION, "10 bench press\n10 push ups\n10 incline press");
        db.insert(WORKOUT_TABLE, null, cv);
    }

    // called if the database version number changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Workout> getWorkouts() {
        List<Workout> result = new ArrayList<>();
        String queryString = "SELECT * FROM " + WORKOUT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst())
        {
            // loop through results and create Workout objects
            do {
                int workoutID = cursor.getInt(0);
                String workoutTitle = cursor.getString(1);
                String workoutDescription = cursor.getString(2);
                Workout workout = new Workout(workoutID, workoutTitle, workoutDescription);
                result.add(workout);
            } while (cursor.moveToNext());
        }
        else
        {
            // don't add anything to the list
        }

        cursor.close();
        db.close();
        return result;
    }
}
