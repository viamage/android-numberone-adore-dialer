package com.numberonecall.ui.more;

import android.graphics.Bitmap;

public class MoreItem {

    private String name;
    private String no;
    private int pic;

    public MoreItem(String name, int pic, String no) {
        this.name = name;
        this.no= no;
        this.pic = pic;
    }
    
    public String getDescription() {
        return no;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBitmap() {
        return pic;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

}
