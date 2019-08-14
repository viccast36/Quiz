package com.example.quizpop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   //initialises an activity;
        setContentView(R.layout.user_page);

        getSupportActionBar().setTitle("User Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
            Intent intent = new Intent(User_Page.this, About_Us.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.SignOut)
        {
            Toast.makeText(getApplicationContext(), "Sign Out Successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(User_Page.this, MainActivity.class);
            startActivity(intent);

        }
        return true;
    }
}
