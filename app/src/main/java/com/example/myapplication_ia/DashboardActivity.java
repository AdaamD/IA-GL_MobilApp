package com.example.myapplication_ia;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Récupérez les références aux vues
        TextView connectionTextView = findViewById(R.id.connectionTextView);
        TextView coursesTextView = findViewById(R.id.coursesTextView);
        TextView durationTextView = findViewById(R.id.durationTextView);
        TextView progressionTextView = findViewById(R.id.progressionTextView);
        TextView recommendationsTextView = findViewById(R.id.recommendationsTextView);
        TextView remindersTextView = findViewById(R.id.remindersTextView);

        // Définissez les actions pour chaque section
        connectionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les moments de connexion de l'élève
                Toast.makeText(DashboardActivity.this, "Moments de connexion de l'élève", Toast.LENGTH_SHORT).show();
            }
        });

        coursesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les cours et les exercices réalisés par l'élève
                Toast.makeText(DashboardActivity.this, "Cours et exercices réalisés par l'élève", Toast.LENGTH_SHORT).show();
            }
        });

        durationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les durées d'activité sur l'application
                Toast.makeText(DashboardActivity.this, "Durées d'activité sur l'application", Toast.LENGTH_SHORT).show();
            }
        });

        progressionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les courbes de progression
                Toast.makeText(DashboardActivity.this, "Courbes de progression", Toast.LENGTH_SHORT).show();
            }
        });

        recommendationsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour afficher les recommandations pour la progression de l'élève
                Toast.makeText(DashboardActivity.this, "Recommandations pour la progression de l'élève", Toast.LENGTH_SHORT).show();
            }
        });

        remindersTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code pour définir des moments de rappel à l'élève pour revenir sur l'application
                Toast.makeText(DashboardActivity.this, "Définir des moments de rappel à l'élève", Toast.LENGTH_SHORT).show();
            }
        });
    }
}