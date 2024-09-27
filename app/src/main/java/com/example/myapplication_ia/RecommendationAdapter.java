package com.example.myapplication_ia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder> {
    private List<Map<String, String>> recommendations;

    public RecommendationAdapter(List<Map<String, String>> recommendations) {
        this.recommendations = recommendations;
    }

    @NonNull
    @Override
    public RecommendationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommendation, parent, false);
        return new RecommendationViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecommendationViewHolder holder, int position) {
        Map<String, String> recommendation = recommendations.get(position);
        holder.titleTextView.setText(recommendation.get("title"));
        holder.descriptionTextView.setText(recommendation.get("description"));
        holder.linkTextView.setText(recommendation.get("link"));
    }

    @Override
    public int getItemCount() {
        return recommendations.size();
    }

    static class RecommendationViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        TextView linkTextView;

        RecommendationViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.recommendationTitleTextView);
            descriptionTextView = itemView.findViewById(R.id.recommendationDescriptionTextView);
            linkTextView = itemView.findViewById(R.id.recommendationLinkTextView);
        }
    }
}

