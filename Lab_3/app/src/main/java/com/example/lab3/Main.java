package com.example.lab3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private LinearLayout mainLayout;
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        mainLayout = findViewById(R.id.mainLayout);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        // Длинные кнопки
        Button buttonLong1 = findViewById(R.id.buttonLong1);
        buttonLong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextViewColors(Color.RED, Color.GREEN);
            }
        });

        Button buttonLong2 = findViewById(R.id.buttonLong2);
        buttonLong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextViewColors(Color.YELLOW, Color.BLUE);
            }
        });

        Button buttonLong3 = findViewById(R.id.buttonLong3);
        buttonLong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextViewColors(Color.BLACK, Color.WHITE);
            }
        });

        // Короткие кнопки
        Button buttonShort1 = findViewById(R.id.buttonShort1);
        buttonShort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityBackgroundColor(Color.RED);
            }
        });

        Button buttonShort2 = findViewById(R.id.buttonShort2);
        buttonShort2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityBackgroundColor(Color.BLUE);
            }
        });

        Button buttonShort3 = findViewById(R.id.buttonShort3);
        buttonShort3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityBackgroundColor(Color.BLACK);
            }
        });
    }

    private void setTextViewColors(int backgroundColor, int textColor) {
        textView1.setBackgroundColor(backgroundColor);
        textView1.setTextColor(textColor);
        textView2.setBackgroundColor(backgroundColor);
        textView2.setTextColor(textColor);
    }

    private void setActivityBackgroundColor(int color) {
        mainLayout.setBackgroundColor(color);
    }
}
