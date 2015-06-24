package com.example.umberto.gallerydb.business.interfaces;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Umberto Sidoti on 23/06/2015.
 */
public interface IImageLoader {
    void loadImage(Context context,ImageView destination,String path,int placeolderId);
}
