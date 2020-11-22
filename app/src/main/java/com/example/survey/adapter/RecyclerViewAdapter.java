package com.example.survey.adapter;



        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.RadioButton;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;


        import com.example.survey.R;
        import com.example.survey.model.Question;

        import java.util.ArrayList;
        import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Question> questions;
    public static OnItemClickListener sOnItemClickListener;
    public static interface OnItemClickListener {
        public void onItemClick(View view, int position,int option);
    }

    public RecyclerViewAdapter(List<Question> questions, OnItemClickListener onItemClickListener) {
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
        holder.question.setText(question.getQuestion());
        holder.option1.setText(question.getOption().get(0).getName());
        holder.option2.setText(question.getOption().get(1).getName());
        holder.option3.setText(question.getOption().get(2).getName());
        holder.option4.setText(question.getOption().get(3).getName());
        holder.option5.setText(question.getOption().get(4).getName());
        holder.option6.setText(question.getOption().get(5).getName());


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
                    int position= RecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position,1);
                }
            });
            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= RecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position,1);
                }
            });
            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= RecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position,2);
                }
            });
            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= RecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position,3);
                }
            });
            option5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= RecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position,4);
                }
            });
            option6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position= RecyclerViewAdapter.ViewHolder.super.getAdapterPosition();
                    sOnItemClickListener.onItemClick(view,position,5);
                }
            });

        }

    }

}