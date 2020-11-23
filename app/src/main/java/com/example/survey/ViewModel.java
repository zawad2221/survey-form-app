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
        questionsB.add(new Question("2. I avoid eating when I am hungry.",partB));
        questionsB.add(new Question("3. Find myself preoccupied with food",partB));
        questionsB.add(new Question("4. I have gone on eating binges where I feel that I may not be able to stop *",partB));
        questionsB.add(new Question("5. Cut my food into small pieces",partB));
        questionsB.add(new Question("6. I aware of the calorie content of foods that I eat.",partB));
        questionsB.add(new Question("7. I particularly avoid food with a high carbohydrate content (i.e. bread, rice, potatoes, etc.",partB));
        questionsB.add(new Question("8. I feel that others would prefer if I ate more.",partB));
        questionsB.add(new Question("9. I vomit after I have eaten. ",partB));
        questionsB.add(new Question("10. I feel extremely guilty after eating. ",partB));
        questionsB.add(new Question("11. I am preoccupied with a desire to be thinner.",partB));
        questionsB.add(new Question("12. I think about burning up calories when I exercise.",partB));
        questionsB.add(new Question("13. Other people think that I am too thin.",partB));
        questionsB.add(new Question("14. I am preoccupied with the thought of having fat on my body.",partB));
        questionsB.add(new Question("15. I take longer than others to eat my meals.",partB));
        questionsB.add(new Question("16. I avoid foods with sugar in them.",partB));
        questionsB.add(new Question("17. I eat diet foods.",partB));
        questionsB.add(new Question("18. I feel that food controls my life.",partB));
        questionsB.add(new Question("19. I display self-control around food.",partB));
        questionsB.add(new Question("20. I feel that others pressure me to eat.",partB));
        questionsB.add(new Question("21. I give too much time and thought to food.",partB));
        questionsB.add(new Question("22. I feel uncomfortable after eating sweets.",partB));
        questionsB.add(new Question("23. I engage in dieting behavior.",partB));
        questionsB.add(new Question("24. I like my stomach to be empty.",partB));
        questionsB.add(new Question("25. I have the impulse to vomit after meals.",partB));
        questionsB.add(new Question("26. I enjoy trying new rich foods.",partB26));


        //part c question
        questionsC.add(new Question("A. Gone on eating binges where I feel that I may not be able to stop? *",partC));
        questionsC.add(new Question("B. Ever made myself sick (vomited) to control my weight or shape?",partC));
        questionsC.add(new Question("C. Ever used laxatives, diet pills or diuretics (water pills) to control my weight or shape?",partC));
        questionsC.add(new Question("D. Exercised more than 60 minutes a day to lose or to control my weight? ",partC));



    }
}
