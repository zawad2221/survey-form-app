package com.example.survey.model;

import java.util.List;

public class Question {
    public Question(String question, List<Option> option) {
        this.question = question;
        this.option = option;
    }

    private String question;
    private List<Option> option;

    public String getQuestion() {
        return question;
    }

    public List<Option> getOption() {
        return option;
    }


}
