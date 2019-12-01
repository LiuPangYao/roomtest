package com.example.roomtest.Diaog;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.roomtest.R;
import com.example.roomtest.firestore.FeedBack;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class feedbackDialogFragment extends DialogFragment {

    static String TAG = "feedbackDialogFragment";
    static feedbackDialogFragment dialog;
    SendDialogListener listener;
    Button sendButton;
    EditText edtTelMail, edtTitle, edtDetail;
    FirebaseFirestore db;

    public interface SendDialogListener {
        void onDialogSendClick(DialogFragment dialog);
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (feedbackDialogFragment.SendDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString() + " must implement NoticeDialogListener");
        }
    }*/

    public static feedbackDialogFragment instance() {
        dialog = new feedbackDialogFragment();
        //dialog.setCancelable(false);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.feedback_form, container, false);

        sendButton = view.findViewById(R.id.buttonSend);
        edtTelMail = view.findViewById(R.id.editTextTelOrMail);
        edtDetail = view.findViewById(R.id.editTextDetail);
        edtTitle = view.findViewById(R.id.editTextMainQ);

        // init
        db = FirebaseFirestore.getInstance();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTelMail.getText().toString().equals("") || edtDetail.getText().toString().equals("") || edtTitle.getText().toString().equals("")) {
                    Snackbar.make(v, getContext().getString(R.string.INPUT_ERROR), Snackbar.LENGTH_LONG).show();
                    return;
                }
                FeedBack feedBack = new FeedBack(edtTelMail.getText().toString(),
                        edtTitle.getText().toString(),
                        edtDetail.getText().toString());
                insert(feedBack);
                //dialog.dismiss();
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
                        Toast.makeText(getContext(), R.string.FEED_BACK_SUCCESSFUL, Toast.LENGTH_LONG).show();
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
