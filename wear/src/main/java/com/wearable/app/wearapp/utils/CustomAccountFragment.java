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
public class CustomAccountFragment extends Fragment {

    private TextView textView;

    public static CustomAccountFragment create(String type, String num, String available) {
        CustomAccountFragment fragment = new CustomAccountFragment();
        Bundle args = new Bundle();
        args.putString("typeAccount", type);
        args.putString("numAccount", num);
        args.putString("availableAccount", available);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_account_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView) view.findViewById(R.id.type_account);
        textView.setText(getArguments().getString("typeAccount"));

        textView = (TextView) view.findViewById(R.id.num_account);
        textView.setText(getArguments().getString("numAccount"));

        textView = (TextView) view.findViewById(R.id.available_account);
        textView.setText(getArguments().getString("availableAccount"));
    }

}