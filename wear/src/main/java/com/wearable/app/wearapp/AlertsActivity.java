package com.wearable.app.wearapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wearable.app.wearapp.utils.MainMenuUtils;
import com.wearable.app.wearapp.vos.ObjMainMenu;

import java.util.ArrayList;
import java.util.List;

public class AlertsActivity extends Activity implements WearableListView.ClickListener {

    private WearableListView mListView;
    private ListAdapter mAdapter;
    private ArrayList <ObjMainMenu> listItems;
    private MainMenuUtils menuUtils;

    private float mDefaultCircleRadius;
    private float mSelectedCircleRadius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerts_activity);
        //List Items
        menuUtils = new MainMenuUtils();
        listItems = menuUtils.getAlerts();

        WearableListView listView = (WearableListView) findViewById(R.id.list);
        mDefaultCircleRadius = getResources().getDimension(R.dimen.default_settings_circle_radius);
        mSelectedCircleRadius = getResources().getDimension(R.dimen.selected_settings_circle_radius);

        mAdapter = new ListAdapter();
        mListView = (WearableListView)findViewById(R.id.list);
        mListView.setAdapter(mAdapter);
        mListView.setClickListener(AlertsActivity.this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        if(listItems.get(viewHolder.getPosition()).getItem2().equals(getString(R.string.yes)))
            listItems.get(viewHolder.getPosition()).setItem2(getString(R.string.no));
        else
            listItems.get(viewHolder.getPosition()).setItem2(getString(R.string.yes));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTopEmptyRegionClick() {

    }

    public class ListAdapter extends WearableListView.Adapter {

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new WearableListView.ViewHolder(new MyItemView(AlertsActivity.this));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int position) {
            MyItemView itemView = (MyItemView) viewHolder.itemView;

            TextView txtView = (TextView) itemView.findViewById(R.id.text);
            txtView.setText(listItems.get(position).getItem());

            txtView = (TextView) itemView.findViewById(R.id.text2);
            txtView.setText(listItems.get(position).getItem2());

            Integer resourceId = listItems.get(position).getImg();
            CircledImageView imgView = (CircledImageView) itemView.findViewById(R.id.image);
            imgView.setImageResource(resourceId);
        }

        @Override
        public int getItemCount() {
            return listItems.size();
        }
    }

    private final class MyItemView extends FrameLayout implements WearableListView.Item {

        final CircledImageView imgView;
        final TextView txtView;
        final TextView txtView2;
        private float mScale;
        private final int mFadedCircleColor;
        private final int mChosenCircleColor;

        public MyItemView(Context context) {
            super(context);
            View.inflate(context, R.layout.alert_list, this);
            imgView = (CircledImageView) findViewById(R.id.image);
            txtView = (TextView) findViewById(R.id.text);
            txtView2 = (TextView) findViewById(R.id.text2);
            mFadedCircleColor = getResources().getColor(android.R.color.darker_gray);
            mChosenCircleColor = getResources().getColor(android.R.color.transparent);
        }

        @Override
        public float getProximityMinValue() {
            return mDefaultCircleRadius;
        }

        @Override
        public float getProximityMaxValue() {
            return mSelectedCircleRadius;
        }

        @Override
        public float getCurrentProximityValue() {
            return mScale;
        }

        @Override
        public void setScalingAnimatorValue(float value) {
            mScale = value;
            imgView.setCircleRadius(mScale);
            imgView.setCircleRadiusPressed(mScale);
        }

        @Override
        public void onScaleUpStart() {
            imgView.setAlpha(1f);
            txtView.setAlpha(1f);
            txtView2.setAlpha(1f);
            imgView.setCircleColor(mChosenCircleColor);
        }

        @Override
        public void onScaleDownStart() {
            imgView.setAlpha(0.5f);
            txtView.setAlpha(0.5f);
            txtView2.setAlpha(0.5f);
            imgView.setCircleColor(mFadedCircleColor);
        }
    }
}
