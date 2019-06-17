package com.hitallow.appminhassenhas.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NAME_DATABASE = "passwords.db";
    private static final int VERSION_DATABASE = 1;
    private Context context;
    private SQLiteDatabase db = null;

    public DBHelper(Context context){
        super(context , NAME_DATABASE , null , VERSION_DATABASE);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table users ( id integet primary key autoincrement, name text not null, senha text not null, username text not null )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users;");
        db.execSQL("drop table if exists passwords");
        this.onCreate(db);
    }
}
