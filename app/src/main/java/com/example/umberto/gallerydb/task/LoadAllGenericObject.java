package com.example.umberto.gallerydb.task;

import android.net.Uri;
import android.os.AsyncTask;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 29/06/2015.
 */
public class LoadAllGenericObject extends AsyncTask<Void, Void, ArrayList<GenericObject>> {

    @Override
    protected ArrayList<GenericObject> doInBackground(Void... params) {
        GenericDataManager dataManager = GalleryApplication.getInstance().
                getServiceLocator().getDataManagerImplementation();
        return dataManager.getAll();
    }
}
