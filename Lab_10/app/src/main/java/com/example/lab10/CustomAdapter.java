package com.example.lab10;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] items;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView textView = view.findViewById(R.id.item_text);
        textView.setText(items[position]);

        if (position % 2 == 0) {
            view.setBackgroundColor(Color.RED);
        } else {
            view.setBackgroundColor(Color.BLUE);
        }

        return view;
    }
}

