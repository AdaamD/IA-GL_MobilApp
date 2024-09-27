package com.example.myapplication_ia;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendationsActivity extends AppCompatActivity {
    private RecyclerView recommendationsRecyclerView;
    private RecommendationAdapter recommendationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        recommendationsRecyclerView = findViewById(R.id.recommendationsRecyclerView);
        recommendationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Map<String, String>> recommendations = getRecommendations();
        recommendationAdapter = new RecommendationAdapter(recommendations);
        recommendationsRecyclerView.setAdapter(recommendationAdapter);
    }

    private List<Map<String, String>> getRecommendations() {
        List<Map<String, String>> recommendations = new ArrayList<>();

        Map<String, String> recommendation1 = new HashMap<>();
        recommendation1.put("title", "Apprenez les bases de la programmation");
        recommendation1.put("description", "Suivez ce cours en ligne pour apprendre les bases de la programmation en Java");
        recommendation1.put("link", "www.exemple.com/cours1");
        recommendations.add(recommendation1);

        Map<String, String> recommendation2 = new HashMap<>();
        recommendation2.put("title", "Pratiquez avec des exercices");
        recommendation2.put("description", "Faites ces exercices pour mettre en pratique vos connaissances en Java");
        recommendation2.put("link", "www.exemple.com/exercices1");
        recommendations.add(recommendation2);

        Map<String, String> recommendation3 = new HashMap<>();
        recommendation3.put("title", "Suivez des tutoriels vidéo");
        recommendation3.put("description", "Regardez ces tutoriels vidéo pour apprendre des concepts avancés en Java");
        recommendation3.put("link", "www.exemple.com/tutoriels1");
        recommendations.add(recommendation3);

        return recommendations;
    }
}
