package com.example.roomtest.database;

import android.util.Log;

import com.example.roomtest.ToyConstants;
import com.example.roomtest.firestore.UpdateMessage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 2021-01-09 fix error
 */
public class listSort {

    static String TAG = "listSort";

    public static ArrayList<UpdateMessage> sortList (ArrayList<UpdateMessage> sample) {

        ArrayList<UpdateMessage> list = new ArrayList<UpdateMessage>();
        list.addAll(sample);
        ArrayList<UpdateMessage> storeList = new ArrayList<UpdateMessage>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        Date date2 = new Date();

        for(int i = 0 ; i < list.size() ; i++) {

            String dateString = list.get(i).getDate(); // current value
            try {
                date1 = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(storeList.size() == 0) {
                storeList.add(0, list.get(i));
            } else {
                for(int j = 0 ; j < storeList.size() ; j++) {
                    try {
                        date2  = sdf.parse(storeList.get(j).getDate());

                        if (date1.compareTo(date2) > 0) {
                            System.out.println("Date1 is after Date2");
                            //continue;
                        } else if (date1.compareTo(date2) < 0) {
                            System.out.println("Date1 is before Date2");
                            storeList.add(j, list.get(i));
                            break;
                        }

                        if(j == (storeList.size()-1)) {
                            storeList.add(list.get(i));
                            break;
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Collections.reverse(storeList);
        return storeList;
    }

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

