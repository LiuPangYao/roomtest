package com.example.roomtest.recyclerview;

import com.example.roomtest.database.toyInfo;

import java.util.List;

public interface ItemTouchHelperAdapter {

    // position change
    void onItemPositionChange(int fromPosition,int toPosition);

    // item delete, database delete
    void onItemDelete(int position, List<toyInfo> list);

}
