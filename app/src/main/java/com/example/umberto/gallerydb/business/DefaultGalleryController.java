package com.example.umberto.gallerydb.business;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.IControllerListener;
import com.example.umberto.gallerydb.business.interfaces.IGalleryController;
import com.example.umberto.gallerydb.db.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public class DefaultGalleryController implements IGalleryController,LoaderManager.LoaderCallbacks<ArrayList<GenericObject>> {

    private static final int LOADER_GALLERY_ID = 0;
    private IControllerListener listener;

    @Override
    public void onActivityCreated(android.support.v4.app.LoaderManager loaderManager) {

        loaderManager.initLoader(LOADER_GALLERY_ID,null,this);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {

    }

    @Override
    public void setListener(IControllerListener listener) {
        this.listener=listener;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public Loader<ArrayList<GenericObject>> onCreateLoader(int i, Bundle bundle) {
        return GalleryApplication.getInstance().
                getServiceLocator().getLoader(GalleryApplication.getInstance());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<GenericObject>> loader, ArrayList<GenericObject> data) {
        if(listener!=null)
            listener.onDataReady(data);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<GenericObject>> loader) {
        if(listener!=null)
            listener.onDataReady(null);
    }
}
