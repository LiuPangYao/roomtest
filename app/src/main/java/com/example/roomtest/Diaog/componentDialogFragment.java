package com.example.roomtest.Diaog;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.R;
import com.example.roomtest.recyclerview.TextAdapter;

import java.util.ArrayList;

import info.hoang8f.android.segmented.SegmentedGroup;

public class componentDialogFragment extends DialogFragment {

    ArrayList<String> recyclerListTool;
    ArrayList<String> recyclerListKnowledge;

    RecyclerView mRecyclerView;
    static Context mContext;

    public componentDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static componentDialogFragment newInstance(Context context) {
        componentDialogFragment frag = new componentDialogFragment();
        mContext = context;
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.component, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerTool);

        // init
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        recyclerListTool = new ArrayList<>();
        recyclerListTool.add("RecyclerView");
        recyclerListTool.add("CardView");
        recyclerListTool.add("Segment Control");
        recyclerListTool.add("TextView");
        recyclerListTool.add("Button");
        recyclerListTool.add("EditText");

        recyclerListKnowledge = new ArrayList<>();
        recyclerListKnowledge.add("FireStore");
        recyclerListKnowledge.add("Shared Preference");
        recyclerListKnowledge.add("Room");

        // default, show data
        TextAdapter textAdapter = new TextAdapter(recyclerListTool, mContext);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(textAdapter);
        textAdapter.notifyDataSetChanged();

        SegmentedGroup segmentedOne = view.findViewById(R.id.segmentedComponent);
        segmentedOne.setTintColor(Color.DKGRAY);

        RadioButton radioButtonOne = view.findViewById(R.id.buttonOne);
        radioButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show data
                TextAdapter textAdapter = new TextAdapter(recyclerListTool, mContext);
                //mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
                mRecyclerView.setAdapter(textAdapter);
                textAdapter.notifyDataSetChanged();
            }
        });

        RadioButton radioButtonTwo = view.findViewById(R.id.buttonTwo);
        radioButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show data
                TextAdapter textAdapter = new TextAdapter(recyclerListKnowledge, mContext);
                //mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
                mRecyclerView.setAdapter(textAdapter);
                textAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}