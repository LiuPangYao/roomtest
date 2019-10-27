package com.example.roomtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;

import java.util.List;

public class WebActivity extends Activity implements View.OnClickListener {

    private WebView mWebView;
    private ImageView imgButton;
    private ProgressBar mProgressBarWeb;
    List<toyInfo> toyList = null;
    private final String TAG = "WebActivity.class";
    int[] toyIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_web);

        //init
        init();

        //get intent information
        Intent intent = getIntent();
        int mId = intent.getIntExtra("mId", 0);
        //Log.d(TAG, "onCreate: mId = " + mId );
        toyIds = new int[1];
        toyIds[0] = mId;

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mProgressBarWeb.setVisibility(View.VISIBLE);

        testTask asyncTask = new testTask(this);
        asyncTask.execute("start");
    }

    public void initWebView() {
        mWebView.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url)
            {
                mProgressBarWeb.setVisibility(View.GONE);
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {
                // error url
            }
        });

        mWebView.loadUrl(toyList.get(0).getWeb());
    }

    public void init() {
        mWebView = findViewById(R.id.webview);
        mProgressBarWeb = findViewById(R.id.progressBarWeb);
        imgButton = findViewById(R.id.imageView_back);
        imgButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imageView_back:
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

