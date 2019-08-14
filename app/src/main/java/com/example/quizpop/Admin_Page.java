package com.example.quizpop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_Page extends AppCompatActivity {

    private Button Add_Question;
    private Button Take_Quiz;
    private Button n_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   //initialises an activity;
        setContentView(R.layout.admin_page);


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
            Intent intent = new Intent(Admin_Page.this, About_Us.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.SignOut)
        {
            Toast.makeText(getApplicationContext(), "Sign Out Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Admin_Page.this, MainActivity.class);
            startActivity(intent);

        }
        return true;
    }
}
