package com.example.myapplication_ia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {
    private List<Map<String, String>> exercises;

    public ExerciseAdapter(List<Map<String, String>> exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise, parent, false);
        return new ExerciseViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Map<String, String> exercise = exercises.get(position);
        holder.titleTextView.setText(exercise.get("title"));
        holder.descriptionTextView.setText(exercise.get("description"));
        holder.difficultyTextView.setText(exercise.get("difficulty"));
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        TextView difficultyTextView;

        ExerciseViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.exerciseTitleTextView);
            descriptionTextView = itemView.findViewById(R.id.exerciseDescriptionTextView);
            difficultyTextView = itemView.findViewById(R.id.exerciseDifficultyTextView);
        }
    }
}
