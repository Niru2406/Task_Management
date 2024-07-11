package com.example.task_management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Splash_screen extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = findViewById(R.id.text_splash);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getstarted();
            }
        });
    }

    public void getstarted(){
        Intent intent = new Intent(this, Registration_Screen.class);
        startActivity(intent);
        finish();
    }
}