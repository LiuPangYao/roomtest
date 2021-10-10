package com.example.roomtest.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roomtest.R;
import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.databinding.FragmentDetailBinding;

import java.util.List;

/**
 * 2021-10-10 view binding
 */
public class DetailFragment extends Fragment {

    public static final String TAG = "DetailFragment";

    private FragmentDetailBinding binding;

    List<toyInfo> toyList = null;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        initView(view);
        return view;
    }

    public void initView(View view) {
        loadList();
    }

    /**
     * print data base data, ready for use
     */
    public void loadList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                toyList = dataBase.getInstance(getActivity()).getToyDao().getAll();
                if (toyList.size() > 0) {
                    for (int i = 0; i < toyList.size(); i++) {
                        Log.d(TAG, "printData: name = " + toyList.get(i).getName() + ", buyPrice = " + toyList.get(i).getBuyPrice() + ", web = " + toyList.get(i).getWeb());
                    }
                }
                initEdit();
            }
        }).start();
    }

    public void initEdit() {
        if (toyList != null && toyList.size() != 0) {
            binding.textViewCount.setText(String.valueOf(toyList.size()));

            int sumPrice = 0;
            for (int i = 0; i < toyList.size(); i++) {
                sumPrice = sumPrice + toyList.get(i).getBuyPrice();
                binding.textViewPrice.setText("NT " + sumPrice);
            }

            int soldPrice = 0;
            for (int i = 0; i < toyList.size(); i++) {
                soldPrice = soldPrice + toyList.get(i).getSellPrice();
                binding.textViewSold.setText("NT " + soldPrice);
            }

            if (soldPrice == sumPrice) {
                binding.State.setText(getString(R.string.PRICE_COMMON));
            } else if (soldPrice > sumPrice) {
                binding.State.setText(getString(R.string.NET_E) + " " + String.valueOf(soldPrice - sumPrice));
                binding.State.setTextColor(getActivity().getColor(R.color.colorIncrease));
            } else {
                binding.State.setText(getString(R.string.NET_L) + " " + String.valueOf(sumPrice - soldPrice));
                binding.State.setTextColor(getActivity().getColor(R.color.colorFalling));
            }

        }
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
