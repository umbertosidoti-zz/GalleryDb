package com.example.umberto.gallerydb.business;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.widget.ImageView;

import com.example.umberto.gallerydb.business.interfaces.GenericImageLoader;
import com.example.umberto.gallerydb.utils.ApplicationUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by Umberto Sidoti on 23/06/2015.
 */
public class GalleryPicassoImageLoader implements GenericImageLoader {
    @Override
    public void loadImage(Context context, ImageView destination, String path, int placeholderId, int loadingId) {

        Picasso.with(context)
                .load(Uri.parse(path))
                .error(placeholderId)
                .placeholder(loadingId)
                .fit().centerCrop()
                .into(destination);
    }

    @Override
    public void loadImage(Context context, ImageView destination, int resourceID, int placeholderId, int loadingId) {
        Picasso.with(context)
                .load(resourceID)
                .error(placeholderId)
                .placeholder(loadingId)
                .fit().centerCrop()
                .into(destination);
    }

    @Override
    public void loadImageFromVideoPath(Context context, ImageView destination,
                                       final String path, int placeholderId, int loadingId) {
        Picasso.with(context)
                .load(loadingId)
                .transform(new Transformation() {
                    @Override
                    public Bitmap transform(Bitmap source) {
                        double w = source.getWidth();
                        source.recycle();
                        Bitmap my = ApplicationUtils.getBitmapPreviewFromUri(path);
                        Point newSize = ApplicationUtils.getNewSizeRatio(w, my.getHeight(), my.getWidth());
                        return Bitmap.createScaledBitmap(my, newSize.x, newSize.y, false);
                    }

                    @Override
                    public String key() {
                        return "loadFrameVideo";
                    }
                })
                .error(placeholderId)
                .placeholder(loadingId)
                .fit().centerCrop()
                .into(destination);
    }
}
