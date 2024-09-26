package com.example.myapplication_ia;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecommendationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        // Récupérez les références aux vues
        TextView recommendation1TextView = findViewById(R.id.recommendation1TextView);
        TextView recommendation2TextView = findViewById(R.id.recommendation2TextView);
        TextView recommendation3TextView = findViewById(R.id.recommendation3TextView);

        // Définissez les informations pour chaque recommandation
        recommendation1TextView.setText("Recommandation 1 - Titre : Apprenez les bases de la programmation\n" +
                "Description : Suivez ce cours en ligne pour apprendre les bases de la programmation en Java\n" +
                "Lien : www.exemple.com/cours1");

        recommendation2TextView.setText("Recommandation 2 - Titre : Pratiquez avec des exercices\n" +
                "Description : Faites ces exercices pour mettre en pratique vos connaissances en Java\n" +
                "Lien : www.exemple.com/exercices1");

        recommendation3TextView.setText("Recommandation 3 - Titre : Suivez des tutoriels vidéo\n" +
                "Description : Regardez ces tutoriels vidéo pour apprendre des concepts avancés en Java\n" +
                "Lien : www.exemple.com/tutoriels1");
    }
}