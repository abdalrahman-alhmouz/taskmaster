package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textView=findViewById(R.id.displayUser);
        String user=sharedPref.getString("userName","user");
        textView.setText(user);



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