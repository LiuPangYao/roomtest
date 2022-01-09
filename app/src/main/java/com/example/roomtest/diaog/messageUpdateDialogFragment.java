package com.example.roomtest.diaog;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomtest.R;
import com.example.roomtest.database.listSort;
import com.example.roomtest.firestore.UpdateMessage;
import com.example.roomtest.recyclerview.MessageUpdateAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * 2022-01-09
 */
public class messageUpdateDialogFragment extends DialogFragment {

    static FirebaseFirestore db;
    String TAG = "messageUpdateDialogFragment";
    ArrayList<UpdateMessage> recyclerList = new ArrayList<UpdateMessage>();

    RecyclerView mRecyclerView;

    public messageUpdateDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static messageUpdateDialogFragment newInstance() {
        messageUpdateDialogFragment frag = new messageUpdateDialogFragment();
        // Access a Cloud Firestore instance from your Activity
        db = FirebaseFirestore.getInstance();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_update_dialogfragment, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerMessageUpdate);

        readData();

        return view;
    }

    public void readData() {

        db.collection("versionControl")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                UpdateMessage updateMessage = new UpdateMessage(
                                        document.getData().get("Date").toString(),
                                        document.getData().get("Version").toString(),
                                        (ArrayList<String>) document.get("Details"));

                                recyclerList.add(updateMessage);
                            }

                            Log.d(TAG, "onComplete: " + recyclerList.size());

                            MessageUpdateAdapter adapter = null;

                            // init
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            mRecyclerView.setLayoutManager(linearLayoutManager);

                            // show data
                            adapter = new MessageUpdateAdapter(listSort.sortList(recyclerList), getContext());
                            mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                            mRecyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

    }
}
