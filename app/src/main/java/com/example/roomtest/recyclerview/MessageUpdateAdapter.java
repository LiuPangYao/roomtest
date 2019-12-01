package com.example.roomtest.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.R;
import com.example.roomtest.firestore.UpdateMessage;

import java.util.ArrayList;

public class MessageUpdateAdapter extends RecyclerView.Adapter<MessageUpdateAdapter.ViewHolder> {

    ArrayList<UpdateMessage> updateMessageList = new ArrayList<UpdateMessage>();

    private Context context;
    public String TAG = "MessageUpdateAdapter";

    public MessageUpdateAdapter(ArrayList<UpdateMessage> data, Context context) {
        this.updateMessageList = data;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDate;
        TextView textViewVersion;
        TextView textViewDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewDate = itemView.findViewById(R.id.textView_date);
            this.textViewVersion = itemView.findViewById(R.id.textView_version);
            this.textViewDetail = itemView.findViewById(R.id.textView_details);
        }
    }

    @NonNull
    @Override
    public MessageUpdateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_update_item, parent, false);
        MessageUpdateAdapter.ViewHolder viewHolder = new MessageUpdateAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageUpdateAdapter.ViewHolder holder, int position) {
        holder.textViewVersion.setText(updateMessageList.get(position).getVersion());
        holder.textViewDate.setText(updateMessageList.get(position).getDate());

        ArrayList<String> arrayList = updateMessageList.get(position).getDetail();

        String visibleString = null;
        for( int i = 0 ; i < arrayList.size() ; i++) {
            if(i == 0) {
                visibleString = "1. " + arrayList.get(i).toString();
            } else {
                visibleString +=  "\n" + (i+1) + ". " +arrayList.get(i).toString();
            }
        }
        holder.textViewDetail.setText(visibleString);
    }

    @Override
    public int getItemCount() {
        return updateMessageList.size();
    }
}
