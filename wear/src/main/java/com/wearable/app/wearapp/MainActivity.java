package com.wearable.app.wearapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wearable.app.wearapp.utils.MainMenuUtils;
import com.wearable.app.wearapp.vos.ObjMainMenu;

import java.util.ArrayList;

public class MainActivity extends Activity implements WearableListView.ClickListener {

    private WearableListView mListView;
    private ListAdapter mAdapter;
    private ArrayList <ObjMainMenu> listItems;
    private MainMenuUtils menuUtils;

    private float mDefaultCircleRadius;
    private float mSelectedCircleRadius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //List Items
        menuUtils = new MainMenuUtils();
        listItems = menuUtils.getItems();

        WearableListView listView = (WearableListView) findViewById(R.id.list);
        mDefaultCircleRadius = getResources().getDimension(R.dimen.default_settings_circle_radius);
        mSelectedCircleRadius = getResources().getDimension(R.dimen.selected_settings_circle_radius);

        mAdapter = new ListAdapter();
        mListView = (WearableListView)findViewById(R.id.list);
        mListView.setAdapter(mAdapter);
        mListView.setClickListener(MainActivity.this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Intent intent = null;
        if(viewHolder.getPosition() == 0 ) {
            intent = new Intent(this, CardsAccountsActivity.class);
            intent.putExtra("type", "cards");
        }
        else if(viewHolder.getPosition() == 1) {
            intent = new Intent(this, CardsAccountsActivity.class);
            intent.putExtra("type", "accounts");
        }
        else if(viewHolder.getPosition() == 2)
            intent = new Intent(this, AlertsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTopEmptyRegionClick() {

    }

    public class ListAdapter extends WearableListView.Adapter {

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new WearableListView.ViewHolder(new MyItemView(MainActivity.this));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int position) {
            MyItemView itemView = (MyItemView) viewHolder.itemView;

            TextView txtView = (TextView) itemView.findViewById(R.id.text);
            txtView.setText(listItems.get(position).getItem());

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
        private float mScale;
        private final int mFadedCircleColor;
        private final int mChosenCircleColor;

        public MyItemView(Context context) {
            super(context);
            View.inflate(context, R.layout.row_list, this);
            imgView = (CircledImageView) findViewById(R.id.image);
            txtView = (TextView) findViewById(R.id.text);
            mFadedCircleColor = getResources().getColor(android.R.color.darker_gray);
            mChosenCircleColor = getResources().getColor(android.R.color.holo_blue_dark);
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
            imgView.setCircleColor(mChosenCircleColor);
        }

        @Override
        public void onScaleDownStart() {
            imgView.setAlpha(0.5f);
            txtView.setAlpha(0.5f);
            imgView.setCircleColor(mFadedCircleColor);
        }
    }
}
