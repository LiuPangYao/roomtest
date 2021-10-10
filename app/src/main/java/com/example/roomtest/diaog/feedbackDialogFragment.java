package com.example.roomtest.diaog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.roomtest.R;
import com.example.roomtest.databinding.FeedbackDialogfragmentBinding;
import com.example.roomtest.firestore.FeedBack;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * 2021-10-10 view binding
 */
public class feedbackDialogFragment extends DialogFragment {

    static String TAG = "feedbackDialogFragment";
    static feedbackDialogFragment dialog;
    SendDialogListener listener;
    FirebaseFirestore db;
    static Context mContext;

    private FeedbackDialogfragmentBinding binding;

    public interface SendDialogListener {
        void onDialogSendClick(DialogFragment dialog);
    }

    public static feedbackDialogFragment instance(Context context) {
        mContext = context;
        dialog = new feedbackDialogFragment();
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FeedbackDialogfragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // init
        db = FirebaseFirestore.getInstance();

        binding.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editTextTelOrMail.getText().toString().equals("") || binding.editTextDetail.getText().toString().equals("") || binding.editTextMainQ.getText().toString().equals("")) {
                    Snackbar.make(v, getContext().getString(R.string.INPUT_ERROR), Snackbar.LENGTH_LONG).show();
                    return;
                }
                FeedBack feedBack = new FeedBack(binding.editTextTelOrMail.getText().toString(),
                        binding.editTextMainQ.getText().toString(),
                        binding.editTextDetail.getText().toString());
                insert(feedBack);
                dialog.dismiss();
            }
        });

        return view;
    }

    public void insert(FeedBack feedback) {

        // Add a new document with a generated ID
        db.collection("feedback")
                .add(feedback)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(mContext, R.string.FEED_BACK_SUCCESSFUL, Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }

}
