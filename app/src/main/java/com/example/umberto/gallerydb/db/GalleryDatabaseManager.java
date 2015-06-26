package com.example.umberto.gallerydb.db;

import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class GalleryDatabaseManager implements GenericDataManager {


    private static final String DATABASE_NAME = "GalleryDb";
    private static final int DATABASE_VERSION=1;

    private final String TABLE_NAME = "galleryItems";
    private final String COLUMN_FILEPATH = "filePath";
    private final String COLUMN_TYPE = "type";
    private final String COLUMN_METADATA = "metadata";
    private final String _ID="_id";

    private String CREATE_TABLE = "create table " + TABLE_NAME
            + "(" + _ID + " integer primary key autoincrement, "
            + COLUMN_TYPE + " integer not null,"
            + COLUMN_FILEPATH + " text not null,"
            + COLUMN_METADATA +" text);";

    public final String[] COLUMNS = new String[]{_ID, COLUMN_TYPE, COLUMN_FILEPATH, COLUMN_METADATA};
    String UPDATE_TABLE =  "DROP TABLE IF EXISTS " + TABLE_NAME;

    @Override
    public String onCreate() {
        return CREATE_TABLE;
    }

    @Override
    public String onUpdate() {
        return UPDATE_TABLE;
    }

    @Override
    public String getName() {
        return DATABASE_NAME;
    }

    @Override
    public int getVersion() {
        return DATABASE_VERSION;
    }

    @Override
    public int insert(GenericObject obj) {
        return 0;
    }

    @Override
    public int delete(GenericObject obj) {
        return 0;
    }

    @Override
    public int update(GenericObject obj) {
        return 0;
    }
}
