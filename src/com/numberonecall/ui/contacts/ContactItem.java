package com.numberonecall.ui.contacts;

import android.graphics.Bitmap;

public class ContactItem {

    private String name;
    private String no;
    private Bitmap pic;

    public ContactItem(String name, Bitmap pic, String no) {
        this.name = name;
        this.no= no;
        this.pic = pic;
    }
    
    public String getNumber() {
        return no;
    }
    
    public String getName() {
        return name;
    }
    
    public Bitmap getBitmap() {
        return pic;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

}
