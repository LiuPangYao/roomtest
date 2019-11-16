package com.example.roomtest.asyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;

public class deleteAsyncTask extends AsyncTask<toyInfo, Integer, Boolean> {

    Context mContext;
    String TAG = "deleteAsyncTask";

    public deleteAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected Boolean doInBackground(toyInfo... toyInfos) {
        toyInfo toyDelete = toyInfos[0];
        dataBase.getInstance(mContext).getToyDao().delete(toyDelete);
        return true;
    }

    public void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        Log.d(TAG, "onPostExecute: delete success");
    }
}
