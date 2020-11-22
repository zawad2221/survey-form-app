package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.survey.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    ViewModel mViewModel;
    RecyclerViewAdapter partBRecyclerViewAdapter,partCRecyclerViewAdapter;
    RecyclerView recyclerViewB,recyclerViewC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewB = findViewById(R.id.partBRecyclerView);
        recyclerViewC = findViewById(R.id.partCRecyclerView);
        mViewModel = new ViewModelProvider(this,new ViewModelFactory(this.getApplication(),"test")).get(ViewModel.class);
        mViewModel.init();
        initPartBRecyclerView();
        initPartCRecyclerView();
    }

    private void initPartBRecyclerView(){
        partBRecyclerViewAdapter = new RecyclerViewAdapter(mViewModel.questionsB, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, int option) {
                Toast.makeText(getApplicationContext(),mViewModel.questionsB.get(position).getQuestion()+option,Toast.LENGTH_LONG).show();
            }
        });
        recyclerViewB.setHasFixedSize(true);
        recyclerViewB.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewB.setAdapter(partBRecyclerViewAdapter);

    }
    private void initPartCRecyclerView(){
        partCRecyclerViewAdapter = new RecyclerViewAdapter(mViewModel.questionsC, new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, int option) {
                Toast.makeText(getApplicationContext(),mViewModel.questionsC.get(position).getQuestion()+option,Toast.LENGTH_LONG).show();
            }
        });
        recyclerViewC.setHasFixedSize(true);
        recyclerViewC.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewC.setAdapter(partCRecyclerViewAdapter);

    }
}