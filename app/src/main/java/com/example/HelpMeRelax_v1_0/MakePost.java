package com.example.HelpMeRelax_v1_0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MakePost extends AppCompatActivity {


    // references to button and other controls on the layout
    Button btn_post;
    EditText et_title, et_content;
    Switch sw_anonymousUser;
//    ListView lv_customerList;

    String username;
    String postSessionID = "-1";

    ArrayAdapter customerArrayAdapter;
    PostDBHelper postDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post);
        Bundle extras = getIntent().getExtras();


        username =  ((StoreUserName) this.getApplication()).getUsername();
        postSessionID = extras.getString("postSessionID");

        // Mar 24 22:50 pm
        et_title = findViewById(R.id.title_input);
        et_content = findViewById(R.id.content_input);
        btn_post = findViewById(R.id.post_button);
        sw_anonymousUser = findViewById(R.id.sw_anonymous);

        postDBHelper = new PostDBHelper(MakePost.this);


        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostModel postModel;
                try{
                    System.out.println("title = " + et_title.getText().toString() + " content = " + et_content.getText().toString());
                    postModel = new PostModel(-1, username, et_title.getText().toString(), et_content.getText().toString(), Integer.parseInt(postSessionID), sw_anonymousUser.isChecked());
                    System.out.println("After creating customer model");
                    Toast.makeText(MakePost.this,"Success", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(MakePost.this,"Error Creating Post", Toast.LENGTH_SHORT).show();
                    postModel = new PostModel(-1,"error", " ", " ", -1,false);
                }

                PostDBHelper postDBHelper = new PostDBHelper(MakePost.this);

                System.out.println("before add one");
                boolean success = postDBHelper.addOne(postModel);

                Toast.makeText(MakePost.this, "Success= " + success, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MakePost.this,  MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
