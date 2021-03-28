package com.example.HelpMeRelax_v1_0;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PostSessionActivity extends AppCompatActivity {

    ListView listView;
    String[] from = {"PostID", "replyUsername", "replyText"};
    int[] to = {0, R.id.replyUsername, R.id.replyText};

//    String username;
    String current_user_name;
    String post_ID;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_session);

        current_user_name = ((StoreUserName) this.getApplication()).getUsername();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String content = extras.getString("content");
            //The key argument here must match that used in the other activity
            System.out.println("in post page: " + content);

            String post_title = extras.getString("title");
            String poster_name = extras.getString("poster_name");
            String post_text = extras.getString("content");
            post_ID = extras.getString("post_ID");
            String user_name_authentication = extras.getString("user_name_authentication");

            TextView tv1 = (TextView) findViewById(R.id.post_session_poster_name_p_page);
            System.out.println("cnm shi bu shi null: " + tv1);
            tv1.setText(poster_name);
            TextView tv2 = (TextView) findViewById(R.id.post_session_title_p_page);
            tv2.setText(post_title);
            TextView tv3 = (TextView) findViewById(R.id.post_session_text_p_page);
            tv3.setText(post_text);

            System.out.println("postID is : " + post_ID);
            System.out.println("user_name_authentication is : " + user_name_authentication);

            // Another User
            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    String another_username = "Goldy Gopher";
                    String message_another_reply = "This is a reply!";
                    System.out.println(" user name = " + another_username + " content = " + message_another_reply );
                    ReplyModel newReplyModel = new ReplyModel(-1, Integer.parseInt(post_ID), another_username, message_another_reply, false);
                    ReplyDBHelper replyDBHelper = new ReplyDBHelper(PostSessionActivity.this);
                    replyDBHelper.addOne(newReplyModel);

                    // refresh page !
                    // find all reply with ID == postID
                    listView = findViewById(R.id.lv_reply_session);
                    final ReplyDBHelper replyDataBaseHelper = new ReplyDBHelper(PostSessionActivity.this);
                    final SimpleAdapter listItemAdapter = new SimpleAdapter(PostSessionActivity.this, replyDataBaseHelper.getEveryReply(Integer.parseInt(post_ID)), R.layout.reply_list_items, from, to);

                    listView.setAdapter(listItemAdapter);

                }
            }, 1000);

            /**
             * Delete the post
             */

            Button btn_delete = findViewById(R.id.btn_delete);
            if (!user_name_authentication.equals(current_user_name)) {

                btn_delete.setVisibility(View.INVISIBLE);
            } else {
                btn_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        PostDBHelper postDBHelper = new PostDBHelper(PostSessionActivity.this);

                        postDBHelper.deleteOne(Integer.parseInt(post_ID));

                        Toast.makeText(PostSessionActivity.this, " Post Successfully Deleted ", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(PostSessionActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                });
            }

            // find all reply with ID == postID
            listView = findViewById(R.id.lv_reply_session);
            final ReplyDBHelper replyDataBaseHelper = new ReplyDBHelper(PostSessionActivity.this);
            final SimpleAdapter listItemAdapter = new SimpleAdapter(PostSessionActivity.this, replyDataBaseHelper.getEveryReply(Integer.parseInt(post_ID)), R.layout.reply_list_items, from, to);

            listView.setAdapter(listItemAdapter);

        }
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable( getResources().getColor(R.color.colorPrimary)));

    }

    /**
     * Chat with User
     */

    public void onClickToChat(View view) {
        Intent intent = new Intent(PostSessionActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the user taps the Reply button
     */
    public void sendMessage(View view) throws InterruptedException {


        EditText editText = findViewById(R.id.et_reply);
        String replyMessage = editText.getText().toString();
        Switch sw_anonymousUser = findViewById(R.id.sw_reply_anonymous);

        // add new reply (user name , content) in db
        ReplyModel replyModel;
        try{
            System.out.println(" user name = " + current_user_name + " content = " + replyMessage );
            replyModel = new ReplyModel(-1, Integer.parseInt(post_ID), current_user_name, replyMessage, sw_anonymousUser.isChecked());

            System.out.println("After creating customer model");
           Toast .makeText(PostSessionActivity.this,"Success", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(PostSessionActivity.this,"Error Creating Reply", Toast.LENGTH_SHORT).show();
            replyModel = new ReplyModel(-1, -1, "", "error", false);
        }

        ReplyDBHelper replyDBHelper = new ReplyDBHelper(PostSessionActivity.this);

        System.out.println("before add one");
        boolean success = replyDBHelper.addOne(replyModel);

        Toast.makeText(PostSessionActivity.this, "Success ", Toast.LENGTH_SHORT).show();

        // refresh page !
        // find all reply with ID == postID
        listView = findViewById(R.id.lv_reply_session);
        final ReplyDBHelper replyDataBaseHelper = new ReplyDBHelper(PostSessionActivity.this);
        final SimpleAdapter listItemAdapter = new SimpleAdapter(PostSessionActivity.this, replyDataBaseHelper.getEveryReply(Integer.parseInt(post_ID)), R.layout.reply_list_items, from, to);

        listView.setAdapter(listItemAdapter);


        // Another User
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String another_username = "Goldy Gopher";
                String message_another_reply = "This is a reply!";
                System.out.println(" user name = " + another_username + " content = " + message_another_reply );
                ReplyModel newreplyModel = new ReplyModel(-1, Integer.parseInt(post_ID), another_username, message_another_reply, false);
                ReplyDBHelper replyDBHelper = new ReplyDBHelper(PostSessionActivity.this);
                replyDBHelper.addOne(newreplyModel);

                // refresh page !
                // find all reply with ID == postID
                listView = findViewById(R.id.lv_reply_session);
                final ReplyDBHelper replyDataBaseHelper = new ReplyDBHelper(PostSessionActivity.this);
                final SimpleAdapter listItemAdapter = new SimpleAdapter(PostSessionActivity.this, replyDataBaseHelper.getEveryReply(Integer.parseInt(post_ID)), R.layout.reply_list_items, from, to);

                listView.setAdapter(listItemAdapter);

            }
        }, 1000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String another_username = "Dave";
                String message_another_reply = "This is another reply!";
                System.out.println(" user name = " + another_username + " content = " + message_another_reply );
                ReplyModel newReplyModel = new ReplyModel(-1, Integer.parseInt(post_ID), another_username, message_another_reply, false);
                ReplyDBHelper replyDBHelper = new ReplyDBHelper(PostSessionActivity.this);
                replyDBHelper.addOne(newReplyModel);

                // refresh page !
                // find all reply with ID == postID
                listView = findViewById(R.id.lv_reply_session);
                final ReplyDBHelper replyDataBaseHelper = new ReplyDBHelper(PostSessionActivity.this);
                final SimpleAdapter listItemAdapter = new SimpleAdapter(PostSessionActivity.this, replyDataBaseHelper.getEveryReply(Integer.parseInt(post_ID)), R.layout.reply_list_items, from, to);

                listView.setAdapter(listItemAdapter);

            }
        }, 3000);


    }


}
