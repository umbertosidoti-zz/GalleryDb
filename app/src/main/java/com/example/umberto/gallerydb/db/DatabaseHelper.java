package com.example.umberto.gallerydb.db;
/**
 * Created by Umberto Sidoti on 21/06/2015.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericSqlConfig;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper sInstance;

    public static DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context,
                GalleryApplication.getInstance().getServiceLocator().
                        getSqlConfig().getDatabaseName(), null,
                GalleryApplication.getInstance().getServiceLocator().
                        getSqlConfig().getDatabaseVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        GenericSqlConfig config = GalleryApplication.getInstance().
                getServiceLocator().getSqlConfig();
        database.execSQL(config.getCreateDatabaseString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int ver1, int ver2) {
        GenericSqlConfig config = GalleryApplication.getInstance().
                getServiceLocator().getSqlConfig();
        database.execSQL(config.getUpdateDatabaseString());
        onCreate(database);
    }
}
