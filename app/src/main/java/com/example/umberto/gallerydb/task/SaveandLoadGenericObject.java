package com.example.umberto.gallerydb.task;

import android.net.Uri;
import android.os.AsyncTask;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Umberto Sidoti on 29/06/2015.
 */
public class SaveAndLoadGenericObject extends AsyncTask<Uri, Void, ArrayList<GenericObject>> {

    @Override
    protected ArrayList<GenericObject> doInBackground(Uri... params) {
        Uri uri = params[0];
        if (uri == null)
            return null;

        GenericObject object = ApplicationUtils.getObjectFromUri(uri);
        long id = -1;
        GenericDataManager dataManager = null;

        if (isCancelled())
            return null;
        ArrayList<GenericObject> result=null;

        if (object != null) {
            dataManager = GalleryApplication.getInstance().getServiceLocator().getDataManagerImplementation();
            id = dataManager.insert(object);
        }
        if(id > 0){
            result= dataManager.getAll();
            Collections.sort(result);
            return result;
        }
        return null;
    }
}
