package com.example.note_cybage_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseClass extends SQLiteOpenHelper {

    Context context;
    private static final String DatabaseName = "MyNotes";
    private static final int DatabaseVersion = 1;

    private static final String TableName = "mynotes";
    private static final String ColumnId = "id";
    private static final String ColumnTitle = "title";
    private static final String ColumnDescription = "description";



    public DatabaseClass(@Nullable Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE "+ TableName +
                " ("+ColumnId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ColumnTitle + " TEXT, "+
                ColumnDescription + " TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(sqLiteDatabase);
    }

    void addNotes(String title, String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(ColumnTitle,title);
    }

}














