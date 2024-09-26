package com.example.myapplication_ia;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_ia.R;

public class ExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        // Récupérez les références aux vues
        TextView exercise1TextView = findViewById(R.id.exercise1TextView);
        TextView exercise2TextView = findViewById(R.id.exercise2TextView);
        TextView exercise3TextView = findViewById(R.id.exercise3TextView);

        // Définissez les informations pour chaque exercice
        exercise1TextView.setText("Exercice 1 - Titre : Écrivez un programme qui affiche \"Bonjour le monde\"\n" +
                "Description : Apprenez à écrire votre premier programme en Java\n" +
                "Difficulté : Facile");

        exercise2TextView.setText("Exercice 2 - Titre : Calculez la somme de deux nombres\n" +
                "Description : Apprenez à effectuer des opérations arithmétiques de base en Java\n" +
                "Difficulté : Moyenne");

        exercise3TextView.setText("Exercice 3 - Titre : Écrivez un programme qui trie une liste de nombres\n" +
                "Description : Apprenez les bases de l'algorithmique en Java\n" +
                "Difficulté : Difficile");
    }
}