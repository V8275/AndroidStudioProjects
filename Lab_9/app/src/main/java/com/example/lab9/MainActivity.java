package com.example.lab9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextString1;
    private EditText editTextString2;
    private EditText editTextInteger;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_STRING1 = "string1";
    private static final String KEY_STRING2 = "string2";
    private static final String KEY_INTEGER = "integer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextString1 = findViewById(R.id.editTextString1);
        editTextString2 = findViewById(R.id.editTextString2);
        editTextInteger = findViewById(R.id.editTextInteger);

        loadPreferences();
    }

    @Override
    protected void onPause() {
        super.onPause();
        savePreferences();
    }

    private void savePreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_STRING1, editTextString1.getText().toString());
        editor.putString(KEY_STRING2, editTextString2.getText().toString());
        editor.putInt(KEY_INTEGER, Integer.parseInt(editTextInteger.getText().toString()));
        editor.apply();
    }

    private void loadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editTextString1.setText(sharedPreferences.getString(KEY_STRING1, ""));
        editTextString2.setText(sharedPreferences.getString(KEY_STRING2, ""));
        editTextInteger.setText(String.valueOf(sharedPreferences.getInt(KEY_INTEGER, 0)));
    }
}

