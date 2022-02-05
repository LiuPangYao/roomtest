package com.example.roomtest.asyncTask;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.roomtest.database.FakeData;
import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * 2022-02-05 整理
 */
public class InsertFakeDataAsyncTask extends AsyncTask<String, Integer, Boolean> {

    Context mContext = null;
    CompleteFakeCallBack callback;
    List<toyInfo> toyList = null;
    boolean isDataReady = false;
    boolean isDeveloper = false;
    String TAG = "InsertFakeDataAsyncTask";
    SharedPreferences shared;

    public interface CompleteFakeCallBack {
        void onTaskComplete(List<toyInfo> toyList, boolean dataReady, boolean developer);
    }

    public InsertFakeDataAsyncTask(Context context, CompleteFakeCallBack mCallback, boolean dataReady, boolean developer) {
        mContext = context;
        callback = mCallback;
        isDataReady = dataReady;
        isDeveloper = developer;
    }

    protected Boolean doInBackground(String... strings) {

        shared = mContext.getSharedPreferences("app_setting", MODE_PRIVATE);

        if (isDeveloper && !isDataReady) {
            shared.edit().putBoolean("isDeveloper", true).commit();
            saveData();
        }
        toyList = dataBase.getInstance(mContext).getToyDao().getAll();

        return true;
    }

    public void saveData() {
        FakeData.setData(mContext);
        if (!isDataReady) {
            boolean isFakeDataReady = true;
            shared.edit().putBoolean("isReady", isFakeDataReady).commit();
            isDataReady = true;
            Log.d(TAG, "dataBase is empty");
        }
    }

    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        callback.onTaskComplete(toyList, isDataReady, isDeveloper);
    }
}
