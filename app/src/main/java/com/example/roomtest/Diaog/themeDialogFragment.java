package com.example.roomtest.Diaog;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.fragment.app.DialogFragment;

import com.example.roomtest.R;
import com.example.roomtest.tool.themeControl;

import info.hoang8f.android.segmented.SegmentedGroup;

import static android.content.Context.MODE_PRIVATE;

/**
 * 2019-12-18
 */
public class themeDialogFragment extends DialogFragment {

    static Context mContext;

    public themeDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static themeDialogFragment newInstance(Context context) {
        themeDialogFragment frag = new themeDialogFragment();
        mContext = context;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.theme_dialogfragment, container, false);

        SegmentedGroup segmentedOne = view.findViewById(R.id.themeSegmentedComponent);
        segmentedOne.setTintColor(Color.DKGRAY);

        RadioButton radioButtonOne = view.findViewById(R.id.buttonThemeOne);
        radioButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = getContext().getSharedPreferences("app_setting", MODE_PRIVATE);
                shared.edit().putInt("currentMode", 0).commit();
            }
        });

        RadioButton radioButtonTwo = view.findViewById(R.id.buttonThemeTwo);
        radioButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = getContext().getSharedPreferences("app_setting", MODE_PRIVATE);
                shared.edit().putInt("currentMode", 1).commit();
            }
        });

        int currentMode = themeControl.getInstance(getContext()).getCurrentMode();
        if(currentMode == 0) {
            radioButtonOne.setChecked(true);
        } else {
            radioButtonTwo.setChecked(true);
        }

        return view;
    }
}
