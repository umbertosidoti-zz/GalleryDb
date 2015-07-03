package com.example.umberto.gallerydb.business.interfaces;

import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 27/06/2015.
 */
public interface RecycleViewFragment {
    void onDataReceived(ArrayList<GenericObject> data);
    void onItemClick(int position);
    void onItemLongClick(int position);
}
