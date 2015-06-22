package com.example.umberto.gallerydb.business;

import android.content.Context;
import android.support.v4.content.Loader;

import com.example.umberto.gallerydb.db.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 19/06/2015.
 */
public class LoaderGenericObject extends Loader<ArrayList<GenericObject>> {
    /**
     * Stores away the application context associated with context. Since Loaders can be used
     * across multiple activities it's dangerous to store the context directly.
     *
     * @param context used to retrieve the application context.
     */
    public LoaderGenericObject(Context context) {
        super(context);
    }
}
