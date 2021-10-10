package com.example.roomtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.databinding.ActivityWebBinding;

import java.util.List;

/**
 * 2021-10-10 view binding
 */
public class WebActivity extends Activity implements View.OnClickListener {

    private ActivityWebBinding binding;

    List<toyInfo> toyList = null;
    private final static String TAG = "WebActivity";
    int[] toyIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 2021-10-10 view binding
        binding = ActivityWebBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setContentView(R.layout.activity_web);

        //init
        initView();

        ProgressDialogUtil.showProgressDialog(this);

        //get intent information
        Intent intent = getIntent();
        int mId = intent.getIntExtra("mId", 0);
        //Log.d(TAG, "onCreate: mId = " + mId );
        toyIds = new int[1];
        toyIds[0] = mId;

        WebSettings settings = binding.webview.getSettings();
        settings.setJavaScriptEnabled(true);

        binding.webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        testTask asyncTask = new testTask(this);
        asyncTask.execute("start");
    }

    public void initWebView() {
        binding.webview.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url)
            {
                ProgressDialogUtil.dismiss();
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {
                // error url
            }
        });

        binding.webview.loadUrl(toyList.get(0).getWeb());
    }

    public void initView() {
        binding.imageViewback.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imageViewback:
                finish();
                break;
        }
    }

    class testTask extends AsyncTask<String, Integer, Boolean> {

        Context mContext = null;

        testTask(Context context){
            mContext = context;
        }

        protected Boolean doInBackground(String... strings) {
            toyList = dataBase.getInstance(WebActivity.this).getToyDao().loadAllByOnlyIds(toyIds);
            return true;
        }

        protected void onPostExecute(Boolean result) {
            initWebView();
        }
    }
}