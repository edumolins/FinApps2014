package com.wearable.app.wearapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;

import com.wearable.app.wearapp.grid.GridPagerAccountAdapter;
import com.wearable.app.wearapp.grid.GridPagerCardAdapter;


public class CardsAccountsActivity extends Activity {
    private GridViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_activity);
        mPager = (GridViewPager) findViewById(R.id.gridPager);
        if(getIntent().getStringExtra("type").equals("cards"))
            mPager.setAdapter(new GridPagerCardAdapter(this, getFragmentManager()));
        else
            mPager.setAdapter(new GridPagerAccountAdapter(this, getFragmentManager()));

    }

}
