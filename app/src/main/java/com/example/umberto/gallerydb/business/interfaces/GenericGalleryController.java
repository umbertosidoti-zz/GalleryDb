package com.example.umberto.gallerydb.business.interfaces;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public interface GenericGalleryController {

    public String TAG_CONTROLLER="uiController";
    void onActivityCreated(LoaderManager loaderManager);
    void onAddButtonPressed(Activity activity);
    void onItemClick(int position);
    void onItemLongClick(int position);
    void setListener(GenericControllerListener listener);
    void onActivityResult(int requestCode, int resultCode, Intent data);
    int getLoaderId();
}
