package com.example.HelpMeRelax_v1_0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class ReplyDBHelper extends SQLiteOpenHelper {

    public static final String REPLY_TABLE = "REPLY_TABLE";
    public static final String COLUMN_POST_ID = "POST_ID";
    public static final String COLUMN_REPLY_USER_NAME = "REPLY_USER_NAME";
    public static final String COLUMN_REPLY_CONTENT = "REPLY_CONTENT";
    public static final String COLUMN_IS_ANONYMOUS = "IS_ANONYMOUS";
    public static final String COLUMN_ID = "ID";

    public ReplyDBHelper(@Nullable Context context) {
        super(context, "reply.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + REPLY_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_POST_ID + " INT, " + COLUMN_REPLY_USER_NAME + " TEXT, " + COLUMN_REPLY_CONTENT + " TEXT, "   + COLUMN_IS_ANONYMOUS + " BOOL )";
        System.out.println(createTableStatement);
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void clearDB() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+REPLY_TABLE;
        db.execSQL(clearDBQuery);

    }
    public boolean addOne(ReplyModel replyModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_POST_ID, replyModel.getPost_id());
        cv.put(COLUMN_REPLY_USER_NAME, replyModel.getReply_username());
        cv.put(COLUMN_REPLY_CONTENT, replyModel.getReply_content());
        cv.put(COLUMN_IS_ANONYMOUS, replyModel.isAnonymous());

        long insert = db.insert(REPLY_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }

    }

    public ArrayList<HashMap<String, String>> getEveryReply(int currentID) {
        ArrayList<HashMap<String, String>> returnList = new ArrayList<HashMap<String, String>>();

        // get data from the database

        String queryString = "SELECT * FROM " + REPLY_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {

            // loop through the cursor (result set) and create new customer objects. Put them into the return list
            do {


                int reply_ID = cursor.getInt(0);
                int post_ID = cursor.getInt(1);

                System.out.println("before adding new map into return list");
                System.out.println("postID = " + post_ID + " currentID = " + currentID);
                if (post_ID == currentID) {
                    System.out.println("start adding new map into return list");
                    String reply_user_name = cursor.getString(2);
                    String replyContent = cursor.getString(3);
                    boolean isAnonymous = cursor.getInt(4) == 1 ? true : false;

                    HashMap<String, String> map = new HashMap<String, String>();
                    if (isAnonymous) {
                        map.put("replyUsername",  "Anonymous");
                    }
                    else {
                        map.put("replyUsername",  reply_user_name);
                    }

                    map.put("replyText", replyContent);
                    map.put("PostID", String.valueOf(post_ID) );
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
