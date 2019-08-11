package com.example.quizpop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class User_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   //initialises an activity;
        setContentView(R.layout.user_page);

        getSupportActionBar().setTitle("User Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
