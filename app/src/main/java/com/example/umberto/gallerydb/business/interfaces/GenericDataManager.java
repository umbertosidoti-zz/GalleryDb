package com.example.umberto.gallerydb.business.interfaces;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public interface GenericDataManager {
    String onCreate();
    String onUpdate();
    String getName();
    int getVersion();
    int insert(GenericObject obj);
    int delete(GenericObject obj);
    int update(GenericObject obj);

}
