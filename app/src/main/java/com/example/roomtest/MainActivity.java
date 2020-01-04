package com.example.roomtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomtest.diaog.editDialogFragment;
import com.example.roomtest.diaog.shareDialogFragment;
import com.example.roomtest.diaog.viewPager2DialogFragment;
import com.example.roomtest.asyncTask.InsertFakeDataAsyncTask;
import com.example.roomtest.asyncTask.InsertAsyncTask;
import com.example.roomtest.asyncTask.updateAsyncTask;
import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.listSort;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.mediastore.mediaStoreControl;
import com.example.roomtest.recyclerview.ListAdapter;
import com.example.roomtest.recyclerview.ListAdapterTouchHelperCallback;
import com.example.roomtest.recyclerview.RecyclerViewNoBugLinearLayoutManager;
import com.example.roomtest.recyclerview.SimpleAdapter;
import com.example.roomtest.tool.themeControl;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 2019-12-21
 */
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,
        View.OnLongClickListener,
        editDialogFragment.InsertDialogListener,
        InsertAsyncTask.CompleteCallBack,
        InsertFakeDataAsyncTask.CompleteFakeCallBack,
        updateAsyncTask.UpdateCallBack, ListAdapter.OnDeleteListener {

    private String TAG = "MainActivity";
    dataBase dataInstance = null;
    boolean isDataReady = false; // Warning
    boolean isDeveloper = false;
    boolean isGuided = false;
    SharedPreferences shared = null;

    private TextView mTextViewEmpty, mTextViewTitle, mTextViewVersion;
    private TextView mCountEdit, mPriceEdit, mSoldEdit, mState;
    private ProgressBar mProgressBarLoading;
    private RecyclerView mRecyclerView, mRecyclerViewSimple;
    private ListAdapter mListAdapter;
    private SimpleAdapter mSimpleAdapter;
    private ImageButton mImageButton, mImageDateButton, mImageCameraButton;
    private RelativeLayout relativeLayoutEditor, relativeLayoutAbout;
    private FloatingActionButton mFloatButton;

    private TabLayout mTabLayout;

    List<toyInfo> toyList = null;
    List<toyInfo> toyListRestore = null;
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

        //initMode();

        // ad mod
        initAdMod();

        checkPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA});

        // avoid data repeat store
        shared = getSharedPreferences("app_setting", MODE_PRIVATE);
        isDataReady = shared.getBoolean("isReady", false);
        isDeveloper = shared.getBoolean("isDeveloper", false);
        isGuided = shared.getBoolean("isGuided", false);

        // init
        dataInstance = dataBase.getInstance(this);

        // load Data ,do not run in main thread
        InsertFakeDataAsyncTask asyncTask = new InsertFakeDataAsyncTask(this, this, isDataReady, isDeveloper);
        asyncTask.execute("load data");

        checkDataSizeDisplay();

        if (!isGuided) {
            initViewPager2();
        }

    }

    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {

        if (adView != null) {
            adView.destroy();
        }

        super.onDestroy();
    }

    public void init() {
        // list
        mRecyclerView = findViewById(R.id.recyclerView);
        mTextViewEmpty = findViewById(R.id.textViewEmpty);
        mProgressBarLoading = findViewById(R.id.progressBarLoading);
        mImageButton = findViewById(R.id.imageButton_menu);
        mImageDateButton = findViewById(R.id.imageButton_date);
        mImageCameraButton = findViewById(R.id.imageButton_camera);
        mImageButton.setOnClickListener(this);
        mImageDateButton.setOnClickListener(this);
        mImageCameraButton.setOnClickListener(this);
        mTextViewTitle = findViewById(R.id.textViewTitle);
        mTextViewTitle.setOnLongClickListener(this);
        mFloatButton = findViewById(R.id.floatingActionButton);

        // tab
        mTabLayout = findViewById(R.id.tabLayout);
        tabListener();

        // edit
        relativeLayoutEditor = findViewById(R.id.relative_edit);
        mCountEdit = findViewById(R.id.textViewCount);
        mPriceEdit = findViewById(R.id.textViewPrice);
        mSoldEdit = findViewById(R.id.textViewSold);
        mState = findViewById(R.id.State);

        // info
        relativeLayoutAbout = findViewById(R.id.relative_about);
        mTextViewVersion = findViewById(R.id.textViewVersion);
        mRecyclerViewSimple = findViewById(R.id.about_recyclerview);
        initSimpleAdapter();
    }

    /**
     * init APP setting theme
     */
    public void initMode() {
        //int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        int currentNightMode = themeControl.getInstance(this).getCurrentMode();
        switch (currentNightMode) {
            //case Configuration.UI_MODE_NIGHT_NO:
            case ToyConstants.LIGHT_MODE:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            //case Configuration.UI_MODE_NIGHT_YES:
            case ToyConstants.DARK_MODE:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            //case Configuration.UI_MODE_NIGHT_UNDEFINED:
            //    break;
        }
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
                        mFloatButton.setVisibility(View.VISIBLE);
                        if (!isDataReady)
                            mTextViewEmpty.setVisibility(View.VISIBLE);

                        initList();
                        mImageCameraButton.setVisibility(View.GONE);
                        //Log.d(TAG, "onTabSelected: list");
                        break;
                    case 1:
                        relativeLayoutEditor.setVisibility(View.VISIBLE);
                        relativeLayoutAbout.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.GONE);
                        mTextViewEmpty.setVisibility(View.GONE);
                        mFloatButton.setVisibility(View.GONE);

                        closeInitList();
                        initEdit();
                        mImageCameraButton.setVisibility(View.VISIBLE);
                        //Log.d(TAG, "onTabSelected: info");
                        break;
                    case 2:
                        relativeLayoutEditor.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.GONE);
                        relativeLayoutAbout.setVisibility(View.VISIBLE);
                        mTextViewEmpty.setVisibility(View.GONE);
                        mFloatButton.setVisibility(View.GONE);

                        initAbout();
                        closeInitList();
                        mImageCameraButton.setVisibility(View.GONE);
                        //Log.d(TAG, "onTabSelected: about");
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

    public void initViewPager2() {
        FragmentManager fm = this.getSupportFragmentManager();
        viewPager2DialogFragment dialog = viewPager2DialogFragment.newInstance(this);
        dialog.show(fm, "viewpager2");
    }

    public void initAdapter(List<toyInfo> toy_List) {
        // init
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(new RecyclerViewNoBugLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //mRecyclerView.setLayoutManager(linearLayoutManager);
        // show data
        mListAdapter = new ListAdapter(toy_List, this);
        mListAdapter.setItemStyle(ToyConstants.LINEARITEM);

        //notify data change
        mListAdapter.notifyDataSetChanged();

        // move and delete
        ItemTouchHelper.Callback callback = new ListAdapterTouchHelperCallback(mListAdapter/*, mListAdapter*/, toy_List);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.setOnDeleteListener(this);
        mListAdapter.notifySetListDataChanged(toy_List);

        mListAdapter.notifyDataSetChanged();
    }

    public void initAdapterStaggered(List<toyInfo> toy_List) {
        // init
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        // show data
        mListAdapter = new ListAdapter(toy_List, this);
        mListAdapter.setItemStyle(ToyConstants.STAGGERITEM);
        mListAdapter.setOnDeleteListener(this);
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.notifySetListDataChanged(toy_List);
        mListAdapter.notifyDataSetChanged();
    }

    /**
     * 2019-12-18
     * set Data in mRecyclerViewSimple use SimpleAdapter
     */
    public void initSimpleAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewSimple.setLayoutManager(linearLayoutManager);

        simpleList = new ArrayList<>();
        simpleList.add(getString(R.string.PERMISSION));
        simpleList.add(getString(R.string.UPDATE_MESSAGE));
        simpleList.add(getString(R.string.QUESTION_RETURN));
        simpleList.add(getString(R.string.COMPONENT_USE));
        simpleList.add(getString(R.string.AD));
        simpleList.add(getString(R.string.THEME));

        // init SimpleAdapter
        mSimpleAdapter = new SimpleAdapter(simpleList, this);
        mRecyclerViewSimple.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerViewSimple.setAdapter(mSimpleAdapter);
        mSimpleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton_menu:
                if (!isDataReady) {
                    return;
                } else {
                    if (!isStaggeredAdapter) {
                        initAdapterStaggered(toyList);
                        mImageButton.setBackground(getResources().getDrawable(R.mipmap.menu_icon_1));
                        //ConstraintLayout.LayoutParams mParams = new ConstraintLayout.LayoutParams(30, 30);
                        //mImageButton.setLayoutParams(mParams);
                        isStaggeredAdapter = true;
                    } else {
                        initAdapter(toyList);
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
                        mListAdapter.setDateOrder(ToyConstants.DATE_NEW_OLD);
                        isDateOrder = true;
                    } else {
                        mImageDateButton.setBackground(getResources().getDrawable(R.mipmap.date_old));
                        mListAdapter.setDateOrder(ToyConstants.DATE_OLD_NEW);
                        isDateOrder = false;
                    }

                    mListAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.floatingActionButton:
                showInsertOrUpdateDialog(ToyConstants.ACTION_INSERT);
                break;
            case R.id.imageButton_camera:
                takeScreenShot(this);
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
                    // store fake data, do not run in main thread
                    InsertFakeDataAsyncTask asyncTask = new InsertFakeDataAsyncTask(this, this, isDataReady, isDeveloper);
                    asyncTask.execute("store fake data");
                }
                break;
        }
        return false;
    }

    /**
     * 2020-01-01
     * @param activity
     * @return
     */
    public Bitmap takeScreenShot(Activity activity) {

        if (activity == null || activity.isFinishing()) {
            return null;
        }

        View scrView = activity.getWindow().getDecorView();
        scrView.setDrawingCacheEnabled(true);
        scrView.buildDrawingCache(true);

        Rect statuBarRect = new Rect();
        scrView.getWindowVisibleDisplayFrame(statuBarRect);

        int statusBarHeight = statuBarRect.top;
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();

        Bitmap scrBmp = null;
        try {
            scrBmp = Bitmap.createBitmap(scrView.getDrawingCache(), 0, statusBarHeight, width, height - statusBarHeight);

            if(!checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd&HH:mm");
                String fileName = dateFormat.format(new Date());

                Uri uri = mediaStoreControl.insertImage(getContentResolver()
                        , scrBmp
                        ,Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+ ToyConstants.TOYSOUL_FOLDER + "/" + fileName + ToyConstants.JPG_SMALL
                        , fileName + ToyConstants.JPG_SMALL
                        , "screen cut, date = " + fileName);

                FragmentManager fm = ((AppCompatActivity) this).getSupportFragmentManager();
                shareDialogFragment dialog = shareDialogFragment.newInstance(this, scrBmp, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/ToySoul/" + fileName + ".jpg", uri);
                dialog.show(fm, "share_dialogfragment");
            } else {
                // not get permission
                checkPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Log.d(TAG, getString(R.string.TAKE_SCREENSHOT_ERROR));
        }

        scrView.setDrawingCacheEnabled(false);
        scrView.destroyDrawingCache();

        return scrBmp;
    }

    /**
     * 2020-01-02
     * check permission
     * 1. storage
     * 2. camera
     */
    private void checkPermission(String[] permissionString) {

        boolean permissionCheck = false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for(int i = 0 ; i < permissionString.length-1 ; i++) {
                if (checkSelfPermission(this, permissionString[i])) {
                    //if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissionString[i])) {
                        // no ask again click no show
                    //    requestPermissions(permissionString, ToyConstants.REQUEST_CODE_PERMISSION);
                    //} else {
                    //    requestPermissions(permissionString, ToyConstants.REQUEST_CODE_PERMISSION);
                    //}
                    permissionCheck = true;
                }
            }

            if(permissionCheck) {
                requestPermissions(permissionString, ToyConstants.REQUEST_CODE_PERMISSION);
            }
        }
    }

    /**
     * 2020-01-02
     * @param context
     * @param permission
     * @return
     * false get permission
     */
    public static boolean checkSelfPermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 2019-12-22
     * permission state
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case ToyConstants.REQUEST_CODE_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                } else {
                    // permission denied
                    Toast.makeText(this.getApplicationContext(), getString(R.string.PERMISSION_DENIED), Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    /**
     * visible no data message
     */
    public void checkDataSizeDisplay() {
        Log.d(TAG, "checkDataSizeDisplay: someone to call this, " + isDataReady);
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

        // default 1.0
        String version = "1.0";
        try {
            PackageInfo packageInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        mTextViewVersion.setText("v " + version);
    }

    /**
     * control edit
     */
    public void initEdit() {
        if (toyList != null && toyList.size() != 0) {
            mCountEdit.setText(String.valueOf(toyList.size()));

            int sumPrice = 0;
            for (int i = 0; i < toyList.size(); i++) {
                sumPrice = sumPrice + toyList.get(i).getBuyPrice();
                mPriceEdit.setText("NT " + sumPrice);
            }

            int soldPrice = 0;
            for (int i = 0; i < toyList.size(); i++) {
                soldPrice = soldPrice + toyList.get(i).getSellPrice();
                mSoldEdit.setText("NT " + soldPrice);
            }

            if (soldPrice == sumPrice) {
                mState.setText(getString(R.string.PRICE_COMMON));
            } else if (soldPrice > sumPrice) {
                mState.setText(getString(R.string.NET_E) + " " + String.valueOf(soldPrice - sumPrice));
                mState.setTextColor(getColor(R.color.colorIncrease));
            } else {
                mState.setText(getString(R.string.NET_L) + " " + String.valueOf(sumPrice - soldPrice));
                mState.setTextColor(getColor(R.color.colorFalling));
            }

        }
    }

    /**
     * action move
     * ACTION_INSERT, ACTION_UPDATE
     */
    public void showInsertOrUpdateDialog(int dialogStyle) {

        editDialogFragment dialog = null;

        if (dialogStyle == ToyConstants.ACTION_INSERT) {
            dialog = editDialogFragment.instance(getString(R.string.INSERT_INFO), ToyConstants.ACTION_INSERT);
            dialog.show(getSupportFragmentManager(), "InsertDialog");
        } else if (dialogStyle == ToyConstants.ACTION_UPDATE) {
            dialog = editDialogFragment.instance(getString(R.string.UPDATE_INFO), ToyConstants.ACTION_UPDATE);
            dialog.show(getSupportFragmentManager(), "updateDialog");
        }
    }

    /**
     * print data base data, ready for use
     */
    public void loadList() {
        toyList = dataBase.getInstance(this).getToyDao().getAll();

        if (toyList.size() > 0) {
            for (int i = 0; i < toyList.size(); i++) {
                Log.d(TAG, "printData: name = " + toyList.get(i).getName()
                        + ", buyPrice = " + toyList.get(i).getBuyPrice()
                        + ", web = " + toyList.get(i).getWeb());
            }
        }
    }

    // callback start
    @Override
    public void onDialogOKClick(DialogFragment dialog, toyInfo info, int style) {
        if (style == ToyConstants.ACTION_INSERT) {
            InsertAsyncTask insertAsyncTask = new InsertAsyncTask(this, this);
            insertAsyncTask.execute(info);
        } else {
            // update
            // Toast.makeText(this, getString(R.string.PREPARE_WAIT), Toast.LENGTH_LONG).show();
            // create async task fot update
            updateAsyncTask task = new updateAsyncTask(this, this);
            task.execute(info);
        }

        dialog.dismiss();
    }

    @Override
    public void onDialogCancelClick(DialogFragment dialog) {
        dialog.dismiss();
    }

    /**
     * InsertAsyncTask
     *
     * @param list
     */
    @Override
    public void onTaskComplete(List<toyInfo> list) {

        toyList = list;

        // sequence list
        if (!isDateOrder) {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_OLD_NEW, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
        } else {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_NEW_OLD, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
        }

        isDataReady = true;
        shared.edit().putBoolean("isReady", true).commit();


        checkDataSizeDisplay();

        if (isStaggeredAdapter) {
            initAdapterStaggered(toyList);
        } else {
            initAdapter(toyList);
        }
    }

    /**
     * Insert Fake Data
     *
     * @param list
     * @param dataReady
     * @param developer
     */
    @Override
    public void onTaskComplete(List<toyInfo> list, boolean dataReady, boolean developer) {
        isDataReady = dataReady;
        isDeveloper = developer;

        //shared.edit().putBoolean("isReady", isDataReady).commit();
        //shared.edit().putBoolean("isDeveloper", isDeveloper).commit();

        toyList = list;

        // sequence list
        if (!isDateOrder) {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_OLD_NEW, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
        } else {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_NEW_OLD, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
        }

        checkDataSizeDisplay();

        if (isDataReady) {
            if (isStaggeredAdapter) {
                initAdapterStaggered(toyList);
            } else {
                initAdapter(toyList);
            }
        }
    }

    @Override
    public void onUpdateTaskComplete(List<toyInfo> list) {
        toyList = list;

        // sequence list
        if (!isDateOrder) {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_OLD_NEW, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
            //isDateOrder = true;
        } else {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_NEW_OLD, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
            //isDateOrder = false;
        }

        if (isStaggeredAdapter) {
            initAdapterStaggered(toyList);
        } else {
            initAdapter(toyList);
        }
    }

    /**
     * list size = 0
     */
    @Override
    public void deleteStateNone() {
        // can not be Winnie the Pooh
        isDataReady = false;
        isDeveloper = false;
        shared.edit().putBoolean("isReady", false).commit();
        shared.edit().putBoolean("isDeveloper", false).commit();

        //checkDataSizeDisplay();

        findViewById(R.id.textViewEmpty).setVisibility(View.VISIBLE);

        /*this.runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        // some problem
                        findViewById(R.id.textViewEmpty).setVisibility(View.VISIBLE);
                    }
                }
        );*/
    }
    // callback end
}
