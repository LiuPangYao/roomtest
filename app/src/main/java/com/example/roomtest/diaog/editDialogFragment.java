package com.example.roomtest.diaog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.roomtest.ToyConstants;
import com.example.roomtest.R;
import com.example.roomtest.database.toyInfo;
import com.example.roomtest.databinding.EditDialogfragmentBinding;
import com.example.roomtest.fragment.ListFragment;

import java.util.Calendar;

/**
 * 2021-10-10 view binding
 */
public class editDialogFragment extends DialogFragment {

    static editDialogFragment dialog;
    static int actionMove = ToyConstants.ACTION_NULL;
    static toyInfo toys = null;
    static String TAG = "editDialogFragment";
    static ListFragment mContext;

    static InsertDialogListener listener;
    private EditDialogfragmentBinding binding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            // listener = (InsertDialogListener) mContext;
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
        listener = (InsertDialogListener) mContext;
        dialog = new editDialogFragment();
        actionMove = action;

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        dialog.setArguments(bundle);

        return dialog;
    }

    public static editDialogFragment instance(String title, int action, toyInfo mToyInfo, ListFragment context) {
        dialog = new editDialogFragment();

        mContext = context;
        listener = (InsertDialogListener) mContext;

        actionMove = action;
        toys = mToyInfo;

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        dialog.setArguments(bundle);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = EditDialogfragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ArrayAdapter<CharSequence> adapterSell = ArrayAdapter.createFromResource(getContext(), R.array.sell_state_array, android.R.layout.simple_spinner_item);
        adapterSell.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerSellState.setAdapter(adapterSell);

        ArrayAdapter<CharSequence> adapterGain = ArrayAdapter.createFromResource(getContext(), R.array.gain_state_array, android.R.layout.simple_spinner_item);
        adapterGain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerGain.setAdapter(adapterGain);

        if (actionMove == ToyConstants.ACTION_UPDATE) {
            binding.editTextName.setText(toys.getName());
            binding.editTextToyUri.setText(toys.getImageUri());
            binding.editTextToyDate.setText(toys.getDate());
            binding.editTextBuyPrice.setText(String.valueOf(toys.getBuyPrice()));
            binding.editTextSellPrice.setText(String.valueOf(toys.getSellPrice()));
            binding.editTextToyWeb.setText(toys.getWeb());

            binding.spinnerSellState.setSelection(toys.getSoldState());
            binding.spinnerGain.setSelection(toys.getGain());

        } else { // Insert
            // Fake Data
            /*binding.editTextName.setText("EAA-051 返校日");
            binding.editTextToyUri.setText("https://imgur.com/IVxECP6");
            binding.editTextToyDate.setText("2018-11-09");
            binding.editTextBuyPrice.setText("2390");
            binding.editTextSellPrice.setText("2390");
            binding.editTextToyWeb.setText("https://www.toy-people.com/?p=38665");*/

            // spinner use default sold out, increase
        }

        String title = getArguments().getString("title");
        binding.dialogTitle.setText(title);

        binding.editTextToyDate.setOnClickListener(new View.OnClickListener() {
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
                        binding.editTextToyDate.setText(dateTime);
                    }

                }, year, month, day).show();
            }
        });

        binding.buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {

                    if (actionMove == ToyConstants.ACTION_INSERT) {
                        // TODO: 2019-11-17 沒有輸入資料 
                        toys = new toyInfo();
                        toys.setName(binding.editTextName.getText().toString());
                        toys.setImageUri(binding.editTextToyUri.getText().toString());
                        toys.setDate(binding.editTextToyDate.getText().toString());
                        toys.setBuyPrice(Integer.valueOf(binding.editTextBuyPrice.getText().toString()));
                        toys.setSellPrice(Integer.valueOf(binding.editTextSellPrice.getText().toString()));
                        toys.setWeb(binding.editTextToyWeb.getText().toString());
                        toys.setGain(Integer.valueOf(binding.spinnerSellState.getSelectedItemPosition()));
                        toys.setSoldState(Integer.valueOf(binding.spinnerGain.getSelectedItemPosition()));
                    } else if (actionMove == ToyConstants.ACTION_UPDATE) {
                        // to do nothing
                        toys.setName(binding.editTextName.getText().toString());
                        toys.setDate(binding.editTextToyDate.getText().toString());
                        toys.setBuyPrice(Integer.valueOf(binding.editTextBuyPrice.getText().toString()));
                        toys.setSellPrice(Integer.valueOf(binding.editTextSellPrice.getText().toString()));
                        toys.setWeb(binding.editTextToyWeb.getText().toString());
                        toys.setGain(Integer.valueOf(binding.spinnerSellState.getSelectedItemPosition()));
                        toys.setSoldState(Integer.valueOf(binding.spinnerGain.getSelectedItemPosition()));
                        //toys.setImageUri("https://imgur.com/mLMdIbz"); // write fake data
                        toys.setImageUri(binding.editTextToyUri.getText().toString());
                    }

                    listener.onDialogOKClick(editDialogFragment.this, toys, actionMove);
                }
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
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
