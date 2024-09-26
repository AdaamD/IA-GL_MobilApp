package com.example.myapplication_ia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        // Create a default parent user if not exists
        createDefaultParentUser();

        // Set up the button for Inscription
        Button buttonInscription = findViewById(R.id.button_inscription);
        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Inscription activity
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });

        // Set up the button for Login
        Button buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Login activity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Set up the button for Démonstration
        Button buttonDemonstration = findViewById(R.id.button_demonstration);
        buttonDemonstration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Démonstration activity
                Intent intent = new Intent(MainActivity.this, DemonstrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createDefaultParentUser() {
        String defaultEmail = "parent@example.com";
        String defaultPassword = "password123";

        if (!databaseHelper.checkUser(defaultEmail)) {
            long userId = databaseHelper.addUser(
                    "Default Parent",
                    defaultEmail,
                    defaultPassword,
                    "parent", // User type is now a string
                    2, // Number of children
                    "Child Name",
                    "Grade 5",
                    R.id.formule1RadioButton, // Using the ID of the radio button for formule
                    R.id.accompagnementProgressionRadioButton, // Using the ID of the radio button for accompagnement
                    "Payment Info"
            );

            if (userId > 0) {
                Toast.makeText(this, "Utilisateur parent par défaut créé", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Échec de la création de l'utilisateur parent par défaut", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
