package com.example.roomtest.firestore;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UpdateMessage {

    public UpdateMessage(String date, String version, ArrayList<String> detail) {
        Date = date;
        Version = version;
        Detail = detail;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public ArrayList<String> getDetail() {
        return Detail;
    }

    public void setDetail(ArrayList<String> detail) {
        Detail = detail;
    }

    private String Date;
    private String Version;
    private ArrayList<String> Detail;
}
