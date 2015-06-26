package com.example.umberto.gallerydb.business;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericControllerListener;
import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public class GalleryController implements GenericGalleryController,LoaderManager.LoaderCallbacks<ArrayList<GenericObject>> {

    private static final int LOADER_GALLERY_ID = 0;
    private static final int REQ_CODE_PICK_SOUND_FILE = 12;
    private GenericControllerListener listener;

    @Override
    public void onActivityCreated(android.support.v4.app.LoaderManager loaderManager) {

        loaderManager.initLoader(LOADER_GALLERY_ID,null,this);
    }

    @Override
    public void onAddButtonPressed(Fragment fragment) {

        Intent intent= ApplicationUtils.getIntentFileChooser();
        fragment.startActivityForResult(
                Intent.createChooser(intent, fragment.getString(R.string.select_file_title)),
                REQ_CODE_PICK_SOUND_FILE);
    }


    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {

    }

    @Override
    public void setListener(GenericControllerListener listener) {
        this.listener=listener;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE_PICK_SOUND_FILE && resultCode == Activity.RESULT_OK){
            if ((data != null) && (data.getData() != null)){
                Uri uri = data.getData();
                saveUriSelected(uri);
            }
        }
    }

    private void saveUriSelected(Uri uri) {

    }

    @Override
    public Loader<ArrayList<GenericObject>> onCreateLoader(int i, Bundle bundle) {
        return GalleryApplication.getInstance().
                getServiceLocator().getLoaderImplementation(GalleryApplication.getInstance());
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
