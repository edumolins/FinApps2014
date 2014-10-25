package com.wearable.app.wearapp.grid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.ImageReference;


import com.wearable.app.wearapp.R;
import com.wearable.app.wearapp.utils.CustomAccountFragment;

import java.util.ArrayList;

public class GridPagerAccountAdapter extends FragmentGridPagerAdapter {

    private Context mContext;
    private ArrayList<GridRowAccount> mRows;

    public GridPagerAccountAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
        initAdapter();
    }
    /**
     * This method is used for demonstration only. In a real app the data and the adapters would
     * probably come from somewhere else.
     */
    private void initAdapter() {
        mRows = new ArrayList<GridRowAccount>();
        GridRowAccount row1 = new GridRowAccount();
        row1.addPage(new GridPageAccount("CCorriente","****2345","+3.455€", R.drawable.blue_background));
        row1.addPage(new GridPageAccount("CCorriente", "****1288","+232€", R.drawable.blue_background));
        row1.addPage(new GridPageAccount("CAhorro", "****5698","+16.444€", R.drawable.blue_background));
        mRows.add(row1);

    }

    @Override
    public Fragment getFragment(int row, int col) {
        GridPageAccount page = mRows.get(row).getPage(col);
        //CardFragment cardFragment = CardFragment.create(page.getTitle(), page.getText(), page.getIcon());
        CustomAccountFragment cardFragment = CustomAccountFragment.create(page.getType(), page.getNum(), page.getAvailable());
        return cardFragment;
    }

    /**
     * This method is Overriden so we can set a Custom Background for each element.
     * @param row
     * @param column
     * @return
     */
    @Override
    public ImageReference getBackground(int row, int column) {
        GridPageAccount page = mRows.get(row).getPage(column);
        return ImageReference.forDrawable(page.getBackground());
    }

    @Override
    public int getRowCount() {
        return mRows.size();
    }

    @Override
    public int getColumnCount(int row) {
        return mRows.get(row).getSize();
    }
}
