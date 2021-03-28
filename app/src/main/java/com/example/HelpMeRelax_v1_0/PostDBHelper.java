package com.example.HelpMeRelax_v1_0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class PostDBHelper extends SQLiteOpenHelper {

    public static final String POST_TABLE = "POST_TABLE";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_POST_TITLE = "POST_TITLE";
    public static final String COLUMN_POST_CONTENT = "POST_CONTENT";
    public static final String COLUMN_POST_SESSION_ID = "POST_SESSION_ID";
    public static final String COLUMN_IS_ANONYMOUS = "IS_ANONYMOUS";
    public static final String COLUMN_ID = "ID";

    public PostDBHelper(@Nullable Context context) {
        super(context, "posts.db", null, 1);
    }

    // this is called the first time a db is accessed. There should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + POST_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_POST_TITLE + " TEXT, " + COLUMN_POST_CONTENT + " TEXT, " + COLUMN_POST_SESSION_ID + " INT, " + COLUMN_IS_ANONYMOUS + " BOOL )";
        System.out.println(createTableStatement);
        db.execSQL(createTableStatement);
    }

    // this is called if version changes. It prevents users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void clearDB() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+POST_TABLE;
        db.execSQL(clearDBQuery);

    }

    public boolean addOne(PostModel postModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_NAME, postModel.getUsername());
        cv.put(COLUMN_POST_TITLE, postModel.getTitle());
        cv.put(COLUMN_POST_CONTENT, postModel.getContent());
        cv.put(COLUMN_POST_SESSION_ID, postModel.getPostSessionID());
        cv.put(COLUMN_IS_ANONYMOUS, postModel.isAnonymous());

        long insert = db.insert(POST_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }

    }

    public boolean deleteOne(int postID) {
        //find customerModel in the database. if it found, delete it and return true.
        // if it is not found, return false
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + POST_TABLE + " WHERE " + COLUMN_ID + " = " + postID;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    }


    public ArrayList<HashMap<String, String>> getEveryoneMap(int currentPostSessionID) {
        ArrayList<HashMap<String, String>> returnList = new ArrayList<HashMap<String, String>>();

        // get data from the database

        String queryString = "SELECT * FROM " + POST_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new customer objects. Put them into the return list
            do {
                int customerID = cursor.getInt(0);
                String customerName = cursor.getString(1);
                String postTitle = cursor.getString(2);
                String postContent = cursor.getString(3);
                int postSessionID = cursor.getInt(4);
                boolean customerActive = cursor.getInt(5) == 1 ? true : false;

                if (currentPostSessionID == postSessionID) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    if (customerActive) {
                        map.put("username",  "Anonymous");
                    }
                    else {
                        map.put("username",  customerName);
                    }
                    map.put("ItemTitle", postTitle);
                    map.put("ItemText", postContent);
                    map.put("PostID", String.valueOf(customerID) );
                    map.put("user_name_authentication",customerName);
                    returnList.add(map);
                }

            } while (cursor.moveToNext());
        }
        else {
            // failure. do not add anything to the list
        }

        // close both the cursor and the db when done
        cursor.close();
        db.close();

        return returnList;
    }

}
