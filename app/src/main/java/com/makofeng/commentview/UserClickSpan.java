package com.makofeng.commentview;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;

/**
 * Created by fenghao on 2015/7/3.
 */
public abstract class UserClickSpan extends ClickableSpan {

    private boolean isUnderLineRequired;
    private int color = Color.BLUE;


    public UserClickSpan(boolean isUnderLineRequired) {
        this.isUnderLineRequired = isUnderLineRequired;
    }

    public UserClickSpan(boolean isUnderLineRequired, int color) {
        this.isUnderLineRequired = isUnderLineRequired;
        this.color = color;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(color);
        ds.setUnderlineText(isUnderLineRequired);
    }

}