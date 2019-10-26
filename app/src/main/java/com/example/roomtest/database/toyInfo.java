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
    public int price;
    //@ColumnInfo
    public String web;
    //@ColumnInfo
    public String imageUri;
    //@ColumnInfo
    public String date;

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

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
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
}
