package com.example.umberto.gallerydb.mockObject;

import android.app.Activity;
import android.content.Intent;

import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class MockGalleryController implements GenericGalleryController {
    @Override
    public void start() {

    }

    @Override
    public void onAddButtonPressed(Activity activity) {

    }

    @Override
    public void onResultReceived(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onDeleteElementRequest(ArrayList<Integer> positionsToRemove) {

    }
}
