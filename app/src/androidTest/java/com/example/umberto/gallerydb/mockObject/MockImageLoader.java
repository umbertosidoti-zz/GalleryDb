package com.example.umberto.gallerydb.mockObject;

import android.content.Context;
import android.widget.ImageView;

import com.example.umberto.gallerydb.business.interfaces.GenericImageLoader;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class MockImageLoader implements GenericImageLoader {
    @Override
    public void loadImage(Context context, ImageView destination, String path, int placeholderId, int loadingId) {

    }

    @Override
    public void loadImage(Context context, ImageView destination, int resourceID, int placeholderId, int loadingId) {

    }

    @Override
    public void loadImageFromVideoPath(Context context, ImageView destination, String path, int placeholderId, int loadingId) {

    }
}
