package com.example.roomtest.Diaog;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.R;
import com.example.roomtest.recyclerview.TextAdapter;

import java.util.ArrayList;

import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * 2019-12-18
 */
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

        View view = inflater.inflate(R.layout.component_dialogfragment, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerTool);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        // init recyclerListTool
        recyclerListTool = new ArrayList<>();
        recyclerListTool.add("RecyclerView");
        recyclerListTool.add("CardView");
        recyclerListTool.add("Segment Control");
        recyclerListTool.add("TextView");
        recyclerListTool.add("Button");
        recyclerListTool.add("EditText");

        // init technology
        recyclerListKnowledge = new ArrayList<>();
        recyclerListKnowledge.add("FireStore");
        recyclerListKnowledge.add("Shared Preference");
        recyclerListKnowledge.add("Room");
        recyclerListKnowledge.add("Picasso");
        recyclerListKnowledge.add("Imgur");

        // default, show recyclerListTool data
        TextAdapter textAdapter = new TextAdapter(recyclerListTool, mContext);
        mRecyclerView.setAdapter(textAdapter);
        textAdapter.notifyDataSetChanged();

        SegmentedGroup segmentedOne = view.findViewById(R.id.segmentedComponent);
        segmentedOne.setTintColor(Color.DKGRAY);

        RadioButton radioButtonOne = view.findViewById(R.id.buttonOne);
        radioButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show recyclerListTool data
                TextAdapter textAdapter = new TextAdapter(recyclerListTool, mContext);
                mRecyclerView.setAdapter(textAdapter);
                textAdapter.notifyDataSetChanged();
            }
        });

        RadioButton radioButtonTwo = view.findViewById(R.id.buttonTwo);
        radioButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show recyclerListKnowledge data
                TextAdapter textAdapter = new TextAdapter(recyclerListKnowledge, mContext);
                mRecyclerView.setAdapter(textAdapter);
                textAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}