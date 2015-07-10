package com.example.umberto.gallerydb.mockObject;

import com.example.umberto.gallerydb.business.GalleryObject;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;
import com.example.umberto.gallerydb.business.interfaces.GenericImageLoader;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.business.interfaces.GenericServiceLocator;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class MockServiceLocator implements GenericServiceLocator {
    @Override
    public GenericGalleryController getGalleryControllerImplementation() {
        return new MockGalleryController();
    }

    @Override
    public GenericImageLoader getImageLoaderImplementation() {
        return new MockImageLoader();
    }

    @Override
    public GenericDataManager getDataManagerImplementation() {
        return new MockDataManager();
    }

    @Override
    public GenericObject getObjectImplementation() {
        return new GalleryObject();
    }
}
