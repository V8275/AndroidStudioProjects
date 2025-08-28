package com.example.lab11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View mainLayout;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "ColorPrefs";
    private static final String KEY_COLOR = "background_color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Установка цвета фона из SharedPreferences
        int color = sharedPreferences.getInt(KEY_COLOR, Color.WHITE);
        mainLayout.setBackgroundColor(color);

        Button button = findViewById(R.id.choose_color_button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ColorPickerActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Обновление цвета фона при возвращении
        int color = sharedPreferences.getInt(KEY_COLOR, Color.WHITE);
        mainLayout.setBackgroundColor(color);
    }
}

