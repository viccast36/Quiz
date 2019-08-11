package com.example.quizpop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);



    private Button m_btnSignup;
    private Button m_btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   //initialises an activity;
        setContentView(R.layout.activity_main); //creates an user interface window;



        m_btnSignup = (Button) findViewById(R.id.btnSignUp);   //casting the widgets to button type;
        m_btnLogin = (Button) findViewById(R.id.btnLogin);
        m_btnSignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {   //This method gets executed when the Sign Up button is clicked in the Login Screen;
                Intent intent = new Intent(getApplicationContext(),Sign_Up. class)
                ; //Used to launch the activity;
                startActivity(intent);
            }
        });

        m_btnLogin.setOnClickListener(new View.OnClickListener() {  //This method gets executed when the Login button is clicked in the Login Screen;
            @Override
            public void onClick(View v) {

                EditText a = (EditText) findViewById(R.id.txtUserName);
                String str = a.getText().toString();               //converting user name data to string;
                EditText b = (EditText) findViewById(R.id.txtPassword);
                String pass = b.getText().toString();             //converting user password data to string;

                String Password = helper.searchPass(str);
                Boolean item = helper.searchadmin(str);

                if(str.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "User Name field must be filled", Toast.LENGTH_LONG).show();
                }
                else if(pass.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Password must be  filled", Toast.LENGTH_LONG).show();
                }
                else if(pass.equals(Password))
                {

                    if(item) {
                        Intent intent = new Intent(MainActivity.this, Admin_Page.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(MainActivity.this, User_Page.class);
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Credentials don't match", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
