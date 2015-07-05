package com.example.umberto.gallerydb.business.interfaces;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 27/06/2015.
 */
public interface RecyclerViewFragmentListener {

    void onAddButtonClick();

    void onRecycleViewReady();

    void onActionModeDeleteRequest(ArrayList<Integer> positionToRemove);
}
