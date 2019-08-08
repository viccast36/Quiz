package com.example.quizpop;

public class FakeUserModel {

    String username;
    int questionsCorrect;
    int questionsAttmepted;

    FakeUserModel(String uName, int questionsCorrect, int questionsAttmepted)
    {
        username=uName;
        this.questionsCorrect = questionsCorrect;
        this.questionsAttmepted=questionsAttmepted;
    }


    public String getUsername() {
        return username;
    }

    public int getQuestionsCorrect() {
        return questionsCorrect;
    }

    public int getQuestionsAttmepted() {
        return questionsAttmepted;
    }
}
