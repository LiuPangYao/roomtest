package com.example.roomtest;

import android.Manifest;

/**
 * 2019-12-21
 */
public class ToyConstants {

    // SELL STATE
    public static final int SOLD_OUT = 0;
    public static final int SELL = 1;
    public static final int PRE_ORDER = 2;

    // PRICE STATE
    public static final int INCREASE = 0;
    public static final int COMMON = 1;
    public static final int FALLING = 2;

    // ITEM STYLE
    public static final int LINEARITEM = 1;
    public static final int STAGGERITEM = 2;

    // DATE
    public static final int DATE_OLD_NEW = 1;
    public static final int DATE_NEW_OLD = 2;

    // AD
    public static final String AD_BANNER = "ca-app-pub-2657997950776627/9014448267";
    public static final String AD_INTERNAL = "ca-app-pub-2657997950776627/6143924104";

    // ACTION MOVE
    public static final int ACTION_NULL = 0;
    public static final int ACTION_INSERT = 1;
    public static final int ACTION_UPDATE = 2;

    // SCREEN CUT(NOT USE)
    public static final String EXTRA_RESULT_CODE="resultCode";
    public static final String EXTRA_RESULT_INTENT="resultIntent";

    // THEME
    public static final int DARK_MODE  = 1;
    public static final int LIGHT_MODE = 0;

    public static final int REQUEST_CODE_PERMISSION = 0;

    // FILE NAME
    public static final String JPG_LARGE = ".JPG";
    public static final String JPG_SMALL = ".jpg";
    public static final String TOYSOUL_FOLDER = "/Toysoul";

}
