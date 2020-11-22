package com.example.survey.model;

public class Option {
    private String name;
    private int mark;

    public Option(String name, int mark) {
        this.name=name;
        this.mark=mark;
    }
    public Option(String name) {
        this.name=name;

    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}
