package com.example.roomtest.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.Constants;
import com.example.roomtest.R;
import com.example.roomtest.WebActivity;
import com.example.roomtest.database.toyInfo;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    private List<toyInfo> toyList;
    private Context context;
    public String TAG = "ListAdapter";
    private int itemStyle = Constants.LINEARITEM;

    public ListAdapter(List<toyInfo> data, Context context)
    {
        this.toyList = data;
        //Log.d(TAG, "ListAdapter: " + toyList.size());
        this.context = context;
    }

    public void setItemStyle(int style) {
        itemStyle = style;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgToy;
        TextView textViewName;
        TextView textViewDate;
        TextView textViewBuyPrice;
        TextView textViewSellPrice;
        TextView textViewState;
        TextView textViewPriceState;
        RelativeLayout relativeLayoutColor;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.imgToy = itemView.findViewById(R.id.toy_imageView);
            this.textViewName = itemView.findViewById(R.id.toy_name);
            this.textViewDate = itemView.findViewById(R.id.toy_date);
            this.textViewBuyPrice = itemView.findViewById(R.id.toy_buy_price);
            this.textViewSellPrice = itemView.findViewById(R.id.toy_sell_price);
            this.relativeLayoutColor = itemView.findViewById(R.id.relative_background);
            this.textViewState = itemView.findViewById(R.id.toy_sell_state);
            this.textViewPriceState = itemView.findViewById(R.id.toy_sell_price_state);
        }
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = null;
        if(itemStyle == Constants.LINEARITEM) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cardview, parent, false);
        } else if(itemStyle == Constants.STAGGERITEM){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cardview_v2, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        Log.d(TAG, "onBindViewHolder: test position " + position);
        holder.textViewName.setText(toyList.get(position).getName());
        holder.textViewDate.setText(/*context.getString(R.string.DATE_ACQUISITION) +*/ toyList.get(position).getDate());
        holder.textViewBuyPrice.setText(context.getString(R.string.P_PRICE) + " " + String.valueOf(toyList.get(position).getBuyPrice()));
        holder.textViewSellPrice.setText(context.getString(R.string.PRICE) + " " + String.valueOf(toyList.get(position).getSellPrice()));

        if(toyList.get(position).getGain() == Constants.INCREASE) {
            //holder.relativeLayoutColor.setBackgroundColor(ContextCompat.getColor(context, R.color.colorIncrease));
            holder.textViewPriceState.setText(context.getResources().getString(R.string.PRICE_INCREASE));
            holder.textViewPriceState.setTextColor(ContextCompat.getColor(context, R.color.colorIncrease));
        } else if(toyList.get(position).getGain() == Constants.COMMON) {
            //holder.relativeLayoutColor.setBackgroundColor(ContextCompat.getColor(context, R.color.colorCommon));
            holder.textViewPriceState.setText(context.getResources().getString(R.string.PRICE_COMMON));
            holder.textViewPriceState.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
        } else if(toyList.get(position).getGain() == Constants.FALLING) {
            //holder.relativeLayoutColor.setBackgroundColor(ContextCompat.getColor(context, R.color.colorFalling));
            holder.textViewPriceState.setText(context.getResources().getString(R.string.PRICE_FALLING));
            holder.textViewPriceState.setTextColor(ContextCompat.getColor(context, R.color.colorFalling));
        }

        if(toyList.get(position).getSoldState() == Constants.PRE_ORDER) {
            holder.textViewState.setText(context.getString(R.string.PRE_ORDER));
        } else if(toyList.get(position).getSoldState() == Constants.SOLD_OUT) {
            holder.textViewState.setText(context.getString(R.string.SOLD_OUT));
        } else if(toyList.get(position).getSoldState() == Constants.SELL) {
            holder.textViewState.setText(context.getString(R.string.SELL));
        }

        Log.d(TAG, "url = " + Uri.parse(toyList.get(position).getImageUri()));

        //Picasso
        Picasso.get()
                .load(Uri.parse(toyList.get(position).getImageUri()+".png")) // internet path
                //.placeholder(R.mipmap.app_launcher_main_foreground)  // preload
                .error(R.mipmap.app_launcher_main_foreground)        // load error
                .into(holder.imgToy);  // component

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(context, "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                if(!toyList.get(position).getWeb().equals("")) {
                    Intent intent = new Intent(context, WebActivity.class);
                    intent.putExtra("mId", toyList.get(position).getId());
                    context.startActivity(intent);
                } else {
                    Snackbar.make(v, context.getString(R.string.WEBVIEW_NOT_SUPPORT), Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return toyList.size();
    }
}
