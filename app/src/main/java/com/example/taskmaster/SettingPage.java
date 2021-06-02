package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);


    }
    public void displayuser(View view) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preferenceEditor=sharedPref.edit();
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);

        EditText userName = (EditText) findViewById(R.id.editTextTextPersonName3);
        String name=userName.getText().toString();
        intent.putExtra("userName", name);
        preferenceEditor.putString("userName",name) ;
        preferenceEditor.apply();
        startActivity(intent);
    }
}