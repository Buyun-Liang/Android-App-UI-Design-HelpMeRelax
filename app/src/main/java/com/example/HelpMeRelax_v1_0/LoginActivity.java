package com.example.HelpMeRelax_v1_0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void loginSuccess(View view) {
        EditText etUsername = (EditText) findViewById(R.id.username);
        String username = etUsername.getText().toString();
        ((StoreUserName) this.getApplication()).setUsername(username);

        // Test global variable
        String s = ((StoreUserName) this.getApplication()).getUsername();
        System.out.println("username = " + s);

        if (username.length() < 2 || username.length() > 30) {

            Toast.makeText(LoginActivity.this, "The username must be between 2 and 30 characters" , Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }



    }

    public void signUp(View view) {
        Intent intent = new Intent(LoginActivity.this, SignUp.class);
        startActivity(intent);
    }

}
