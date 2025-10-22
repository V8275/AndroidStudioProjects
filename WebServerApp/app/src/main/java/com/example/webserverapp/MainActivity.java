package com.example.webserverapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CruiseAdapter adapter;
    private List<Cruise> cruiseList = new ArrayList<>();
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        initializeViews();
        loadCruises();
    }

    private void initializeViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CruiseAdapter(cruiseList, new CruiseAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                deleteCruise(position);
            }
        });
        recyclerView.setAdapter(adapter);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(v -> addCruise());
    }

    private void loadCruises() {
        Call<List<Cruise>> call = apiService.getCruises();
        call.enqueue(new Callback<List<Cruise>>() {
            @Override
            public void onResponse(Call<List<Cruise>> call, Response<List<Cruise>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    cruiseList.clear();
                    cruiseList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Cruise>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ошибка загрузки", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addCruise() {
        EditText editName = findViewById(R.id.editTextName);
        EditText editCapacity = findViewById(R.id.editTextCapacity);

        String name = editName.getText().toString();
        String capacityStr = editCapacity.getText().toString();

        if (name.isEmpty() || capacityStr.isEmpty()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        int capacity = Integer.parseInt(capacityStr);
        Cruise newCruise = new Cruise(name, capacity);

        Call<Cruise> call = apiService.addCruise(newCruise);
        call.enqueue(new Callback<Cruise>() {
            @Override
            public void onResponse(Call<Cruise> call, Response<Cruise> response) {
                if (response.isSuccessful()) {
                    editName.setText("");
                    editCapacity.setText("");
                    loadCruises();
                    Toast.makeText(MainActivity.this, "Добавлено", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cruise> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ошибка добавления", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteCruise(int position) {
        Cruise cruise = cruiseList.get(position);
        Call<Void> call = apiService.deleteCruise(cruise.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    loadCruises();
                    Toast.makeText(MainActivity.this, "Удалено", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ошибка удаления", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
