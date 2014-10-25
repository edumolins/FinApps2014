package com.wearable.app.wearapp.utils;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wearable.app.wearapp.R;

/**
 * Created by Edu on 25/10/2014.
 */
public class CustomCardFragment extends Fragment {

    private TextView textView;

    public static CustomCardFragment create(String type, String num, String available, String total) {
        CustomCardFragment fragment = new CustomCardFragment();
        Bundle args = new Bundle();
        args.putString("typeCard", type);
        args.putString("numCard", num);
        args.putString("availableCard", available);
        args.putString("totalCard", total);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_card_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView) view.findViewById(R.id.type_card);
        textView.setText(getArguments().getString("typeCard"));

        textView = (TextView) view.findViewById(R.id.num_card);
        textView.setText(getArguments().getString("numCard"));

        textView = (TextView) view.findViewById(R.id.available_card);
        textView.setText(getArguments().getString("availableCard"));

        textView = (TextView) view.findViewById(R.id.total_card);
        textView.setText("/"+getArguments().getString("totalCard"));

    }
}