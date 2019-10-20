package com.example.roomtest.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {toyInfo.class}, version = 1)
public abstract class dataBase extends RoomDatabase {

    private static final String DB_NAME = "toy.db";
    private static volatile dataBase instance;

    public static synchronized dataBase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static dataBase create(final Context context) {
        return Room.databaseBuilder(
                context,
                dataBase.class,
                DB_NAME).build();
    }

    public abstract toyDao getToyDao();

}
