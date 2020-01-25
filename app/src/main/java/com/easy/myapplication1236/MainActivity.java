package com.easy.myapplication1236;

import android.os.Bundle;

import com.easy.myapplication1236.adapter.RecyclerViewAdapter;
import com.easy.myapplication1236.adapter.TestModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<TestModel> testModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestModel testModel = new TestModel();

        testModels = new ArrayList<>();

        testModel.setId(25);
        testModels.add(testModel);
        TestModel testModel1 = new TestModel();
        testModel1.setId(145);
        testModels.add(testModel1);
        TestModel testModel2 = new TestModel();
        testModel2.setId(98);
        testModels.add(testModel2);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));

        recyclerViewAdapter = new RecyclerViewAdapter(testModels, this);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onItemClick(int id) {
        Log.v("APP", String.valueOf(id));
    }
}
