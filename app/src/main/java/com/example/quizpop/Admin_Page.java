package com.example.quizpop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Page extends AppCompatActivity {

    private Button Add_Question;
    private Button Take_Quiz;
    private Button n_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   //initialises an activity;
        setContentView(R.layout.admin_page);

        getSupportActionBar().setTitle("Admin Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Add_Question = (Button) findViewById(R.id.button1);

        Add_Question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Add_Questions. class)
                        ; //Used to launch the activity;
                startActivity(intent);
            }
        });

    }
}
