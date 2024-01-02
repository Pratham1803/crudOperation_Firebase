package com.example.crudInFireBase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void btnAdd_Clicked(View v) {
        Intent intent = new Intent(this, activityAddRecord.class);
        startActivity(intent);
    }

    public void btnDisplay_Clicked(View v) {
        Intent intent = new Intent(this, activityDisplay.class);
        startActivity(intent);
    }

    public void btnSearch_Clicked(View v) {
        Intent intent = new Intent(this, activityAddRecord.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}