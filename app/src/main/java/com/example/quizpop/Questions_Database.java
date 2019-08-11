package com.example.quizpop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Questions_Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "User_Details.db";
    private static final String TABLE_NAME = "Questions";
    private static final String Q_ID = "q_id";
    private static final String QUESTION = "question";
    private static final String OPTION_1= "option1";
    private static final String OPTION_2 = "option2";
    private static final String OPTION_3 = "option3";
    private static final String OPTION_4= "option4";
    private static final String ANSWER = "answer";

    SQLiteDatabase db;

    private static final String CREATE_TABLE_2 = "create table Questions (q_id integer primary key autoincrement, "+
            "question text not null, option1 text not null, option2 text not null, option3 text not null, option4 text not null, "+
            "answer text not null);";

    public Questions_Database(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertquestion(Questions qs)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QUESTION, qs.getquestion());
        values.put(OPTION_1, qs.getOption1());
        values.put(OPTION_2, qs.getOption2());
        values.put(OPTION_3, qs.getoption3());
        values.put(OPTION_4, qs.getoption4());
        values.put(ANSWER, qs.getanswer());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_2);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
