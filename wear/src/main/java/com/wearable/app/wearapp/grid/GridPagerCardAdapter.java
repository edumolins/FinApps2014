package com.wearable.app.wearapp.grid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.ImageReference;

import com.wearable.app.wearapp.R;
import com.wearable.app.wearapp.utils.CustomCardFragment;

import java.util.ArrayList;

public class GridPagerCardAdapter extends FragmentGridPagerAdapter {

    private Context mContext;
    private ArrayList<GridRowCard> mRows;

    public GridPagerCardAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
        initAdapter();
    }

    private void initAdapter() {
        mRows = new ArrayList<GridRowCard>();
        GridRowCard row1 = new GridRowCard();
        row1.addPage(new GridPageCard("Visa Oro","****2222","1.200","38.444€", R.drawable.blue_background));
        row1.addPage(new GridPageCard("V.Electron", "****2655","480", "6.000€", R.drawable.blue_background));
        mRows.add(row1);

    }

    @Override
    public Fragment getFragment(int row, int col) {
        GridPageCard page = mRows.get(row).getPage(col);
        //CardFragment cardFragment = CardFragment.create(page.getTitle(), page.getText(), page.getIcon());
        CustomCardFragment cardFragment = CustomCardFragment.create(page.getType(), page.getNum(), page.getAvailable(), page.getTotal());
        return cardFragment;
    }

    @Override
    public ImageReference getBackground(int row, int column) {
        GridPageCard page = mRows.get(row).getPage(column);
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
