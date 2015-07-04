package com.example.umberto.gallerydb.business.interfaces;

/**
 * Created by Umberto Sidoti on 27/06/2015.
 */
public interface RecycleViewFragmentListener {
    void onItemClick(int position);
    void onItemLongClick(int position);
    void onAddButtonClick();
    void onRecycleViewReady();
}
