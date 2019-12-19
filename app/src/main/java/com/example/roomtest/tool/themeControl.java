package com.example.roomtest.tool;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.roomtest.R;

import static android.content.Context.MODE_PRIVATE;

public class themeControl {

    int CURRENT_MODE = themeControl.LIGHT_MODE;
    static int DARK_MODE  = 1;
    static int LIGHT_MODE = 0;

    SharedPreferences shared = null;

    private static themeControl instance;

    public static themeControl getInstance(Context context) {
        if(instance == null) {
            synchronized(themeControl.class) {
                if(instance == null) {
                    instance = new themeControl(context);
                }
            }
        }
        return instance;
    }

    public themeControl(Context context) {
        shared = context.getSharedPreferences("app_setting", MODE_PRIVATE);
        CURRENT_MODE = shared.getInt("currentMode", themeControl.LIGHT_MODE);
    }

    public int getCurrentMode() {
        return CURRENT_MODE;
    }

    public void changeStyle() {
        if(CURRENT_MODE == LIGHT_MODE) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }

}
