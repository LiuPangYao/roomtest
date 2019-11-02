package com.example.roomtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.roomtest.database.FakeData;
import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.recyclerview.ListAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private String TAG = "MainActivity";
    dataBase dataInstance = null;
    boolean isDataReady = false;
    boolean isDeveloper = false;
    SharedPreferences shared = null;

    private TextView mTextViewEmpty, mTextViewTitle;
    private ProgressBar mProgressBarLoading;
    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;
    private ImageButton mImageButton;

    List<toyInfo> toyList = null;

    private boolean isStaggeredAdapter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        init();

        // avoid data repeat store
        shared = getSharedPreferences("first_open", MODE_PRIVATE);
        isDataReady = shared.getBoolean("isReady", false);
        isDeveloper = shared.getBoolean("isDeveloper",false);

        //init
        dataInstance = dataBase.getInstance(this);

        // do not run in main thread
        testTask asyncTask = new testTask(this);
        asyncTask.execute("start");

        checkDataSize();
    }

    public void init() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mTextViewEmpty = findViewById(R.id.textViewEmpty);
        mProgressBarLoading = findViewById(R.id.progressBarLoading);
        mImageButton = findViewById(R.id.imageButton_menu);
        mImageButton.setOnClickListener(this);
        mTextViewTitle = findViewById(R.id.textViewTitle);
        mTextViewTitle.setOnLongClickListener(this);
    }

    public void initAdapter() {
        // init
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        // show data
        mListadapter = new ListAdapter(toyList, this);
        mListadapter.setItemStyle(Constants.LINEARITEM);
        mRecyclerView.setAdapter(mListadapter);
        mListadapter.notifyDataSetChanged();
    }

    public void initAdapterV2() {
        // init
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        // show data
        mListadapter = new ListAdapter(toyList, this);
        mListadapter.setItemStyle(Constants.STAGGERITEM);
        mRecyclerView.setAdapter(mListadapter);
        mListadapter.notifyDataSetChanged();
    }

    public void printData() {
        toyList = dataBase.getInstance(this).getToyDao().getAll();

        if(toyList.size() > 0){
            for(int i = 0 ; i < toyList.size() ; i ++) {
                Log.d(TAG, "printData: name = " + toyList.get(i).getName() + ", buyPrice = " + toyList.get(i).getBuyPrice() + ", web = " + toyList.get(i).getWeb());
            }
        }
    }

    public void saveData() {
        FakeData.setData(this);
        if(!isDataReady) {
            boolean isFakeDataReady = true;
            shared.edit().putBoolean("isReady", isFakeDataReady).commit();
            isDataReady = true;
            Log.d(TAG, "dataBase is empty");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton_menu:
                if(!isDataReady) {
                    return;
                } else {
                    if(!isStaggeredAdapter) {
                        initAdapterV2();
                        mImageButton.setBackground(getResources().getDrawable(R.mipmap.menu_icon_1));
                        //ConstraintLayout.LayoutParams mParams = new ConstraintLayout.LayoutParams(30, 30);
                        //mImageButton.setLayoutParams(mParams);
                        isStaggeredAdapter = true;
                    } else {
                        initAdapter();
                        mImageButton.setBackground(getResources().getDrawable(R.mipmap.menu_icon_3));
                        isStaggeredAdapter = false;
                    }
                }
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.textViewTitle:
                if(!isDeveloper) {
                    Snackbar.make(v, this.getString(R.string.DEVELOPER), Snackbar.LENGTH_LONG).show();
                    isDeveloper = true;
                    // do not run in main thread
                    testTask asyncTask = new testTask(this);
                    asyncTask.execute("start");
                }
                break;
        }
        return false;
    }

    public void checkDataSize() {
        if(isDataReady) {
            mTextViewEmpty.setVisibility(View.GONE);
        } else {
            mTextViewEmpty.setVisibility(View.VISIBLE);
        }
    }

    class testTask extends AsyncTask<String, Integer, Boolean> {

        Context mContext = null;

        testTask(Context context){
            mContext = context;
        }

        protected Boolean doInBackground(String... strings) {

            if(isDeveloper && !isDataReady) {
                shared.edit().putBoolean("isDeveloper", true).commit();
                saveData();
            }
            printData();

            return true;
        }

        protected void onPostExecute(Boolean result) {
            checkDataSize();

            if(isDataReady) {
                if(isStaggeredAdapter) {
                    initAdapterV2();
                } else {
                    initAdapter();
                }
            }
        }
    }
}
