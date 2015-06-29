package com.example.umberto.gallerydb.business.interfaces;

import android.content.Context;
import android.support.v4.content.Loader;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public interface GenericServiceLocator {
    GenericGalleryController getGalleryControllerImplementation();
    GenericImageLoader getImageLoaderImplementation();
    GenericDataManager getDataManagerImplementation();
}
