package com.example.roomtest.diaog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.roomtest.R;

/**
 * 2020-01-01
 */
public class shareDialogFragment extends DialogFragment {

    static Context mContext;
    static shareDialogFragment frag;
    static Bitmap mBitmap;
    static Uri mUri;
    static String mPath;
    String TAG = "shareDialogFragment";

    public shareDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static shareDialogFragment newInstance(Context context, Bitmap bitmap, String path, Uri uri) {
        frag = new shareDialogFragment();
        mContext = context;
        mBitmap = bitmap;
        mPath = path;
        mUri = uri;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.share_dialogfragment, container, false);

        ImageView shareImage = view.findViewById(R.id.imageViewShare);
        shareImage.setImageBitmap(mBitmap);

        TextView path = view.findViewById(R.id.textViewImagePath);
        path.setText(mPath);

        Button closeButton = view.findViewById(R.id.buttonEnd);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag.dismiss();
            }
        });

        Button shareButton = view.findViewById(R.id.buttonShare);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, mUri);
                shareIntent.setType("image/jpeg");
                startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.SEND_TO)));
            }
        });

        return view;
    }
}
