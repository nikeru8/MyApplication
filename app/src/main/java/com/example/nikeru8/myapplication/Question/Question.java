package com.example.nikeru8.myapplication.Question;

/**
 * Created by nikeru8 on 2016/5/19.
 */
public class Question {
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;

    // 建構子
    public Question(String question, String optionA, String optionB, String optionC) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
    }

    // getter
    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }
}



