package com.example.umberto.gallerydb.business.interfaces;

import android.provider.BaseColumns;

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

    int getId();
    int getType();
    String getFilePath();
    HashMap<String,String> getMetadata();
}
