package com.example.quizpop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Sign_Up extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    private Button m_btnSignup2;
    public String item;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        m_btnSignup2 = (Button) findViewById(R.id.btnSignup2);
        spinner = (Spinner) findViewById(R.id.spinner);

        List<String> level = new ArrayList<>();

        level.add(0, "Select Level");
        level.add("Level 1 - Admin");
        level.add("Level 2 - User");

        ArrayAdapter<String> data;
        data = new ArrayAdapter(this, android.R.layout.simple_spinner_item, level);
        data.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(data);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                if (parent.getItemAtPosition(position).equals("Select Level")) {
                    System.out.println("SSSSSSSSSSSSSSSSSS");
                } else {
                    item = parent.getItemAtPosition(position).toString();
                    System.out.println("SSSSSSSSSSSSSSSSSS");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        m_btnSignup2.setOnClickListener(new View.OnClickListener() { //This method gets executed when the Sign Me Up! button is clicked in the Sign Up Screen;
            @Override
            public void onClick(View v) {

                EditText UserName2 = (EditText) findViewById(R.id.txtUserName2);    //casting the data fields to edit text;
                EditText Password2 = (EditText) findViewById(R.id.txtPassword2);
                EditText RePassword2 = (EditText) findViewById(R.id.txtRe_Password);
                EditText Email = (EditText) findViewById(R.id.txtEmail);
                EditText Phone = (EditText) findViewById(R.id.numPhone);

                String Uname2 = UserName2.getText().toString();             // converting the data fields to string;
                String Pass2 = Password2.getText().toString();
                String RePass2 = RePassword2.getText().toString();
                String Email2 = Email.getText().toString();
                String Phone2 = Phone.getText().toString();

                if (Uname2.isEmpty())  //checks if the user name field is empty, if true, a toast message is passed;
                {

                    Toast.makeText(getApplicationContext(), "User Name field must be filled", Toast.LENGTH_LONG).show();
//                    Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                    startActivity(intent1);
                }

                else if(Pass2.isEmpty())  //checks if the entered password field is empty or not, based on hashmap key-value pair;
                {
                    Toast.makeText(getApplicationContext(), "Password field must be filled", Toast.LENGTH_LONG).show();
//                   Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                   startActivity(intent1);
                }

                else if(RePass2.isEmpty())     // checks if the retype-password is empty, if true, an error message is passed;
                {
                    Toast.makeText(getApplicationContext(), "Retype-Password must be filled", Toast.LENGTH_LONG).show();
//                    Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                    startActivity(intent1);
                }

                else if(!Pass2.equals(RePass2))  // checks if the retype-password and user password data matches, if false, a toast message is passed;
                {
                    Toast.makeText(getApplicationContext(), "Password doesn't match with Retype-Password", Toast.LENGTH_LONG).show();
//                    Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                    startActivity(intent1);
                }

                else if (Pass2.length() < 8) {   //checks if the entered password in the sign up window is more than 8 characters, if false, a toast message is passed;
                    Toast.makeText(getApplicationContext(), "Password minimum 8 characters", Toast.LENGTH_LONG).show();
//                    Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                    startActivity(intent1);
                }

                else if(Email2.isEmpty())  //checks if email id feild is empty, if true, a toast message is passed;
                {
                    Email.setError("Email field must be filled");
//                    Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                    startActivity(intent1);

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(Email2).matches()) //checks if the email id is in the correct format or not, if not toast message is passed;;
                {
                    Toast.makeText(getApplicationContext(), "Invalid Email Id format", Toast.LENGTH_LONG).show();
//                    Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                    startActivity(intent1);

                }

                else if(Phone2.isEmpty()) //checks if the phone number feild is empty or not;
                {
                    Toast.makeText(getApplicationContext(), "Phone number field must be filled", Toast.LENGTH_LONG).show();
//                    Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                    startActivity(intent1);
                }
                else if(Phone2.length()!=10)   //checks if the phone number has 10 characters, else, a toast message is passed;
                {
                    Toast.makeText(getApplicationContext(), "Invalid Phone number format", Toast.LENGTH_LONG).show();
//                    Intent intent1 = new Intent(getApplicationContext(), Second_Class.class);
//                    startActivity(intent1);
                }
                else {
                    User_Details ud = new User_Details();
                    ud.setUname(Uname2);
                    ud.setPassword(Pass2);
                    ud.setEmail(Email2);
                    ud.setPhone(Phone2);


                    if (item.equals("Level 1 - Admin")) {
                        ud.setIs_Admin(true);
                    } else {
                        ud.setIs_Admin(false);
                    }
                    if(helper.searchPass(Uname2)!=null)
                    {
                        Toast.makeText(Sign_Up.this, "User Name already exists", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        if (helper.search() && item.equals("Level 1 - Admin")) {
                            Toast.makeText(Sign_Up.this, "Admin already exists", Toast.LENGTH_LONG).show();
                        } else {
                            helper.insertdetails(ud);
                            Toast.makeText(getApplicationContext(), "Sign Up Successful!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Sign_Up.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }

                }


            }
        });
    }
}