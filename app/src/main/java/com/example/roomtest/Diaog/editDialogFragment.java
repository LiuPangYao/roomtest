package com.example.roomtest.Diaog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.roomtest.Constants;
import com.example.roomtest.R;
import com.example.roomtest.database.toyInfo;

public class editDialogFragment extends DialogFragment {

    static editDialogFragment dialog;
    InsertDialogListener listener;
    Button mButtonOK, mButtonCancel;
    TextView mTextViewTitle;
    EditText mEdtName, mEdtBuyPrice, mEdtSellPrice, mEdtDate, mEdtWeb, mEdtUri, mEdtGain, mEdtSellState;
    static int actionMove = Constants.ACTION_NULL;
    static toyInfo toys = null;
    static String TAG = "editDialogFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (InsertDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString() + " must implement NoticeDialogListener");
        }
    }

    public interface InsertDialogListener {
        void onDialogOKClick(DialogFragment dialog, toyInfo info ,int style);
        void onDialogCancelClick(DialogFragment dialog);
    }

    public static editDialogFragment instance(String title, int action) {

        //if (dialog == null) {
        //    synchronized (editDialogFragment.class) {
        //        if (dialog == null) {
                    dialog = new editDialogFragment();
        //        }
        //    }
        //}

        actionMove = action;

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        dialog.setArguments(bundle);

        return dialog;
    }

    public static editDialogFragment instance(String title, int action, toyInfo mToyInfo) {

        //if (dialog == null) {
        //    synchronized (editDialogFragment.class) {
        //        if (dialog == null) {
                    dialog = new editDialogFragment();
        //        }
        //    }
        //}

        //Log.d(TAG, "instance: execute");
        actionMove = action;

        toys = mToyInfo;

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        dialog.setArguments(bundle);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.insert_dialog, container, false);

        mTextViewTitle = view.findViewById(R.id.dialodTitle);
        mButtonOK = view.findViewById(R.id.buttonOK);
        mButtonCancel = view.findViewById(R.id.buttonCancel);

        mEdtName = view.findViewById(R.id.editTextName);
        mEdtUri = view.findViewById(R.id.editTextToyUri);
        mEdtDate = view.findViewById(R.id.editTextToyDate);
        mEdtBuyPrice = view.findViewById(R.id.editTextBuyPrice);
        mEdtSellPrice = view.findViewById(R.id.editTextSellPrice);
        mEdtWeb = view.findViewById(R.id.editTextToyWeb);
        mEdtGain = view.findViewById(R.id.editTextToyGain);
        mEdtSellState = view.findViewById(R.id.editTextToySellState);

        mEdtName.setText("");
        mEdtUri.setText("");
        mEdtDate.setText("");
        mEdtBuyPrice.setText("");
        mEdtSellPrice.setText("");
        mEdtWeb.setText("");
        mEdtGain.setText("");
        mEdtSellState.setText("");

        if(actionMove == Constants.ACTION_UPDATE) {
            mEdtName.setText(toys.getName());
            mEdtUri.setText(toys.getImageUri());
            mEdtDate.setText(toys.getDate());
            mEdtBuyPrice.setText(String.valueOf(toys.getBuyPrice()));
            mEdtSellPrice.setText(String.valueOf(toys.getSellPrice()));
            mEdtWeb.setText(toys.getWeb());
            mEdtGain.setText(String.valueOf(toys.getGain()));
            mEdtSellState.setText(String.valueOf(toys.getSoldState()));
        } else {
            // Fake Data
            mEdtName.setText("EAA-051 返校日");
            mEdtUri.setText("https://imgur.com/IVxECP6");
            mEdtDate.setText("2018-11-09");
            mEdtBuyPrice.setText("2390");
            mEdtSellPrice.setText("2390");
            mEdtWeb.setText("https://www.toy-people.com/?p=38665");
            mEdtGain.setText(String.valueOf(Constants.SOLD_OUT));
            mEdtSellState.setText(String.valueOf(Constants.SELL));
        }

        String title = getArguments().getString("title");
        mTextViewTitle.setText(title);

        mButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {

                    if(actionMove == Constants.ACTION_INSERT) {
                        toys = new toyInfo();
                        toys.setName(mEdtName.getText().toString());
                        toys.setImageUri(mEdtUri.getText().toString());
                        toys.setDate(mEdtDate.getText().toString());
                        toys.setBuyPrice(Integer.valueOf(mEdtBuyPrice.getText().toString()));
                        toys.setSellPrice(Integer.valueOf(mEdtSellPrice.getText().toString()));
                        toys.setWeb(mEdtWeb.getText().toString());
                        toys.setGain(Integer.valueOf(mEdtGain.getText().toString()));
                        toys.setSoldState(Integer.valueOf(mEdtSellState.getText().toString()));
                    } else if(actionMove == Constants.ACTION_UPDATE) {
                        //to fo nothing
                        toys.setImageUri("https://imgur.com/mLMdIbz");
                    }

                    listener.onDialogOKClick(editDialogFragment.this, toys, actionMove);
                }
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onDialogCancelClick(editDialogFragment.this);
                }
            }
        });

        return view;
    }
}
