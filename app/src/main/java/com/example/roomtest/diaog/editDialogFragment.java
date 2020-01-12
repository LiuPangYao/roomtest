package com.example.roomtest.diaog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.roomtest.ToyConstants;
import com.example.roomtest.R;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.fragment.ListFragment;

import java.util.Calendar;

/**
 * 2019-12-19
 */
public class editDialogFragment extends DialogFragment {

    static editDialogFragment dialog;
    static int actionMove = ToyConstants.ACTION_NULL;
    static toyInfo toys = null;
    static String TAG = "editDialogFragment";

    InsertDialogListener listener;
    Button mButtonOK, mButtonCancel;
    TextView mTextViewTitle;
    EditText mEdtDate; // extra onclick
    EditText mEdtName, mEdtBuyPrice, mEdtSellPrice, mEdtWeb, mEdtUri;
    Spinner sellstateSpinner, gainSpinner;

    static ListFragment mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (InsertDialogListener) mContext;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString() + " must implement NoticeDialogListener");
        }
    }

    public interface InsertDialogListener {
        void onDialogOKClick(DialogFragment dialog, toyInfo info, int style);
        void onDialogCancelClick(DialogFragment dialog);
    }

    public static editDialogFragment instance(String title, int action, ListFragment context) {

        mContext = context;
        dialog = new editDialogFragment();
        actionMove = action;

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        dialog.setArguments(bundle);

        return dialog;
    }

    public static editDialogFragment instance(String title, int action, toyInfo mToyInfo) {
        dialog = new editDialogFragment();

        actionMove = action;
        toys = mToyInfo;

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        dialog.setArguments(bundle);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_dialogfragment, container, false);

        mTextViewTitle = view.findViewById(R.id.dialogTitle);
        mButtonOK = view.findViewById(R.id.buttonOK);
        mButtonCancel = view.findViewById(R.id.buttonCancel);

        mEdtName = view.findViewById(R.id.editTextName);
        mEdtUri = view.findViewById(R.id.editTextToyUri);
        mEdtDate = view.findViewById(R.id.editTextToyDate);
        mEdtBuyPrice = view.findViewById(R.id.editTextBuyPrice);
        mEdtSellPrice = view.findViewById(R.id.editTextSellPrice);
        mEdtWeb = view.findViewById(R.id.editTextToyWeb);
        sellstateSpinner = view.findViewById(R.id.spinnerSellState);
        gainSpinner = view.findViewById(R.id.spinnerGain);

        ArrayAdapter<CharSequence> adapterSell = ArrayAdapter.createFromResource(getContext(), R.array.sell_state_array, android.R.layout.simple_spinner_item);
        adapterSell.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sellstateSpinner.setAdapter(adapterSell);

        ArrayAdapter<CharSequence> adapterGain = ArrayAdapter.createFromResource(getContext(), R.array.gain_state_array, android.R.layout.simple_spinner_item);
        adapterGain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gainSpinner.setAdapter(adapterGain);

        if (actionMove == ToyConstants.ACTION_UPDATE) {
            mEdtName.setText(toys.getName());
            mEdtUri.setText(toys.getImageUri());
            mEdtDate.setText(toys.getDate());
            mEdtBuyPrice.setText(String.valueOf(toys.getBuyPrice()));
            mEdtSellPrice.setText(String.valueOf(toys.getSellPrice()));
            mEdtWeb.setText(toys.getWeb());

            sellstateSpinner.setSelection(toys.getSoldState());
            gainSpinner.setSelection(toys.getGain());

        } else { // Insert
            // Fake Data
            /*mEdtName.setText("EAA-051 返校日");
            mEdtUri.setText("https://imgur.com/IVxECP6");
            mEdtDate.setText("2018-11-09");
            mEdtBuyPrice.setText("2390");
            mEdtSellPrice.setText("2390");
            mEdtWeb.setText("https://www.toy-people.com/?p=38665");*/

            // spinner use default sold out, increase
        }

        String title = getArguments().getString("title");
        mTextViewTitle.setText(title);

        mEdtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String dateTime = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
                        mEdtDate.setText(dateTime);
                    }

                }, year, month, day).show();
            }
        });

        mButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {

                    if (actionMove == ToyConstants.ACTION_INSERT) {
                        // TODO: 2019-11-17 沒有輸入資料 
                        toys = new toyInfo();
                        toys.setName(mEdtName.getText().toString());
                        toys.setImageUri(mEdtUri.getText().toString());
                        toys.setDate(mEdtDate.getText().toString());
                        toys.setBuyPrice(Integer.valueOf(mEdtBuyPrice.getText().toString()));
                        toys.setSellPrice(Integer.valueOf(mEdtSellPrice.getText().toString()));
                        toys.setWeb(mEdtWeb.getText().toString());
                        toys.setGain(Integer.valueOf(sellstateSpinner.getSelectedItemPosition()));
                        toys.setSoldState(Integer.valueOf(gainSpinner.getSelectedItemPosition()));
                    } else if (actionMove == ToyConstants.ACTION_UPDATE) {
                        // to do nothing
                        toys.setName(mEdtName.getText().toString());
                        toys.setDate(mEdtDate.getText().toString());
                        toys.setBuyPrice(Integer.valueOf(mEdtBuyPrice.getText().toString()));
                        toys.setSellPrice(Integer.valueOf(mEdtSellPrice.getText().toString()));
                        toys.setWeb(mEdtWeb.getText().toString());
                        toys.setGain(Integer.valueOf(sellstateSpinner.getSelectedItemPosition()));
                        toys.setSoldState(Integer.valueOf(gainSpinner.getSelectedItemPosition()));
                        //toys.setImageUri("https://imgur.com/mLMdIbz"); // write fake data
                        toys.setImageUri(mEdtUri.getText().toString());
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
