package com.example.roomtest.recyclerview;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_SETTLING;

/**
 * 2020-01-07
 */
public abstract class onLoadMoreListener extends RecyclerView.OnScrollListener {

    private int countItem;
    private int lastItem;
    private boolean isScrolled = false;
    private RecyclerView.LayoutManager layoutManager;
    private static int currentState;

    protected abstract void onLoading(int countItem, int lastItem);

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

        currentState = newState;

        if (newState == SCROLL_STATE_DRAGGING || newState == SCROLL_STATE_SETTLING) {
            isScrolled = true;
        } else {
            isScrolled = false;
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            layoutManager = recyclerView.getLayoutManager();
            countItem = layoutManager.getItemCount();
            lastItem = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }

        // comment out move to last position will called this
        // if (isScrolled && countItem != lastItem && lastItem == countItem - 1) {

        if(isScrolled && currentState == SCROLL_STATE_DRAGGING) {
            onLoading(countItem, lastItem);
        }
    }
}
