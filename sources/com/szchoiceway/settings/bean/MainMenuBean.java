package com.szchoiceway.settings.bean;

import android.graphics.drawable.Drawable;

public class MainMenuBean {
    private Drawable chkDrawable = null;
    private String tag = "";
    private String tvTitle = "";

    public Drawable getChkDrawable() {
        return this.chkDrawable;
    }

    public void setChkDrawable(Drawable drawable) {
        this.chkDrawable = drawable;
    }

    public String getTvTitle() {
        return this.tvTitle;
    }

    public void setTvTitle(String str) {
        this.tvTitle = str;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }
}
