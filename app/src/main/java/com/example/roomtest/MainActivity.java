package com.example.roomtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.roomtest.database.FakeData;
import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.recyclerview.ListAdapter;
import com.example.roomtest.recyclerview.SimpleAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private String TAG = "MainActivity";
    dataBase dataInstance = null;
    boolean isDataReady = false;
    boolean isDeveloper = false;
    SharedPreferences shared = null;

    private TextView mTextViewEmpty, mTextViewTitle, mTextViewVersion;
    private ProgressBar mProgressBarLoading;
    private RecyclerView mRecyclerView, mRecyclerViewSimple;
    private ListAdapter mListadapter;
    private SimpleAdapter mSimpleAdapter;
    private ImageButton mImageButton, mImageDateButton;
    private RelativeLayout relativeLayoutEditor, relativeLayoutAbout;

    private TabLayout mTabLayout;

    List<toyInfo> toyList = null;
    List<String> simpleList = null;

    private boolean isStaggeredAdapter = false;
    private boolean isDateOrder = false;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        init();
        // admod
        initAdMod();

        // avoid data repeat store
        shared = getSharedPreferences("first_open", MODE_PRIVATE);
        isDataReady = shared.getBoolean("isReady", false);
        isDeveloper = shared.getBoolean("isDeveloper", false);

        // init
        dataInstance = dataBase.getInstance(this);

        // do not run in main thread
        testTask asyncTask = new testTask(this);
        asyncTask.execute("start");

        checkDataSize();
    }

    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    public void init() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mTextViewEmpty = findViewById(R.id.textViewEmpty);
        mProgressBarLoading = findViewById(R.id.progressBarLoading);
        mImageButton = findViewById(R.id.imageButton_menu);
        mImageDateButton = findViewById(R.id.imageButton_date);
        mImageButton.setOnClickListener(this);
        mImageDateButton.setOnClickListener(this);
        mTextViewTitle = findViewById(R.id.textViewTitle);
        mTextViewTitle.setOnLongClickListener(this);

        mTabLayout = findViewById(R.id.tabLayout);
        tabListener();

        relativeLayoutEditor = findViewById(R.id.relative_edit);

        relativeLayoutAbout = findViewById(R.id.relative_about);
        mTextViewVersion = findViewById(R.id.textViewVersion);
        mRecyclerViewSimple = findViewById(R.id.about_recyclerview);
        initSimpleAdapter();
    }

    public void initAdMod() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.d(TAG, "onInitializationComplete: done");
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build();
                adView.loadAd(adRequest);
            }
        });
    }

    public void tabListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        relativeLayoutEditor.setVisibility(View.GONE);
                        relativeLayoutAbout.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.VISIBLE);
                        if (!isDataReady)
                            mTextViewEmpty.setVisibility(View.VISIBLE);

                        initList();

                        //Log.d(TAG, "onTabSelected: 1");
                        break;
                    case 1:
                        relativeLayoutEditor.setVisibility(View.VISIBLE);
                        relativeLayoutAbout.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.GONE);
                        mTextViewEmpty.setVisibility(View.GONE);

                        closeInitList();

                        //Log.d(TAG, "onTabSelected: 2");
                        break;
                    case 2:
                        relativeLayoutEditor.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.GONE);
                        relativeLayoutAbout.setVisibility(View.VISIBLE);
                        mTextViewEmpty.setVisibility(View.GONE);

                        initAbout();
                        closeInitList();

                        //Log.d(TAG, "onTabSelected: 3");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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

    public void initAdapterStaggered() {
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

    public void initSimpleAdapter() {
        // init
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewSimple.setLayoutManager(linearLayoutManager);

        simpleList = new ArrayList<>();
        simpleList.add(getString(R.string.PERMISSION));
        simpleList.add(getString(R.string.SERVICE));
        simpleList.add(getString(R.string.QUESTION_RETURN));
        simpleList.add(getString(R.string.COMPONENT_USE));
        simpleList.add(getString(R.string.AD));

        // show data
        mSimpleAdapter = new SimpleAdapter(simpleList,this);
        mRecyclerViewSimple.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerViewSimple.setAdapter(mSimpleAdapter);
        mSimpleAdapter.notifyDataSetChanged();
    }

    public void loadList() {
        toyList = dataBase.getInstance(this).getToyDao().getAll();

        if (toyList.size() > 0) {
            for (int i = 0; i < toyList.size(); i++) {
                Log.d(TAG, "printData: name = " + toyList.get(i).getName() + ", buyPrice = " + toyList.get(i).getBuyPrice() + ", web = " + toyList.get(i).getWeb());
            }
        }
    }

    public void saveData() {
        FakeData.setData(this);
        if (!isDataReady) {
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
                if (!isDataReady) {
                    return;
                } else {
                    if (!isStaggeredAdapter) {
                        initAdapterStaggered();
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
            case R.id.imageButton_date:
                if (!isDataReady) {
                    return;
                } else {
                    if (!isDateOrder) {
                        mImageDateButton.setBackground(getResources().getDrawable(R.mipmap.date_new));
                        mListadapter.setDateOrder(Constants.DATE_NEW_OLD);
                        isDateOrder = true;
                    } else {
                        mImageDateButton.setBackground(getResources().getDrawable(R.mipmap.date_old));
                        mListadapter.setDateOrder(Constants.DATE_OLD_NEW);
                        isDateOrder = false;
                    }

                    mListadapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.textViewTitle:
                if (!isDeveloper) {
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

    class testTask extends AsyncTask<String, Integer, Boolean> {

        Context mContext = null;

        testTask(Context context) {
            mContext = context;
        }

        protected Boolean doInBackground(String... strings) {

            if (isDeveloper && !isDataReady) {
                shared.edit().putBoolean("isDeveloper", true).commit();
                saveData();
            }
            loadList();

            return true;
        }

        protected void onPostExecute(Boolean result) {
            checkDataSize();

            if (isDataReady) {
                if (isStaggeredAdapter) {
                    initAdapterStaggered();
                } else {
                    initAdapter();
                }
            }
        }
    }

    public void checkDataSize() {
        if (isDataReady) {
            mTextViewEmpty.setVisibility(View.GONE);
        } else {
            mTextViewEmpty.setVisibility(View.VISIBLE);
        }
    }

    // UI
    public void initList() {
        mImageDateButton.setVisibility(View.VISIBLE);
        mImageButton.setVisibility(View.VISIBLE);
    }

    public void closeInitList() {
        mImageDateButton.setVisibility(View.GONE);
        mImageButton.setVisibility(View.GONE);
    }

    public void initAbout() {

        String version = "1.0";
        try {
            PackageInfo packageInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        mTextViewVersion.setText("v " + version);
    }
}
