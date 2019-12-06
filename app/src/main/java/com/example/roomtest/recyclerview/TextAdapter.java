package com.example.roomtest.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.R;

import java.util.ArrayList;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    ArrayList<String> stringList = new ArrayList<>();

    private Context context;
    public String TAG = "TextAdapter";

    public TextAdapter(ArrayList<String> data, Context context) {
        this.stringList = data;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCenterTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewCenterTitle = itemView.findViewById(R.id.textViewCenterTitle);
        }
    }

    @Override
    public TextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewCenterTitle.setText(stringList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}