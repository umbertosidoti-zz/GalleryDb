package com.example.umberto.gallerydb.controller;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;

import com.example.umberto.gallerydb.business.interfaces.GenericControllerListener;
import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;

/**
 * Created by Umberto Sidoti on 29/06/2015.
 */
public class UiControllerRetainFragment extends Fragment implements GenericGalleryController
{
    public static final String TAG_DOWNLOADER="uiController";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(LoaderManager loaderManager) {

    }

    @Override
    public void onAddButtonPressed(Activity activity) {

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {

    }

    @Override
    public void setListener(GenericControllerListener listener) {

    }

    @Override
    public int getLoaderId() {
        return 0;
    }
}