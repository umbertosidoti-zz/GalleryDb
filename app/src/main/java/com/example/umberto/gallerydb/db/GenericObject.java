package com.example.umberto.gallerydb.db;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by Umberto Sidoti on 19/06/2015.
 */
public interface GenericObject extends BaseColumns {
    int IMAGE_TYPE=0;
    int VIDEO_TYPE=1;
    int AUDIO_TYPE=2;
    int getId();
    int getType();
    String getImagePath();
    String getMetadata();
    String[] getAllColumns();
    String onCreateDb();
    String onUpdateDb();
}
