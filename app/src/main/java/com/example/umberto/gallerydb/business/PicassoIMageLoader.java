package com.example.umberto.gallerydb.business;

import android.content.Context;
import android.widget.ImageView;

import com.example.umberto.gallerydb.business.interfaces.IImageLoader;
import com.squareup.picasso.Picasso;

/**
 * Created by Umberto Sidoti on 23/06/2015.
 */
public class PicassoImageLoader implements IImageLoader {
    @Override
    public void loadImage(Context context, ImageView destination, String path, int placeolderId) {
        Picasso.with(context).load(path)
                .placeholder(placeolderId)
                .error(placeolderId)
                .into(destination);
    }
}
