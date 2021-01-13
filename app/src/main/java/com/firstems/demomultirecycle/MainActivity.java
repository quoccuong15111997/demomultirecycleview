package com.firstems.demomultirecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.firstems.demomultirecycle.model.ParentModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ParentModel> parentModels;
    private ParentAdapter parentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();

    }

    private void addEvents() {
        parentAdapter.setChildClickCallback((pos, value) -> {
            Toast.makeText(this,"Child Click: "+value,Toast.LENGTH_LONG).show();
        });
    }

    private void addControls() {
        recyclerView = findViewById(R.id.recycle);
        parentModels = new ArrayList<>();
        parentAdapter = new ParentAdapter(parentModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(parentAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        invokeData();
    }

    private void invokeData() {
        for (int i = 1 ;i <= 5;i++ ){
            ParentModel parentModel = new ParentModel();
            parentModel.setTitle("Title :"+i);
            List<String> s =  new ArrayList<>();
            for (int j = 1; j <= 20;j++){
                s.add("Child: "+j);
            }
            parentModel.setListChild(s);
            parentModels.add(parentModel);
        }
        parentAdapter.notifyDataSetChanged();
    }
}