package com.example.umberto.gallerydb.business.interfaces;

import org.json.JSONObject;
/**
 * Created by Umberto Sidoti on 19/06/2015.
 */
public interface GenericObject {
    int IMAGE_TYPE = 0;
    int VIDEO_TYPE = 1;
    int AUDIO_TYPE = 2;
    String IMAGE_MIME = "image/";
    String AUDIO_MIME = "audio/";
    String VIDEO_MIME = "video/";

    long getId();

    void setId(long id);

    int getType();

    void setType(int type);

    String getUriString();

    void setUriString(String uriString);

    JSONObject getMetadata();

    void setMetadata(JSONObject metadata);
}
