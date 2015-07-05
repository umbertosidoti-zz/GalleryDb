package com.example.umberto.gallerydb.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class GalleryDatabaseManager implements GenericDataManager {

    private static final String DATABASE_NAME = "GalleryDb";
    private static final int DATABASE_VERSION = 1;

    private final String TABLE_NAME = "galleryItems";
    private final String COLUMN_ID = "_id";
    private final String COLUMN_FILEPATH = "filePath";
    private final String COLUMN_TYPE = "type";
    private final String COLUMN_METADATA = "metadata";
    private final String COLUMN_TIMESTAMP = "timestamp";

    private String CREATE_TABLE = "create table " + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TYPE + " integer not null,"
            + COLUMN_FILEPATH + " text not null,"
            + COLUMN_METADATA + " text,"
            + COLUMN_TIMESTAMP + " integer not null);";

    public final String[] COLUMNS = new String[]{COLUMN_ID, COLUMN_TYPE, COLUMN_FILEPATH, COLUMN_TIMESTAMP, COLUMN_METADATA};
    String UPDATE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

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
    public long insert(GenericObject obj) {
        ContentValues contentValue = getContentValue(obj);
        return getWritableInstance().insert(TABLE_NAME, null, contentValue);
    }

    private SQLiteDatabase getWritableInstance() {
        return DatabaseHelper.getInstance(
                GalleryApplication.getInstance())
                .getWritableDatabase();
    }

    private ContentValues getContentValue(GenericObject obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TYPE, obj.getType());
        contentValues.put(COLUMN_FILEPATH, obj.getUriString());
        contentValues.put(COLUMN_TIMESTAMP, obj.getCreationDate());

        if (obj.getMetadata() != null)
            contentValues.put(COLUMN_METADATA, (obj.getMetadata().toString()));

        return contentValues;
    }

    @Override
    public int delete(long id) {
        return getWritableInstance().delete(TABLE_NAME, COLUMN_ID + " = " + id, null);
    }

    @Override
    public int update(GenericObject obj) {
        return 0;
    }

    @Override
    public ArrayList<GenericObject> getAll() {
        ArrayList<GenericObject> objects = new ArrayList<>();
        SQLiteDatabase writableDB = DatabaseHelper.getInstance(
                GalleryApplication.getInstance()).getWritableDatabase();

        Cursor cursor = writableDB.query(TABLE_NAME, COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();

        int type;
        String path;
        String metadataString;
        long id;
        JSONObject jsonObj = null;
        long timestamp;

        while (!cursor.isAfterLast()) {
            type = cursor.getInt(cursor.getColumnIndex(COLUMN_TYPE));
            path = cursor.getString(cursor.getColumnIndex(COLUMN_FILEPATH));
            timestamp = cursor.getLong(cursor.getColumnIndex(COLUMN_TIMESTAMP));

            metadataString = cursor.getString(cursor.getColumnIndex(COLUMN_METADATA));
            if (metadataString != null) {
                try {
                    jsonObj = new JSONObject(metadataString);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
            GenericObject obj = ApplicationUtils.getObjectFromData(type, path, jsonObj, timestamp);
            obj.setId(id);
            objects.add(obj);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return objects;
    }
}
