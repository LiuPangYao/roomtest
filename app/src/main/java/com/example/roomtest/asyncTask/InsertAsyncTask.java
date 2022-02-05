package com.example.roomtest.asyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;

import java.util.List;

/**
 * 2022-02-05 整理
 */
public class InsertAsyncTask extends AsyncTask<toyInfo, Integer, Boolean> {

    Context mContext = null;
    CompleteCallBack callback;
    List<toyInfo> toyList = null;
    String TAG = "InsertAsyncTask";

    public interface CompleteCallBack {
        void onTaskComplete(List<toyInfo> toyList);
    }

    public InsertAsyncTask(Context context, CompleteCallBack mCallBack) {
        mContext = context;
        callback = mCallBack;
    }

    public Boolean doInBackground(toyInfo... toySample) {

        dataBase dataInstance = null;
        dataInstance = dataBase.getInstance(mContext);

        toyInfo toyInsert = toySample[0];

        toyInfo toy = new toyInfo();
        toy.setName(toyInsert.getName());
        toy.setBuyPrice(toyInsert.getBuyPrice());
        toy.setSellPrice(toyInsert.getSellPrice());
        toy.setWeb(toyInsert.getWeb());
        toy.setImageUri(toyInsert.getImageUri());
        toy.setDate(toyInsert.getDate());
        toy.setSoldState(toyInsert.getSoldState());
        toy.setGain(toyInsert.getGain());
        dataInstance.getToyDao().insert(toy);

        toyList = dataInstance.getToyDao().getAll();
        Log.d(TAG, "InsertAsyncTask doInBackground: done");

        return true;
    }

    public void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        callback.onTaskComplete(toyList);
    }
}
