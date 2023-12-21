package com.example.dailyroutinetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class activityDisplay extends AppCompatActivity {
    SearchView txtSearchBox;
    RecyclerView recyclerViewDisplay;

    private DatabaseReference fbDataBase = FirebaseDatabase.getInstance().getReference().child("tblUser");

    DisplayAdapter displayAdapter;
    List<UserData> userDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerViewDisplay = findViewById(R.id.recyclerViewDisplay);

        displayAdapter = new DisplayAdapter(this,userDataList);
        recyclerViewDisplay.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDisplay.setAdapter(displayAdapter);

        txtSearchBox = findViewById(R.id.txtSearch);

        txtSearchBox.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dbSearch();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText!="")
                    dbSearch();
                return true;
            }
        });

        dbShowData();
    }
    private void dbSearch(){
        userDataList.clear();
        String str = txtSearchBox.getQuery().toString();
        fbDataBase.orderByChild("userName").startAt(str).endAt(str+"~").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapShot : snapshot.getChildren()){
                    UserData user = postSnapShot.getValue(UserData.class);
                    userDataList.add(user);
                }
                displayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void dbShowData(){
        fbDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapShot : snapshot.getChildren()){
                    UserData user = postSnapShot.getValue(UserData.class);
                    Log.d("ReadData", "User Name: "+user.getUserName()+" Email id : "+user.getUserEmailId());
                    userDataList.add(user);
                }
                displayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}