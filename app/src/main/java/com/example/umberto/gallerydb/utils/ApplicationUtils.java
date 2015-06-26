package com.example.umberto.gallerydb.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class ApplicationUtils {

    public static Intent getIntentFileChooser(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*,video/*,audio/*");
        return intent;
    }

    String getMimeTypeStringFromUri(Context context,Uri uri){
        ContentResolver cR = context.getContentResolver();
        return cR.getType(uri);
    }
}
