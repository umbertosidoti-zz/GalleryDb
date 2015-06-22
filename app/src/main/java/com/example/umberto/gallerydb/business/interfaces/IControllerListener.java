package com.example.umberto.gallerydb.business.interfaces;

import com.example.umberto.gallerydb.db.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 22/06/2015.
 */
public interface IControllerListener {

    void onDataReady(ArrayList<GenericObject> data);
}
