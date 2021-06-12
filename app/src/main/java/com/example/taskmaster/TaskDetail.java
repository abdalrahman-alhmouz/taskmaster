package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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


        Intent intent = getIntent();
        TextView titleTask = TaskDetail.this.findViewById(R.id.title);
        TextView bodyTask = TaskDetail.this.findViewById(R.id.status);
        TextView stateTask = TaskDetail.this.findViewById(R.id.body);

        titleTask.setText(intent.getExtras().getString("title"));
        bodyTask.setText(intent.getExtras().getString("body"));
        stateTask.setText(intent.getExtras().getString("state"));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mtIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(mtIntent, 0);
        return true;

    }

}