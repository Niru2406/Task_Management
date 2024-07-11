package com.example.task_management;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity {
    private ListView languageLV;
    private TextView addBtn;
    private EditText itemEdt;
    private ArrayList<String> lngList;
    private CustomAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        languageLV = findViewById(R.id.ListView);
        addBtn = findViewById(R.id.Add);
        itemEdt = findViewById(R.id.idEdtItemTask);
        lngList = new ArrayList<>();

         adapter = new CustomAdapter(this, lngList);
        languageLV.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemEdt.getText().toString();

                if (!item.isEmpty()) {
                    lngList.add(item);
                    adapter.notifyDataSetChanged();
                    itemEdt.setText("");
                    Log.d("DashBoard", "Added item: " + item);
                } else {
                    Toast.makeText(DashBoard.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}