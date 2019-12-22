package com.example.roomtest.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.diaog.messageUpdateDialogFragment;
import com.example.roomtest.diaog.componentDialogFragment;
import com.example.roomtest.diaog.feedbackDialogFragment;
import com.example.roomtest.diaog.permissionDialogFragment;
import com.example.roomtest.diaog.themeDialogFragment;
import com.example.roomtest.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019-12-18
 */
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();

                if (position == 4) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        //Log.d("TAG", "The interstitial wasn't loaded yet.");
                        Snackbar.make(view, "The interstitial wasn't loaded yet.", Snackbar.LENGTH_SHORT).show();
                    }
                } else if (position == 0) {
                    permissionDialogFragment dialog = permissionDialogFragment.newInstance();
                    dialog.show(fm, "permission_dialogfragment");
                } else if (position == 1) {
                    messageUpdateDialogFragment dialog = messageUpdateDialogFragment.newInstance();
                    dialog.show(fm, "message_update_dialogfragment");
                } else if (position == 2) {
                    feedbackDialogFragment dialog = feedbackDialogFragment.instance();
                    dialog.show(fm, "feedback_dialogfragment");
                } else if (position == 3) {
                    componentDialogFragment dialog = componentDialogFragment.newInstance(context);
                    dialog.show(fm, "component_dialogfragment");
                } else if (position == 5 ) {
                    themeDialogFragment dialog = themeDialogFragment.newInstance(context);
                    dialog.show(fm, "theme_dialogfragment");
                } else {
                    Snackbar.make(view, context.getString(R.string.FIX), Snackbar.LENGTH_SHORT).show();
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
