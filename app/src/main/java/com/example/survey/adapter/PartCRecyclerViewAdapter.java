package com.example.survey.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.survey.R;
import com.example.survey.model.Question;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PartCRecyclerViewAdapter extends RecyclerView.Adapter<PartCRecyclerViewAdapter.ViewHolder> {

    List<Question> questions;
    public static OnItemClickListener sOnItemClickListener;
    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public PartCRecyclerViewAdapter(List<Question> questions, OnItemClickListener onItemClickListener) {
        if(questions==null){
            this.questions =new ArrayList<Question>();
        }
        else {
            this.questions = questions;
        }
        this.sOnItemClickListener=onItemClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Question question= questions.get(position);


    }

    @Override
    public int getItemCount() {
        if(questions==null){
            return 0;
        }
        else
            return questions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView question;
        public RadioButton option1,option2,option3,option4,option5,option6;
        public LinearLayout mLinearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.questionTextView);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
            option5 = itemView.findViewById(R.id.option5);
            option6 = itemView.findViewById(R.id.option6);
            mLinearLayout = itemView.findViewById(R.id.itemLinearView);

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= PartCRecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position);
                }
            });
            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= PartCRecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position);
                }
            });
            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= PartCRecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position);
                }
            });
            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= PartCRecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position);
                }
            });
            option5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= PartCRecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position);
                }
            });
            option6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= PartCRecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position);
                }
            });

        }

    }

}