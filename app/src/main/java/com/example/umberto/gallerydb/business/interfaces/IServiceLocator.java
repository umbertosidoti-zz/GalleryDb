package com.example.umberto.gallerydb.business.interfaces;

import android.content.Context;
import android.support.v4.content.Loader;

import com.example.umberto.gallerydb.db.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public interface IServiceLocator {

    Loader<ArrayList<GenericObject>> getLoader(Context context);
    IGalleryController getGalleryController();
}
