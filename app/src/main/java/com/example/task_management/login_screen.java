package com.example.task_management;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_screen extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView loginButton;
    private TextView forgotPasswordText;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_screen.this, Forgot_Password.class);
                startActivity(intent);
            }
        });
    }
    public void loginUser() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String savedEmail = sharedPreferences.getString("email", "");
        String savedPassword = sharedPreferences.getString("password", "");

        if (email.equals(savedEmail) && password.equals(savedPassword)) {
            Toast.makeText(login_screen.this, "Login Successful", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(login_screen.this, DashBoard.class);
            startActivity(intent);
        } else {
            Toast.makeText(login_screen.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
        }
    }
}