package com.example.quizpop;

public class User_Details {
    int id, Questions_Correct, Questions_Attempted;
    boolean Is_Admin;
    String Uname, Password, Email, Phone;

    public void setUname(String Uname)
    {
        this.Uname = Uname;
    }

    public String getUname()
    {
        return Uname;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setPhone(String Phone)
    {
        this.Phone = Phone;
    }

    public String getPhone()
    {
        return Phone;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getid()
    {
        return id;
    }
//
    public void setIs_Admin(boolean Is_Admin)
    {
        this.Is_Admin = Is_Admin;
    }

    public boolean getIs_Admin()
    {
        return Is_Admin;
    }


}
