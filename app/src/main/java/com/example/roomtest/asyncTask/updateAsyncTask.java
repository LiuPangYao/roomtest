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
public class updateAsyncTask extends AsyncTask<toyInfo, Integer, Boolean> {

    Context mContext;
    String TAG = "updateAsyncTask";
    UpdateCallBack callback;
    List<toyInfo> toyList = null;

    public interface UpdateCallBack {
        void onUpdateTaskComplete(List<toyInfo> toyList);
    }

    public updateAsyncTask(Context context, UpdateCallBack  mCallBack) {
        mContext = context;
        callback = mCallBack;
    }

    @Override
    protected Boolean doInBackground(toyInfo... toyInfos) {
        toyInfo toyUpdate= toyInfos[0];
        dataBase dataInstance = dataBase.getInstance(mContext);
        dataBase.getInstance(mContext).getToyDao().update(toyUpdate);
        toyList = dataInstance.getToyDao().getAll();
        return true;
    }

    public void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        callback.onUpdateTaskComplete(toyList);
        //Log.d(TAG, "onPostExecute: update success");
    }
}
