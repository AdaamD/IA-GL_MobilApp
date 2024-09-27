package com.example.myapplication_ia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class StudentDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        // Récupérez les références aux vues
        MaterialCardView coursesCard = findViewById(R.id.coursesCard);
        MaterialCardView exercisesCard = findViewById(R.id.exercisesCard);
        MaterialCardView recommendationsCard = findViewById(R.id.recommendationsCard);

        // Définissez les actions pour chaque bouton
        coursesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les cours
                startActivity(new Intent(StudentDashboardActivity.this, CoursesActivity.class));
            }
        });

        exercisesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les exercices
                startActivity(new Intent(StudentDashboardActivity.this, ExercisesActivity.class));
            }
        });

        recommendationsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les recommandations
                startActivity(new Intent(StudentDashboardActivity.this, RecommendationsActivity.class));
            }
        });
    }
}