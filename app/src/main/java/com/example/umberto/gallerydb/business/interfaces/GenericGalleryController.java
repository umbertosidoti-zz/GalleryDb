package com.example.umberto.gallerydb.business.interfaces;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public interface GenericGalleryController {
    String TAG_CONTROLLER="uiController";
    void onAddButtonPressed(Activity activity);
    void onItemClick(int position);
    void onItemLongClick(int position);
    void onResultReceived(int requestCode, int resultCode, Intent data);
    int getLoaderId();
}
