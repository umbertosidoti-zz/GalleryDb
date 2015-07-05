package com.example.umberto.gallerydb.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.umberto.gallerydb.business.interfaces.CheckableHolder;

/**
 * Created by Umberto Sidoti on 05/07/2015.
 */
public class CheckableRecyclerView extends RecyclerView {
    public CheckableRecyclerView(Context context) {
        super(context);
    }

    public CheckableRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckableRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void checkItem(int layoutPosition, boolean value) {
        try {
            CheckableHolder holder = (CheckableHolder)
                    findViewHolderForLayoutPosition(layoutPosition);
            holder.setChecked(value);
        } catch (ClassCastException e) {
            throw new IllegalStateException("Holder must implement CheckableHolder");
        }
    }
}
