package com.wearable.app.wearapp.grid;

public class GridPageCard {
    private String mType;
    private String mNum;
    private String mAvailable;
    private String mTotal;
    private int mBackground;

    public GridPageCard(String mType, String mNum, String mAvailable, String mTotal, int mBackground) {
        this.mType = mType;
        this.mNum = mNum;
        this.mAvailable= mAvailable;
        this.mTotal = mTotal;
        this.mBackground = mBackground;
    }
    public String getType() {
        return mType;
    }
    public String getNum() {
        return mNum;
    }
    public String getAvailable() {
        return mAvailable;
    }
    public String getTotal() {
        return mTotal;
    }
    public int getBackground() {
        return mBackground;
    }
}
