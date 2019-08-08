package com.example.quizpop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


//chrashes when back is pressed
public class QuizActivity  extends AppCompatActivity {
    int practice;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //should be quizactivity
        setContentView(R.layout.quiz_fragment);
        TextView question = findViewById(R.id.question_Text);
        Button choiceA = findViewById(R.id.choiceA);
        Button choiceB = findViewById(R.id.choiceB);
        Button choiceC = findViewById(R.id.choiceC);
        Button choiceD = findViewById(R.id.choiceD);

    }

}
