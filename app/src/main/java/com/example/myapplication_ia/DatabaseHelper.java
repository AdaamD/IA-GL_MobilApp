package com.example.myapplication_ia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Définissez les noms des colonnes de la table des utilisateurs
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_USER_TYPE = "user_type";
    private static final String COLUMN_NUM_CHILDREN = "num_children";
    private static final String COLUMN_STUDENT_NAME = "student_name";
    private static final String COLUMN_STUDENT_GRADE = "student_grade";
    private static final String COLUMN_FORMULE = "formule";
    private static final String COLUMN_ACCOMPAGNEMENT = "accompagnement";
    private static final String COLUMN_PAYMENT_INFO = "payment_info";

    // Définissez les noms des colonnes de la table des cours
    private static final String TABLE_COURSES = "courses";
    private static final String COLUMN_COURSE_ID = "course_id";
    private static final String COLUMN_COURSE_TITLE = "title";
    private static final String COLUMN_COURSE_DESCRIPTION = "description";
    private static final String COLUMN_COURSE_DURATION = "duration";

    // Définissez les noms des colonnes de la table des exercices
    private static final String TABLE_EXERCISES = "exercises";
    private static final String COLUMN_EXERCISE_ID = "exercise_id";
    private static final String COLUMN_EXERCISE_TITLE = "title";
    private static final String COLUMN_EXERCISE_DESCRIPTION = "description";
    private static final String COLUMN_EXERCISE_DIFFICULTY = "difficulty";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_EMAIL + " TEXT UNIQUE,"
                + COLUMN_PASSWORD + " TEXT,"
                + COLUMN_USER_TYPE + " TEXT,"
                + COLUMN_NUM_CHILDREN + " INTEGER,"
                + COLUMN_STUDENT_NAME + " TEXT,"
                + COLUMN_STUDENT_GRADE + " TEXT,"
                + COLUMN_FORMULE + " INTEGER,"
                + COLUMN_ACCOMPAGNEMENT + " INTEGER,"
                + COLUMN_PAYMENT_INFO + " TEXT"
                + ")";
        db.execSQL(CREATE_USERS_TABLE);

        // Création de la table courses
        String CREATE_COURSES_TABLE = "CREATE TABLE " + TABLE_COURSES + "("
                + COLUMN_COURSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_COURSE_TITLE + " TEXT,"
                + COLUMN_COURSE_DESCRIPTION + " TEXT,"
                + COLUMN_COURSE_DURATION + " TEXT"
                + ")";
        db.execSQL(CREATE_COURSES_TABLE);

        String CREATE_EXERCISES_TABLE = "CREATE TABLE " + TABLE_EXERCISES + "("
                + COLUMN_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_EXERCISE_TITLE + " TEXT,"
                + COLUMN_EXERCISE_DESCRIPTION + " TEXT,"
                + COLUMN_EXERCISE_DIFFICULTY + " TEXT"
                + ")";
        db.execSQL(CREATE_EXERCISES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);
        onCreate(db);
    }

    public long addUser(String name, String email, String password, String userType, int numChildren,
                        String studentName, String studentGrade, int formule, int accompagnement, String paymentInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_USER_TYPE, userType);
        values.put(COLUMN_NUM_CHILDREN, numChildren);
        values.put(COLUMN_STUDENT_NAME, studentName);
        values.put(COLUMN_STUDENT_GRADE, studentGrade);
        values.put(COLUMN_FORMULE, formule);
        values.put(COLUMN_ACCOMPAGNEMENT, accompagnement);
        values.put(COLUMN_PAYMENT_INFO, paymentInfo);

        long id = db.insert(TABLE_USERS, null, values);
        db.close();
        return id;
    }

    public boolean checkUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_ID},
                COLUMN_EMAIL + "=?", new String[]{email},
                null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount > 0;
    }

    public String checkLogin(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { COLUMN_ID, COLUMN_USER_TYPE };
        String selection = COLUMN_EMAIL + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        String userType = "";

        if (cursor.moveToFirst()) {
            userType = cursor.getString(cursor.getColumnIndex(COLUMN_USER_TYPE));
        }

        cursor.close();
        db.close();

        return userType;
    }

    // Ajoutez une méthode pour ajouter un cours à la base de données
    public long addCourse(String title, String description, String duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COURSE_TITLE, title);
        values.put(COLUMN_COURSE_DESCRIPTION, description);
        values.put(COLUMN_COURSE_DURATION, duration);
        long id = db.insert(TABLE_COURSES, null, values);
        db.close();
        return id;
    }

    public List<Map<String, String>> getAllCourses() {
        List<Map<String, String>> courseList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_COURSES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Map<String, String> course = new HashMap<>();
                course.put("id", cursor.getString(cursor.getColumnIndex(COLUMN_COURSE_ID)));
                course.put("title", cursor.getString(cursor.getColumnIndex(COLUMN_COURSE_TITLE)));
                course.put("description", cursor.getString(cursor.getColumnIndex(COLUMN_COURSE_DESCRIPTION)));
                course.put("duration", cursor.getString(cursor.getColumnIndex(COLUMN_COURSE_DURATION)));
                courseList.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return courseList;
    }

    // Ajoutez une méthode pour ajouter un exercice à la base de données
    public long addExercise(String title, String description, String difficulty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXERCISE_TITLE, title);
        values.put(COLUMN_EXERCISE_DESCRIPTION, description);
        values.put(COLUMN_EXERCISE_DIFFICULTY, difficulty);
        long id = db.insert(TABLE_EXERCISES, null, values);
        db.close();
        return id;
    }

    // Ajoutez une méthode pour récupérer tous les exercices de la base de données
    public List<Map<String, String>> getAllExercises() {
        List<Map<String, String>> exerciseList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EXERCISES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Map<String, String> exercise = new HashMap<>();
                exercise.put("id", cursor.getString(cursor.getColumnIndex(COLUMN_EXERCISE_ID)));
                exercise.put("title", cursor.getString(cursor.getColumnIndex(COLUMN_EXERCISE_TITLE)));
                exercise.put("description", cursor.getString(cursor.getColumnIndex(COLUMN_EXERCISE_DESCRIPTION)));
                exercise.put("difficulty", cursor.getString(cursor.getColumnIndex(COLUMN_EXERCISE_DIFFICULTY)));
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return exerciseList;
    }
}
