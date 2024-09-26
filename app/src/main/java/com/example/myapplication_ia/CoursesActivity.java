package com.example.myapplication_ia;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        // Récupérez les références aux vues
        TextView course1TextView = findViewById(R.id.course1TextView);
        TextView course2TextView = findViewById(R.id.course2TextView);
        TextView course3TextView = findViewById(R.id.course3TextView);

        // Définissez les informations pour chaque cours
        course1TextView.setText("Cours 1 - Titre : Introduction à la programmation\n" +
                "Description : Apprenez les bases de la programmation avec Java\n" +
                "Durée : 2 heures");

        course2TextView.setText("Cours 2 - Titre : Algorithmique et structures de données\n" +
                "Description : Maîtrisez les algorithmes de base et les structures de données en Java\n" +
                "Durée : 3 heures");

        course3TextView.setText("Cours 3 - Titre : Programmation orientée objet\n" +
                "Description : Découvrez la programmation orientée objet avec Java\n" +
                "Durée : 4 heures");
    }
}