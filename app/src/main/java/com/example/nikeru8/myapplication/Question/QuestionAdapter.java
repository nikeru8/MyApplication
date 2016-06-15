package com.example.nikeru8.myapplication.Question;

/**
 * Created by nikeru8 on 2016/5/19.
 */
public interface QuestionAdapter {

    int getQuestionCount();

    CharSequence getQuestion(int index);
    CharSequence getQuestionOptionsA(int index);
    CharSequence getQuestionOptionsB(int index);
    CharSequence getQuestionOptionsC(int index);

}



