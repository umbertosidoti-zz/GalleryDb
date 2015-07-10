package com.example.umberto.gallerydb.business.interfaces;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public interface GenericSqlConfig {

    String getDatabaseName();

    int getDatabaseVersion();

    String getTableName();

    String getCreateDatabaseString();

    String getUpdateDatabaseString();

    String getColumnType();

    String getColumnId();

    String getColumnMetadata();

    String getColumnTimestamp();

    String getColumnFilePath();

    String[] getAllColumns();

}
