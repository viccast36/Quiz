package com.example.quizpop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class About_Us extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   //initialises an activity;
        setContentView(R.layout.about_us);

        getSupportActionBar().setTitle("Quiz Pop");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
