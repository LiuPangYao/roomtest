package com.example.roomtest.database;

import android.content.Context;

import com.example.roomtest.ToyConstants;

/**
 * 2021-01-18
 */
public class FakeData {

    public static void setData(Context context) {

        dataBase dataInstance = null;
        dataInstance = dataBase.getInstance(context);

        toyInfo toy_eaa051 = new toyInfo();
        toy_eaa051.setName("EAA-051 返校日");
        toy_eaa051.setBuyPrice(2150);
        toy_eaa051.setSellPrice(2390);
        toy_eaa051.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-051.html");
        toy_eaa051.setImageUri("https://imgur.com/5BHCO65");
        toy_eaa051.setDate("2019-05-01");
        toy_eaa051.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa051.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa051);

        toyInfo toy_eaa033 = new toyInfo();
        toy_eaa033.setName("EAA-033 黑豹");
        toy_eaa033.setBuyPrice(2790);
        toy_eaa033.setSellPrice(2990);
        toy_eaa033.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-033.html");
        toy_eaa033.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa033.setDate("2019-05-10");
        toy_eaa033.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa033.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa033);

        toyInfo toy_eaa024 = new toyInfo();
        toy_eaa024.setName("EAA-024 戰損鋼鐵人");
        toy_eaa024.setBuyPrice(2150);
        toy_eaa024.setSellPrice(2390);
        toy_eaa024.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-024-mk43.html");
        toy_eaa024.setImageUri("https://imgur.com/fg1jY5C");
        toy_eaa024.setDate("2019-05-11");
        toy_eaa024.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa024.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa024);

        toyInfo toy_eaa066 = new toyInfo();
        toy_eaa066.setName("EAA-066 金鋼狼");
        toy_eaa066.setBuyPrice(2340);
        toy_eaa066.setSellPrice(2390);
        toy_eaa066.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-066-x.html");
        toy_eaa066.setImageUri("https://imgur.com/zZja4Nu");
        toy_eaa066.setDate("2019-05-24");
        toy_eaa066.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa066.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa066);

        toyInfo toy_eaa083 = new toyInfo();
        toy_eaa083.setName("EAA-083 萬磁王");
        toy_eaa083.setBuyPrice(2150);
        toy_eaa083.setSellPrice(2390);
        toy_eaa083.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa083-x.html");
        toy_eaa083.setImageUri("https://imgur.com/76drfLI");
        toy_eaa083.setDate("2019-06-16");
        toy_eaa083.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa083.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa083);

        toyInfo toy_eaa060 = new toyInfo();
        toy_eaa060.setName("EAA-060 鋼鐵蜘蛛人");
        toy_eaa060.setBuyPrice(2790);
        toy_eaa060.setSellPrice(2990);
        toy_eaa060.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-060dx.html");
        toy_eaa060.setImageUri("https://imgur.com/4apuRHs");
        toy_eaa060.setDate("2019-09-07");
        toy_eaa060.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa060.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa060);

        toyInfo toy_eaa074 = new toyInfo();
        toy_eaa074.setName("EAA-074 自製戰衣");
        toy_eaa074.setBuyPrice(2150);
        toy_eaa074.setSellPrice(2390);
        toy_eaa074.setWeb("https://www.eeaseries.com/2020/10/eaa-074.html");
        toy_eaa074.setImageUri("https://imgur.com/DiAvxnM");
        toy_eaa074.setDate("2019-09-28");
        toy_eaa074.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa074.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa074);

        toyInfo toy_eaa099 = new toyInfo();
        toy_eaa099.setName("EAA-099 特製戰衣");
        toy_eaa099.setBuyPrice(2150);
        toy_eaa099.setSellPrice(2390);
        toy_eaa099.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-099.html");
        toy_eaa099.setImageUri("https://imgur.com/GjZFw9o");
        toy_eaa099.setDate("2019-10-10");
        toy_eaa099.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa099.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa099);

        toyInfo toy_eaa098 = new toyInfo();
        toy_eaa098.setName("EAA-098 潛行戰衣");
        toy_eaa098.setBuyPrice(2150);
        toy_eaa098.setSellPrice(2390);
        toy_eaa098.setWeb("https://www.eeaseries.com/2020/12/egg-attack-action-eaa-074.html");
        toy_eaa098.setImageUri("https://imgur.com/7WlxG8d");
        toy_eaa098.setDate("2019-10-22");
        toy_eaa098.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa098.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa098);

        toyInfo toy_eaa089 = new toyInfo();
        toy_eaa089.setName("EAA-089 邁爾斯 莫拉雷斯");
        toy_eaa089.setBuyPrice(2150);
        toy_eaa089.setSellPrice(2390);
        toy_eaa089.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-087.html");
        toy_eaa089.setImageUri("https://imgur.com/gT50iXZ");
        toy_eaa089.setDate("2019-10-23");
        toy_eaa089.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa089.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa089);

        toyInfo toy_eaa088 = new toyInfo();
        toy_eaa088.setName("EAA-088 彼得帕克 蜘蛛人");
        toy_eaa088.setBuyPrice(2150);
        toy_eaa088.setSellPrice(2390);
        toy_eaa088.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-088.html");
        toy_eaa088.setImageUri("https://imgur.com/KDvJtyd");
        toy_eaa088.setDate("2020-08-07");
        toy_eaa088.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa088.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa088);

        toyInfo toy_eaa001 = new toyInfo();
        toy_eaa001.setName("EAA-001 驚奇之戰 蜘蛛人");
        toy_eaa001.setBuyPrice(2500);
        toy_eaa001.setSellPrice(2500);
        toy_eaa001.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-001.html");
        toy_eaa001.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa001.setDate("2015-01-01");
        toy_eaa001.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa001.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa001);

        toyInfo toy_eaa097 = new toyInfo();
        toy_eaa097.setName("EAA-097 X戰警 機堡");
        toy_eaa097.setBuyPrice(2150);
        toy_eaa097.setSellPrice(2390);
        toy_eaa097.setWeb("https://www.beast-kingdom.com.tw/SalePage/Index/6549777?lang=zh-TW");
        toy_eaa097.setImageUri("https://imgur.com/Hz3QQK3");
        toy_eaa097.setDate("2020-10-02");
        toy_eaa097.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa097.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa097);

        toyInfo toy_eaa150 = new toyInfo();
        toy_eaa150.setName("EAA-150 融合戰服");
        toy_eaa150.setBuyPrice(2150);
        toy_eaa150.setSellPrice(2390);
        toy_eaa150.setWeb("https://www.beast-kingdom.com.tw/SalePage/Index/7499982?lang=zh-TW");
        toy_eaa150.setImageUri("https://imgur.com/PC3En3q");
        toy_eaa150.setDate("2021-12-15");
        toy_eaa150.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa150.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa150);
    }
}
