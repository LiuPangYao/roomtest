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

import com.example.roomtest.ToyConstants;
import com.example.roomtest.databinding.AboutItemBinding;
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
import com.google.common.graph.AbstractNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2019-12-18
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    List<String> stringList = new ArrayList<>();

    private Context context;
    public static final String TAG = "SimpleAdapter";
    private InterstitialAd mInterstitialAd;

    private AboutItemBinding binding;

    public SimpleAdapter(List<String> data, Context context) {
        this.stringList = data;
        this.context = context;

        mInterstitialAd = new InterstitialAd(context);
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdUnitId(ToyConstants.AD_INTERNAL);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            binding = AboutItemBinding.bind(itemView);
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
        binding.textViewAboutTitle.setText(stringList.get(position).toString());

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

                    // 更動 直接編輯

                    // for blogger need to delete
                    /*long function1 = 0;
                    long function2 = 0;
                    long function3 = 0;
                    long function4 = 0;

                    for(int i = 0 ; i < randomByte.length ; i++) {
                        randomByte[i] = (byte) (1000*Math.random());
                    }

                    // 重複執行 30 次
                    for (int i = 0 ; i < 30 ; i++) {
                        function1 += testForLoopSpeed();
                        function2 += testArrayCopySpeed();
                        function3 += testArrayCopyOfSpeed();
                        function4 += testArrayCloneSpeed();
                    }

                    // 總時長
                    Log.d(TAG, "總時長 ForLoop : " + function1 + ", ArrayCopy : " + function2 +
                            ", ArrayCopyOf : " + function3 + ", ArrayClone : " + function4);*/

                    /*testForLoopSpeed();
                    testArrayCopySpeed();
                    testArrayCopyOfSpeed();
                    testArrayCloneSpeed();*/

                } else if (position == 1) {
                    messageUpdateDialogFragment dialog = messageUpdateDialogFragment.newInstance();
                    dialog.show(fm, "message_update_dialogfragment");
                } else if (position == 2) {
                    feedbackDialogFragment dialog = feedbackDialogFragment.instance(context);
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

        // 更動 1

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

    byte[] randomByte = new byte[5000];

    public long testForLoopSpeed() {

        long startTime = System.currentTimeMillis();

        byte[] copyByte = new byte[randomByte.length];
        for(int i = 0 ; i < copyByte.length ; i++ ) {
            copyByte[i] = randomByte[i];
        }
        printData(copyByte);

        long endTime = System.currentTimeMillis();

        Log.d(TAG, "花費時間: "+(endTime-startTime));

        return (endTime-startTime);
    }

    public long testArrayCopySpeed() {

        long startTime = System.currentTimeMillis();

        byte[] copyByte = new byte[randomByte.length];

        // 準備複製的內容, 開始位置, 複製目的地, 開始位置, 長度
        System.arraycopy(randomByte, 0, copyByte, 0 , copyByte.length);
        printData(copyByte);

        long endTime = System.currentTimeMillis();

        Log.d(TAG, "花費時間: "+(endTime-startTime));

        return (endTime-startTime);
    }

    public long testArrayCopyOfSpeed() {

        long startTime = System.currentTimeMillis();

        byte[] copyByte = Arrays.copyOf(randomByte, randomByte.length);
        printData(copyByte);

        long endTime = System.currentTimeMillis();

        Log.d(TAG, "花費時間: "+(endTime-startTime));

        return (endTime-startTime);
    }

    public long testArrayCloneSpeed() {

        long startTime = System.currentTimeMillis();

        byte[] copyByte = randomByte.clone();
        printData(copyByte);

        long endTime = System.currentTimeMillis();

        Log.d(TAG, "花費時間: "+(endTime-startTime));

        return (endTime-startTime);
    }

    public void printData(byte[] copyArray) {
        StringBuilder builder = new StringBuilder();
        for(int value : copyArray) {
            builder.append(value + ", ");
        }
    }
}
