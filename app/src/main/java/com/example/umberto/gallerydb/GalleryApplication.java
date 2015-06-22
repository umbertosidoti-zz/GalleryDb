package com.example.umberto.gallerydb;

import android.app.Application;

import com.example.umberto.gallerydb.business.DefaultGalleryServiceLocator;
import com.example.umberto.gallerydb.business.interfaces.IServiceLocator;

/**
 * Created by Umberto Sidoti on 21/06/2015.
 */
public class GalleryApplication extends Application {

    private static GalleryApplication instance;
    private static IServiceLocator serviceLocator;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static GalleryApplication getInstance() {
        return instance;
    }

    public IServiceLocator getServiceLocator() {

        if(serviceLocator==null)
            serviceLocator=new DefaultGalleryServiceLocator();
        return serviceLocator;
    }
}
