package com.example.yesilarsiv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class veritabani extends SQLiteOpenHelper {

    public veritabani(@Nullable Context context) {
        super(context, "arsiv.sqlite",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE arsiv (notId INTEGER PRIMARY KEY AUTOINCREMENT, textViewNot TEXT );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS arsiv");
        onCreate(db);

    }
}
