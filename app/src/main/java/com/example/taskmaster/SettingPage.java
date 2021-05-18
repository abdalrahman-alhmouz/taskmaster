package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;

public class SettingPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preferenceEditor=sharedPref.edit();

        Button saveButton=findViewById(R.id.button5);

        saveButton.setOnClickListener((view)->{
            EditText userName=findViewById(R.id.editTextTextPersonName3);
            String name=userName.getText().toString();
            preferenceEditor.putString("userName",name) ;
            preferenceEditor.apply();

            Intent intent=new Intent(SettingPage.this,MainActivity.class);
            startActivity(intent);

        });
    }
}