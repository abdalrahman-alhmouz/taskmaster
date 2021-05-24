package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        List<Task> mTask = new ArrayList<>();
//        Task task1 = new Task("hello","abd","alrahman");
//        Task task2 = new Task("hello","ahmad","kefak");
//        Task task3 = new Task("hello","ali","mohd");
//
//
//        mTask.add(task1);
//        mTask.add(task2);
//        mTask.add(task3);


        database = Room.databaseBuilder(getApplicationContext(), Database.class, "tasks")
                .allowMainThreadQueries()
                .build();
        TaskDao taskDao = database.taskDao();

        List<Task> tasks = taskDao.getAllTasks();



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        ContactAdapter adapter = new ContactAdapter(tasks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        System.out.println(adapter.toString()+"ssssssssssssssssssssssssssssssss");

        adapter.notifyDataSetChanged();

    }

    public void addTask(View view){
        Intent intent =new Intent(this,AddTask.class);
        startActivity(intent);

    }

    public void allTasks(View view){
        Intent intent =new Intent(this,AllTasks.class);
        startActivity(intent);

    }
    public void settingPage(View view){
        Intent intent =new Intent(this,SettingPage.class);
        startActivity(intent);

    }

    //    public void title(View view){
//        Intent intent =new Intent(this,TaskDetail.class);
//        startActivity(intent);
//
//    }
    public void tasks(View view){
        Button buttonMain=(Button)view;
        String title=buttonMain.getText().toString();
        Intent intent =new Intent(this,TaskDetail.class);
        intent.putExtra("title",title);
        startActivity(intent);

    }



}