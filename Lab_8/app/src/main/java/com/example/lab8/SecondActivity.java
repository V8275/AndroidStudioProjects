package com.example.lab8;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<String> list1 = new ArrayList<>();
    private ArrayList<String> list2 = new ArrayList<>();
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView1 = findViewById(R.id.listView1);
        ListView listView2 = findViewById(R.id.listView2);
        EditText editText = findViewById(R.id.editText);
        Button addToList1Button = findViewById(R.id.addToList1Button);
        Button addToList2Button = findViewById(R.id.addToList2Button);
        Button backButton = findViewById(R.id.backButton);

        String[] array1 = getResources().getStringArray(R.array.list1_items);
        String[] array2 = getResources().getStringArray(R.array.list2_items);

        list1.addAll(Arrays.asList(array1));
        list2.addAll(Arrays.asList(array2));

        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list1);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list2);
        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);

        addToList1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    list1.add(text);
                    adapter1.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        addToList2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    list2.add(text);
                    adapter2.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
