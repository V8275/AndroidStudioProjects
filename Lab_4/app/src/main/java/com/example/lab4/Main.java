package com.example.lab4;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private EditText inputA, inputB, outputResult;
    private Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        outputResult = findViewById(R.id.outputResult);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        inputA.setBackgroundColor(Color.parseColor("#FFF3E0"));
        inputB.setBackgroundColor(Color.parseColor("#FFF3E0"));
        outputResult.setBackgroundColor(Color.parseColor("#E3F2FD"));

        buttonPlus.setOnClickListener(v -> calculate('+'));
        buttonMinus.setOnClickListener(v -> calculate('-'));
        buttonMultiply.setOnClickListener(v -> calculate('*'));
        buttonDivide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operation) {
        try {
            double a = Double.parseDouble(inputA.getText().toString());
            double b = Double.parseDouble(inputB.getText().toString());
            double result;

            switch (operation) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
                default:
                    result = 0;
            }

            outputResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Введите корректные числа", Toast.LENGTH_SHORT).show();
        }
    }
}
