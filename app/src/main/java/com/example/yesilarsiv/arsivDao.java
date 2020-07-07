package com.example.yesilarsiv;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.Normalizer;
import java.util.ArrayList;

public class arsivDao {

    public ArrayList<arsivim> tumArsivim (veritabani vt){

        ArrayList<arsivim> arsivimArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();  //veritabanına yazma izni

        Cursor c = db.rawQuery("SELECT * FROM arsiv", null);

        while (c.moveToNext()){

            arsivim a = new arsivim(c.getInt(c.getColumnIndex("notId")),c.getString(c.getColumnIndex("textViewNot")));
            arsivimArrayList.add(a);
        }
        db.close();
        return arsivimArrayList;


    }

    //arama metodu
    public ArrayList<arsivim> araArsivim (veritabani vt, String aramaNot){

        ArrayList<arsivim> arsivimArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();  //veritabanına yazma izni

        Cursor c = db.rawQuery("SELECT * FROM arsiv WHERE textViewNot like '%"+aramaNot+"%'", null);

        while (c.moveToNext()){

            arsivim a = new arsivim(c.getInt(c.getColumnIndex("notId"))
                    ,c.getString(c.getColumnIndex("textViewNot")));
            arsivimArrayList.add(a);
        }
        db.close();
        return arsivimArrayList;


    }

    //silme metodu
    public void notSil(veritabani vt, int notId){

        SQLiteDatabase db = vt.getWritableDatabase();
        db.delete("arsiv", "notId=?",new String[]{String.valueOf(notId)});
        db.close();

    }

    public void notEkle(veritabani vt, String textViewNot){

        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("textViewNot", textViewNot);

        db.insertOrThrow("arsiv", null,values);
        db.close();
    }

    public void notGuncelle(veritabani vt, int notId, String textViewNot){

        SQLiteDatabase db = vt.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("textViewNot", textViewNot);

        db.update("arsiv",values, "notId=?", new String[]{String.valueOf(notId)});
        db.close();

    }

}
