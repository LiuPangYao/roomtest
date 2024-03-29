package com.example.roomtest.fragment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roomtest.R;
import com.example.roomtest.databinding.FragmentAboutBinding;
import com.example.roomtest.recyclerview.SimpleAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-10-10 view binding
 * 2021-10-10 last update
 */
public class AboutFragment extends Fragment {

    public static final String TAG = "AboutFragment";

    private FragmentAboutBinding binding;

    List<String> simpleList = null;
    private SimpleAdapter mSimpleAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
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
    public void onPause() {
        super.onPause();
        if (binding.adView != null) {
            binding.adView.pause();
        }
    }

    public void init(View view) {
        initSimpleAdapter();
        initAbout();
        initAdMod(view); // ad mod
    }

    public void initAbout() {
        // default 1.0
        String version = "1.0";
        try {
            PackageInfo packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        binding.textViewVersion.setText(getString(R.string.VERSION, version));
    }

    /**
     * 2019-12-18
     * set Data in mRecyclerViewSimple use SimpleAdapter
     */
    public void initSimpleAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.aboutRecyclerview.setLayoutManager(linearLayoutManager);

        simpleList = new ArrayList<>();
        simpleList.add(getString(R.string.PERMISSION));
        simpleList.add(getString(R.string.UPDATE_MESSAGE));
        simpleList.add(getString(R.string.QUESTION_RETURN));
        simpleList.add(getString(R.string.COMPONENT_USE));
        simpleList.add(getString(R.string.AD));
        simpleList.add(getString(R.string.THEME));

        // init SimpleAdapter
        mSimpleAdapter = new SimpleAdapter(simpleList, getActivity());
        binding.aboutRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        binding.aboutRecyclerview.setAdapter(mSimpleAdapter);
        mSimpleAdapter.notifyDataSetChanged();
    }

    public void initAdMod(View view) {
        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.d(TAG, "onInitializationComplete: done");
            }
        });

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AdRequest adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build();
                binding.adView.loadAd(adRequest);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // 2021-10-10 view binding
        binding = FragmentAboutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        init(view);
        return view;
    }

    /**
     * comment out
     * @param context
     */
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
    public void onResume() {
        super.onResume();
        if (binding.adView != null) {
            binding.adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (binding.adView != null) {
            binding.adView.destroy();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
}