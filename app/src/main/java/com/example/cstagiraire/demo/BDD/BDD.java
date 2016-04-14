package com.example.cstagiraire.demo.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cstagiaire on 06/04/2016.
 */
public class BDD extends SQLiteOpenHelper {

    private static final String BD_CREATE = "create table Inscription (" +
            "Id_client int," +
            "Nom varchar(255)," +
            "Prenom varchar(255)," +
            "Ville Varchar(255)," +
            "Cp int )";
    public BDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BD_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Inscription");
        onCreate(db);
    }

}
