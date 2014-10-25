package com.wearable.app.wearapp.vos;

/**
 * Created by Edu on 25/10/2014.
 */
public class ObjMainMenu {

    private int img = 0;
    private String item = "";
    private String item2 = "";

    public ObjMainMenu(int img, String item) {
        this.img = img;
        this.item = item;
    }

    public ObjMainMenu(int img, String item, String item2) {
        this.img = img;
        this.item = item;
        this.item2 = item2;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }
}
