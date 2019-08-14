package com.example.quizpop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class QuizResultsPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //
        //should be quizactivity


        setContentView(R.layout.quiz_results_page_activity);
        TextView results = findViewById(R.id.results_after_quiz_textview);


    }
}
