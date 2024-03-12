package com.example.demo_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "coursedb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mycourse";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String DURATION_COL = "duration";
    private static final String DESCRIPTION_COL = "description";
    private static final String TRACK_COL = "track";
    public DBHandler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    public void addNewCourse(String courseName,String courseDuration,String courseDescription,String courseTrack){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL,courseName);
        values.put(DURATION_COL,courseDuration);
        values.put(DESCRIPTION_COL,courseDescription);
        values.put(TRACK_COL,courseTrack);
        database.insert(TABLE_NAME,null,values);
        database.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABLE_NAME + "("+ID_COL +" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME_COL+" TEXT,"+DURATION_COL+" TEXT,"+DESCRIPTION_COL+" TEXT,"+TRACK_COL+" TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
