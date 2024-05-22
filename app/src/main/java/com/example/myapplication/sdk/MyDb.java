package com.example.myapplication.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class MyDb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentlist";
    private static final String TABLE_STUDENTS = "students";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public MyDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT"
                + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new student
    void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, student.getID()); // studentName
        values.put(KEY_NAME, student.getName()); // studentName

        System.out.println("DB add thread = " + Thread.currentThread().getName() + " student id = " + student.getID());

        // Inserting Row
        db.insert(TABLE_STUDENTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single student
    Student getStudent(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STUDENTS,
                new String[]{KEY_ID, KEY_NAME}, KEY_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student student = new Student(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        // return studentList
        return student;
    }


    // code to get all student in a list view
    public ArrayList<Student> getAllStudentList() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_STUDENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setID(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                // Adding student to list
                studentList.add(student);
            } while (cursor.moveToNext());
        }

        System.out.println("MYSDK, current DB Size = " + studentList.size() );
        // return student list
        return studentList;
    }

    // code to update the single student
    public int updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());

        // updating row
        return db.update(TABLE_STUDENTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(student.getID())});
    }


    // Deleting single student
    public void deleteStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENTS, KEY_ID + " = ?",
                new String[]{String.valueOf(student.getID())});
        db.close();
    }

    public void deleteAllStudents() {
        ArrayList<Student> studentList = getAllStudentList();

        SQLiteDatabase db = this.getWritableDatabase();

        for (Student student : studentList) {
            System.out.println("Student = " + student.getID());
            db.delete(TABLE_STUDENTS, KEY_ID + " = ?",
                    new String[]{String.valueOf(student.getID())});
        }
        System.out.println("MYSDK deleting all students from DB ");
        BigInteger veryBig = new BigInteger(1000, new Random());
        veryBig.nextProbablePrime();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        db.close();
    }


    // Getting student Count
    public int getStudentListCount() {
        String countQuery = "SELECT * FROM " + TABLE_STUDENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
