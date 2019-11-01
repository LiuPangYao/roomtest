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

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "MainActivity";
    dataBase dataInstance = null;
    boolean isReady = false;
    SharedPreferences shared = null;

    private TextView mTextViewEmpty;
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

        // avoid data repeat
        shared = getSharedPreferences("first_open", MODE_PRIVATE);
        isReady = shared.getBoolean("isReady", false);
        if(!isReady) {
            boolean isFakeDataReady = true;
            shared.edit().putBoolean("isReady", isFakeDataReady).commit();
            Log.d(TAG, "dataBase is empty");
        } else {
            Log.d(TAG, "dataBase already setting");
        }

        //init
        dataInstance = dataBase.getInstance(this);

        // do not run in main thread
        testTask asyncTask = new testTask(this);
        asyncTask.execute("start");

        init();
    }

    public void init() {
        mRecyclerView = findViewById(R.id.recyclerView);
        //not use
        mTextViewEmpty = findViewById(R.id.textViewEmpty);
        mProgressBarLoading = findViewById(R.id.progressBarLoading);
        mImageButton = findViewById(R.id.imageButton_menu);
        mImageButton.setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton_menu:
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
                break;
        }
    }

    class testTask extends AsyncTask<String, Integer, Boolean> {

        Context mContext = null;

        testTask(Context context){
            mContext = context;
        }

        protected Boolean doInBackground(String... strings) {
            if(!isReady) {
                saveData();
            }
            printData();
            return true;
        }

        protected void onPostExecute(Boolean result) {
            initAdapter();
        }
    }
}
