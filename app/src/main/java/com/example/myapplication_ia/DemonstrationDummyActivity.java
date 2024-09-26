package com.example.myapplication_ia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DemonstrationDummyActivity extends AppCompatActivity {

    // Declare UI elements
    private TextView demonstrationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demonstration_dummy);

        // Initialize UI elements
        demonstrationTextView = findViewById(R.id.demonstrationTextView);

        // Set text to demonstrate the app functionality
        demonstrationTextView.setText("Welcome to the demonstration! This is a dummy activity to showcase the functionality of the app. In a real app, you would replace this activity with actual content." +
                "\n\nHere are some of the things you can do:\n" +
                "1. View a clear and ergonomic presentation of the app in different formats (video, text, etc.)\n" +
                "2. Get a temporary demonstration (use) of the app's services\n" +
                "3. Log in or sign up for an account to access the full functionality of the app\n" +
                "4. Contact support for help or feedback\n" +
                "5. Access the app's settings to customize your experience\n" +
                "6. And much more!\n\n" +
                "Thank you for choosing our app! We hope you enjoy using it.");
    }
}