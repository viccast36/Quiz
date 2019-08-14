package com.example.quizpop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Add_Questions extends AppCompatActivity {

    Questions_Database helper = new Questions_Database(this);

    private Button upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   //initialises an activity;
        setContentView(R.layout.add_questions);

        upload = (Button)findViewById(R.id.btnUpload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText q = (EditText) findViewById(R.id.txtQuestion);
                String question = q.getText().toString();               //converting user name data to string;
                EditText op1 = (EditText) findViewById(R.id.txtOption1);
                String option1 = op1.getText().toString();
                EditText op2 = (EditText) findViewById(R.id.txtOption2);
                String option2 = op2.getText().toString();               //converting user name data to string;
                EditText op3 = (EditText) findViewById(R.id.txtOption3);
                String option3 = op1.getText().toString();
                EditText op4 = (EditText) findViewById(R.id.txtOption4);
                String option4 = op4.getText().toString();               //converting user name data to string;
                EditText ans = (EditText) findViewById(R.id.txtAnswer);
                String answer = ans.getText().toString();

                if(question.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Question field must be filled", Toast.LENGTH_LONG).show();
                }
                else if(option1.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Option 1 field must be filled", Toast.LENGTH_LONG).show();
                }
                else if(option2.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Option 2 field must be filled", Toast.LENGTH_LONG).show();
                }
                else if(option3.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Option 3 field must be filled", Toast.LENGTH_LONG).show();
                }
                else if(option4.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Option 4 field must be filled", Toast.LENGTH_LONG).show();
                }
                else if(answer.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Answer field must be filled", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Questions qs = new Questions();
                    System.out.println(question);
                    qs.setquestion(question);
                    qs.setoption1(option1);
                    qs.setOption2(option2);
                    qs.setOption3(option3);
                    qs.setOption4(option4);
                    qs.setanswer(answer);
                    helper.insertquestion(qs);
                    Toast.makeText(getApplicationContext(), "Upload Successful!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Add_Questions.this, Admin_Page.class);
                    startActivity(intent);
                }

                getSupportActionBar().setTitle("Add Question Page");
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.AboutUs)
        {
            Intent intent = new Intent(Add_Questions.this, About_Us.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.SignOut)
        {
            Toast.makeText(getApplicationContext(), "Sign Out Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Add_Questions.this, MainActivity.class);
            startActivity(intent);

        }
        return true;
    }
}
