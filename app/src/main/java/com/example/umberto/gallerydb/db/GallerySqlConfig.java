package com.example.umberto.gallerydb.db;

import com.example.umberto.gallerydb.business.interfaces.GenericSqlConfig;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class GallerySqlConfig implements GenericSqlConfig {

    private static final String DATABASE_NAME = "GalleryDb";
    private static final int DATABASE_VERSION = 1;

    private final String TABLE_NAME = "galleryItems";
    private final String COLUMN_ID = "_id";
    private final String COLUMN_FILEPATH = "filePath";
    private final String COLUMN_TYPE = "type";
    private final String COLUMN_METADATA = "metadata";
    private final String COLUMN_TIMESTAMP = "timestamp";

    private final String CREATE_TABLE = "create table " + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TYPE + " integer not null,"
            + COLUMN_FILEPATH + " text not null,"
            + COLUMN_METADATA + " text,"
            + COLUMN_TIMESTAMP + " integer not null);";

    private final String[] COLUMNS = new String[]{COLUMN_ID, COLUMN_TYPE, COLUMN_FILEPATH, COLUMN_TIMESTAMP, COLUMN_METADATA};
    private final String UPDATE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    @Override
    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    public int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String getCreateDatabaseString() {
        return CREATE_TABLE;
    }

    @Override
    public String getUpdateDatabaseString() {
        return UPDATE_TABLE;
    }

    @Override
    public String getColumnType() {
        return COLUMN_TYPE;
    }

    @Override
    public String getColumnId() {
        return COLUMN_ID;
    }

    @Override
    public String getColumnMetadata() {
        return COLUMN_METADATA;
    }

    @Override
    public String getColumnTimestamp() {
        return COLUMN_TIMESTAMP;
    }

    @Override
    public String getColumnFilePath() {
        return COLUMN_FILEPATH;
    }

    @Override
    public String[] getAllColumns() {
        return COLUMNS;
    }
}
