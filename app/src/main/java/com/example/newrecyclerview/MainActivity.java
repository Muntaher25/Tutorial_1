package com.example.newrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] images = {
            R.drawable.facebook,R.drawable.gallery,
            R.drawable.instagram,
            R.drawable.messenger,R.drawable.whatsapp,R.drawable.pinterset,R.drawable.telegram
    };

    String[] title, description;
    My_Adapter my_adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview_id);
        title = getResources().getStringArray(R.array.App_names);
        description = getResources().getStringArray(R.array.App_des);

        my_adapter = new My_Adapter(this,title,description,images);
        recyclerView.setAdapter(my_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        my_adapter.setOnItemClickListener(new My_Adapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(MainActivity.this, "Onitem click: "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(MainActivity.this, "Onitemlong click: "+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}