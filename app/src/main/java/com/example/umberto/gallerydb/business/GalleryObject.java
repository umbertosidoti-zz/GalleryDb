package com.example.umberto.gallerydb.business;

import android.util.SparseArray;

import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.HashMap;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class GalleryObject implements GenericObject {

    private int id;
    private int type;
    private String filePath;
    private SparseArray<String> metadata;

    public GalleryObject(int type, String path, SparseArray<String> metadata) {
        this.type = type;
        this.filePath = path;
        this.metadata = metadata;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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
    public SparseArray<String> getMetadata() {
        return metadata;
    }
}
