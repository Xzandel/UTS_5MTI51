package com.ubm.uts;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {
    //DATABASE NAME
    public static final String DATABASE_NAME = "logindb";
    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;
    //TABLE NAME
    public static final String TABLE_USERS = "users";
    //TABLE USERS COLUMNS
    //ID COLUMN @primaryKey
    public static final String KEY_ID = "id";
    //COLUMN user name
    public static final String KEY_USER_NAME = "username";
    //COLUMN email
    public static final String KEY_EMAIL = "email";
    //COLUMN password
    public static final String KEY_PASSWORD = "password";
    //COLUMN jenis kelamin
    public static final String KEY_JENIS_KELAMIN = "jeniskelamin";


    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT, "
            + KEY_JENIS_KELAMIN + " TEXT "
            + ")";

    public SqliteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create Table when oncreate gets called
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int ii) {
        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL("  DROP TABLE IF EXiSTS " + TABLE_USERS);
    }

    public Boolean insertData(String username, String password, String id, String jeniskelamin, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //Insert values
        contentValues.put("id", id);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("jeniskelamin", jeniskelamin);
        contentValues.put("username", username);

        long result = db.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public boolean checkusername(String usermame) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username =? ", new String[]{usermame});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkidpassword(String id, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where id =? and password =?", new String[]{id, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}