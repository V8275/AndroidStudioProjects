package com.example.webserverapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CruiseAdapter extends RecyclerView.Adapter<CruiseAdapter.ViewHolder> {
    private List<Cruise> cruises;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public CruiseAdapter(List<Cruise> cruises, OnItemClickListener listener) {
        this.cruises = cruises;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cruise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cruise cruise = cruises.get(position);
        holder.textName.setText(cruise.getName());
        holder.textCapacity.setText("Вместимость: " + cruise.getPassengerCapacity());

        holder.buttonDelete.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cruises.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName;
        public TextView textCapacity;
        public Button buttonDelete;

        public ViewHolder(View view) {
            super(view);
            textName = view.findViewById(R.id.textName);
            textCapacity = view.findViewById(R.id.textCapacity);
            buttonDelete = view.findViewById(R.id.buttonDelete);
        }
    }
}