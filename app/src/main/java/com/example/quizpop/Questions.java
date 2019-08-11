package com.example.quizpop;

public class Questions {

    int q_id;
    String question, option1, option2, option3, option4, answer;

    public void setq_id(int q_id)
    {
        this.q_id = q_id;
    }

    public int getq_id()
    {
        return q_id;
    }

    public void setquestion(String question)
    {
        this.question = question;
    }

    public String getquestion()
    {
        return question;
    }

    public void setoption1(String option1)
    {
        this.option1 = option1;
    }

    public String getOption1()
    {
        return option1;
    }

    public void setOption2(String option2)
    {
        this.option2 = option2;
    }

    public String getOption2()
    {
        return option2;
    }

    public void setOption3(String option3)
    {
        this.option3 = option3;
    }

    public String getoption3()
    {
        return option3;
    }

    public void setOption4(String option4)
    {
        this.option4 = option4;
    }

    public String getoption4()
    {
        return option4;
    }

    public void setanswer(String answer)
    {
        this.answer = answer;
    }

    public String getanswer()
    {
        return answer;
    }

}
