package com.example.umberto.gallerydb.business;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.example.umberto.gallerydb.business.interfaces.GenericImageLoader;
import com.squareup.picasso.Picasso;

/**
 * Created by Umberto Sidoti on 23/06/2015.
 */
public class GalleryPicassoImageLoader implements GenericImageLoader {
    @Override
    public void loadImage(Context context, ImageView destination, String path, int placeolderId, int loadingId) {

        Picasso.with(context)
                .load(Uri.parse(path))
                .error(placeolderId)
                .placeholder(loadingId)
                .fit().centerCrop()
                .into(destination);
    }

    @Override
    public void loadImage(Context context, ImageView destination, int resourceID, int placeolderId, int loadingId) {
        Picasso.with(context)
                .load(resourceID)
                .error(placeolderId)
                .placeholder(loadingId)
                .fit().centerCrop()
                .into(destination);
    }
}
