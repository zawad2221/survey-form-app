package com.example.survey;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.survey.adapter.PartCRecyclerViewAdapter;
import com.example.survey.adapter.RecyclerViewAdapter;
import com.example.survey.model.Answer;

public class MainActivity extends AppCompatActivity {

    ViewModel mViewModel;
    RecyclerViewAdapter partBRecyclerViewAdapter;
    PartCRecyclerViewAdapter partCRecyclerViewAdapter;
    RecyclerView recyclerViewB,recyclerViewC;
    Button submit;
    EditText emailEditText, ageEditText, heightEditText, weightEditText;
    RadioButton genderMale,genderFemale,questionERadioYes,questionERadioNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewB = findViewById(R.id.partBRecyclerView);
        recyclerViewC = findViewById(R.id.partCRecyclerView);
        submit = findViewById(R.id.submitButton);

        emailEditText = findViewById(R.id.inputTextEmail);
        ageEditText = findViewById(R.id.inputTextAge);
        heightEditText = findViewById(R.id.inputTextHeight);
        weightEditText = findViewById(R.id.inputTextWeight);
        genderFemale = findViewById(R.id.radioButtonFemale);
        genderMale = findViewById(R.id.radioButtonMale);
        questionERadioYes = findViewById(R.id.radioButtonQuestionEYes);
        questionERadioNo = findViewById(R.id.radioButtonQuestionENo);


        mViewModel = new ViewModelProvider(this,new ViewModelFactory(this.getApplication(),"test")).get(ViewModel.class);
        mViewModel.init();
        initPartBRecyclerView();
        initPartCRecyclerView();
        submitOnClick();
    }

    private void submitOnClick(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mViewModel.response.setAge(Integer.parseInt(ageEditText.getText().toString()));
                }
                catch (Exception e){

                }
                try{
                    mViewModel.response.setWeight(Double.parseDouble(weightEditText.getText().toString()));
                }
                catch (Exception e){

                }
                mViewModel.response.setEmail(emailEditText.getText().toString());

                mViewModel.response.setHeight(heightEditText.getText().toString());
                if(genderMale.isChecked()){
                    mViewModel.response.setGender("Male");
                }
                else if(genderFemale.isChecked()){
                    mViewModel.response.setGender("Female");
                }

                if(questionERadioYes.isChecked()){
                    mViewModel.response.getAnswers().get(mViewModel.response.getAnswers().size()-1).setAnswer("Yes");
                }
                else if(questionERadioNo.isChecked()){
                    mViewModel.response.getAnswers().get(mViewModel.response.getAnswers().size()-1).setAnswer("No");
                }


                int totalMark=0;
                for(Answer answer : mViewModel.response.getAnswers()){
                    try{
                        totalMark+=answer.getMark();
                        Log.d("MainActivity","question "+answer.getQuestionNumber()+" mark "+answer.getMark());
                    }
                    catch (Exception e){

                    }
                }
                mViewModel.response.setMark(totalMark);
                mViewModel.saveResponse(getApplicationContext(),mViewModel.response);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Your Mark: "+totalMark);
                alertDialog.setCancelable(true);
                alertDialog.show();

            }
        });
    }

    private void initPartBRecyclerView(){
        partBRecyclerViewAdapter = new RecyclerViewAdapter(mViewModel.questionsB, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, int option) {
                Toast.makeText(getApplicationContext(),mViewModel.questionsB.get(position).getQuestion()+option,Toast.LENGTH_LONG).show();
                mViewModel.response.getAnswers().get(position).setAnswer(mViewModel.questionsB.get(position).getOption().get(option).getName());
                mViewModel.response.getAnswers().get(position).setMark(mViewModel.questionsB.get(position).getOption().get(option).getMark());

            }
        });
        recyclerViewB.setHasFixedSize(true);
        recyclerViewB.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewB.setAdapter(partBRecyclerViewAdapter);

    }
    private void initPartCRecyclerView(){
        partCRecyclerViewAdapter = new PartCRecyclerViewAdapter(mViewModel.questionsC, new PartCRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, int option) {
                Toast.makeText(getApplicationContext(),mViewModel.questionsC.get(position).getQuestion()+mViewModel.response.getAnswers().get(position+26).getQuestionNumber(),Toast.LENGTH_LONG).show();
                mViewModel.response.getAnswers().get(position+26).setAnswer(mViewModel.questionsC.get(position).getOption().get(option).getName());
                mViewModel.response.getAnswers().get(position+26).setMark(mViewModel.questionsC.get(position).getOption().get(option).getMark());

            }
        });
        recyclerViewC.setHasFixedSize(true);
        recyclerViewC.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewC.setAdapter(partCRecyclerViewAdapter);

    }
}