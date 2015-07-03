package com.example.umberto.gallerydb.business.interfaces;

import android.content.Context;
import android.support.v4.content.Loader;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public interface GenericServiceLocator {
    GenericGalleryController getGalleryControllerImplementation();
    GenericImageLoader getImageLoaderImplementation();
    GenericDataManager getDataManagerImplementation();
    GenericObject getObjectImplementation();
}
