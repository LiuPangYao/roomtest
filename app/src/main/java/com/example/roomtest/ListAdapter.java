package com.example.roomtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.database.toyInfo;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    private List<toyInfo> toyList;
    private Context context;
    public String TAG = "ListAdapter";

    public ListAdapter(List<toyInfo> data, Context context)
    {
        this.toyList = data;
        Log.d(TAG, "ListAdapter: " + toyList.size());
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgToy;
        TextView textViewName;
        TextView textViewDate;
        TextView textViewPrice;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.imgToy = (ImageView) itemView.findViewById(R.id.toy_imageView);
            this.textViewName = (TextView) itemView.findViewById(R.id.toy_name);
            this.textViewDate = (TextView) itemView.findViewById(R.id.toy_date);
            this.textViewPrice = (TextView) itemView.findViewById(R.id.toy_price);
        }
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
    {
        Log.d(TAG, "onBindViewHolder: test position " + position);
        holder.textViewName.setText(toyList.get(position).getName());
        holder.textViewDate.setText(toyList.get(position).getDate());
        holder.textViewPrice.setText(String.valueOf(toyList.get(position).getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(context, "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return toyList.size();
    }
}
