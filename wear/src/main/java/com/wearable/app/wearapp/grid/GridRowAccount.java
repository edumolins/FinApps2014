package com.wearable.app.wearapp.grid;


import com.wearable.app.wearapp.grid.GridPageAccount;

import java.util.ArrayList;

public class GridRowAccount {
    ArrayList<GridPageAccount> mPages = new ArrayList<GridPageAccount>();
    public GridRowAccount() {}
    public GridRowAccount(ArrayList<GridPageAccount> mPages) {
        this.mPages = mPages;
    }
    public GridPageAccount getPage(int index) {
        return mPages.get(index);
    }
    public void addPage(GridPageAccount mPage) {
        mPages.add(mPage);
    }
    public int getSize() {
        return mPages.size();
    }
    public ArrayList<GridPageAccount> getPagesArray() {
        return mPages;
    }
    public void setPages(ArrayList<GridPageAccount> mPages) {
        this.mPages = mPages;
    }
}