package com.example.umberto.gallerydb.business.interfaces;

import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public interface GenericDataManager {
    String onCreate();

    String onUpdate();

    String getName();

    int getVersion();

    long insert(GenericObject obj);

    int delete(long id);

    int update(GenericObject obj);

    ArrayList<GenericObject> getAll();
}
