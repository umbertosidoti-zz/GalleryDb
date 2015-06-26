package com.example.umberto.gallerydb.business;

import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.HashMap;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class GalleryObject implements GenericObject {

    private int id;
    private int type;
    private String filePath;
    private HashMap<String, String> metadata;

    @Override
    public int getId() {
        return id;
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
    public HashMap<String, String> getMetadata() {
        return metadata;
    }
}
