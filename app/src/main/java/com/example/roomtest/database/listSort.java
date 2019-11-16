package com.example.roomtest.database;

import android.util.Log;

import com.example.roomtest.ToyConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class listSort {

    static String TAG = "listSort";

    public static List<toyInfo> sortlist(int style, List<toyInfo> sample) {

        int dateStyle = style;
        List<toyInfo> toyList = new ArrayList<toyInfo>();
        toyList.addAll(sample);
        List<toyInfo> toyListRestore = new ArrayList<toyInfo>();

        if(dateStyle == ToyConstants.DATE_OLD_NEW) {
            for(int i = 0 ; i < toyList.size() ; i++) {

                String dateString = toyList.get(i).getDate();

                if(toyListRestore.size() == 0) {
                    toyListRestore.add(toyList.get(i));
                } else {
                    for(int j = 0 ; j < toyListRestore.size() ; j++) {
                        try {
                            boolean isBigger = compare(toyListRestore.get(j).getDate(), dateString);

                            if(!isBigger) {
                                toyListRestore.add(j, toyList.get(i));
                                break;
                            } else if(j == toyListRestore.size() - 1) {
                                toyListRestore.add(toyList.get(i));
                                break;
                            }

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            toyList.clear();
            toyList.addAll(toyListRestore);
            toyListRestore.clear();

        } else if(dateStyle == ToyConstants.DATE_NEW_OLD) {

            for(int i = 0 ; i < toyList.size() ; i++) {

                String dateString = toyList.get(i).getDate();

                if(toyListRestore.size() == 0) {
                    toyListRestore.add(toyList.get(i));
                } else {
                    for(int j = 0 ; j < toyListRestore.size() ; j++) {
                        try {
                            boolean isBigger = compare(toyListRestore.get(j).getDate(), dateString);

                            Log.d(TAG, "setDateOrder: compare");

                            if(isBigger) {
                                Log.d(TAG, "setDateOrder: set in");
                                toyListRestore.add(j, toyList.get(i));
                                break;
                            } else if(j == toyListRestore.size() - 1) {
                                Log.d(TAG, "setDateOrder: end");
                                toyListRestore.add(toyList.get(i));
                                break;
                            }

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            Log.d(TAG, "setDateOrder: break for - loop");

            toyList.clear();
            toyList.addAll(toyListRestore);
            toyListRestore.clear();
            Log.d(TAG, "setDateOrder: " + toyListRestore.size() + ", " + toyList.size());
        }

        return toyList;
    }

    public static boolean compare(String t1, String t2) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = sdf.parse(t1);
        Date time2 = sdf.parse(t2);

        //if(time1.before(time2))
        //    return true;
        //else
        //    return false;

        if(time1.getTime()-time2.getTime()<0)
            return true;
        else
            return false;

    }
}

