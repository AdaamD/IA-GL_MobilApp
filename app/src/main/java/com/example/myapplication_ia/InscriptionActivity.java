package com.example.myapplication_ia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InscriptionActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText, numChildrenEditText,
            studentNameEditText, studentGradeEditText, paymentInfoEditText;
    private RadioGroup userTypeRadioGroup, formuleRadioGroup, accompagnementRadioGroup;
    private Button submitButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        databaseHelper = new DatabaseHelper(this);

        // Initialize UI elements
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        userTypeRadioGroup = findViewById(R.id.userTypeRadioGroup);
        numChildrenEditText = findViewById(R.id.numChildrenEditText);
        studentNameEditText = findViewById(R.id.studentNameEditText);
        studentGradeEditText = findViewById(R.id.studentGradeEditText);
        formuleRadioGroup = findViewById(R.id.formuleRadioGroup);
        accompagnementRadioGroup = findViewById(R.id.accompagnementRadioGroup);
        paymentInfoEditText = findViewById(R.id.paymentInfoEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String userType = userTypeRadioGroup.getCheckedRadioButtonId() == R.id.radioParent ? "parent" : "child";
        int numChildren = Integer.parseInt(numChildrenEditText.getText().toString().trim());
        String studentName = studentNameEditText.getText().toString().trim();
        String studentGrade = studentGradeEditText.getText().toString().trim();
        int formule = formuleRadioGroup.getCheckedRadioButtonId();
        int accompagnement = accompagnementRadioGroup.getCheckedRadioButtonId();
        String paymentInfo = paymentInfoEditText.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || userType.isEmpty() ||
                numChildren == 0 || studentName.isEmpty() || studentGrade.isEmpty() ||
                formule == -1 || accompagnement == -1 || paymentInfo.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        if (databaseHelper.checkUser(email)) {
            Toast.makeText(this, "Cet email est déjà utilisé", Toast.LENGTH_SHORT).show();
            return;
        }

        long id = databaseHelper.addUser(name, email, password, userType, numChildren,
                studentName, studentGrade, formule, accompagnement, paymentInfo);

        if (id > 0) {
            Toast.makeText(this, "Inscription réussie", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erreur lors de l'inscription", Toast.LENGTH_SHORT).show();
        }
    }
}
