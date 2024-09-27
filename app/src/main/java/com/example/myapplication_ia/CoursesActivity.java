package com.example.myapplication_ia;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class CoursesActivity extends AppCompatActivity {
    private RecyclerView coursesRecyclerView;
    private CourseAdapter courseAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        databaseHelper = new DatabaseHelper(this);

        // Ajout de cours de test si la base de données est vide
        if (databaseHelper.getAllCourses().isEmpty()) {
            addSampleCourses();
        }

        coursesRecyclerView = findViewById(R.id.coursesRecyclerView);
        coursesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Map<String, String>> courses = databaseHelper.getAllCourses();
        courseAdapter = new CourseAdapter(courses);
        coursesRecyclerView.setAdapter(courseAdapter);
    }

    private void addSampleCourses() {
        databaseHelper.addCourse("Introduction à la programmation", "Apprenez les bases de la programmation avec Java", "2 heures");
        databaseHelper.addCourse("Algorithmique et structures de données", "Maîtrisez les algorithmes de base et les structures de données en Java", "3 heures");
        databaseHelper.addCourse("Programmation orientée objet", "Découvrez la programmation orientée objet avec Java", "4 heures");
    }
}
