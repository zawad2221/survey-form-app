package com.example.survey;

import android.content.Context;

import com.example.survey.model.Answer;
import com.example.survey.model.Option;
import com.example.survey.model.Question;
import com.example.survey.model.Response;

import java.util.ArrayList;
import java.util.List;

public class ViewModel extends androidx.lifecycle.ViewModel {
    public List<Question> questionsB;
    public List<Question> questionsC;
    public List<Option> partB;
    public List<Option> partB26;
    public List<Option> partC;


    public Response response;
    private List<Answer> answers;



    public void saveResponse(Context context, Response response){
        ResponseRepository responseRepository = ResponseRepository.getInstance();
        responseRepository.saveResponse(context,response);
    }


    public void init(){
        response = new Response();
        answers = new ArrayList<>();
        for(int index=1;index<32;index++){
            answers.add(new Answer(String.valueOf(index),""));
        }
        response.setAnswers(answers);

        partB = new ArrayList<Option>();
        partB26 = new ArrayList<Option>();
        partC = new ArrayList<Option>();
        questionsB = new ArrayList<Question>();
        questionsC = new ArrayList<Question>();

        partB.add(new Option("Always",3));
        partB.add(new Option("Usually",2));
        partB.add(new Option("Often",1));
        partB.add(new Option("Sometimes",0));
        partB.add(new Option("Rarely",0));
        partB.add(new Option("Never",0));

        partB26.add(new Option("Always",0));
        partB26.add(new Option("Usually",0));
        partB26.add(new Option("Often",0));
        partB26.add(new Option("Sometimes",1));
        partB26.add(new Option("Rarely",2));
        partB26.add(new Option("Never",3));

        partC.add(new Option("Never"));
        partC.add(new Option("Once a month or less"));
        partC.add(new Option("2-3 times a month"));
        partC.add(new Option("once a week"));
        partC.add(new Option("2-6 times a week"));
        partC.add(new Option("Once a day or more"));

        //part b question
        questionsB.add(new Question("1. I am terrified about being overweight.",partB));
        questionsB.add(new Question("2. Avoid eating when I am hungry.",partB));
        questionsB.add(new Question("Find myself preoccupied with food",partB));
        questionsB.add(new Question("I have gone on eating binges where I feel that I may not be able to stop *",partB));
        questionsB.add(new Question("Cut my food into small pieces",partB));
        questionsB.add(new Question("Aware of the calorie content of foods that I eat.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB));
        questionsB.add(new Question("Am terrified about being overweight.",partB26));


        //part c question
        questionsC.add(new Question("A. Gone on eating binges where I feel that I may not be able to stop? *",partC));
        questionsC.add(new Question("Am terrified about being overweight.",partC));
        questionsC.add(new Question("Am terrified about being overweight.",partC));
        questionsC.add(new Question("Am terrified about being overweight.",partC));


    }
}
