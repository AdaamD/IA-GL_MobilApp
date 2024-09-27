package com.example.myapplication_ia;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_ia.R;

import java.util.List;
import java.util.Map;

public class ExercisesActivity extends AppCompatActivity {
    private RecyclerView exercisesRecyclerView;
    private ExerciseAdapter exerciseAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        databaseHelper = new DatabaseHelper(this);

        // Ajout d'exercices de test si la base de données est vide
        if (databaseHelper.getAllExercises().isEmpty()) {
            addSampleExercises();
        }

        exercisesRecyclerView = findViewById(R.id.exercisesRecyclerView);
        exercisesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Map<String, String>> exercises = databaseHelper.getAllExercises();
        exerciseAdapter = new ExerciseAdapter(exercises);
        exercisesRecyclerView.setAdapter(exerciseAdapter);
    }

    private void addSampleExercises() {
        databaseHelper.addExercise("Écrivez un programme qui affiche \"Bonjour le monde\"", "Apprenez à écrire votre premier programme en Java", "Facile");
        databaseHelper.addExercise("Calculez la somme de deux nombres", "Apprenez à effectuer des opérations arithmétiques de base en Java", "Moyenne");
        databaseHelper.addExercise("Écrivez un programme qui trie une liste de nombres", "Apprenez les bases de l'algorithmique en Java", "Difficile");
    }
}
