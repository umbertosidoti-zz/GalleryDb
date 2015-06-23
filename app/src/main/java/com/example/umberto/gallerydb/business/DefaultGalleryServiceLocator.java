package com.example.umberto.gallerydb.business;

import android.content.Context;
import android.support.v4.content.Loader;

import com.example.umberto.gallerydb.business.interfaces.IGalleryController;
import com.example.umberto.gallerydb.business.interfaces.IImageLoader;
import com.example.umberto.gallerydb.business.interfaces.IServiceLocator;
import com.example.umberto.gallerydb.db.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public class DefaultGalleryServiceLocator implements IServiceLocator {
    @Override
    public Loader<ArrayList<GenericObject>> getLoader(Context context) {
        return new LoaderGenericObject(context);
    }

    @Override
    public IGalleryController getGalleryController() {
        return new DefaultGalleryController();
    }

    @Override
    public IImageLoader getImageLoader() {
        return new PicassoImageLoader();
    }
}
