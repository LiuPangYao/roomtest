package com.example.roomtest.database;

import android.content.Context;

import com.example.roomtest.ToyConstants;

/**
 * 2021-01-18
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
        toy_eaa001.setDate("2015-05-16");
        toy_eaa001.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa001.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa001);

        toyInfo toy_eaa002 = new toyInfo();
        toy_eaa002.setName("EAA-002 黑武士 達斯.維達");
        toy_eaa002.setBuyPrice(2990);
        toy_eaa002.setSellPrice(2990);
        toy_eaa002.setWeb("https://www.toy-people.com/?p=28921");
        toy_eaa002.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa002.setDate("2015-05-19");
        toy_eaa002.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa002.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa002);

        toyInfo toy_eaa003 = new toyInfo();
        toy_eaa003.setName("EAA-003 Iron Man Mark I");
        toy_eaa003.setBuyPrice(2990);
        toy_eaa003.setSellPrice(2990);
        toy_eaa003.setWeb("https://www.toy-people.com/?p=28921");
        toy_eaa003.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa003.setDate("2015-05-19");
        toy_eaa003.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa003.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa003);

        toyInfo toy_eaa004 = new toyInfo();
        toy_eaa004.setName("EAA-004 Iron Man Mark 43");
        toy_eaa004.setBuyPrice(2500);
        toy_eaa004.setSellPrice(2500);
        toy_eaa004.setWeb("https://www.toy-people.com/?p=28921");
        toy_eaa004.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa004.setDate("2015-11-29");
        toy_eaa004.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa004.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa004);

        toyInfo toy_eaa005 = new toyInfo();
        toy_eaa005.setName("EAA-005 帝國暴風兵");
        toy_eaa005.setBuyPrice(2690);
        toy_eaa005.setSellPrice(2990);
        toy_eaa005.setWeb("https://www.toy-people.com/?p=30008");
        toy_eaa005.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa005.setDate("2015-09-03");
        toy_eaa005.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa005.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa005);

        toyInfo toy_eaa006 = new toyInfo();
        toy_eaa006.setName("EAA-006 共和國複製人士兵");
        toy_eaa006.setBuyPrice(2150);
        toy_eaa006.setSellPrice(2390);
        toy_eaa006.setWeb("https://www.toy-people.com/?p=32360");
        toy_eaa006.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa006.setDate("2015-04-25");
        toy_eaa006.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa006.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa006);

        toyInfo toy_eaa007 = new toyInfo();
        toy_eaa007.setName("EAA-007 帝國沙漠兵");
        toy_eaa007.setBuyPrice(2690);
        toy_eaa007.setSellPrice(2990);
        toy_eaa007.setWeb("https://www.toy-people.com/?p=30010");
        toy_eaa007.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa007.setDate("2015-09-03");
        toy_eaa007.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa007.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa007);

        toyInfo toy_eaa008 = new toyInfo();
        toy_eaa008.setName("EAA-008 G-3P9");
        toy_eaa008.setBuyPrice(2500);
        toy_eaa008.setSellPrice(2790);
        toy_eaa008.setWeb("http://www.luantoys.url.tw/archives/44793");
        toy_eaa008.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa008.setDate("2016-05-18");
        toy_eaa008.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa008.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa008);

        toyInfo toy_eaa009 = new toyInfo();
        toy_eaa009.setName("EAA-009 R2-D2");
        toy_eaa009.setBuyPrice(2790);
        toy_eaa009.setSellPrice(2790);
        toy_eaa009.setWeb("https://www.toy-people.com/?p=36858&fbclid=IwAR34Lh-AwLuqrRqGzfhECyYm0u5cVp1U2rkbYsS_MBipz7ilc4s73ewxDnM");
        toy_eaa009.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa009.setDate("2017-05-18");
        toy_eaa009.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa009.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa009);

        toyInfo toy_eaa010 = new toyInfo();
        toy_eaa010.setName("EAA-010 G-3P9 & R2-D2");
        toy_eaa010.setBuyPrice(5380);
        toy_eaa010.setSellPrice(5380);
        toy_eaa010.setWeb("https://www.toy-people.com/?p=32586");
        toy_eaa010.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa010.setDate("2017-03-01");
        toy_eaa010.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa010.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa010);

        toyInfo toy_eaa011 = new toyInfo();
        toy_eaa011.setName("EAA-011 奧創紀元 美國隊長");
        toy_eaa011.setBuyPrice(2690);
        toy_eaa011.setSellPrice(2990);
        toy_eaa011.setWeb("https://www.facebook.com/BKTOYS000/photos/eaa-011-%E5%BE%A9%E4%BB%87%E8%80%85%E8%81%AF%E7%9B%9F-%E5%A5%A7%E5%89%B5%E7%B4%80%E5%85%83-%E7%BE%8E%E5%9C%8B%E9%9A%8A%E9%95%B7%E5%BB%BA%E8%AD%B0%E5%94%AE%E5%83%B92990%E5%85%83%E5%8F%83%E8%80%83%E9%A0%90%E8%B3%BC%E5%83%B92690%E5%85%83%E9%A0%90%E8%A8%88%E5%88%B0%E8%B2%A8%E6%97%A52016%E5%B9%B43%E6%9C%88%E4%B8%8B%E6%97%AC%E9%A0%90%E8%B3%BC%E6%88%AA%E6%AD%A2%E6%97%A52015%E5%B9%B411%E6%9C%8823%E6%97%A5%E9%87%8E%E7%8D%B8%E5%9C%8B%E9%9A%86%E9%87%8D%E6%8E%A8%E5%87%BA%E5%BE%A9/10153715678012277/");
        toy_eaa011.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa011.setDate("2015-11-23");
        toy_eaa011.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa011.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa011);

        toyInfo toy_eaa013 = new toyInfo();
        toy_eaa013.setName("EAA-013 奧創紀元 雷神索爾");
        toy_eaa013.setBuyPrice(2690);
        toy_eaa013.setSellPrice(2990);
        toy_eaa013.setWeb("https://www.toy-people.com/?p=30620");
        toy_eaa013.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa013.setDate("2015-11-04");
        toy_eaa013.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa013.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa013);

        toyInfo toy_eaa014 = new toyInfo();
        toy_eaa014.setName("EAA-014 星際大戰 濕背獸");
        toy_eaa014.setBuyPrice(1590);
        toy_eaa014.setSellPrice(1590);
        toy_eaa014.setWeb("https://www.beast-kingdom.com.tw/SalePage/Index/6677948?lang=zh-TW");
        toy_eaa014.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa014.setDate("2017-03-01");
        toy_eaa014.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa014.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa014);

        toyInfo toy_eaa014s = new toyInfo();
        toy_eaa014s.setName("EAA-014s 星際大戰 濕背獸 & 帝國沙漠兵");
        toy_eaa014s.setBuyPrice(4280);
        toy_eaa014s.setSellPrice(4280);
        toy_eaa014s.setWeb("https://www.toy-people.com/?p=38583");
        toy_eaa014s.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa014s.setDate("2017-07-03");
        toy_eaa014s.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa014s.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa014s);

        toyInfo toy_eaa015H = new toyInfo();
        toy_eaa015H.setName("EAA-015H 第一軍團 重裝突擊兵");
        toy_eaa015H.setBuyPrice(2150);
        toy_eaa015H.setSellPrice(2390);
        toy_eaa015H.setWeb("https://www.toy-people.com/?p=36973");
        toy_eaa015H.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa015H.setDate("2017-04-07");
        toy_eaa015H.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa015H.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa015H);

        toyInfo toy_eaa015R = new toyInfo();
        toy_eaa015R.setName("EAA-015R 第一軍團 鎮暴突擊兵");
        toy_eaa015R.setBuyPrice(2150);
        toy_eaa015R.setSellPrice(2390);
        toy_eaa015R.setWeb("https://www.toy-people.com/?p=36973");
        toy_eaa015R.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa015R.setDate("2017-04-07");
        toy_eaa015R.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa015R.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa015R);

        toyInfo toy_eaa016 = new toyInfo();
        toy_eaa016.setName("EAA-016 法斯馬隊長");
        toy_eaa016.setBuyPrice(2150);
        toy_eaa016.setSellPrice(2390);
        toy_eaa016.setWeb("https://www.toy-people.com/?p=31412");
        toy_eaa016.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa016.setDate("2016-01-21");
        toy_eaa016.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa016.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa016);

        toyInfo toy_eaa017 = new toyInfo();
        toy_eaa017.setName("EAA-017 凱羅．忍");
        toy_eaa017.setBuyPrice(2150);
        toy_eaa017.setSellPrice(2390);
        toy_eaa017.setWeb("https://www.toy-people.com/?p=31411");
        toy_eaa017.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa017.setDate("2016-01-22");
        toy_eaa017.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa017.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa017);

        toyInfo toy_eaa018 = new toyInfo();
        toy_eaa018.setName("EAA-018 星際大戰 帝國暗影風暴兵");
        toy_eaa018.setBuyPrice(2150);
        toy_eaa018.setSellPrice(2390);
        toy_eaa018.setWeb("https://www.facebook.com/BKTOYS000/photos/%E5%B8%9D%E5%9C%8B%E7%B2%BE%E9%8A%B3egg-attack-action-eaa-018-%E6%98%9F%E9%9A%9B%E5%A4%A7%E6%88%B0%E5%B8%9D%E5%9C%8B%E6%9A%97%E5%BD%B1%E9%A2%A8%E6%9A%B4%E5%85%B5%E5%8D%B3%E5%B0%87%E5%89%8D%E4%BE%86%E5%A0%B1%E5%88%B0egg-attack-action-eaa-018-star-wa/10153759521532277/");
        toy_eaa018.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa018.setDate("2015-11-27");
        toy_eaa018.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa018.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa018);

        toyInfo toy_eaa020 = new toyInfo();
        toy_eaa020.setName("EAA-020 星際大戰 波巴·費特");
        toy_eaa020.setBuyPrice(2150);
        toy_eaa020.setSellPrice(2390);
        toy_eaa020.setWeb("https://www.toy-people.com/?p=43483");
        toy_eaa020.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa020.setDate("2018-06-05");
        toy_eaa020.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa020.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa020);

        toyInfo toy_eaa021 = new toyInfo();
        toy_eaa021.setName("EAA-021 Iron Man MK45");
        toy_eaa021.setBuyPrice(2690);
        toy_eaa021.setSellPrice(2990);
        toy_eaa021.setWeb("https://www.toy-people.com/?p=32847");
        toy_eaa021.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa021.setDate("2016-06-08");
        toy_eaa021.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa021.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa021);

        toyInfo toy_eaa023 = new toyInfo();
        toy_eaa023.setName("EAA-023 火箭浣熊 & 小樹人格魯特");
        toy_eaa023.setBuyPrice(2690);
        toy_eaa023.setSellPrice(2990);
        toy_eaa023.setWeb("https://www.toy-people.com/?p=33049");
        toy_eaa023.setImageUri("https://imgur.com/CMHkNlK");
        toy_eaa023.setDate("2016-06-27");
        toy_eaa023.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa023.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa023);

        toyInfo toy_eaa024 = new toyInfo();
        toy_eaa024.setName("EAA-024 戰損鋼鐵人");
        toy_eaa024.setBuyPrice(2390);
        toy_eaa024.setSellPrice(2150);
        toy_eaa024.setWeb("https://www.eeaseries.com/2020/10/egg-attack-action-eaa-024-mk43.html");
        toy_eaa024.setImageUri("https://imgur.com/fg1jY5C");
        toy_eaa024.setDate("2019-05-11");
        toy_eaa024.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa024.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa024);

        toyInfo toy_eaa027 = new toyInfo();
        toy_eaa027.setName("EAA-027 星際大戰 絕地大反攻 波巴費特");
        toy_eaa027.setBuyPrice(2690);
        toy_eaa027.setSellPrice(2990);
        toy_eaa027.setWeb("https://www.beast-kingdom.com.tw/SalePage/Index/6863820?lang=zh-TW");
        toy_eaa027.setImageUri("https://imgur.com/fg1jY5C");
        toy_eaa027.setDate("2019-05-11");
        toy_eaa027.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa027.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa027);

        toyInfo toy_eaa029 = new toyInfo();
        toy_eaa029.setName("EAA-029 美國隊長 英雄內戰");
        toy_eaa029.setBuyPrice(2690);
        toy_eaa029.setSellPrice(2990);
        toy_eaa029.setWeb("https://www.toy-people.com/?p=33130");
        toy_eaa029.setImageUri("https://imgur.com/fg1jY5C");
        toy_eaa029.setDate("2016-06-30");
        toy_eaa029.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa029.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa029);

        toyInfo toy_eaa030 = new toyInfo();
        toy_eaa030.setName("EAA-030 Iron Man MK46");
        toy_eaa030.setBuyPrice(2690);
        toy_eaa030.setSellPrice(2990);
        toy_eaa030.setWeb("https://www.nownews.com/news/5617290");
        toy_eaa030.setImageUri("https://imgur.com/fg1jY5C");
        toy_eaa030.setDate("2020-01-04");
        toy_eaa030.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa030.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa030);

        toyInfo toy_eaa031D = new toyInfo();
        toy_eaa031D.setName("EAA-031D 星際大戰 共和國複製人501師");
        toy_eaa031D.setBuyPrice(2690);
        toy_eaa031D.setSellPrice(2990);
        toy_eaa031D.setWeb("https://shopee.tw/%E6%96%B0%E7%AB%B9%E5%BF%AB%E6%A8%82%E5%A0%82-EAA-031D-%E6%98%9F%E9%9A%9B%E5%A4%A7%E6%88%B0-%E5%85%B1%E5%92%8C%E5%9C%8B%E8%A4%87%E8%A3%BD%E4%BA%BA-501%E5%B8%AB-i.23067971.717768920");
        toy_eaa031D.setImageUri("https://imgur.com/fg1jY5C");
        toy_eaa031D.setDate("2020-01-04");
        toy_eaa031D.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa031D.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa031D);

        toyInfo toy_eaa031S = new toyInfo();
        toy_eaa031S.setName("EAA-031S 星戰複製人 震擊部隊");
        toy_eaa031S.setBuyPrice(2690);
        toy_eaa031S.setSellPrice(2990);
        toy_eaa031S.setWeb("https://shopee.tw/EAA-031S-%E6%98%9F%E6%88%B0%E8%A4%87%E8%A3%BD%E4%BA%BA-%E9%9C%87%E6%93%8A%E9%83%A8%E9%9A%8AAGG-ATTACK-i.1404683.1775534730");
        toy_eaa031S.setImageUri("https://imgur.com/fg1jY5C");
        toy_eaa031S.setDate("2020-01-04");
        toy_eaa031S.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa031S.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa031S);

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

        toyInfo toy_eaa036 = new toyInfo();
        toy_eaa036.setName("EAA-036 Iron Man MK42");
        toy_eaa036.setBuyPrice(2690);
        toy_eaa036.setSellPrice(2990);
        toy_eaa036.setWeb("https://www.toy-people.com/?p=34315");
        toy_eaa036.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa036.setDate("2016-09-20");
        toy_eaa036.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa036.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa036);

        toyInfo toy_eaa037 = new toyInfo();
        toy_eaa037.setName("EAA-037 酷寒戰士");
        toy_eaa037.setBuyPrice(2150);
        toy_eaa037.setSellPrice(2390);
        toy_eaa037.setWeb("https://www.toy-people.com/?p=33960");
        toy_eaa037.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa037.setDate("2016-08-25");
        toy_eaa037.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa037.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa037);

        toyInfo toy_eaa038 = new toyInfo();
        toy_eaa038.setName("EAA-038 蟻人");
        toy_eaa038.setBuyPrice(2150);
        toy_eaa038.setSellPrice(2390);
        toy_eaa038.setWeb("https://www.toy-people.com/?p=34893");
        toy_eaa038.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa038.setDate("2016-11-01");
        toy_eaa038.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa038.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa038);

        toyInfo toy_eaa039 = new toyInfo();
        toy_eaa039.setName("EAA-039 國死星突擊兵");
        toy_eaa039.setBuyPrice(1970);
        toy_eaa039.setSellPrice(2190);
        toy_eaa039.setWeb("https://www.toy-people.com/?p=36149");
        toy_eaa039.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa039.setDate("2017-01-22");
        toy_eaa039.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa039.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa039);

        toyInfo toy_eaa040 = new toyInfo();
        toy_eaa040.setName("EAA-040 帝國岸防兵");
        toy_eaa040.setBuyPrice(1970);
        toy_eaa040.setSellPrice(2190);
        toy_eaa040.setWeb("https://www.toy-people.com/?p=36148");
        toy_eaa040.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa040.setDate("2017-01-22");
        toy_eaa040.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa040.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa040);

        toyInfo toy_eaa044 = new toyInfo();
        toy_eaa044.setName("EAA-044 史蒂芬．史傳奇");
        toy_eaa044.setBuyPrice(1610);
        toy_eaa044.setSellPrice(1790);
        toy_eaa044.setWeb("https://www.toy-people.com/?p=35057");
        toy_eaa044.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa044.setDate("2016-11-04");
        toy_eaa044.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa044.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa044);

        toyInfo toy_eaa045 = new toyInfo();
        toy_eaa045.setName("EAA-045 黑武士達斯．維德");
        toy_eaa045.setBuyPrice(1970);
        toy_eaa045.setSellPrice(2190);
        toy_eaa045.setWeb("https://www.toy-people.com/?p=35547");
        toy_eaa045.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa045.setDate("2016-12-11");
        toy_eaa045.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa045.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa045);

        toyInfo toy_eaa046 = new toyInfo();
        toy_eaa046.setName("EAA-046 帝國暴風兵");
        toy_eaa046.setBuyPrice(1970);
        toy_eaa046.setSellPrice(2190);
        toy_eaa046.setWeb("https://www.toy-people.com/?p=35548");
        toy_eaa046.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa046.setDate("2016-12-12");
        toy_eaa046.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa046.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa046);

        toyInfo toy_eaa047 = new toyInfo();
        toy_eaa047.setName("EAA-047 席魯．英韋");
        toy_eaa047.setBuyPrice(1610);
        toy_eaa047.setSellPrice(1790);
        toy_eaa047.setWeb("https://www.toy-people.com/?p=36254");
        toy_eaa047.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa047.setDate("2016-12-12");
        toy_eaa047.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa047.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa047);

        toyInfo toy_eaa048 = new toyInfo();
        toy_eaa048.setName("EAA-048 巴茲．馬霸世");
        toy_eaa048.setBuyPrice(1610);
        toy_eaa048.setSellPrice(1790);
        toy_eaa048.setWeb("https://www.toy-people.com/?p=36254");
        toy_eaa048.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa048.setDate("2016-12-12");
        toy_eaa048.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa048.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa048);

        toyInfo toy_eaa049 = new toyInfo();
        toy_eaa049.setName("EAA-049 星際異攻隊2 火箭浣熊與小格魯特");
        toy_eaa049.setBuyPrice(2690);
        toy_eaa049.setSellPrice(2990);
        toy_eaa049.setWeb("https://shopee.tw/EAA-049-Egg-Attack-Action-%E9%87%8E%E7%8D%B8%E5%9C%8B-%E7%B5%95%E7%89%88%E6%AD%A3%E5%93%81-(%E7%8F%BE%E8%B2%A8%E4%B8%80%E4%BB%B6)-%E6%98%9F%E9%9A%9B%E7%95%B0%E6%94%BB%E9%9A%8A2-%E7%81%AB%E7%AE%AD%E6%B5%A3%E7%86%8A%E8%88%87%E5%B0%8F%E6%A0%BC%E9%AD%AF%E7%89%B9-i.20470875.4215145815");
        toy_eaa049.setImageUri("https://imgur.com/tJl7j2Y");
        toy_eaa049.setDate("2016-12-12");
        toy_eaa049.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa049.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa049);

        toyInfo toy_eaa050 = new toyInfo();
        toy_eaa050.setName("EAA-050 星爵彼得．奎爾");
        toy_eaa050.setBuyPrice(1610);
        toy_eaa050.setSellPrice(1790);
        toy_eaa050.setWeb("https://www.toy-people.com/?p=37550");
        toy_eaa050.setImageUri("https://imgur.com/tJl7j2Y");
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
        toy_eaa051.setDate("2019-05-01");
        toy_eaa051.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa051.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa051);

        toyInfo toy_eaa052 = new toyInfo();
        toy_eaa052.setName("EAA-052 返校日 Iron Man mk 47");
        toy_eaa052.setBuyPrice(2150);
        toy_eaa052.setSellPrice(2390);
        toy_eaa052.setWeb("https://www.eeaseries.com/2020/10/egg-attack-eaa-051.html");
        toy_eaa052.setImageUri("https://imgur.com/5BHCO65");
        toy_eaa052.setDate("2019-05-01");
        toy_eaa052.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa052.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa052);

        toyInfo toy_eaa053 = new toyInfo();
        toy_eaa053.setName("EAA-053 角鬥士索爾");
        toy_eaa053.setBuyPrice(2150);
        toy_eaa053.setSellPrice(2390);
        toy_eaa053.setWeb("https://www.toy-people.com/?p=40260");
        toy_eaa053.setImageUri("https://imgur.com/5BHCO65");
        toy_eaa053.setDate("2017-10-04");
        toy_eaa053.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa053.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa053);

        toyInfo toy_eaa054 = new toyInfo();
        toy_eaa054.setName("EAA-054 角鬥士浩克");
        toy_eaa054.setBuyPrice(2150);
        toy_eaa054.setSellPrice(2390);
        toy_eaa054.setWeb("https://www.toy-people.com/?p=40259");
        toy_eaa054.setImageUri("https://imgur.com/5BHCO65");
        toy_eaa054.setDate("2017-10-04");
        toy_eaa054.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa054.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa054);

        toyInfo toy_eaa055 = new toyInfo();
        toy_eaa055.setName("EAA-055 帝國大反擊 達斯維德");
        toy_eaa055.setBuyPrice(2150);
        toy_eaa055.setSellPrice(2390);
        toy_eaa055.setWeb("https://www.facebook.com/BKTOYS000/posts/10155777400482277/");
        toy_eaa055.setImageUri("https://imgur.com/5BHCO65");
        toy_eaa055.setDate("2017-10-01");
        toy_eaa055.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa055.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa055);

        toyInfo toy_eaa058 = new toyInfo();
        toy_eaa058.setName("EAA-058 法斯瑪隊長");
        toy_eaa058.setBuyPrice(2150);
        toy_eaa058.setSellPrice(2390);
        toy_eaa058.setWeb("https://www.toy-people.com/?p=40570");
        toy_eaa058.setImageUri("https://imgur.com/5BHCO65");
        toy_eaa058.setDate("2017-10-27");
        toy_eaa058.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa058.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa058);

        toyInfo toy_eaa059 = new toyInfo();
        toy_eaa059.setName("EAA-059 薩諾斯");
        toy_eaa059.setBuyPrice(2690);
        toy_eaa059.setSellPrice(2990);
        toy_eaa059.setWeb("https://www.toy-people.com/?p=42305");
        toy_eaa059.setImageUri("https://imgur.com/5BHCO65");
        toy_eaa059.setDate("2017-10-27");
        toy_eaa059.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa059.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa059);

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

        toyInfo toy_eaa065 = new toyInfo();
        toy_eaa065.setName("EAA-065 死侍(漫畫版");
        toy_eaa065.setBuyPrice(2790);
        toy_eaa065.setSellPrice(2990);
        toy_eaa065.setWeb("https://www.toy-people.com/?p=43253");
        toy_eaa065.setImageUri("https://imgur.com/4apuRHs");
        toy_eaa065.setDate("2019-09-07");
        toy_eaa065.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa065.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa065);

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

        toyInfo toy_eaa067 = new toyInfo();
        toy_eaa067.setName("EAA-067 X戰警 獨眼龍");
        toy_eaa067.setBuyPrice(2150);
        toy_eaa067.setSellPrice(2390);
        toy_eaa067.setWeb("https://www.toy-people.com/?p=45025");
        toy_eaa067.setImageUri("https://imgur.com/zZja4Nu");
        toy_eaa067.setDate("2018-10-01");
        toy_eaa067.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa067.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa067);

        toyInfo toy_eaa069 = new toyInfo();
        toy_eaa069.setName("EAA-069 蟻人與黃蜂女 蟻人");
        toy_eaa069.setBuyPrice(2150);
        toy_eaa069.setSellPrice(2390);
        toy_eaa069.setWeb("https://www.toy-people.com/?p=43720");
        toy_eaa069.setImageUri("https://imgur.com/zZja4Nu");
        toy_eaa069.setDate("2018-06-22");
        toy_eaa069.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa069.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa069);

        toyInfo toy_eaa070 = new toyInfo();
        toy_eaa070.setName("EAA-070 Iron Man MARK 50");
        toy_eaa070.setBuyPrice(2150);
        toy_eaa070.setSellPrice(2390);
        toy_eaa070.setWeb("https://https://www.toy-people.com/?p=46055");
        toy_eaa070.setImageUri("https://imgur.com/zZja4Nu");
        toy_eaa070.setDate("2018-12-21");
        toy_eaa070.setSoldState(ToyConstants.SOLD_OUT);
        toy_eaa070.setGain(ToyConstants.COMMON);
        dataInstance.getToyDao().insert(toy_eaa070);

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
