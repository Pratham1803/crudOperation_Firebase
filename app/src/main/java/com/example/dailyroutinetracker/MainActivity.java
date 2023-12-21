package com.example.dailyroutinetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public void btnAdd_Clicked(View v){
        Intent intent = new Intent(this, activityAddRecord.class);
        startActivity(intent);
    }

    public void btnDisplay_Clicked(View v){
        Intent intent = new Intent(this, activityDisplay.class);
        startActivity(intent);
    }

    public void btnSearch_Clicked(View v){
        Intent intent = new Intent(this, activityAddRecord.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}