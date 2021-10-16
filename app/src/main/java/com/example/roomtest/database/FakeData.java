package com.example.roomtest.database;

import android.content.Context;

import com.example.roomtest.ToyConstants;

public class FakeData {

    public static void setDataForMain(Context context) {
        dataBase dataInstance = null;
        dataInstance = dataBase.getInstance(context);

        toyInfo toy1 = new toyInfo();
        toy1.setName("EAA-051 返校日");
        toy1.setBuyPrice(2390);
        toy1.setSellPrice(2390);
        toy1.setWeb("https://www.toy-people.com/?p=38665");
        toy1.setImageUri("https://imgur.com/5BHCO65");
        toy1.setDate("2019-05-01");
        toy1.setSoldState(ToyConstants.SOLD_OUT);
        toy1.setGain(ToyConstants.SELL);
        dataInstance.getToyDao().insert(toy1);

        toyInfo toy6 = new toyInfo();
        toy6.setName("EAA-060 鋼鐵蜘蛛人");
        toy6.setBuyPrice(2790);
        toy6.setSellPrice(2990);
        toy6.setWeb("https://www.toy-people.com/?p=45927");
        toy6.setImageUri("https://imgur.com/4apuRHs");
        toy6.setDate("2019-09-07");
        toy6.setSoldState(ToyConstants.SELL);
        toy6.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy6);

        toyInfo toy7 = new toyInfo();
        toy7.setName("EAA-074 自製戰衣");
        toy7.setBuyPrice(2150);
        toy7.setSellPrice(2390);
        toy7.setWeb("https://www.toy-people.com/?p=48110");
        toy7.setImageUri("https://imgur.com/DiAvxnM");
        toy7.setDate("2019-09-28");
        toy7.setSoldState(ToyConstants.PRE_ORDER);
        toy7.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy7);

        toyInfo toy8 = new toyInfo();
        toy8.setName("EAA-099 特製戰衣");
        toy8.setBuyPrice(2150);
        toy8.setSellPrice(2390);
        toy8.setWeb("https://www.toy-people.com/?p=48751");
        toy8.setImageUri("https://imgur.com/GjZFw9o");
        toy8.setDate("2019-10-10");
        toy8.setSoldState(ToyConstants.PRE_ORDER);
        toy8.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy8);

        toyInfo toy9 = new toyInfo();
        toy9.setName("EAA-098 潛行戰衣");
        toy9.setBuyPrice(2150);
        toy9.setSellPrice(2390);
        toy9.setWeb("");
        toy9.setImageUri("https://imgur.com/7WlxG8d");
        toy9.setDate("2019-10-22");
        toy9.setSoldState(ToyConstants.PRE_ORDER);
        toy9.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy9);


    }

    public static void setData(Context context) {

        dataBase dataInstance = null;
        dataInstance = dataBase.getInstance(context);

        toyInfo toy1 = new toyInfo();
        toy1.setName("EAA-051 返校日");
        toy1.setBuyPrice(2390);
        toy1.setSellPrice(2390);
        toy1.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-051.html");
        toy1.setImageUri("https://imgur.com/5BHCO65");
        toy1.setDate("2019-05-01");
        toy1.setSoldState(ToyConstants.SOLD_OUT);
        toy1.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy1);

        toyInfo toy2 = new toyInfo();
        toy2.setName("EAA-033 黑豹");
        toy2.setBuyPrice(2990);
        toy2.setSellPrice(2990);
        toy2.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-033.html");
        toy2.setImageUri("https://imgur.com/tJl7j2Y");
        toy2.setDate("2019-05-10");
        toy2.setSoldState(ToyConstants.SOLD_OUT);
        toy2.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy2);

        toyInfo toy3 = new toyInfo();
        toy3.setName("EAA-024 戰損鋼鐵人");
        toy3.setBuyPrice(2150);
        toy3.setSellPrice(2390);
        toy3.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-024-mk43.html");
        toy3.setImageUri("https://imgur.com/fg1jY5C");
        toy3.setDate("2019-05-11");
        toy3.setSoldState(ToyConstants.SOLD_OUT);
        toy3.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy3);

        toyInfo toy4 = new toyInfo();
        toy4.setName("EAA-066 金鋼狼");
        toy4.setBuyPrice(2340);
        toy4.setSellPrice(2390);
        toy4.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-066-x.html");
        toy4.setImageUri("https://imgur.com/zZja4Nu");
        toy4.setDate("2019-05-24");
        toy4.setSoldState(ToyConstants.SOLD_OUT);
        toy4.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy4);

        toyInfo toy5 = new toyInfo();
        toy5.setName("EAA-083 萬磁王");
        toy5.setBuyPrice(2150);
        toy5.setSellPrice(2390);
        toy5.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa083-x.html");
        toy5.setImageUri("https://imgur.com/76drfLI");
        toy5.setDate("2019-06-16");
        toy5.setSoldState(ToyConstants.SOLD_OUT);
        toy5.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy5);

        toyInfo toy6 = new toyInfo();
        toy6.setName("EAA-060 鋼鐵蜘蛛人");
        toy6.setBuyPrice(2790);
        toy6.setSellPrice(2990);
        toy6.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-060dx.html");
        toy6.setImageUri("https://imgur.com/4apuRHs");
        toy6.setDate("2019-09-07");
        toy6.setSoldState(ToyConstants.SOLD_OUT);
        toy6.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy6);

        toyInfo toy7 = new toyInfo();
        toy7.setName("EAA-074 自製戰衣");
        toy7.setBuyPrice(2150);
        toy7.setSellPrice(2390);
        toy7.setWeb("https://www.eeaseries.com/2020/10/eaa-074.html");
        toy7.setImageUri("https://imgur.com/DiAvxnM");
        toy7.setDate("2019-09-28");
        toy7.setSoldState(ToyConstants.SOLD_OUT);
        toy7.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy7);

        toyInfo toy8 = new toyInfo();
        toy8.setName("EAA-099 特製戰衣");
        toy8.setBuyPrice(2150);
        toy8.setSellPrice(2390);
        toy8.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-099.html");
        toy8.setImageUri("https://imgur.com/GjZFw9o");
        toy8.setDate("2019-10-10");
        toy8.setSoldState(ToyConstants.SOLD_OUT);
        toy8.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy8);

        toyInfo toy9 = new toyInfo();
        toy9.setName("EAA-098 潛行戰衣");
        toy9.setBuyPrice(2150);
        toy9.setSellPrice(2390);
        toy9.setWeb("https://www.eeaseries.com/2020/12/egg-attack-action-eaa-074.html");
        toy9.setImageUri("https://imgur.com/7WlxG8d");
        toy9.setDate("2019-10-22");
        toy9.setSoldState(ToyConstants.SOLD_OUT);
        toy9.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy9);

        toyInfo toy10 = new toyInfo();
        toy10.setName("EAA-089 邁爾斯 莫拉雷斯");
        toy10.setBuyPrice(2150);
        toy10.setSellPrice(2390);
        toy10.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-087.html");
        toy10.setImageUri("https://imgur.com/gT50iXZ");
        toy10.setDate("2019-10-23");
        toy10.setSoldState(ToyConstants.SOLD_OUT);
        toy10.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy10);

        toyInfo toy11 = new toyInfo();
        toy11.setName("EAA-088 彼得帕克 蜘蛛人");
        toy11.setBuyPrice(2150);
        toy11.setSellPrice(2390);
        toy11.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-088.html");
        toy11.setImageUri("https://imgur.com/KDvJtyd");
        toy11.setDate("2020-08-07");
        toy11.setSoldState(ToyConstants.SOLD_OUT);
        toy11.setGain(ToyConstants.INCREASE);
        dataInstance.getToyDao().insert(toy11);

        toyInfo toy12 = new toyInfo();
        toy12.setName("EAA-001 驚奇之戰 蜘蛛人");
        toy12.setBuyPrice(2500);
        toy12.setSellPrice(2500);
        toy12.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-001.html");
        toy12.setImageUri("https://imgur.com/CMHkNlK");
        toy12.setDate("2015-01-01");
        toy12.setSoldState(ToyConstants.SOLD_OUT);
        toy12.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy12);
    }

}
