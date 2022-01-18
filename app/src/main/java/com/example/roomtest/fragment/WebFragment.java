package com.example.roomtest.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.roomtest.ProgressDialogUtil;
import com.example.roomtest.R;
import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.databinding.FragmentWebBinding;

import java.util.List;

public class WebFragment extends Fragment implements View.OnClickListener{

    private FragmentWebBinding binding;

    List<toyInfo> toyList = null;
    private final static String TAG = "WebFragment";
    int[] toyIds;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public WebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebFragment newInstance(String param1, String param2) {
        WebFragment fragment = new WebFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentWebBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        initView(view);
        return view;
    }

    public void initView(View view) {
        binding.imageViewBack.setOnClickListener(this);

        Bundle bundle = this.getArguments();
        int mId = bundle.getInt("mId");
        //int mId = 1;
        Log.d(TAG, "onCreate: mId = " + mId );
        toyIds = new int[1];
        toyIds[0] = mId;

        WebSettings settings = binding.webview.getSettings();
        settings.setJavaScriptEnabled(true);

        binding.webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        testTask asyncTask = new testTask(getActivity());
        asyncTask.execute("start");

        ProgressDialogUtil.showProgressDialog(getActivity());
    }

    class testTask extends AsyncTask<String, Integer, Boolean> {

        Context mContext = null;

        testTask(Context context){
            mContext = context;
        }

        protected Boolean doInBackground(String... strings) {
            toyList = dataBase.getInstance(getActivity()).getToyDao().loadAllByOnlyIds(toyIds);
            return true;
        }

        protected void onPostExecute(Boolean result) {
            initWebView();
        }
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageViewBack:
                Log.d(TAG, "onClick: back");
                getFragmentManager().popBackStack();
                ((AppCompatActivity)getActivity()).findViewById(R.id.bottomNavigationView).setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        ((AppCompatActivity)getActivity()).findViewById(R.id.bottomNavigationView).setVisibility(View.VISIBLE);
    }
}
