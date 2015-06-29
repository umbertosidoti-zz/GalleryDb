package com.example.umberto.gallerydb.business;

import android.content.Context;
import android.support.v4.content.Loader;

import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;
import com.example.umberto.gallerydb.business.interfaces.GenericImageLoader;
import com.example.umberto.gallerydb.business.interfaces.GenericServiceLocator;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.controller.UiControllerRetainFragment;
import com.example.umberto.gallerydb.db.GalleryDatabaseManager;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public class GalleryServiceLocator implements GenericServiceLocator {

    @Override
    public GenericGalleryController getGalleryControllerImplementation() {
        return new UiControllerRetainFragment();
    }

    @Override
    public GenericImageLoader getImageLoaderImplementation() {
        return new GalleryPicassoImageLoader();
    }

    @Override
    public GenericDataManager getDataManagerImplementation() {
        return new GalleryDatabaseManager();
    }
}
