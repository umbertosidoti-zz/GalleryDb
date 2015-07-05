package com.example.umberto.gallerydb.task;

import android.os.AsyncTask;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 05/07/2015.
 */
public class DeleteGenericObject extends AsyncTask<ArrayList<Long>,Void, ArrayList<GenericObject>>{
    @Override
    protected ArrayList<GenericObject> doInBackground(ArrayList<Long>... params) {

        ArrayList<Long> idsToDelete = params[0];

        GenericDataManager dataManager = GalleryApplication.getInstance().getServiceLocator().getDataManagerImplementation();

        for (Long id:idsToDelete)
            dataManager.delete(id);

        return dataManager.getAll();
    }
}
