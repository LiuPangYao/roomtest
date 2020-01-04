package com.example.roomtest.mediastore;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 2020-01-01
 */
public class mediaStoreControl {

    static String TAG = "mediaStoreControl";

    public static Uri insertImage(ContentResolver contentResolver, Bitmap bitmap, String filePath, String title, String desc) {

        OutputStream fos = null;
        File file = new File(filePath);

        /*if (!file.exists()) {
            return null;
        }*/

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, file.getName());
        values.put(MediaStore.Images.Media.TITLE, title);
        values.put(MediaStore.Images.Media.DESCRIPTION, desc);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.MediaColumns.SIZE, file.length());
        values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/ToySoul");

        Uri uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        try {
            fos = contentResolver.openOutputStream(uri);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uri;
    }

}
