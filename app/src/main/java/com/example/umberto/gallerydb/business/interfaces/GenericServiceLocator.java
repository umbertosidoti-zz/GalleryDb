package com.example.umberto.gallerydb.business.interfaces;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public interface GenericServiceLocator {
    GenericGalleryController getGalleryControllerImplementation();

    GenericImageLoader getImageLoaderImplementation();

    GenericDataManager getDataManagerImplementation();

    GenericObject getObjectImplementation();

    GenericSqlConfig getSqlConfig();

}
