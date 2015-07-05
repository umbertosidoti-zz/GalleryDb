package com.example.umberto.gallerydb.business.interfaces;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 05/07/2015.
 */
public interface DeleteActionModeListener {
    void deleteItems(ArrayList<Integer> positionToRemove);
    void checkItem(int position, boolean value);
}