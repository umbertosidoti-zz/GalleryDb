package com.example.umberto.gallerydb.ui;

/**
 * Created by Umberto Sidoti on 03/07/2015.
 */

import android.content.Context;
import android.util.AttributeSet;

/**
 * A RelativeLayout that will always be square -- same width and height,
 * where the height is based off the width.
 */
public class SquareRelativeLayout extends RelativeLayoutCheckable {

    public SquareRelativeLayout(Context context) {
        super(context);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

}