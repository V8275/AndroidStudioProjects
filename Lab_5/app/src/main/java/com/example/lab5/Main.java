package com.example.lab5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonEdit = findViewById(R.id.buttonEdit);
        Button buttonDel = findViewById(R.id.buttonDel);
        Button buttonClear = findViewById(R.id.buttonClear);

        itemList = new ArrayList<>();
        itemList.add("first");
        itemList.add("second");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (selectedPosition != -1) {
                    // Сброс цвета для ранее выбранного элемента
                    parent.getChildAt(selectedPosition).setBackgroundColor(Color.TRANSPARENT);
                }
                selectedPosition = position;
                view.setBackgroundColor(Color.YELLOW); // Устанавливаем цвет для выбранного элемента
                editText.setText(itemList.get(position)); // Копируем текст в EditText
            }
        });

        buttonAdd.setOnClickListener(v -> {
            String newItem = editText.getText().toString();
            if (!newItem.isEmpty()) {
                itemList.add(newItem);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        buttonEdit.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                String editedItem = editText.getText().toString();
                if (!editedItem.isEmpty()) {
                    itemList.set(selectedPosition, editedItem);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        buttonDel.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                itemList.remove(selectedPosition);
                adapter.notifyDataSetChanged();
                selectedPosition = -1; // Сбрасываем выбор
                editText.setText("");
            }
        });

        buttonClear.setOnClickListener(v -> {
            itemList.clear();
            adapter.notifyDataSetChanged();
            editText.setText("");
            selectedPosition = -1; // Сбрасываем выбор
        });
    }
}

