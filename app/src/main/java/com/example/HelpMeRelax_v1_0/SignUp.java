package com.example.HelpMeRelax_v1_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.util.Patterns;
import android.graphics.Color;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etUsername;
    EditText etEmail;
    EditText etPassword;
    EditText etConfirmPassword;
    TextView tvErrorMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        tvErrorMessage = (TextView) findViewById(R.id.tvErrorMessage);

        bRegister.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.bRegister:
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                String errorMessage = "We're sorry, you account could not be created due to the following reasons:\n";
                boolean isError = false;

                // Check for errors
                if (!password.equals(confirmPassword)){
                    isError = true;
                    errorMessage = errorMessage.concat("The passwords must match\n");
                }
                if (username.length() < 2 || username.length() > 30) {
                    isError = true;
                    errorMessage = errorMessage.concat("The username must be between 2 and 30 characters\n");
                }
                if (!isValidEmail(email)){
                    isError = true;
                    errorMessage = errorMessage.concat("The email address must be valid\n");
                }

                // Check
                if (isError){
                    // Display the error message
                    tvErrorMessage.setTextColor(Color.RED);
                    tvErrorMessage.setText(errorMessage);
                }
                else {
                    // TODO: Register new user and start main page activity

                    ((StoreUserName) this.getApplication()).setUsername(username);
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(intent);

//                    // To check if it works. This can be deleted when finished
//                    tvErrorMessage.setTextColor(Color.GREEN);
//                    tvErrorMessage.setText("Success!");
                }

                break;
        }
    }

    public boolean isValidEmail(String email){
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true;
        } else {
            return false;
        }
    }
}