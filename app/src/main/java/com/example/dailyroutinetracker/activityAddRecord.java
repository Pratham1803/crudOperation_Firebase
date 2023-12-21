package com.example.dailyroutinetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activityAddRecord extends AppCompatActivity {

    EditText txtName;
    EditText txtEmailId;
    Button btnDelete;
    Button btnAddRecord;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("tblUser");

    public void btnAddRecord_Clicked(View v){
        if(btnAddRecord.getText().toString().equals(R.string.btnAdd)) {
            UserData user = new UserData(txtName.getText().toString(), txtEmailId.getText().toString());
            databaseReference.push().setValue(user);
            Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
        }
        else if(btnAddRecord.getText().toString().equals(R.string.btnUpdate)){

        }
        reset();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        txtName = findViewById(R.id.txtName);
        txtEmailId = findViewById(R.id.txtEmailId);
        btnDelete = findViewById(R.id.btnDelete);
        btnAddRecord = findViewById(R.id.btnAddRecord);

        try {
            Intent intent = getIntent();
            String[] data = intent.getStringArrayExtra("DataTransfer");
            fillTextBox(data);
        }catch (Exception e){
            Log.d("ErrorMsg", "onCreate: "+e.toString());
        }
    }

    public void fillTextBox(String[] data){
        txtName.setText(data[0]);
        txtEmailId.setText(data[1]);
        btnAddRecord.setText(R.string.btnUpdate);
        btnDelete.setVisibility(View.VISIBLE);
    }

    private void reset(){
        txtEmailId.setText("");
        txtName.setText("");
    }
}