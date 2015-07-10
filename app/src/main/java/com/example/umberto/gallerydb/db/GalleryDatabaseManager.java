package com.example.umberto.gallerydb.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.business.interfaces.GenericSqlConfig;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class GalleryDatabaseManager implements GenericDataManager {

    GenericSqlConfig config;

    public GalleryDatabaseManager() {
        config = GalleryApplication.getInstance().getServiceLocator().getSqlConfig();
    }

    @Override
    public long insert(GenericObject obj) {
        ContentValues contentValue = getContentValue(obj);
        return getWritableInstance().insert(config.getTableName(), null, contentValue);
    }

    private SQLiteDatabase getWritableInstance() {
        return DatabaseHelper.getInstance(
                GalleryApplication.getInstance())
                .getWritableDatabase();
    }

    private ContentValues getContentValue(GenericObject obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(config.getColumnType(), obj.getType());
        contentValues.put(config.getColumnFilePath(), obj.getUriString());
        contentValues.put(config.getColumnTimestamp(), obj.getCreationDate());

        if (obj.getMetadata() != null)
            contentValues.put(config.getColumnMetadata(), (obj.getMetadata().toString()));

        return contentValues;
    }

    @Override
    public int delete(long id) {
        return getWritableInstance().delete(config.getTableName(), config.getColumnId() + " = " + id, null);
    }

    @Override
    public int update(GenericObject obj) {
        return 0;
    }

    @Override
    public ArrayList<GenericObject> getAll() {
        ArrayList<GenericObject> objects = new ArrayList<>();
        SQLiteDatabase writableDB = getWritableInstance();

        Cursor cursor = writableDB.query(config.getTableName(), config.getAllColumns(), null, null, null, null, null);

        cursor.moveToFirst();

        int type;
        String path;
        String metadataString;
        long id;
        JSONObject jsonObj = null;
        long timestamp;

        while (!cursor.isAfterLast()) {
            type = cursor.getInt(cursor.getColumnIndex(config.getColumnType()));
            path = cursor.getString(cursor.getColumnIndex(config.getColumnFilePath()));
            timestamp = cursor.getLong(cursor.getColumnIndex(config.getColumnTimestamp()));

            metadataString = cursor.getString(cursor.getColumnIndex(config.getColumnMetadata()));
            if (metadataString != null) {
                try {
                    jsonObj = new JSONObject(metadataString);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            id = cursor.getLong(cursor.getColumnIndex(config.getColumnId()));
            GenericObject obj = GalleryApplication.getInstance().
                    getServiceLocator().getObjectImplementation();
            ApplicationUtils.setDataToObject(obj, type, path, jsonObj, timestamp);
            obj.setId(id);
            objects.add(obj);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return objects;
    }
}
