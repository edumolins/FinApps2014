package com.wearable.app.wearapp.grid;


import java.util.ArrayList;

public class GridRowCard {
    ArrayList<GridPageCard> mPages = new ArrayList<GridPageCard>();
    public GridRowCard() {}
    public GridRowCard(ArrayList<GridPageCard> mPages) {
        this.mPages = mPages;
    }
    public GridPageCard getPage(int index) {
        return mPages.get(index);
    }
    public void addPage(GridPageCard mPage) {
        mPages.add(mPage);
    }
    public int getSize() {
        return mPages.size();
    }
    public ArrayList<GridPageCard> getPagesArray() {
        return mPages;
    }
    public void setPages(ArrayList<GridPageCard> mPages) {
        this.mPages = mPages;
    }
}