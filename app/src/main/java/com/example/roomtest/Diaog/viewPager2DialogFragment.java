package com.example.roomtest.Diaog;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.roomtest.R;
import com.example.roomtest.recyclerview.ViewPager2Adapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class viewPager2DialogFragment extends DialogFragment
        implements ViewPager2Adapter.OnCurrentPageCallBack {

    static Context mContext;
    static viewPager2DialogFragment frag;
    TextView currentPageText;
    TextView totalPageText;
    List<Drawable> list;
    String TAG = "viewPager2DialogFragment.class";

    public viewPager2DialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static viewPager2DialogFragment newInstance(Context context) {
        frag = new viewPager2DialogFragment();
        mContext = context;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.viewpager2_dialog_fragment, container, false);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewpager2);
        final CheckBox checkBoxAgain = view.findViewById(R.id.checkBoxAgain);

        currentPageText = view.findViewById(R.id.textCurrentPage);
        totalPageText = view.findViewById(R.id.textTotalPage);

        list = new ArrayList<>();
        list.add(getResources().getDrawable(R.mipmap.viewpager2_01));
        list.add(getResources().getDrawable(R.mipmap.viewpager2_02));
        list.add(getResources().getDrawable(R.mipmap.viewpager2_03));

        ViewPager2Adapter adapter2 = new ViewPager2Adapter(mContext, list, viewPager2);
        adapter2.setOnCurrentListener(this);
        viewPager2.setAdapter(adapter2);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                currentStatePage(position + 1);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        Button closeGuidedButton = view.findViewById(R.id.buttonGuided);
        closeGuidedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = mContext.getSharedPreferences("app_setting", MODE_PRIVATE);
                shared.edit().putBoolean("isGuided", checkBoxAgain.isChecked()).commit();
                frag.dismiss();
            }
        });

        return view;
    }

    @Override
    public void currentState(int totalPage, int currentPage) {
        Log.d(TAG, "test current state");
        currentPageText.setText(String.valueOf(currentPage));
        totalPageText.setText(String.valueOf(totalPage));
    }

    public void currentStatePage(int currentPage) {
        Log.d(TAG, "test current state");
        currentPageText.setText(String.valueOf(currentPage));
        totalPageText.setText(String.valueOf(list.size()));
    }
}
