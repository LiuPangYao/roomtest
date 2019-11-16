package com.example.roomtest.recyclerview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.ToyConstants;
import com.example.roomtest.Diaog.editDialogFragment;
import com.example.roomtest.R;
import com.example.roomtest.WebActivity;
import com.example.roomtest.asyncTask.deleteAsyncTask;
import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.listSort;
import com.example.roomtest.database.toyInfo;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements
        ItemTouchHelperAdapter//,
        //deleteDialogFragment.deleteDialogListener
        {

    List<toyInfo> toyList = new ArrayList<toyInfo>();
    List<toyInfo> toyListRestore = new ArrayList<toyInfo>();

    OnDeleteListener mCallback;
    AlertDialog dialog;

    private Context context;
    public String TAG = "ListAdapter";
    private int itemStyle = ToyConstants.LINEARITEM;
    private int dateStyle = ToyConstants.DATE_OLD_NEW;

    public ListAdapter(List<toyInfo> data, Context con) {

        toyList.clear();
        toyList.addAll(data);
        Log.d(TAG, "toyList size pre prepare = " + toyList.size());
        context = con;

        // add for after delete, database size = 0
        //if(toyList.size() == 0) {
            //mCallback.deleteStateNone();
            //Log.d(TAG, "getItemCount: 0");
        //}

        //Log.d(TAG, "ListAdapter: " + toyList.size());
        Log.d(TAG, "ListAdapter: list update size");
        //notifyDataSetChanged();
    }

    public ListAdapter(Context context) {
        this.context = context;
    }

    // check for list size is 0
    public interface OnDeleteListener {
        void deleteStateNone();
    }

    public void setOnDeleteListener(OnDeleteListener mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void onItemPositionChange(int fromPosition, int toPosition) {
        Collections.swap(toyList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDelete(int position, List<toyInfo> mList) {

        final int mPosition = position;
        Log.d(TAG, "onItemDelete: " + position);
        Log.d(TAG, "toyList size prepare1 = " + toyList.size());
        Log.d(TAG, "toyList size prepare2 = " + mList.size());
        Log.d(TAG, "toyList size prepare3 = " + getToyList().size());

        notifySetListDataChanged(toyList);

        dialog = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.DELETE))
                .setMessage(context.getString(R.string.DELETE_CHECK))
                .setPositiveButton(R.string.OK,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                Log.d(TAG, "toyList size = " + toyList.size());
                                toyInfo storeToy = toyList.get(mPosition);

                                // database delete
                                deleteAsyncTask task = new deleteAsyncTask(context);
                                task.execute(storeToy);

                                //mList.remove(mPosition);
                                toyList.remove(mPosition);

                                notifyItemRemoved(mPosition);
                                notifyDataSetChanged();

                                dialog.dismiss();
                            }
                        }
                )
                .setNegativeButton(R.string.CANCEL,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        }
                )
                .create();

        dialog.show();

    }

    public void setItemStyle(int style) {
        this.itemStyle = style;
    }

    public void setDateOrder(int style) {
        dateStyle = style;
        toyListRestore = listSort.sortlist(dateStyle, toyList);
        toyList.clear();
        toyList.addAll(toyListRestore);
        toyListRestore.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgToy;
        TextView textViewName;
        TextView textViewDate;
        TextView textViewBuyPrice;
        TextView textViewSellPrice;
        TextView textViewState;
        TextView textViewPriceState;
        RelativeLayout relativeLayoutColor;

        public ViewHolder(View itemView) {
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
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (itemStyle == ToyConstants.LINEARITEM) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cardview, parent, false);
        } else if (itemStyle == ToyConstants.STAGGERITEM) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_cardview_v2, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: test position " + position);
        holder.textViewName.setText(toyList.get(position).getName());
        holder.textViewDate.setText(/*context.getString(R.string.DATE_ACQUISITION) +*/ toyList.get(position).getDate());
        holder.textViewBuyPrice.setText(context.getString(R.string.P_PRICE) + " " + String.valueOf(toyList.get(position).getBuyPrice()));
        holder.textViewSellPrice.setText(context.getString(R.string.PRICE) + " " + String.valueOf(toyList.get(position).getSellPrice()));

        if (toyList.get(position).getGain() == ToyConstants.INCREASE) {
            //holder.relativeLayoutColor.setBackgroundColor(ContextCompat.getColor(context, R.color.colorIncrease));
            holder.textViewPriceState.setText(context.getResources().getString(R.string.PRICE_INCREASE));
            holder.textViewPriceState.setTextColor(ContextCompat.getColor(context, R.color.colorDarkRed));
        } else if (toyList.get(position).getGain() == ToyConstants.COMMON) {
            //holder.relativeLayoutColor.setBackgroundColor(ContextCompat.getColor(context, R.color.colorCommon));
            holder.textViewPriceState.setText(context.getResources().getString(R.string.PRICE_COMMON));
            holder.textViewPriceState.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
        } else if (toyList.get(position).getGain() == ToyConstants.FALLING) {
            //holder.relativeLayoutColor.setBackgroundColor(ContextCompat.getColor(context, R.color.colorFalling));
            holder.textViewPriceState.setText(context.getResources().getString(R.string.PRICE_FALLING));
            holder.textViewPriceState.setTextColor(ContextCompat.getColor(context, R.color.colorFalling));
        }

        if (toyList.get(position).getSoldState() == ToyConstants.PRE_ORDER) {
            holder.textViewState.setText(context.getString(R.string.PRE_ORDER));
        } else if (toyList.get(position).getSoldState() == ToyConstants.SOLD_OUT) {
            holder.textViewState.setText(context.getString(R.string.SOLD_OUT));
        } else if (toyList.get(position).getSoldState() == ToyConstants.SELL) {
            holder.textViewState.setText(context.getString(R.string.SELL));
        }

        Log.d(TAG, "url = " + Uri.parse(toyList.get(position).getImageUri()));

        //Picasso
        Picasso.get()
                .load(Uri.parse(toyList.get(position).getImageUri() + ".png")) // internet path
                //.placeholder(R.mipmap.app_launcher_main_foreground)  // preload
                .error(R.mipmap.app_launcher_main_foreground)        // load error
                .into(holder.imgToy);  // component

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                if (!toyList.get(position).getWeb().equals("")) {
                    Intent intent = new Intent(context, WebActivity.class);
                    intent.putExtra("mId", toyList.get(position).getId());
                    context.startActivity(intent);
                } else {
                    Snackbar.make(v, context.getString(R.string.WEBVIEW_NOT_SUPPORT), Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (!toyList.get(position).getWeb().equals("")) {
                    //Log.d(TAG, "onLongClick: " + position);
                    toyInfo toys = toyList.get(position);
                    FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
                    editDialogFragment dialog = editDialogFragment.instance(context.getString(R.string.UPDATE_INFO), ToyConstants.ACTION_UPDATE, toys);
                    dialog.show(manager, "update");
                } else {
                    Snackbar.make(v, "error!", Snackbar.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {

        // list size = 0
        if(toyList.size() == 0) {
            mCallback.deleteStateNone();
            Log.d(TAG, "getItemCount: 0");
        }

        return toyList.size();
    }

    public List<toyInfo> getToyList() {
        return toyList;
    }

    public void notifySetListDataChanged(List<toyInfo>list){
        this.toyList = list;
        notifyDataSetChanged();
    }
}
