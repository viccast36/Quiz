package com.example.quizpop;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import android.widget.Toast;

public class QuizActivityFragment extends Fragment {

    Context context;
    int count = 10;
    boolean picked0, picked1,picked2,picked3;
    boolean isCorrectA, isCorrectB, isCorrectC, isCorrectD;
    String[] answers;
    int questionsCorrect=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup  root =  (ViewGroup) inflater.inflate(R.layout.quiz_fragment, container, false);
        TextView question = root.findViewById(R.id.question_Text);
        Button choiceA = root.findViewById(R.id.choiceA);
        Button choiceB = root.findViewById(R.id.choiceB);
        Button choiceC = root.findViewById(R.id.choiceC);
        Button choiceD = root.findViewById(R.id.choiceD);
        picked0=false; picked1=false; picked2=false; picked3=false;
        isCorrectA=false; isCorrectB=false; isCorrectC=false; isCorrectD=false;
        answers = new String[4];
        answers[0] = "Hello";
        answers[1] = "Bye";
        answers[2] = "anotheranswer";
        answers[3] = "boogieMan";
        String word = getMultipleChoiceText();
        choiceA.setText(word);
        word = getMultipleChoiceText();
        choiceB.setText(word);
        word = getMultipleChoiceText();
        choiceC.setText(word);
        word = getMultipleChoiceText();
        choiceD.setText(word);
        context = root.getContext();

        choiceA.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                count--;
                if (count == 0 )
                {
                    if(isCorrectA)
                    {
                        questionsCorrect++;
                    }
                    callResultsPage();
                }
                else
                {
                    if(isCorrectA)
                    {
                        questionsCorrect++;
                    }
                    callNextQuestion();
                }

            }
        });

        choiceB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                count--;
                if (count == 0 )
                {
                    if(isCorrectB)
                    {
                        questionsCorrect++;
                    }
                    callResultsPage();
                }
                else
                {
                    if(isCorrectB)
                    {
                        questionsCorrect++;
                    }
                    callNextQuestion();
                }
            }
        });
        choiceC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                count--;
                if (count == 0 )
                {
                    if(isCorrectC)
                    {
                        questionsCorrect++;
                    }
                    callResultsPage();
                }
                else
                {
                    if(isCorrectC)
                    {
                        questionsCorrect++;
                    }
                    callNextQuestion();
                }
            }
        });
        choiceD.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                count--;
                if (count == 0 )
                {
                    if(isCorrectD)
                    {
                        questionsCorrect++;
                    }
                    callResultsPage();
                }
                else
                {
                    if(isCorrectD)
                    {
                        questionsCorrect++;
                    }
                    callNextQuestion();
                }
            }
        });

        return root;
    }

    public void callNextQuestion()
    {
        Fragment nextQuestion = new QuizActivityFragment();

        //FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.quiz_fragment, nextQuestion);

        fragmentTransaction.commit();
    }

    public void callResultsPage()
    {
        Intent intent = new Intent(context, QuizResultsPageActivity.class);
        startActivity(intent);
    }

    public String getMultipleChoiceText() {

     Random rand = new Random();
    while(!(picked0 && picked1 && picked2 && picked3))
    {

        int n = rand.nextInt(97);
        n = n%4;
        if(n == 0 && picked0 == false)
        {
            picked0 = true;
            return answers[n];
        }
        else if(n == 1 && picked1 ==false)
        {
            picked1 = true;
            return answers[n];
        }
        else if(n==2 && picked2 == false)
        {
            picked2 = true;
            return answers[n];
        }
        else if(n==3 && picked3 == false)
        {
            picked3 = true;
            return answers[n];
        }

        //return answers[n];
    }
    return null;
    }

}
