package com.example.HelpMeRelax_v1_0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    Button registerButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.bRegister);

        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.bRegister:
                startActivity(new Intent(this, SignUp.class) );
                break;
            case R.id.loginButton:
                //start login activity
                startActivity(new Intent(this, LoginActivity.class) );
                break;
            case R.id.btn_reset:
                // clear db
                Toast.makeText(Welcome.this, "DB cleared", Toast.LENGTH_SHORT).show();
                System.out.println("DB cleared");
                PostDBHelper postDBHelper = new PostDBHelper(Welcome.this);
                ReplyDBHelper replyDBHelper = new ReplyDBHelper(Welcome.this);
                replyDBHelper.clearDB();
                postDBHelper.clearDB();
                break;
        }

    }

}