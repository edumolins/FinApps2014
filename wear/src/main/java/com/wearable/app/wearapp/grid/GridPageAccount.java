package com.wearable.app.wearapp.grid;

public class GridPageAccount {
    private String mType;
    private String mNum;
    private String mAvailable;
    private int mBackground;

    public GridPageAccount(String mType, String mNum, String mAvailable, int mBackground) {
        this.mType = mType;
        this.mNum = mNum;
        this.mAvailable= mAvailable;
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
    public int getBackground() {
        return mBackground;
    }
}
