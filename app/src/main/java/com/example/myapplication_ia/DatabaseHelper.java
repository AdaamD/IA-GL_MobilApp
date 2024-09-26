package com.example.myapplication_ia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDatabase.db";
    private static final int DATABASE_VERSION = 1;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
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

}
