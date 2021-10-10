package com.example.roomtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.roomtest.databinding.ActivityMainBinding;
import com.example.roomtest.diaog.shareDialogFragment;
import com.example.roomtest.diaog.viewPager2DialogFragment;
import com.example.roomtest.fragment.AboutFragment;
import com.example.roomtest.fragment.DetailFragment;
import com.example.roomtest.fragment.ListFragment;
import com.example.roomtest.mediastore.mediaStoreControl;
import com.example.roomtest.tool.themeControl;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 2020-01-11 update use viewpager2 + fragment
 * 2021-10-10 view binding
 */
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,
        View.OnLongClickListener {
    
    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    boolean isGuided = false;
    boolean isDeveloper = false;

    private ArrayList<Fragment> fragments = new ArrayList<Fragment>(3);

    ListFragment listFragment;
    DetailFragment detailFragment;
    AboutFragment aboutFragment;

    SharedPreferences shared = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 2021-10-10 view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initView();

        checkPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA});

        // avoid data repeat store
        shared = getSharedPreferences("app_setting", MODE_PRIVATE);
        isGuided = shared.getBoolean("isGuided", false);
        isDeveloper = shared.getBoolean("isDeveloper", false);

        fragments = getFragments();

        FragmentStateAdapter mAdapter = new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments.get(position);
            }

            @Override
            public int getItemCount() {
                return fragments.size();
            }
        };

        binding.mainViewPager2.setAdapter(mAdapter);

        if (!isGuided) {
            initViewPager2();
        }
    }

    public ArrayList<Fragment> getFragments() {

        listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", getString(R.string.TAB_LIST));
        listFragment.setArguments(bundle);

        detailFragment = new DetailFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.TAB_INFO));
        detailFragment.setArguments(bundle);

        aboutFragment = new AboutFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.TAB_ABOUT));
        aboutFragment.setArguments( bundle);

        fragments.add(listFragment);
        fragments.add(detailFragment);
        fragments.add(aboutFragment);

        return fragments;
    }

    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //need to fix some problem
    }

    public void initView() {

        binding.imageButtonMenu.setOnClickListener(this);
        binding.imageButtonDate.setOnClickListener(this);
        binding.imageButtonCamera.setOnClickListener(this);
        binding.textViewTitle.setOnLongClickListener(this);

        binding.mainViewPager2.setCurrentItem(0, false);

        initMode();
        bottomNavigationViewListener();

        //NavController navController = Navigation.findNavController(this, R.id.main_fragment);
    }

    /**
     * init APP setting theme
     */
    public void initMode(/*int currentNightMode*/) {
        //int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        int currentNightMode = themeControl.getInstance(this).getCurrentMode();
        Log.d(TAG, "initMode: " + currentNightMode);

        switch (currentNightMode) {
            //case Configuration.UI_MODE_NIGHT_NO:
            case ToyConstants.LIGHT_MODE:
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                binding.bottomNavigationView.inflateMenu(R.menu.bottom_navigation_main_v2);
                break;
            //case Configuration.UI_MODE_NIGHT_YES:
            case ToyConstants.DARK_MODE:
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                binding.bottomNavigationView.inflateMenu(R.menu.bottom_navigation_main);
                break;
            //case Configuration.UI_MODE_NIGHT_UNDEFINED:
            //    break;
        }
    }

    /**
     * 2019-01-11
     */
    public void bottomNavigationViewListener() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_list:
                        binding.mainViewPager2.setCurrentItem(0, false);
                        initList();
                        binding.imageButtonCamera.setVisibility(View.GONE);
                        //Log.d(TAG, "onTabSelected: list");
                        break;
                    case R.id.action_detail:
                        binding.mainViewPager2.setCurrentItem(1, false);
                        closeInitList();
                        binding.imageButtonCamera.setVisibility(View.VISIBLE);
                        // update information
                        //detailFragment.loadList();
                        //Log.d(TAG, "onTabSelected: info");
                        break;
                    case R.id.action_about:
                        binding.mainViewPager2.setCurrentItem(2, false);
                        closeInitList();
                        binding.imageButtonCamera.setVisibility(View.GONE);
                        //Log.d(TAG, "onTabSelected: about");
                        break;
                }
                return true;
            }
        });
    }

    public void initViewPager2() {
        FragmentManager fm = this.getSupportFragmentManager();
        viewPager2DialogFragment dialog = viewPager2DialogFragment.newInstance(this);
        dialog.show(fm, "viewpager2");
    }

    public void initList() {
        binding.imageButtonDate.setVisibility(View.VISIBLE);
        binding.imageButtonMenu.setVisibility(View.VISIBLE);
    }

    public void closeInitList() {
        binding.imageButtonDate.setVisibility(View.GONE);
        binding.imageButtonMenu.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton_menu:
                listFragment.menuListUpdate();

                boolean isStraggered = listFragment.getIsStaggered();
                if(isStraggered == true) {
                    binding.imageButtonMenu.setBackground(getResources().getDrawable(R.mipmap.menu_icon_1));
                } else if(isStraggered == false) {
                    binding.imageButtonMenu.setBackground(getResources().getDrawable(R.mipmap.menu_icon_3));
                }

                break;
            case R.id.imageButton_date:
                listFragment.dateListUpdate();

                settingImageButton();

                break;
            case R.id.imageButton_camera:
                takeScreenShot(this);
                break;
        }
    }

    public void settingImageButton() {
        int currentStyle = listFragment.getDateListStyle();
        if(currentStyle == ToyConstants.DATE_NEW_OLD) {
            binding.imageButtonDate.setBackground(getResources().getDrawable(R.mipmap.date_new));
        } else if (currentStyle == ToyConstants.DATE_OLD_NEW){
            binding.imageButtonDate.setBackground(getResources().getDrawable(R.mipmap.date_old));
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.textViewTitle:

                isDeveloper = shared.getBoolean("isDeveloper", false);

                if (!isDeveloper) {
                    Snackbar.make(v, this.getString(R.string.DEVELOPER), Snackbar.LENGTH_LONG).show();
                    isDeveloper = true;
                    listFragment.insertFakeData();
                }
                break;
        }
        return false;
    }

    /**
     * 2020-01-01
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

            if (!checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd&HH:mm");
                String fileName = dateFormat.format(new Date());

                Uri uri = mediaStoreControl.insertImage(getContentResolver()
                        , scrBmp
                        , Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + ToyConstants.TOYSOUL_FOLDER + "/" + fileName + ToyConstants.JPG_SMALL
                        , fileName + ToyConstants.JPG_SMALL
                        , "screen cut, date = " + fileName);

                FragmentManager fm = ((AppCompatActivity) this).getSupportFragmentManager();
                shareDialogFragment dialog = shareDialogFragment.newInstance(this, scrBmp, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/ToySoul/" + fileName + ".jpg", uri);
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
            for (int i = 0; i < permissionString.length - 1; i++) {
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

            if (permissionCheck) {
                requestPermissions(permissionString, ToyConstants.REQUEST_CODE_PERMISSION);
            }
        }
    }

    /**
     * 2020-01-02
     */
    public static boolean checkSelfPermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 2019-12-22
     * permission state
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

}
