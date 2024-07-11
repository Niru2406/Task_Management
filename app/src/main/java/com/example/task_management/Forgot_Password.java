package com.example.task_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forgot_Password extends AppCompatActivity {
    private EditText emailEditText;
    private TextView resetPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = findViewById(R.id.emailEditText);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);

      resetPasswordButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              resetPassword();
          }
      });
    }
    private void resetPassword() {
        String email = emailEditText.getText().toString();

        if (!email.isEmpty()) {
            Toast.makeText(Forgot_Password.this, "Password reset link sent to " + email, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Forgot_Password.this, "Please enter your email", Toast.LENGTH_SHORT).show();
        }
    }
}