package com.example.umberto.gallerydb.business.interfaces;

import org.json.JSONObject;
/**
 * Created by Umberto Sidoti on 19/06/2015.
 */
public abstract class GenericObject {

    public static final int IMAGE_TYPE = 0;
    public static final int VIDEO_TYPE = 1;
    public static final int AUDIO_TYPE = 2;
    public static final String IMAGE_MIME = "image/";
    public static final String AUDIO_MIME = "audio/";
    public static final String VIDEO_MIME = "video/";
    private long id;
    private int type;
    private String filePath;
    private JSONObject metadata;
    private long date;

    public GenericObject(){
        id=-1;
        date= System.currentTimeMillis();
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUriString(String uriString) {
        this.filePath = uriString;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    public void setCreationDate(long date) {
        this.date=date;
    }

    public double getCreationDate() {
        return date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public String getUriString() {
        return filePath;
    }

    public JSONObject getMetadata() {
        return metadata;
    }
}
