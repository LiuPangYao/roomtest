package com.example.roomtest.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.Diaog.MessageUpdateDialogFragment;
import com.example.roomtest.Diaog.feedbackDialogFragment;
import com.example.roomtest.Diaog.permissionDialogFragment;
import com.example.roomtest.R;
import com.example.roomtest.ToyConstants;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    List<String> stringList = new ArrayList<>();

    private Context context;
    public String TAG = "SimpleAdapter";
    private InterstitialAd mInterstitialAd;

    public SimpleAdapter(List<String> data, Context context) {
        this.stringList = data;
        this.context = context;

        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        //mInterstitialAd.setAdUnitId(ToyConstants.AD_INTERNAL);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewAboutTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewAboutTitle = itemView.findViewById(R.id.textView_about_title);
        }
    }

    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewAboutTitle.setText(stringList.get(position).toString());

        holder.textViewAboutTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();

                if (position == 4) { // ad
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                        Snackbar.make(v, "The interstitial wasn't loaded yet.", Snackbar.LENGTH_SHORT).show();
                    }
                } else if (position == 0) {
                    permissionDialogFragment dialog = permissionDialogFragment.newInstance();
                    dialog.show(fm, "permission");
                } else if (position == 1) {
                    MessageUpdateDialogFragment dialog = MessageUpdateDialogFragment.newInstance();
                    dialog.show(fm, "message update");
                } else if (position == 2) { // feedback form
                    feedbackDialogFragment dialog = feedbackDialogFragment.instance();
                    dialog.show(fm, "feedback");
                } else {
                    Snackbar.make(v, context.getString(R.string.FIX), Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        // reload
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }
}
