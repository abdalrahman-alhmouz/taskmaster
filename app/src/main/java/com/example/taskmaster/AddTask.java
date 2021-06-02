package com.example.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class AddTask extends AppCompatActivity implements ViewAdapter.OnInteractingWithTaskListener{

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);


        db = Room.databaseBuilder(getApplicationContext(),
                Database.class, "tasks").allowMainThreadQueries().build();

        final TextView title = findViewById(R.id.editTextMyTask);
        final TextView body = findViewById(R.id.editTextDoSomething);
        final TextView status = findViewById(R.id.editTextStatus);


        Button addTaskButton = AddTask.this.findViewById(R.id.buttonAddTaskSubmit);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Task newTask = new Task(title.getText().toString(), body.getText().toString(), status.getText().toString());
            db.taskDao().insertAll(newTask);

            Intent intent = new Intent(AddTask.this, MainActivity.class);
            startActivity(intent);
            }
        });

    }


    @Override
    public void taskListener(Task task) {

    }
}
