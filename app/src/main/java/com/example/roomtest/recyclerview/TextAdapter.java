package com.example.roomtest.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.R;
import com.example.roomtest.databinding.ComponentItemBinding;

import java.util.ArrayList;

/**
 * 2021-10-11 view binding
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    ArrayList<String> stringList = new ArrayList<>();

    private Context context;
    public static final String TAG = "TextAdapter";
    private ComponentItemBinding binding;

    public TextAdapter(ArrayList<String> data, Context context) {
        this.stringList = data;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            binding = ComponentItemBinding.bind(itemView);
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
        binding.textViewCenterTitle.setText(stringList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}