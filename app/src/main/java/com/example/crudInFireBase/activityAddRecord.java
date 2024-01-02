package com.example.crudInFireBase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class activityAddRecord extends AppCompatActivity {

    EditText txtName;
    EditText txtEmailId;
    Button btnDelete;
    Button btnAddRecord;
    String[] data;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("tblUser");

    public void btnAddRecord_Clicked(View v) {

        if (btnAddRecord.getText().toString().equals("Add Data")) {
            UserData user = new UserData(txtName.getText().toString(), txtEmailId.getText().toString());
            databaseReference.push().setValue(user);
            Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
            Log.d("ErrorMsg", "Data added");
        } else if (btnAddRecord.getText().toString().equals("Update")) {
            Map<String, Object > map = new HashMap<>();
            map.put("userEmailId",txtEmailId.getText().toString());
            map.put("userName",txtName.getText().toString());

            databaseReference.child(data[2]).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(activityAddRecord.this, "Updated", Toast.LENGTH_SHORT).show();
                }
            });
            Intent i = new Intent(this, activityDisplay.class);
            startActivity(i);
            btnAddRecord.setText(R.string.btnAdd);
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
            data = intent.getStringArrayExtra("DataTransfer");
            fillTextBox(data);
        } catch (Exception e) {
            Log.d("ErrorMsg", "onCreate: " + e.toString());
        }
    }

    public void btnDelete_Clicked(View v){
        Toast.makeText(this, "Data" + data[2], Toast.LENGTH_SHORT).show();
        databaseReference.child(data[2]).removeValue();
        Intent i = new Intent(this, activityDisplay.class);
        startActivity(i);
    }

    public void fillTextBox(String[] data) {
        txtName.setText(data[0]);
        txtEmailId.setText(data[1]);
        btnAddRecord.setText(R.string.btnUpdate);
        btnDelete.setVisibility(View.VISIBLE);
    }

    private void reset() {
        txtEmailId.setText("");
        txtName.setText("");
    }
}