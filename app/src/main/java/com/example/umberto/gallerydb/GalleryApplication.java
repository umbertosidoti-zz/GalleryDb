package com.example.umberto.gallerydb;

import android.app.Application;

import com.example.umberto.gallerydb.business.GalleryServiceLocator;
import com.example.umberto.gallerydb.business.interfaces.GenericServiceLocator;

/**
 * Created by Umberto Sidoti on 21/06/2015.
 */
public class GalleryApplication extends Application {

    private static GalleryApplication instance;
    private static GenericServiceLocator serviceLocator;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static GalleryApplication getInstance() {
        return instance;
    }

    public GenericServiceLocator getServiceLocator() {

        if(serviceLocator==null)
            serviceLocator=new GalleryServiceLocator();
        return serviceLocator;
    }
}
