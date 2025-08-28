package com.example.lab10;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        String[] items = getResources().getStringArray(R.array.items_array);

        CustomAdapter adapter = new CustomAdapter(this, items);
        listView.setAdapter(adapter);
    }
}

