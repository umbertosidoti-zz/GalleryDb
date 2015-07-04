package com.example.umberto.gallerydb.business.interfaces;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Umberto Sidoti on 23/06/2015.
 */
public interface GenericImageLoader {
    void loadImage(Context context, ImageView destination, String path, int placeholderId, int loadingId);

    void loadImage(Context context, ImageView destination, int resourceID, int placeholderId, int loadingId);

    void loadImageFromVideoPath(Context context, ImageView destination, String path, int placeholderId, int loadingId);
}
