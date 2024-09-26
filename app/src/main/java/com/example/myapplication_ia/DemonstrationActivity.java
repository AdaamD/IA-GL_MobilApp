package com.example.myapplication_ia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DemonstrationActivity extends AppCompatActivity {

    // Declare UI elements
    private Button startDemonstrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demonstration);

        // Initialize UI elements
        startDemonstrationButton = findViewById(R.id.startDemonstrationButton);

        // Set onClickListener for start demonstration button
        startDemonstrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a toast message
                Toast.makeText(DemonstrationActivity.this, "Demonstration started!", Toast.LENGTH_SHORT).show();

                // Start the dummy demonstration activity
                startActivity(new Intent(DemonstrationActivity.this, DemonstrationDummyActivity.class));
            }
        });
    }
}