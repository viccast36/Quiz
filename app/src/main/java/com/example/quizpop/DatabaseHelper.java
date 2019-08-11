package com.example.quizpop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "User_Details.db";
    private static final String TABLE_NAME = "User_Details";
    private static final String ID = "id";
    private static final String USER_NAME = "user_name";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String IS_ADMIN = "is_admin";
    private static final String QUESTIONS_CORRECT = "questions_correct";
    private static final String QUESTIONS_ATTEMPTED = "questions_attempted";


    SQLiteDatabase db;
    private static final String TABLE_CREATE_1 = "create table User_Details (id integer primary key autoincrement, " +
            "user_name text not null, password text not null, email text not null, phone text not null, is_admin boolean not null);";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertdetails(User_Details ud)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, ud.getUname());
        values.put(PASSWORD, ud.getPassword());
        values.put(EMAIL, ud.getEmail());
        values.put(PHONE, ud.getPhone());
        values.put(IS_ADMIN, ud.getIs_Admin());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public boolean search()
    {
        db = this.getReadableDatabase();
        String query = "Select "+IS_ADMIN+" from "+TABLE_NAME+" where is_admin = "+1;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.getCount()>0)
        {
            return true;
        }
        return false;
    }

    public String searchPass(String user_name)
    {
        db = this.getReadableDatabase();
        String query = "Select user_name, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b=null;
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(user_name))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());

        }
        return b;
    }

    public boolean searchadmin(String user_name)
    {
        db = this.getReadableDatabase();
        String query = "Select user_name, is_admin from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a;
        boolean b=false;
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(user_name))
                {
                    b = cursor.getInt(1)>0;
                    break;
                }
            }
            while(cursor.moveToNext());

        }
        return b;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE_1);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
