package com.example.roomtest.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.database.toyInfo;

import java.util.List;

public class ListAdapterTouchHelperCallback extends ItemTouchHelper.Callback {

    ItemTouchHelperAdapter mAdapter;
    ListAdapter mListAdapter;
    List<toyInfo> mList;

    public ListAdapterTouchHelperCallback(ItemTouchHelperAdapter adapter/*, ListAdapter listAdapter*/, List<toyInfo> data) {
        mAdapter = adapter;
        //mListAdapter = listAdapter;
        //mListAdapter.notifyDataSetChanged();
        mList = data;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        //mAdapter.onItemPositionChange(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        //return true;
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDelete(viewHolder.getAdapterPosition(), getToyList());
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public List<toyInfo> getToyList() {
        return mList;
    }
}
