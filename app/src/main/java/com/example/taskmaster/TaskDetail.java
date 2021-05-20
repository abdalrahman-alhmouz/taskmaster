package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.Button;
import android.widget.TextView;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        TextView textView=findViewById(R.id.detailsTitle);
        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        textView.setText(title);
        this.setTitle(title);

    }
}