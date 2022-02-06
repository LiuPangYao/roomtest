package com.example.roomtest.database;

import android.content.Context;

import com.example.roomtest.ToyConstants;

/**
 * 2022-02-05 整理
 * prepare all files
 */
public class FakeData {

    public static void setData(Context context) {

        dataBase dataInstance = null;
        dataInstance = dataBase.getInstance(context);

        toyInfo toy_eaa001 = new toyInfo();
        toy_eaa001.setName("EAA-001 驚奇之戰 蜘蛛人");
        toy_eaa001.setBuyPrice(2500);
        toy_eaa001.setSellPrice(2500);
        toy_eaa001.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-001.html");
        toy_eaa001.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa001.setDate("2015-01-05");
        toy_eaa001.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa001.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa001);

        toyInfo toy_eaa002 = new toyInfo();
        toy_eaa002.setName("EAA-002 黑武士 達斯.維達");
        toy_eaa002.setBuyPrice(2990);
        toy_eaa002.setSellPrice(2990);
        toy_eaa002.setWeb("https://www.toy-people.com/?p=28921");
        toy_eaa002.setImageUri("https://imgur.com/COT5GCl");
        toy_eaa002.setDate("2015-05-19");
        toy_eaa002.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa002.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa002);

        toyInfo toy_eaa003 = new toyInfo();
        toy_eaa003.setName("EAA-003 Iron Man Mark I");
        toy_eaa003.setBuyPrice(2990);
        toy_eaa003.setSellPrice(2990);
        toy_eaa003.setWeb("https://www.toy-people.com/?p=28873");
        toy_eaa003.setImageUri("https://imgur.com/zJsmL6s");
        toy_eaa003.setDate("2015-05-20"); // 2019-05-12
        toy_eaa003.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa003.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa003);

        toyInfo toy_eaa004 = new toyInfo();
        toy_eaa004.setName("EAA-004 Iron Man Mark 43");
        toy_eaa004.setBuyPrice(2500);
        toy_eaa004.setSellPrice(2500);
        toy_eaa004.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa004.setImageUri("https://imgur.com/88KxW15");
        toy_eaa004.setDate("2015-05-21");
        toy_eaa004.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa004.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa004);

        toyInfo toy_eaa005 = new toyInfo();
        toy_eaa005.setName("EAA-005 帝國暴風兵");
        toy_eaa005.setBuyPrice(2690);
        toy_eaa005.setSellPrice(2990);
        toy_eaa005.setWeb("https://www.toy-people.com/?p=30008");
        toy_eaa005.setImageUri("https://imgur.com/PbDp4Ov");
        toy_eaa005.setDate("2015-09-03");
        toy_eaa005.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa005.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa005);

        toyInfo toy_eaa006 = new toyInfo();
        toy_eaa006.setName("EAA-006 共和國複製人士兵");
        toy_eaa006.setBuyPrice(2150);
        toy_eaa006.setSellPrice(2390);
        toy_eaa006.setWeb("https://www.toy-people.com/?p=32360");
        toy_eaa006.setImageUri("https://imgur.com/SCokzkY");
        toy_eaa006.setDate("2015-09-04");
        toy_eaa006.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa006.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa006);

        toyInfo toy_eaa007 = new toyInfo();
        toy_eaa007.setName("EAA-007 帝國沙漠兵");
        toy_eaa007.setBuyPrice(2690);
        toy_eaa007.setSellPrice(2990);
        toy_eaa007.setWeb("https://www.toy-people.com/?p=30010");
        toy_eaa007.setImageUri("https://imgur.com/4yixSgj");
        toy_eaa007.setDate("2015-09-05");//2015-09-03
        toy_eaa007.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa007.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa007);

        toyInfo toy_eaa008 = new toyInfo();
        toy_eaa008.setName("EAA-008 G-3P9");
        toy_eaa008.setBuyPrice(2500);
        toy_eaa008.setSellPrice(2790);
        toy_eaa008.setWeb("https://www.toy-people.com/?p=32585");
        toy_eaa008.setImageUri("https://imgur.com/EI5KIaU");
        toy_eaa008.setDate("2015-09-06");
        toy_eaa008.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa008.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa008);

        toyInfo toy_eaa009 = new toyInfo();
        toy_eaa009.setName("EAA-009 R2-D2");
        toy_eaa009.setBuyPrice(2790);
        toy_eaa009.setSellPrice(2790);
        toy_eaa009.setWeb("https://www.toy-people.com/?p=32586");
        toy_eaa009.setImageUri("https://imgur.com/O8k7Pwh");
        toy_eaa009.setDate("2015-11-01");
        toy_eaa009.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa009.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa009);

        toyInfo toy_eaa010 = new toyInfo();
        toy_eaa010.setName("EAA-010 G-3P9 & R2-D2");
        toy_eaa010.setBuyPrice(5380);
        toy_eaa010.setSellPrice(5380);
        toy_eaa010.setWeb("https://www.toy-people.com/?p=36858");
        toy_eaa010.setImageUri("https://imgur.com/HqquTK1");
        toy_eaa010.setDate("2015-11-02");
        toy_eaa010.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa010.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa010);

        toyInfo toy_eaa011 = new toyInfo();
        toy_eaa011.setName("EAA-011 奧創紀元 美國隊長");
        toy_eaa011.setBuyPrice(2690);
        toy_eaa011.setSellPrice(2990);
        toy_eaa011.setWeb("https://www.toy-people.com/?p=30623");
        toy_eaa011.setImageUri("https://imgur.com/ScSB3Kh");
        toy_eaa011.setDate("2015-11-03");
        toy_eaa011.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa011.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa011);

        toyInfo toy_eaa013 = new toyInfo();
        toy_eaa013.setName("EAA-013 奧創紀元 雷神索爾");
        toy_eaa013.setBuyPrice(2690);
        toy_eaa013.setSellPrice(2990);
        toy_eaa013.setWeb("https://www.toy-people.com/?p=30620");
        toy_eaa013.setImageUri("https://imgur.com/pZPsre6");
        toy_eaa013.setDate("2015-11-04");
        toy_eaa013.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa013.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa013);

        toyInfo toy_eaa014 = new toyInfo();
        toy_eaa014.setName("EAA-014 星際大戰 濕背獸");
        toy_eaa014.setBuyPrice(1590);
        toy_eaa014.setSellPrice(1590);
        toy_eaa014.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa014.setImageUri("https://imgur.com/dSuhyPO");
        toy_eaa014.setDate("2015-11-05");
        toy_eaa014.setSoldState(ToyConstants.SELL);
        toy_eaa014.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa014);

        toyInfo toy_eaa014S = new toyInfo();
        toy_eaa014S.setName("EAA-014s 星際大戰 濕背獸 & 帝國沙漠兵");
        toy_eaa014S.setBuyPrice(4280);
        toy_eaa014S.setSellPrice(4280);
        toy_eaa014S.setWeb("https://www.toy-people.com/?p=38583");
        toy_eaa014S.setImageUri("https://imgur.com/x22Nm2M");
        toy_eaa014S.setDate("2015-11-06");
        toy_eaa014S.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa014S.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa014S);

        toyInfo toy_eaa015H = new toyInfo();
        toy_eaa015H.setName("EAA-015H 第一軍團 重裝突擊兵");
        toy_eaa015H.setBuyPrice(2150);
        toy_eaa015H.setSellPrice(2390);
        toy_eaa015H.setWeb("https://www.toy-people.com/?p=36973");
        toy_eaa015H.setImageUri("https://imgur.com/gdZDAaH");
        toy_eaa015H.setDate("2015-12-01");
        toy_eaa015H.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa015H.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa015H);

        toyInfo toy_eaa015R = new toyInfo();
        toy_eaa015R.setName("EAA-015R 第一軍團 鎮暴突擊兵");
        toy_eaa015R.setBuyPrice(2150);
        toy_eaa015R.setSellPrice(2390);
        toy_eaa015R.setWeb("https://www.toy-people.com/?p=36973");
        toy_eaa015R.setImageUri("https://imgur.com/VpzOVkI");
        toy_eaa015R.setDate("2015-12-02");
        toy_eaa015R.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa015R.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa015R);

        toyInfo toy_eaa016 = new toyInfo();
        toy_eaa016.setName("EAA-016 法斯瑪隊長");
        toy_eaa016.setBuyPrice(2150);
        toy_eaa016.setSellPrice(2390);
        toy_eaa016.setWeb("https://www.toy-people.com/?p=31412");
        toy_eaa016.setImageUri("https://imgur.com/k0LwXCw");
        toy_eaa016.setDate("2016-01-21");
        toy_eaa016.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa016.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa016);

        toyInfo toy_eaa017 = new toyInfo();
        toy_eaa017.setName("EAA-017 凱羅．忍");
        toy_eaa017.setBuyPrice(2150);
        toy_eaa017.setSellPrice(2390);
        toy_eaa017.setWeb("https://www.toy-people.com/?p=31411");
        toy_eaa017.setImageUri("https://imgur.com/ueX1t29");
        toy_eaa017.setDate("2016-01-22");
        toy_eaa017.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa017.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa017);

        toyInfo toy_eaa018 = new toyInfo();
        toy_eaa018.setName("EAA-018 星際大戰 帝國暗影風暴兵");
        toy_eaa018.setBuyPrice(2150);
        toy_eaa018.setSellPrice(2390);
        toy_eaa018.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa018.setImageUri("https://imgur.com/uAmFdMe");
        toy_eaa018.setDate("2016-01-23");
        toy_eaa018.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa018.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa018);

        toyInfo toy_eaa020 = new toyInfo();
        toy_eaa020.setName("EAA-020 星際大戰 波巴·費特");
        toy_eaa020.setBuyPrice(2150);
        toy_eaa020.setSellPrice(2390);
        toy_eaa020.setWeb("https://www.toy-people.com/?p=43483");
        toy_eaa020.setImageUri("https://imgur.com/WDpSnEe");
        toy_eaa020.setDate("2016-01-24");
        toy_eaa020.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa020.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa020);

        toyInfo toy_eaa021 = new toyInfo();
        toy_eaa021.setName("EAA-021 Iron Man Mark 45");
        toy_eaa021.setBuyPrice(2390);
        toy_eaa021.setSellPrice(2990);
        toy_eaa021.setWeb("https://www.toy-people.com/?p=32847");
        toy_eaa021.setImageUri("https://imgur.com/9oj0vV7");
        toy_eaa021.setDate("2016-01-25");
        toy_eaa021.setSoldState(ToyConstants.SELL);
        toy_eaa021.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa021);

        toyInfo toy_eaa023 = new toyInfo();
        toy_eaa023.setName("EAA-023 火箭浣熊 & 小樹人格魯特");
        toy_eaa023.setBuyPrice(2690);
        toy_eaa023.setSellPrice(2990);
        toy_eaa023.setWeb("https://www.toy-people.com/?p=33049");
        toy_eaa023.setImageUri("https://imgur.com/w7vESwU");
        toy_eaa023.setDate("2016-06-27");
        toy_eaa023.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa023.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa023);

        toyInfo toy_eaa024 = new toyInfo();
        toy_eaa024.setName("EAA-024 戰損鋼鐵人");
        toy_eaa024.setBuyPrice(2390);
        toy_eaa024.setSellPrice(2150);
        toy_eaa024.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-024-mk43.html");
        toy_eaa024.setImageUri("https://imgur.com/CoqSJ06");
        toy_eaa024.setDate("2016-06-28");
        toy_eaa024.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa024.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa024);

        toyInfo toy_eaa027 = new toyInfo();
        toy_eaa027.setName("EAA-027 星際大戰 絕地大反攻 波巴費特");
        toy_eaa027.setBuyPrice(2690);
        toy_eaa027.setSellPrice(2990);
        toy_eaa027.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa027.setImageUri("https://imgur.com/Gtb5I7a");
        toy_eaa027.setDate("2016-06-29");
        toy_eaa027.setSoldState(ToyConstants.SELL);
        toy_eaa027.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa027);

        toyInfo toy_eaa029 = new toyInfo();
        toy_eaa029.setName("EAA-029 美國隊長 英雄內戰");
        toy_eaa029.setBuyPrice(2690);
        toy_eaa029.setSellPrice(2990);
        toy_eaa029.setWeb("https://www.toy-people.com/?p=33130");
        toy_eaa029.setImageUri("https://imgur.com/b5hso7w");
        toy_eaa029.setDate("2016-06-30");
        toy_eaa029.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa029.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa029);

        toyInfo toy_eaa030 = new toyInfo();
        toy_eaa030.setName("EAA-030 Iron Man Mark 46");
        toy_eaa030.setBuyPrice(2690);
        toy_eaa030.setSellPrice(2990);
        toy_eaa030.setWeb("https://www.nownews.com/news/5617290");
        toy_eaa030.setImageUri("https://imgur.com/s4jbfBu");
        toy_eaa030.setDate("2016-07-01");
        toy_eaa030.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa030.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa030);

        toyInfo toy_eaa031D = new toyInfo();
        toy_eaa031D.setName("EAA-031D 星際大戰 共和國複製人501師");
        toy_eaa031D.setBuyPrice(2690);
        toy_eaa031D.setSellPrice(2990);
        toy_eaa031D.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa031D.setImageUri("https://imgur.com/ssjlh2T");
        toy_eaa031D.setDate("2016-07-03");
        toy_eaa031D.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa031D.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa031D);

        toyInfo toy_eaa031S = new toyInfo();
        toy_eaa031S.setName("EAA-031S 星戰複製人 震擊部隊");
        toy_eaa031S.setBuyPrice(2690);
        toy_eaa031S.setSellPrice(2990);
        toy_eaa031S.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa031S.setImageUri("https://imgur.com/NEGobvN");
        toy_eaa031S.setDate("2016-07-04");
        toy_eaa031S.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa031S.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa031S);

        toyInfo toy_eaa033 = new toyInfo();
        toy_eaa033.setName("EAA-033 黑豹");
        toy_eaa033.setBuyPrice(2390);
        toy_eaa033.setSellPrice(2390);
        toy_eaa033.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-033.html");
        toy_eaa033.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa033.setDate("2016-07-05");
        toy_eaa033.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa033.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa033);

        toyInfo toy_eaa036 = new toyInfo();
        toy_eaa036.setName("EAA-036 Iron Man Mark 42");
        toy_eaa036.setBuyPrice(2690);
        toy_eaa036.setSellPrice(2990);
        toy_eaa036.setWeb("https://www.toy-people.com/?p=34315");
        toy_eaa036.setImageUri("https://imgur.com/L2Sdo72");
        toy_eaa036.setDate("2016-09-20");
        toy_eaa036.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa036.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa036);

        toyInfo toy_eaa037 = new toyInfo();
        toy_eaa037.setName("EAA-037 酷寒戰士");
        toy_eaa037.setBuyPrice(2150);
        toy_eaa037.setSellPrice(2390);
        toy_eaa037.setWeb("https://www.toy-people.com/?p=33960");
        toy_eaa037.setImageUri("https://imgur.com/zxZV1y3");
        toy_eaa037.setDate("2016-09-21");
        toy_eaa037.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa037.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa037);

        toyInfo toy_eaa038 = new toyInfo();
        toy_eaa038.setName("EAA-038 蟻人");
        toy_eaa038.setBuyPrice(2150);
        toy_eaa038.setSellPrice(2390);
        toy_eaa038.setWeb("https://www.toy-people.com/?p=34893");
        toy_eaa038.setImageUri("https://imgur.com/MSuszHO");
        toy_eaa038.setDate("2016-11-01");
        toy_eaa038.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa038.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa038);

        toyInfo toy_eaa039 = new toyInfo();
        toy_eaa039.setName("EAA-039 國死星突擊兵");
        toy_eaa039.setBuyPrice(1970);
        toy_eaa039.setSellPrice(2190);
        toy_eaa039.setWeb("https://www.toy-people.com/?p=36149");
        toy_eaa039.setImageUri("https://imgur.com/RunQtf7");
        toy_eaa039.setDate("2017-01-22");
        toy_eaa039.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa039.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa039);

        toyInfo toy_eaa040 = new toyInfo();
        toy_eaa040.setName("EAA-040 帝國岸防兵");
        toy_eaa040.setBuyPrice(1970);
        toy_eaa040.setSellPrice(2190);
        toy_eaa040.setWeb("https://www.toy-people.com/?p=36148");
        toy_eaa040.setImageUri("https://imgur.com/ngusY8h");
        toy_eaa040.setDate("2017-01-23");
        toy_eaa040.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa040.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa040);

        toyInfo toy_eaa044 = new toyInfo();
        toy_eaa044.setName("EAA-044 史蒂芬．史傳奇");
        toy_eaa044.setBuyPrice(1610);
        toy_eaa044.setSellPrice(1790);
        toy_eaa044.setWeb("https://www.toy-people.com/?p=35057");
        toy_eaa044.setImageUri("https://imgur.com/LRFHVu2");
        toy_eaa044.setDate("2017-01-24");
        toy_eaa044.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa044.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa044);

        toyInfo toy_eaa045 = new toyInfo();
        toy_eaa045.setName("EAA-045 黑武士達斯．維德");
        toy_eaa045.setBuyPrice(1970);
        toy_eaa045.setSellPrice(2190);
        toy_eaa045.setWeb("https://www.toy-people.com/?p=35547");
        toy_eaa045.setImageUri("https://imgur.com/YMJMfXf");
        toy_eaa045.setDate("2017-01-25");
        toy_eaa045.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa045.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa045);

        toyInfo toy_eaa046 = new toyInfo();
        toy_eaa046.setName("EAA-046 帝國暴風兵");
        toy_eaa046.setBuyPrice(1970);
        toy_eaa046.setSellPrice(2190);
        toy_eaa046.setWeb("https://www.toy-people.com/?p=35548");
        toy_eaa046.setImageUri("https://imgur.com/zEtLe7p");
        toy_eaa046.setDate("2017-01-26");
        toy_eaa046.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa046.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa046);

        toyInfo toy_eaa047 = new toyInfo();
        toy_eaa047.setName("EAA-047 席魯．英韋");
        toy_eaa047.setBuyPrice(1610);
        toy_eaa047.setSellPrice(1790);
        toy_eaa047.setWeb("https://www.toy-people.com/?p=36254");
        toy_eaa047.setImageUri("https://imgur.com/WEM0bHM");
        toy_eaa047.setDate("2017-01-27");
        toy_eaa047.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa047.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa047);

        toyInfo toy_eaa048 = new toyInfo();
        toy_eaa048.setName("EAA-048 巴茲．馬霸世");
        toy_eaa048.setBuyPrice(1610);
        toy_eaa048.setSellPrice(1790);
        toy_eaa048.setWeb("https://www.toy-people.com/?p=36254");
        toy_eaa048.setImageUri("https://imgur.com/JPLYHNo");
        toy_eaa048.setDate("2017-01-28");
        toy_eaa048.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa048.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa048);

        toyInfo toy_eaa049 = new toyInfo();
        toy_eaa049.setName("EAA-049 星際異攻隊2 火箭浣熊與小格魯特");
        toy_eaa049.setBuyPrice(2690);
        toy_eaa049.setSellPrice(2990);
        toy_eaa049.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa049.setImageUri("https://imgur.com/EKDO4SS");
        toy_eaa049.setDate("2017-01-29");
        toy_eaa049.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa049.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa049);

        toyInfo toy_eaa050 = new toyInfo();
        toy_eaa050.setName("EAA-050 星爵彼得．奎爾");
        toy_eaa050.setBuyPrice(1610);
        toy_eaa050.setSellPrice(1790);
        toy_eaa050.setWeb("https://www.toy-people.com/?p=37550");
        toy_eaa050.setImageUri("https://imgur.com/SvBgbGh");
        toy_eaa050.setDate("2017-05-02");
        toy_eaa050.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa050.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa050);

        toyInfo toy_eaa051 = new toyInfo();
        toy_eaa051.setName("EAA-051 返校日");
        toy_eaa051.setBuyPrice(2150);
        toy_eaa051.setSellPrice(2390);
        toy_eaa051.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-051.html");
        toy_eaa051.setImageUri("https://imgur.com/5BHCO65");
        toy_eaa051.setDate("2017-05-03");
        toy_eaa051.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa051.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa051);

        toyInfo toy_eaa052 = new toyInfo();
        toy_eaa052.setName("EAA-052 返校日 Iron Mark 47");
        toy_eaa052.setBuyPrice(2150);
        toy_eaa052.setSellPrice(2390);
        toy_eaa052.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa052.setImageUri("https://imgur.com/66r9spL");
        toy_eaa052.setDate("2017-05-04");
        toy_eaa052.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa052.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa052);

        toyInfo toy_eaa053 = new toyInfo();
        toy_eaa053.setName("EAA-053 角鬥士索爾");
        toy_eaa053.setBuyPrice(2150);
        toy_eaa053.setSellPrice(2390);
        toy_eaa053.setWeb("https://www.toy-people.com/?p=40260");
        toy_eaa053.setImageUri("https://imgur.com/l7Ng2mE");
        toy_eaa053.setDate("2017-10-04");
        toy_eaa053.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa053.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa053);

        toyInfo toy_eaa054 = new toyInfo();
        toy_eaa054.setName("EAA-054 角鬥士浩克");
        toy_eaa054.setBuyPrice(2150);
        toy_eaa054.setSellPrice(2390);
        toy_eaa054.setWeb("https://www.toy-people.com/?p=40259");
        toy_eaa054.setImageUri("https://imgur.com/NJ9RJyp");
        toy_eaa054.setDate("2017-10-05");
        toy_eaa054.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa054.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa054);

        toyInfo toy_eaa055 = new toyInfo();
        toy_eaa055.setName("EAA-055 帝國大反擊 達斯維德");
        toy_eaa055.setBuyPrice(2150);
        toy_eaa055.setSellPrice(2390);
        toy_eaa055.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa055.setImageUri("https://imgur.com/XsuuW4c");
        toy_eaa055.setDate("2017-10-06");
        toy_eaa055.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa055.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa055);

        toyInfo toy_eaa058 = new toyInfo();
        toy_eaa058.setName("EAA-058 法斯瑪隊長");
        toy_eaa058.setBuyPrice(2150);
        toy_eaa058.setSellPrice(2390);
        toy_eaa058.setWeb("https://www.toy-people.com/?p=40570");
        toy_eaa058.setImageUri("https://imgur.com/hFRD8Nn");
        toy_eaa058.setDate("2017-10-27");
        toy_eaa058.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa058.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa058);

        toyInfo toy_eaa059 = new toyInfo();
        toy_eaa059.setName("EAA-059 薩諾斯");
        toy_eaa059.setBuyPrice(1888);
        toy_eaa059.setSellPrice(2990);
        toy_eaa059.setWeb("https://www.toy-people.com/?p=42305");
        toy_eaa059.setImageUri("https://imgur.com/pTkAMjY");
        toy_eaa059.setDate("2017-10-28");
        toy_eaa059.setSoldState(ToyConstants.SELL);
        toy_eaa059.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa059);

        toyInfo toy_eaa060 = new toyInfo();
        toy_eaa060.setName("EAA-060 鋼鐵蜘蛛人");
        toy_eaa060.setBuyPrice(2790);
        toy_eaa060.setSellPrice(2990);
        toy_eaa060.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-060dx.html");
        toy_eaa060.setImageUri("https://imgur.com/4apuRHs");
        toy_eaa060.setDate("2017-10-29");
        toy_eaa060.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa060.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa060);

        toyInfo toy_eaa065 = new toyInfo();
        toy_eaa065.setName("EAA-065 死侍(漫畫版");
        toy_eaa065.setBuyPrice(2790);
        toy_eaa065.setSellPrice(2990);
        toy_eaa065.setWeb("https://www.toy-people.com/?p=43253");
        toy_eaa065.setImageUri("https://imgur.com/AL2A0u8");
        toy_eaa065.setDate("2017-11-01");
        toy_eaa065.setSoldState(ToyConstants.SELL);
        toy_eaa065.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa065);

        toyInfo toy_eaa066 = new toyInfo();
        toy_eaa066.setName("EAA-066 金鋼狼");
        toy_eaa066.setBuyPrice(1588);
        toy_eaa066.setSellPrice(2390);
        toy_eaa066.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-066-x.html");
        toy_eaa066.setImageUri("https://imgur.com/zZja4Nu");
        toy_eaa066.setDate("2017-11-02");
        toy_eaa066.setSoldState(ToyConstants.SELL);
        toy_eaa066.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa066);

        toyInfo toy_eaa067 = new toyInfo();
        toy_eaa067.setName("EAA-067 X戰警 獨眼龍");
        toy_eaa067.setBuyPrice(1588);
        toy_eaa067.setSellPrice(2390);
        toy_eaa067.setWeb("https://www.toy-people.com/?p=45025");
        toy_eaa067.setImageUri("https://imgur.com/QVCayh0");
        toy_eaa067.setDate("2017-11-03");
        toy_eaa067.setSoldState(ToyConstants.SELL);
        toy_eaa067.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa067);

        toyInfo toy_eaa069 = new toyInfo();
        toy_eaa069.setName("EAA-069 蟻人與黃蜂女 蟻人");
        toy_eaa069.setBuyPrice(2150);
        toy_eaa069.setSellPrice(2390);
        toy_eaa069.setWeb("https://www.toy-people.com/?p=43720");
        toy_eaa069.setImageUri("https://imgur.com/SwbjsS2");
        toy_eaa069.setDate("2018-06-19");
        toy_eaa069.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa069.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa069);

        toyInfo toy_eaa070 = new toyInfo();
        toy_eaa070.setName("EAA-070 Iron Man Mark 50");
        toy_eaa070.setBuyPrice(2799);
        toy_eaa070.setSellPrice(3290);
        toy_eaa070.setWeb("https://https://www.toy-people.com/?p=46055");
        toy_eaa070.setImageUri("https://imgur.com/thCscFR");
        toy_eaa070.setDate("2018-12-20");
        toy_eaa070.setSoldState(ToyConstants.SELL);
        toy_eaa070.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa070);

        toyInfo toy_eaa072 = new toyInfo();
        toy_eaa072.setName("EAA-072 復仇者聯盟3：無限之戰 奇異博士");
        toy_eaa072.setBuyPrice(2088);
        toy_eaa072.setSellPrice(2990);
        toy_eaa072.setWeb("https://www.toy-people.com/?p=45926");
        toy_eaa072.setImageUri("https://imgur.com/HREodWr");
        toy_eaa072.setDate("2018-12-21");
        toy_eaa072.setSoldState(ToyConstants.SELL);
        toy_eaa072.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa072);

        toyInfo toy_eaa073 = new toyInfo();
        toy_eaa073.setName("EAA-073 復仇者聯盟3：無限之戰 美國隊長");
        toy_eaa073.setBuyPrice(1688);
        toy_eaa073.setSellPrice(2390);
        toy_eaa073.setWeb("https://www.toy-people.com/?p=46057");
        toy_eaa073.setImageUri("https://imgur.com/ld0cLj6");
        toy_eaa073.setDate("2018-12-22");
        toy_eaa073.setSoldState(ToyConstants.SELL);
        toy_eaa073.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa073);

        toyInfo toy_eaa074 = new toyInfo();
        toy_eaa074.setName("EAA-074 蜘蛛人 自製戰衣");
        toy_eaa074.setBuyPrice(1888);
        toy_eaa074.setSellPrice(2390);
        toy_eaa074.setWeb("https://www.eeaseries.com/2020/10/eaa-074.html");
        toy_eaa074.setImageUri("https://imgur.com/DiAvxnM");
        toy_eaa074.setDate("2019-01-01");
        toy_eaa074.setSoldState(ToyConstants.SELL);
        toy_eaa074.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa074);

        toyInfo toy_eaa075 = new toyInfo();
        toy_eaa075.setName("EAA-075 驚奇隊長 卡羅丹佛斯");
        toy_eaa075.setBuyPrice(1688);
        toy_eaa075.setSellPrice(2390);
        toy_eaa075.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa075.setImageUri("https://imgur.com/2etjfYx");
        toy_eaa075.setDate("2019-01-02");
        toy_eaa075.setSoldState(ToyConstants.SELL);
        toy_eaa075.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa075);

        toyInfo toy_eaa077 = new toyInfo();
        toy_eaa077.setName("EAA-077 女蜘蛛人 關");
        toy_eaa077.setBuyPrice(1888);
        toy_eaa077.setSellPrice(2390);
        toy_eaa077.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa077.setImageUri("https://imgur.com/n8eB3qm");
        toy_eaa077.setDate("2019-01-03");
        toy_eaa077.setSoldState(ToyConstants.SELL);
        toy_eaa077.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa077);

        toyInfo toy_eaa078 = new toyInfo();
        toy_eaa078.setName("EAA-078 練習生 死侍");
        toy_eaa078.setBuyPrice(2150);
        toy_eaa078.setSellPrice(2390);
        toy_eaa078.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa078.setImageUri("https://imgur.com/Zimq8lA");
        toy_eaa078.setDate("2019-01-04");
        toy_eaa078.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa078.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa078);

        toyInfo toy_eaa079 = new toyInfo();
        toy_eaa079.setName("EAA-079 戰甲薩諾斯");
        toy_eaa079.setBuyPrice(1888);
        toy_eaa079.setSellPrice(2990);
        toy_eaa079.setWeb("https://www.toy-people.com/?p=47254");
        toy_eaa079.setImageUri("https://imgur.com/udOquLl");
        toy_eaa079.setDate("2019-04-23");
        toy_eaa079.setSoldState(ToyConstants.SELL);
        toy_eaa079.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa079);

        toyInfo toy_eaa080 = new toyInfo();
        toy_eaa080.setName("EAA-080 X戰警 金鋼狼");
        toy_eaa080.setBuyPrice(2150);
        toy_eaa080.setSellPrice(2390);
        toy_eaa080.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa080.setImageUri("https://imgur.com/OkLow4m");
        toy_eaa080.setDate("2019-04-24");
        toy_eaa080.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa080.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa080);

        toyInfo toy_eaa081 = new toyInfo();
        toy_eaa081.setName("EAA-081 終局之戰 浪人");
        toy_eaa081.setBuyPrice(1195);
        toy_eaa081.setSellPrice(2390);
        toy_eaa081.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa081.setImageUri("https://imgur.com/plgslly");
        toy_eaa081.setDate("2019-04-25");
        toy_eaa081.setSoldState(ToyConstants.SELL);
        toy_eaa081.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa081);

        toyInfo toy_eaa082 = new toyInfo();
        toy_eaa082.setName("EAA-082 終局之戰 黑寡婦");
        toy_eaa082.setBuyPrice(1195);
        toy_eaa082.setSellPrice(2390);
        toy_eaa082.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa082.setImageUri("https://imgur.com/WscoJby");
        toy_eaa082.setDate("2019-04-26");
        toy_eaa082.setSoldState(ToyConstants.SELL);
        toy_eaa082.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa082);

        toyInfo toy_eaa083 = new toyInfo();
        toy_eaa083.setName("EAA-083 萬磁王");
        toy_eaa083.setBuyPrice(1888);
        toy_eaa083.setSellPrice(2390);
        toy_eaa083.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa083-x.html");
        toy_eaa083.setImageUri("https://imgur.com/76drfLI");
        toy_eaa083.setDate("2019-06-16");
        toy_eaa083.setSoldState(ToyConstants.SELL);
        toy_eaa083.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa083);

        toyInfo toy_eaa084 = new toyInfo();
        toy_eaa084.setName("EAA-084 金鋼狼");
        toy_eaa084.setBuyPrice(2150);
        toy_eaa084.setSellPrice(2390);
        toy_eaa084.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa084.setImageUri("https://imgur.com/YAO4YRP");
        toy_eaa084.setDate("2019-06-17");
        toy_eaa084.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa084.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa084);

        toyInfo toy_eaa085 = new toyInfo();
        toy_eaa085.setName("EAA-085 獨眼龍");
        toy_eaa085.setBuyPrice(2150);
        toy_eaa085.setSellPrice(2390);
        toy_eaa085.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa085.setImageUri("https://imgur.com/eJCKuqP");
        toy_eaa085.setDate("2019-06-18");
        toy_eaa085.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa085.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa085);

        toyInfo toy_eaa086 = new toyInfo();
        toy_eaa086.setName("EAA-086 驚奇X戰警 獨眼龍");
        toy_eaa086.setBuyPrice(1588);
        toy_eaa086.setSellPrice(2390);
        toy_eaa086.setWeb("https://www.toy-people.com/?p=48591");
        toy_eaa086.setImageUri("https://imgur.com/9rYP6T3");
        toy_eaa086.setDate("2019-06-19");
        toy_eaa086.setSoldState(ToyConstants.SELL);
        toy_eaa086.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa086);

        toyInfo toy_eaa087 = new toyInfo();
        toy_eaa087.setName("EAA-087 漫威反派 猛毒");
        toy_eaa087.setBuyPrice(2390);
        toy_eaa087.setSellPrice(2990);
        toy_eaa087.setWeb("https://www.toy-people.com/?p=48535");
        toy_eaa087.setImageUri("https://imgur.com/heIhBeg");
        toy_eaa087.setDate("2019-07-22");
        toy_eaa087.setSoldState(ToyConstants.SELL);
        toy_eaa087.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa087);

        toyInfo toy_eaa088 = new toyInfo();
        toy_eaa088.setName("EAA-088 彼得帕克 蜘蛛人");
        toy_eaa088.setBuyPrice(1888);
        toy_eaa088.setSellPrice(2390);
        toy_eaa088.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-088.html");
        toy_eaa088.setImageUri("https://imgur.com/KDvJtyd");
        toy_eaa088.setDate("2019-08-07");
        toy_eaa088.setSoldState(ToyConstants.SELL);
        toy_eaa088.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa088);

        toyInfo toy_eaa089 = new toyInfo();
        toy_eaa089.setName("EAA-089 漫威英雄 邁爾斯 莫拉雷斯");
        toy_eaa089.setBuyPrice(1888);
        toy_eaa089.setSellPrice(2390);
        toy_eaa089.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-087.html");
        toy_eaa089.setImageUri("https://imgur.com/gT50iXZ");
        toy_eaa089.setDate("2019-08-08");
        toy_eaa089.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa089.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa089);

        toyInfo toy_eaa090 = new toyInfo();
        toy_eaa090.setName("EAA-090 Ｘ戰警 金牌手");
        toy_eaa090.setBuyPrice(1888);
        toy_eaa090.setSellPrice(2390);
        toy_eaa090.setWeb("https://www.toy-people.com/?p=50659");
        toy_eaa090.setImageUri("https://imgur.com/T8YtZN7");
        toy_eaa090.setDate("2019-12-05");
        toy_eaa090.setSoldState(ToyConstants.SELL);
        toy_eaa090.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa090);

        toyInfo toy_eaa092 = new toyInfo();
        toy_eaa092.setName("EAA-092 漫威之父 史丹李");
        toy_eaa092.setBuyPrice(2150);
        toy_eaa092.setSellPrice(2390);
        toy_eaa092.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa092.setImageUri("https://imgur.com/0AnS5Qh");
        toy_eaa092.setDate("2019-12-06");
        toy_eaa092.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa092.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa092);

        toyInfo toy_eaa093 = new toyInfo();
        toy_eaa093.setName("EAA-093 X戰警 羅根");
        toy_eaa093.setBuyPrice(2150);
        toy_eaa093.setSellPrice(2390);
        toy_eaa093.setWeb("https://www.toy-people.com/?p=48591");
        toy_eaa093.setImageUri("https://imgur.com/j11RK1d");
        toy_eaa093.setDate("2019-12-07");
        toy_eaa093.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa093.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa093);

        toyInfo toy_eaa095 = new toyInfo();
        toy_eaa095.setName("EAA-095 星際大戰:威脅潛伏達斯魔");
        toy_eaa095.setBuyPrice(2420);
        toy_eaa095.setSellPrice(2690);
        toy_eaa095.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa095.setImageUri("https://imgur.com/80cOyHD");
        toy_eaa095.setDate("2019-12-08");
        toy_eaa095.setSoldState(ToyConstants.SELL);
        toy_eaa095.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa095);

        toyInfo toy_eaa097 = new toyInfo();
        toy_eaa097.setName("EAA-097 X戰警 機堡");
        toy_eaa097.setBuyPrice(2150);
        toy_eaa097.setSellPrice(2390);
        toy_eaa097.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa097.setImageUri("https://imgur.com/Hz3QQK3");
        toy_eaa097.setDate("2020-01-01");
        toy_eaa097.setSoldState(ToyConstants.SELL);
        toy_eaa097.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa097);

        toyInfo toy_eaa098 = new toyInfo();
        toy_eaa098.setName("EAA-098 蜘蛛人 潛行戰衣");
        toy_eaa098.setBuyPrice(1888);
        toy_eaa098.setSellPrice(2390);
        toy_eaa098.setWeb("https://www.eeaseries.com/2020/12/egg-attack-action-eaa-074.html");
        toy_eaa098.setImageUri("https://imgur.com/7WlxG8d");
        toy_eaa098.setDate("2020-01-02");
        toy_eaa098.setSoldState(ToyConstants.SELL);
        toy_eaa098.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa098);

        toyInfo toy_eaa099 = new toyInfo();
        toy_eaa099.setName("EAA-099 蜘蛛人 特製戰衣");
        toy_eaa099.setBuyPrice(1799);
        toy_eaa099.setSellPrice(2390);
        toy_eaa099.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-099.html");
        toy_eaa099.setImageUri("https://imgur.com/GjZFw9o");
        toy_eaa099.setDate("2020-01-03");
        toy_eaa099.setSoldState(ToyConstants.SELL);
        toy_eaa099.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa099);

        toyInfo toy_eaa100 = new toyInfo();
        toy_eaa100.setName("EAA-100 浩克毀滅者");
        toy_eaa100.setBuyPrice(4499);
        toy_eaa100.setSellPrice(5390);
        toy_eaa100.setWeb("https://www.toy-people.com/?p=49049");
        toy_eaa100.setImageUri("https://imgur.com/fD3VTPj");
        toy_eaa100.setDate("2020-01-05");
        toy_eaa100.setSoldState(ToyConstants.SELL);
        toy_eaa100.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa100);

        toyInfo toy_eaa100SP = new toyInfo();
        toy_eaa100SP.setName("EAA-100SP 浩克毀滅者 黑金配色");
        toy_eaa100SP.setBuyPrice(5390);
        toy_eaa100SP.setSellPrice(5390);
        toy_eaa100SP.setWeb("https://www.toy-people.com/?p=53450");
        toy_eaa100SP.setImageUri("https://imgur.com/QMhPzX5");
        toy_eaa100SP.setDate("2020-01-06");
        toy_eaa100SP.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa100SP.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa100SP);

        toyInfo toy_eaa101 = new toyInfo();
        toy_eaa101.setName("EAA-101 蝙蝠俠動畫系列 蝙蝠俠");
        toy_eaa101.setBuyPrice(1888);
        toy_eaa101.setSellPrice(2390);
        toy_eaa101.setWeb("https://www.toy-people.com/?p=48775");
        toy_eaa101.setImageUri("https://imgur.com/H0sqdj8");
        toy_eaa101.setDate("2020-01-07");
        toy_eaa101.setSoldState(ToyConstants.SELL);
        toy_eaa101.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa101);

        toyInfo toy_eaa102 = new toyInfo();
        toy_eaa102.setName("EAA-102 蝙蝠俠動畫系列 小丑");
        toy_eaa102.setBuyPrice(1888);
        toy_eaa102.setSellPrice(2390);
        toy_eaa102.setWeb("https://www.toy-people.com/?p=48818");
        toy_eaa102.setImageUri("https://imgur.com/4UcTU9y");
        toy_eaa102.setDate("2020-01-08");
        toy_eaa102.setSoldState(ToyConstants.SELL);
        toy_eaa102.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa102);

        toyInfo toy_eaa103 = new toyInfo();
        toy_eaa103.setName("EAA-103 復仇者聯盟：終局之戰 雷神索爾");
        toy_eaa103.setBuyPrice(1888);
        toy_eaa103.setSellPrice(2690);
        toy_eaa103.setWeb("https://www.toy-people.com/?p=49592");
        toy_eaa103.setImageUri("https://imgur.com/kN2KlA6");
        toy_eaa103.setDate("2020-01-09");
        toy_eaa103.setSoldState(ToyConstants.SELL);
        toy_eaa103.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa103);

        toyInfo toy_eaa104 = new toyInfo();
        toy_eaa104.setName("EAA-104 復仇者聯盟：終局之戰 美國隊長");
        toy_eaa104.setBuyPrice(2150);
        toy_eaa104.setSellPrice(2690);
        toy_eaa104.setWeb("https://www.toy-people.com/?p=49584");
        toy_eaa104.setImageUri("https://imgur.com/uhQ3Jby");
        toy_eaa104.setDate("2020-01-10");
        toy_eaa104.setSoldState(ToyConstants.SELL);
        toy_eaa104.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa104);

        toyInfo toy_eaa105 = new toyInfo();
        toy_eaa105.setName("EAA-105 漫威英雄 鋼鐵人 經典漫畫版");
        toy_eaa105.setBuyPrice(2790);
        toy_eaa105.setSellPrice(2990);
        toy_eaa105.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa105.setImageUri("https://imgur.com/1NRrGH8");
        toy_eaa105.setDate("2020-01-11");
        toy_eaa105.setSoldState(ToyConstants.SELL);
        toy_eaa105.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa105);

        toyInfo toy_eaa105SP = new toyInfo();
        toy_eaa105SP.setName("EAA-105SP 漫威英雄 鋼鐵人 匿蹤模式");
        toy_eaa105SP.setBuyPrice(2790);
        toy_eaa105SP.setSellPrice(2990);
        toy_eaa105SP.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa105SP.setImageUri("https://imgur.com/nNCWSNm");
        toy_eaa105SP.setDate("2020-01-11");
        toy_eaa105SP.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa105.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa105SP);

        toyInfo toy_eaa106 = new toyInfo();
        toy_eaa106.setName("EAA-106 復仇者聯盟：無限之戰 雷神索爾");
        toy_eaa106.setBuyPrice(1888);
        toy_eaa106.setSellPrice(2390);
        toy_eaa106.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa106.setImageUri("https://imgur.com/Ph2oIm8");
        toy_eaa106.setDate("2020-01-12");
        toy_eaa106.setSoldState(ToyConstants.SELL);
        toy_eaa106.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa106);

        toyInfo toy_eaa107 = new toyInfo();
        toy_eaa107.setName("EAA-107 星際大戰:複製人全面進攻 強格費特");
        toy_eaa107.setBuyPrice(1888);
        toy_eaa107.setSellPrice(2390);
        toy_eaa107.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa107.setImageUri("https://imgur.com/kHrXZ2v");
        toy_eaa107.setDate("2020-01-13");
        toy_eaa107.setSoldState(ToyConstants.SELL);
        toy_eaa107.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa107);

        toyInfo toy_eaa108 = new toyInfo();
        toy_eaa108.setName("EAA-108 復仇者聯盟:終局之戰 驚奇隊長");
        toy_eaa108.setBuyPrice(2150);
        toy_eaa108.setSellPrice(2390);
        toy_eaa108.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa108.setImageUri("https://imgur.com/wM1ZqKV");
        toy_eaa108.setDate("2020-01-14");
        toy_eaa108.setSoldState(ToyConstants.SELL);
        toy_eaa108.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa108);

        toyInfo toy_eaa109 = new toyInfo();
        toy_eaa109.setName("EAA-109 復仇者聯盟:終局之戰 鋼鐵人 Mark 49 救援裝甲");
        toy_eaa109.setBuyPrice(2540);
        toy_eaa109.setSellPrice(2990);
        toy_eaa109.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa109.setImageUri("https://imgur.com/5BShda6");
        toy_eaa109.setDate("2020-01-15");
        toy_eaa109.setSoldState(ToyConstants.SELL);
        toy_eaa109.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa109);

        toyInfo toy_eaa110 = new toyInfo();
        toy_eaa110.setName("EAA-110 復仇者聯盟:終局之戰 鋼鐵人 Mark 85");
        toy_eaa110.setBuyPrice(2799);
        toy_eaa110.setSellPrice(3290);
        toy_eaa110.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa110.setImageUri("https://imgur.com/eWpeRuE");
        toy_eaa110.setDate("2020-01-16");
        toy_eaa110.setSoldState(ToyConstants.SELL);
        toy_eaa110.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa110);

        toyInfo toy_eaa111 = new toyInfo();
        toy_eaa111.setName("EAA-111 曼達洛人 & 孩子 豪華雙入組");
        toy_eaa111.setBuyPrice(4040);
        toy_eaa111.setSellPrice(4490);
        toy_eaa111.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa111.setImageUri("https://imgur.com/HvZZZ73");
        toy_eaa111.setDate("2020-01-17");
        toy_eaa111.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa111.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa111);

        toyInfo toy_eaa113 = new toyInfo();
        toy_eaa113.setName("EAA-113 星際大戰 達斯維達 夜光版");
        toy_eaa113.setBuyPrice(2150);
        toy_eaa113.setSellPrice(2390);
        toy_eaa113.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa113.setImageUri("https://imgur.com/SDfuNfZ");
        toy_eaa113.setDate("2020-01-18");
        toy_eaa113.setSoldState(ToyConstants.SELL);
        toy_eaa113.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa113);

        toyInfo toy_eaa116 = new toyInfo();
        toy_eaa116.setName("EAA-116 復仇者聯盟 終局之戰 雷神索爾 居家服版");
        toy_eaa116.setBuyPrice(1899);
        toy_eaa116.setSellPrice(2390);
        toy_eaa116.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa116.setImageUri("https://imgur.com/dKOlMl2");
        toy_eaa116.setDate("2020-01-19");
        toy_eaa116.setSoldState(ToyConstants.SELL);
        toy_eaa116.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa116);

        toyInfo toy_eaa117 = new toyInfo();
        toy_eaa117.setName("EAA-117 鋼鐵人 鋼鐵人Mark I");
        toy_eaa117.setBuyPrice(2420);
        toy_eaa117.setSellPrice(2690);
        toy_eaa117.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa117.setImageUri("https://imgur.com/V1aDTWc");
        toy_eaa117.setDate("2020-01-20");
        toy_eaa117.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa117.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa117);

        toyInfo toy_eaa118 = new toyInfo();
        toy_eaa118.setName("EAA-118 蝙蝠俠動畫系列 小丑女");
        toy_eaa118.setBuyPrice(1880);
        toy_eaa118.setSellPrice(2090);
        toy_eaa118.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa118.setImageUri("https://imgur.com/G256DOC");
        toy_eaa118.setDate("2020-01-21");
        toy_eaa118.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa118.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa118);

        toyInfo toy_eaa119 = new toyInfo();
        toy_eaa119.setName("EAA-119 黑暗騎士 蝙蝠俠");
        toy_eaa119.setBuyPrice(2790);
        toy_eaa119.setSellPrice(2990);
        toy_eaa119.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa119.setImageUri("https://imgur.com/IBc45xc");
        toy_eaa119.setDate("2020-01-22");
        toy_eaa119.setSoldState(ToyConstants.SELL);
        toy_eaa119.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa119);

        toyInfo toy_eaa120 = new toyInfo();
        toy_eaa120.setName("EAA-120 黑暗騎士 小丑");
        toy_eaa120.setBuyPrice(1970);
        toy_eaa120.setSellPrice(2190);
        toy_eaa120.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa120.setImageUri("https://imgur.com/htOwNLF");
        toy_eaa120.setDate("2020-01-23");
        toy_eaa120.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa120.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa120);

        toyInfo toy_eaa121 = new toyInfo();
        toy_eaa121.setName("EAA-121 無限傳奇 美國隊長 豪華版");
        toy_eaa121.setBuyPrice(2960);
        toy_eaa121.setSellPrice(3290);
        toy_eaa121.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa121.setImageUri("https://imgur.com/XK2vESr");
        toy_eaa121.setDate("2020-01-24");
        toy_eaa121.setSoldState(ToyConstants.PRE_ORDER);
        toy_eaa121.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa121);

        toyInfo toy_eaa122 = new toyInfo();
        toy_eaa122.setName("EAA-122 曼達洛人 貝斯卡裝甲版");
        toy_eaa122.setBuyPrice(2690);
        toy_eaa122.setSellPrice(2690);
        toy_eaa122.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa122.setImageUri("https://i.imgur.com/8wmUSMI.png");
        toy_eaa122.setDate("2021-10-27");
        toy_eaa122.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa122.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa122);

        toyInfo toy_eaa125 = new toyInfo();
        toy_eaa125.setName("EAA-125 自殺突擊隊 哈利 奎茵");
        toy_eaa125.setBuyPrice(2420);
        toy_eaa125.setSellPrice(2690);
        toy_eaa125.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa125.setImageUri("https://imgur.com/w0Mjj4Y");
        toy_eaa125.setDate("2021-10-28");
        toy_eaa125.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa125.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa125);

        toyInfo toy_eaa133 = new toyInfo();
        toy_eaa133.setName("EAA-133 復仇者聯盟 無限之戰 東尼史塔克 奈米服版");
        toy_eaa133.setBuyPrice(1888);
        toy_eaa133.setSellPrice(2390);
        toy_eaa133.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa133.setImageUri("https://imgur.com/dt5X4ea");
        toy_eaa133.setDate("2021-10-29");
        toy_eaa133.setSoldState(ToyConstants.SELL);
        toy_eaa133.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa133);

        toyInfo toy_eaa137 = new toyInfo();
        toy_eaa137.setName("EAA-137 魔法世界 哈利波特");
        toy_eaa137.setBuyPrice(1971);
        toy_eaa137.setSellPrice(2190);
        toy_eaa137.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa137.setImageUri("https://imgur.com/NBzWMVD");
        toy_eaa137.setDate("2021-11-01");
        toy_eaa137.setSoldState(ToyConstants.PRE_ORDER);
        toy_eaa137.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa137);

        toyInfo toy_eaa138 = new toyInfo();
        toy_eaa138.setName("EAA-138 復仇者聯盟:終局之戰 鋼鐵人Mark 85 戰損版");
        toy_eaa138.setBuyPrice(2799);
        toy_eaa138.setSellPrice(3290);
        toy_eaa138.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa138.setImageUri("https://imgur.com/VpM704D");
        toy_eaa138.setDate("2021-11-02");
        toy_eaa138.setSoldState(ToyConstants.SELL);
        toy_eaa138.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa138);

        toyInfo toy_eaa139 = new toyInfo();
        toy_eaa139.setName("EAA-139 漫威反派 綠惡魔");
        toy_eaa139.setBuyPrice(2511);
        toy_eaa139.setSellPrice(2790);
        toy_eaa139.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa139.setImageUri("https://imgur.com/b2Ro13h");
        toy_eaa139.setDate("2021-12-08");
        toy_eaa139.setSoldState(ToyConstants.PRE_ORDER);
        toy_eaa139.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa139);

        toyInfo toy_eaa143 = new toyInfo();
        toy_eaa143.setName("EAA-143 漫威反派 屠殺");
        toy_eaa143.setBuyPrice(2420);
        toy_eaa143.setSellPrice(2690);
        toy_eaa143.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa143.setImageUri("https://imgur.com/dK9Qa94");
        toy_eaa143.setDate("2021-12-09");
        toy_eaa143.setSoldState(ToyConstants.SELL);
        toy_eaa143.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa143);

        toyInfo toy_eaa144 = new toyInfo();
        toy_eaa144.setName("EAA-144 漫威反派 毒侍");
        toy_eaa144.setBuyPrice(2691);
        toy_eaa144.setSellPrice(2990);
        toy_eaa144.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-series.html");
        toy_eaa144.setImageUri("https://imgur.com/M9CJ5oH");
        toy_eaa144.setDate("2021-12-10");
        toy_eaa144.setSoldState(ToyConstants.PRE_ORDER);
        toy_eaa144.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa144);

        toyInfo toy_eaa150 = new toyInfo();
        toy_eaa150.setName("EAA-150 融合戰服");
        toy_eaa150.setBuyPrice(2151);
        toy_eaa150.setSellPrice(2390);
        toy_eaa150.setWeb("https://www.beast-kingdom.com.tw/SalePage/Index/7499982?lang=zh-TW");
        toy_eaa150.setImageUri("https://imgur.com/PC3En3q");
        toy_eaa150.setDate("2021-12-15");
        toy_eaa150.setSoldState(ToyConstants.PRE_ORDER);
        toy_eaa150.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa150);

        toyInfo toy_eaa160 = new toyInfo();
        toy_eaa160.setName("EAA-160 漫威復仇者聯盟 鋼鐵人 限定版");
        toy_eaa160.setBuyPrice(2630);
        toy_eaa160.setSellPrice(2990);
        toy_eaa160.setWeb("https://www.beast-kingdom.com.tw/SalePage/Index/7499982?lang=zh-TW");
        toy_eaa160.setImageUri("https://imgur.com/xJXPXIz");
        toy_eaa160.setDate("2021-12-16");
        toy_eaa160.setSoldState(ToyConstants.SELL);
        toy_eaa160.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa160);
    }
}
