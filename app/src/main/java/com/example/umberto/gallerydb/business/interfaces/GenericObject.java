package com.example.umberto.gallerydb.business.interfaces;

import android.provider.BaseColumns;
import android.util.SparseArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Umberto Sidoti on 19/06/2015.
 */
public interface GenericObject {
    int IMAGE_TYPE=0;
    int VIDEO_TYPE=1;
    int AUDIO_TYPE=2;
    String IMAGE_MIME="image/";
    String AUDIO_MIME="audio/";
    String VIDEO_MIME="video/";

    int getId();
    void setId(int id);
    int getType();
    String getFilePath();
    SparseArray<String> getMetadata();
}
