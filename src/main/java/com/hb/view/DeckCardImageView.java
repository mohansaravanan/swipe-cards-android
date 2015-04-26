package com.hb.view;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class DeckCardImageView extends ImageView {

    private GestureDetectorCompat gestureDetectorCompat;

    public DeckCardImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DeckCardImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setGestureDetectorCompat(GestureDetectorCompat gestureDetectorCompat) {
        this.gestureDetectorCompat = gestureDetectorCompat;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (gestureDetectorCompat != null) {
            gestureDetectorCompat.onTouchEvent(ev);
        }
        return super.onTouchEvent(ev);
    }

}
