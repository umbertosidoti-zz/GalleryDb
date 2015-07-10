package com.example.umberto.gallerydb.business.interfaces;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public interface GenericDataManager {

    long insert(GenericObject obj);

    int delete(long id);

    int update(GenericObject obj);

    ArrayList<GenericObject> getAll();
}
