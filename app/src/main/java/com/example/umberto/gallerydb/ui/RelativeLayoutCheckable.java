package com.example.umberto.gallerydb.ui;

/**
 * Created by Umberto Sidoti on 05/07/2015.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Umberto Sidoti on 03/02/15.
 */
public class RelativeLayoutCheckable extends RelativeLayout implements Checkable {
    private boolean checked = false;
    private List<Checkable> checkableViews = new ArrayList<>();

    public RelativeLayoutCheckable(Context context) {
        super(context, null);
    }

    public RelativeLayoutCheckable(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public RelativeLayoutCheckable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private static final int[] CheckedStateSet = {
            android.R.attr.state_checked
    };

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CheckedStateSet);
        }
        return drawableState;
    }


    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;

        sendCheckedStatusToCheckableChildren(checked);
        refreshDrawableState();
    }

    private void sendCheckedStatusToCheckableChildren(boolean checked) {
        for (Checkable c : checkableViews) {
            // Pass the information to all the child Checkable widgets
            c.setChecked(checked);
        }
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final int childCount = this.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            findCheckableChildren(this.getChildAt(i));
        }
    }

    /**
     * Add to our checkable list all the children of the view that implement the
     * interface Checkable
     */
    private void findCheckableChildren(View v) {
        if (v instanceof Checkable) {
            checkableViews.add((Checkable) v);
        }
        if (v instanceof ViewGroup) {
            final ViewGroup vg = (ViewGroup) v;
            final int childCount = vg.getChildCount();
            for (int i = 0; i < childCount; ++i) {
                findCheckableChildren(vg.getChildAt(i));
            }
        }
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        checked = !checked;
    }
}