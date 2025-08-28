package com.example.lab11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ColorPickerActivity extends AppCompatActivity {

    private View colChangeLayout;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "ColorPrefs";
    private static final String KEY_COLOR = "background_color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        ListView listView = findViewById(R.id.color_list);
        String[] colorNames = getResources().getStringArray(R.array.color_names);
        String[] colorValues = getResources().getStringArray(R.array.color_values);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colorNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            try {
                // Получение выбранного цвета
                String selectedColor = colorValues[position];
                int color = Color.parseColor(selectedColor);

                // Сохранение цвета в SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(KEY_COLOR, color);
                editor.apply();

                // Переход на главную активность
                Intent intent = new Intent(ColorPickerActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(ColorPickerActivity.this, "Ошибка при выборе цвета", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        colChangeLayout = findViewById(R.id.activity_color_selection);
        int color = sharedPreferences.getInt(KEY_COLOR, Color.WHITE);
        colChangeLayout.setBackgroundColor(color);
    }
}

