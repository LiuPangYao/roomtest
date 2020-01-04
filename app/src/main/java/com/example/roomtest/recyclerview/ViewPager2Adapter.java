package com.example.roomtest.recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.roomtest.R;

import java.util.List;

/**
 * 2020-01-04
 */
public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder> {

    private List<Drawable> mData;
    private LayoutInflater mInflater;
    private ViewPager2 viewPager2;
    String TAG = "ViewPager2Adapter";

    OnCurrentPageCallBack mCallback;

    // this callback not use
    public interface OnCurrentPageCallBack {
        void currentState(int totalPage, int currentPage);
    }

    public void setOnCurrentListener(OnCurrentPageCallBack mCallback) {
        this.mCallback = mCallback;
    }

    public ViewPager2Adapter(Context context, List<Drawable> data, ViewPager2 viewPager2) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.viewPager2 = viewPager2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.viewpager2_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setBackground(mData.get(position));
        holder.mImageView.setScaleType(ImageView.ScaleType.CENTER);
        Log.d(TAG, "onBindViewHolder = position " + position);

        // display current page
        //mCallback.currentState(mData.size(), (position + 1));
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_viewpager2);
        }
    }
}
