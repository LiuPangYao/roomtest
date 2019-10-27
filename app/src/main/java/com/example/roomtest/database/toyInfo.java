package com.example.roomtest.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class toyInfo {

    @PrimaryKey(autoGenerate = true)
    public int mId;
    //@ColumnInfo
    public String name;
    //@ColumnInfo
    public int buyPrice;
    //@ColumnInfo
    public int sellPrice;
    //@ColumnInfo
    public String web;
    //@ColumnInfo
    public String imageUri;
    //@ColumnInfo
    public String date;
    //@ColumnInfo
    public int gain;
    //@ColumnInfo
    public int soldState;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public int getSoldState() {
        return soldState;
    }

    public void setSoldState(int soldState) {
        this.soldState = soldState;
    }
}
