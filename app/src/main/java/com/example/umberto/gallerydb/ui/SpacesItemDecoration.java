package com.example.umberto.gallerydb.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;

/**
 * Created by Umberto Sidoti on 04/07/2015.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int numColumns;

    public SpacesItemDecoration(int space) {
        this.space = space;
        numColumns=GalleryApplication.getInstance().getResources().getInteger(R.integer.column_number);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildAdapterPosition(view) <numColumns)
            outRect.top = space;
    }
}