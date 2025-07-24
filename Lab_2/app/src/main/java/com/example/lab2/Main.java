package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    TextView textView1, textView2;
    Button buttonAdd, buttonCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        // Инициализация всех элементов интерфейса
        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2); // Предположим, что у второго TextView id = tv2
        buttonAdd = findViewById(R.id.buttonAdd); // Предположим, что у кнопки Add id = buttonAdd
        buttonCopy = findViewById(R.id.buttonCopy); // Предположим, что у кнопки Result id = buttonCopy
    }

    public void onAdd(View view){
        String currentText = textView1.getText().toString();
        textView1.setText(currentText + "*"); // Добавляем звездочку
    }

    public void onCopy(View view){
        String textToCopy = textView1.getText().toString();
        textView2.setText(textToCopy); // Копируем содержимое
    }
}
