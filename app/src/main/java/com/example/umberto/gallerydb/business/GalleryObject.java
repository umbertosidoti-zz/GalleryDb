package com.example.umberto.gallerydb.business;

import android.util.SparseArray;

import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class GalleryObject implements GenericObject {

    private long id;
    private int type;
    private String filePath;
    private JSONObject metadata;

    public void setType(int type) {
        this.type = type;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setMetadata(JSONObject metadata) {
        this.metadata = metadata;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public JSONObject getMetadata() {
        return metadata;
    }
}
