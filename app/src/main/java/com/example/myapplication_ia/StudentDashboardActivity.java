package com.example.myapplication_ia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        // Récupérez les références aux vues
        Button coursesButton = findViewById(R.id.coursesButton);
        Button exercisesButton = findViewById(R.id.exercisesButton);
        Button recommendationsButton = findViewById(R.id.recommendationsButton);

        // Définissez les actions pour chaque bouton
        coursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les cours
                startActivity(new Intent(StudentDashboardActivity.this, CoursesActivity.class));
            }
        });

        exercisesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les exercices
                startActivity(new Intent(StudentDashboardActivity.this, ExercisesActivity.class));
            }
        });

        recommendationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les recommandations
                startActivity(new Intent(StudentDashboardActivity.this, RecommendationsActivity.class));
            }
        });
    }
}