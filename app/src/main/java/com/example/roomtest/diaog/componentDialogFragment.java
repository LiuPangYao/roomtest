package com.example.roomtest.diaog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.roomtest.R;
import com.example.roomtest.databinding.ComponentDialogfragmentBinding;
import com.example.roomtest.recyclerview.TextAdapter;

import java.util.ArrayList;

import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * 2021-10-10 view binding
 */
public class componentDialogFragment extends DialogFragment {

    ArrayList<String> recyclerListTool;
    ArrayList<String> recyclerListKnowledge;

    private ComponentDialogfragmentBinding binding;
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

        binding = ComponentDialogfragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerTool.setLayoutManager(linearLayoutManager);

        // init recyclerList Tool
        recyclerListTool = new ArrayList<>();
        recyclerListTool.add("RecyclerView");
        recyclerListTool.add("CardView");
        recyclerListTool.add("Segment Control");
        recyclerListTool.add("TextView");
        recyclerListTool.add("Button");
        recyclerListTool.add("EditText");
        recyclerListTool.add("ViewPager2");
        recyclerListTool.add("BottomNavigationView");

        // init technology
        recyclerListKnowledge = new ArrayList<>();
        recyclerListKnowledge.add("FireStore");
        recyclerListKnowledge.add("Shared Preference");
        recyclerListKnowledge.add("Room");
        recyclerListKnowledge.add("Picasso");
        recyclerListKnowledge.add("Imgur");
        recyclerListKnowledge.add("Share");
        recyclerListKnowledge.add("ScreenShot");
        recyclerListKnowledge.add("Navigation");

        // default, show recyclerListTool data
        TextAdapter textAdapter = new TextAdapter(recyclerListTool, mContext);
        binding.recyclerTool.setAdapter(textAdapter);
        textAdapter.notifyDataSetChanged();

        SegmentedGroup segmentedOne = view.findViewById(R.id.segmentedComponent);
        //segmentedOne.setTintColor(Color.DKGRAY);

        RadioButton radioButtonOne = view.findViewById(R.id.buttonOne);
        radioButtonOne.setChecked(true);
        radioButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show recyclerListTool data
                TextAdapter textAdapter = new TextAdapter(recyclerListTool, mContext);
                binding.recyclerTool.setAdapter(textAdapter);
                textAdapter.notifyDataSetChanged();
            }
        });

        RadioButton radioButtonTwo = view.findViewById(R.id.buttonTwo);
        radioButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show recyclerListKnowledge data
                TextAdapter textAdapter = new TextAdapter(recyclerListKnowledge, mContext);
                binding.recyclerTool.setAdapter(textAdapter);
                textAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}