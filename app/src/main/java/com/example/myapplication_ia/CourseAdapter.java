package com.example.myapplication_ia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private List<Map<String, String>> courses;

    public CourseAdapter(List<Map<String, String>> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Map<String, String> course = courses.get(position);
        holder.titleTextView.setText(course.get("title"));
        holder.descriptionTextView.setText(course.get("description"));
        holder.durationTextView.setText(course.get("duration"));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        TextView durationTextView;

        CourseViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.courseTitleTextView);
            descriptionTextView = itemView.findViewById(R.id.courseDescriptionTextView);
            durationTextView = itemView.findViewById(R.id.courseDurationTextView);
        }
    }
}
