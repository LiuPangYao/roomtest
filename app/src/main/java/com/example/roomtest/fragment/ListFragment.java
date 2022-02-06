package com.example.roomtest.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.roomtest.R;
import com.example.roomtest.ToyConstants;
import com.example.roomtest.asyncTask.InsertAsyncTask;
import com.example.roomtest.asyncTask.InsertFakeDataAsyncTask;
import com.example.roomtest.asyncTask.updateAsyncTask;
import com.example.roomtest.database.dataBase;
import com.example.roomtest.database.listSort;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.databinding.FragmentListBinding;
import com.example.roomtest.databinding.RecyclerItemBinding;
import com.example.roomtest.diaog.editDialogFragment;
import com.example.roomtest.recyclerview.ListAdapter;
import com.example.roomtest.recyclerview.ListAdapterTouchHelperCallback;
import com.example.roomtest.recyclerview.RecyclerViewNoBugLinearLayoutManager;
import com.example.roomtest.recyclerview.onLoadMoreListener;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * date:2021-10-10 view binding
 */
public class ListFragment extends Fragment implements
        View.OnClickListener,
        editDialogFragment.InsertDialogListener,
        InsertAsyncTask.CompleteCallBack,
        InsertFakeDataAsyncTask.CompleteFakeCallBack,
        updateAsyncTask.UpdateCallBack,
        ListAdapter.OnDeleteListener, ListAdapter.CallBackListener {

    public static final String TAG = "ListFragment";

    dataBase dataInstance = null;

    private FragmentListBinding binding;
    private RecyclerItemBinding includeBinding;
    
    SharedPreferences shared = null;

    boolean isDataReady = false; // Warning
    boolean isDeveloper = false;
    private boolean isRefresh = false;

    private ListAdapter mListAdapter;

    List<toyInfo> toyList = null;
    List<toyInfo> toyListRestore = null;

    private boolean isStaggeredAdapter = false;
    private boolean isDateOrder = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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

        binding = FragmentListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        includeBinding = RecyclerItemBinding.bind(view);

        initView(view);
        initSwipeRefresh();
        return view;
    }

    public void initView(View view) {
        // avoid data repeat store
        shared = getActivity().getSharedPreferences("app_setting", MODE_PRIVATE);
        isDataReady = shared.getBoolean("isReady", false);
        isDeveloper = shared.getBoolean("isDeveloper", true);

        binding.floatingActionButton.setOnClickListener(this);

        // key word search
        includeBinding.radioButtonPrice.setChecked(true);
        initSearchKeyWord();

        // init
        dataInstance = dataBase.getInstance(getActivity());

        InsertFakeDataAsyncTask asyncTask =
                new InsertFakeDataAsyncTask(getActivity(), this, isDataReady, isDeveloper);
        asyncTask.execute("load data");

        checkDataSizeDisplay();

        if (!isDataReady) {
            binding.textViewEmpty.setVisibility(View.VISIBLE);
        }
    }

    public void insertFakeData() {
        // load Data ,do not run in main thread
        isDeveloper = true;
        InsertFakeDataAsyncTask asyncTask =
                new InsertFakeDataAsyncTask(getActivity(), this, isDataReady, isDeveloper);
        asyncTask.execute("load data");
    }

    /**
     * 2020-01-07
     */
    public void initSearchKeyWord() {

        includeBinding.radioButtonName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // will called twice
                mListAdapter.setSearchType(ToyConstants.PRICE_TYPE);
                if (isChecked) {
                    includeBinding.radioButtonPrice.setChecked(false);
                } else {
                    includeBinding.radioButtonPrice.setChecked(true);
                }
            }
        });

        includeBinding.radioButtonPrice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // will called twice
                mListAdapter.setSearchType(ToyConstants.NAME_TYPE);
                if (isChecked) {
                    includeBinding.radioButtonName.setChecked(false);
                } else {
                    includeBinding.radioButtonName.setChecked(true);
                }
            }
        });

        includeBinding.editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: " + s);
                if (mListAdapter != null) {
                    mListAdapter.getFilter().filter(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * 2020-01-06
     */
    public void initSwipeRefresh() {

        binding.recyclerView.addOnScrollListener(new onLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        includeBinding.includeRecyclerItem.setVisibility(View.GONE);
                    }
                }, 20);
            }
        });

        binding.swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                if (!isRefresh) {
                    isRefresh = true;

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if(toyList.size() != 0) {
                                includeBinding.includeRecyclerItem.setVisibility(View.VISIBLE);
                            }
                            binding.swipeToRefresh.setRefreshing(false);
                            isRefresh = false;
                        }
                    }, 100);
                }
            }
        });
    }

    /**
     * visible no data message
     */
    public void checkDataSizeDisplay() {
        Log.d(TAG, "checkDataSizeDisplay: someone to call this, " + isDataReady);
        if (isDataReady) {
            binding.textViewEmpty.setVisibility(View.GONE);
        } else {
            binding.textViewEmpty.setVisibility(View.VISIBLE);
        }
    }

    public void initAdapter(List<toyInfo> toy_List) {
        // init
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(new RecyclerViewNoBugLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        // show data
        mListAdapter = new ListAdapter(toy_List, getActivity(), this);
        mListAdapter.setSearchType(ToyConstants.PRICE_TYPE);
        mListAdapter.setItemStyle(ToyConstants.LINEARITEM);

        //notify data change
        mListAdapter.notifyDataSetChanged();

        // move and delete
        ItemTouchHelper.Callback callback = new ListAdapterTouchHelperCallback(mListAdapter/*, mListAdapter*/, toy_List);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(binding.recyclerView);

        binding.recyclerView.setAdapter(mListAdapter);
        mListAdapter.setOnDeleteListener(this);
        mListAdapter.setCallBackListener(this);
        mListAdapter.notifySetListDataChanged(toy_List);

        mListAdapter.notifyDataSetChanged();
    }

    public void initAdapterStaggered(List<toyInfo> toy_List) {
        // init
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);
        // show data
        mListAdapter = new ListAdapter(toy_List, getActivity(), this);
        mListAdapter.setSearchType(ToyConstants.PRICE_TYPE);
        mListAdapter.setItemStyle(ToyConstants.STAGGERITEM);
        mListAdapter.setOnDeleteListener(this);
        binding.recyclerView.setAdapter(mListAdapter);
        mListAdapter.notifySetListDataChanged(toy_List);
        mListAdapter.notifyDataSetChanged();
    }

    public boolean getIsStaggered() {
        return isStaggeredAdapter;
    }

    public void menuListUpdate() {
        if (!isDataReady) {
            return;
        } else {
            if (!isStaggeredAdapter) {
                initAdapterStaggered(toyList);
                //ConstraintLayout.LayoutParams mParams = new ConstraintLayout.LayoutParams(30, 30);
                //mImageButton.setLayoutParams(mParams);
                isStaggeredAdapter = true;
            } else {
                initAdapter(toyList);
                isStaggeredAdapter = false;
            }
        }
    }

    public int getDateListStyle() {
        return mListAdapter.getDateOrder();
    }

    public void dateListUpdate() {
        if (!isDataReady) {
            return;
        } else {
            if (!isDateOrder) {
                mListAdapter.setDateOrder(ToyConstants.DATE_NEW_OLD);
                isDateOrder = true;
            } else {
                mListAdapter.setDateOrder(ToyConstants.DATE_OLD_NEW);
                isDateOrder = false;
            }

            mListAdapter.notifyDataSetChanged();
        }
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
            case R.id.floatingActionButton:
                showInsertOrUpdateDialog(ToyConstants.ACTION_INSERT);
            break;
        }
    }

    /**
     * action move
     * ACTION_INSERT, ACTION_UPDATE
     */
    public void showInsertOrUpdateDialog(int dialogStyle) {

        editDialogFragment dialog = null;

        if (dialogStyle == ToyConstants.ACTION_INSERT) {
            dialog = editDialogFragment.instance(getString(R.string.INSERT_INFO), ToyConstants.ACTION_INSERT, this);
            dialog.show(getActivity().getSupportFragmentManager(), "InsertDialog");
        } else if (dialogStyle == ToyConstants.ACTION_UPDATE) {
            dialog = editDialogFragment.instance(getString(R.string.UPDATE_INFO), ToyConstants.ACTION_UPDATE, this);
            dialog.show(getActivity().getSupportFragmentManager(), "updateDialog");
        }
    }

    @Override
    public void goToWebFragment() {

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

    // callback start
    @Override
    public void onDialogOKClick(DialogFragment dialog, toyInfo info, int style) {
        if (style == ToyConstants.ACTION_INSERT) {
            InsertAsyncTask insertAsyncTask = new InsertAsyncTask(getActivity(), this);
            insertAsyncTask.execute(info);
        } else {
            // update
            // Toast.makeText(this, getString(R.string.PREPARE_WAIT), Toast.LENGTH_LONG).show();
            // create async task fot update
            updateAsyncTask task = new updateAsyncTask(getActivity(), this);
            task.execute(info);
        }

        dialog.dismiss();
    }

    @Override
    public void onDialogCancelClick(DialogFragment dialog) {
        dialog.dismiss();
    }

    @Override
    public void onTaskComplete(List<toyInfo> list) {

        toyList = list;

        // sequence list
        if (!isDateOrder) {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_OLD_NEW, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
        } else {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_NEW_OLD, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
        }

        isDataReady = true;
        shared.edit().putBoolean("isReady", true).commit();

        checkDataSizeDisplay();

        if (isStaggeredAdapter) {
            initAdapterStaggered(toyList);
        } else {
            initAdapter(toyList);
        }
    }

    /**
     * Insert Fake Data
     *
     * @param list
     * @param dataReady
     * @param developer
     */
    @Override
    public void onTaskComplete(List<toyInfo> list, boolean dataReady, boolean developer) {
        isDataReady = dataReady;
        isDeveloper = developer;

        //shared.edit().putBoolean("isReady", isDataReady).commit();
        //shared.edit().putBoolean("isDeveloper", isDeveloper).commit();

        toyList = list;

        // sequence list
        if (!isDateOrder) {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_OLD_NEW, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
        } else {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_NEW_OLD, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
        }

        checkDataSizeDisplay();

        if (isDataReady) {
            if (isStaggeredAdapter) {
                initAdapterStaggered(toyList);
            } else {
                initAdapter(toyList);
            }
        }
    }

    @Override
    public void onUpdateTaskComplete(List<toyInfo> list) {
        toyList = list;

        // sequence list
        if (!isDateOrder) {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_OLD_NEW, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
            //isDateOrder = true;
        } else {
            toyListRestore = listSort.sortlist(ToyConstants.DATE_NEW_OLD, list);
            toyList.clear();
            toyList.addAll(toyListRestore);
            //isDateOrder = false;
        }

        if (isStaggeredAdapter) {
            initAdapterStaggered(toyList);
        } else {
            initAdapter(toyList);
        }
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
            }
        }).start();
    }

    /**
     * list size = 0
     */
    @Override
    public void deleteStateNone() {
        // can not be Winnie the Pooh
        isDataReady = false;
        isDeveloper = false;
        shared.edit().putBoolean("isReady", false).commit();
        shared.edit().putBoolean("isDeveloper", false).commit();

        //checkDataSizeDisplay();

        //findViewById(R.id.textViewEmpty).setVisibility(View.VISIBLE);

        /*this.runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        // some problem
                        findViewById(R.id.textViewEmpty).setVisibility(View.VISIBLE);
                    }
                }
        );*/
    }
    // callback end
}
