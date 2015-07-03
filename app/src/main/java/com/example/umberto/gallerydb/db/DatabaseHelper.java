package com.example.umberto.gallerydb.db;
/**
 * Created by Umberto Sidoti on 21/06/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static DatabaseHelper sInstance;
    private static SQLiteDatabase writableDB;

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
                        getDataManagerImplementation().getName(), null,
                GalleryApplication.getInstance().getServiceLocator().
                        getDataManagerImplementation().getVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        GenericDataManager dataManager = GalleryApplication.getInstance().
                getServiceLocator().getDataManagerImplementation();
        database.execSQL(dataManager.onCreate());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int ver1, int ver2)
    {
        GenericDataManager dataManager = GalleryApplication.getInstance().
                getServiceLocator().getDataManagerImplementation();
        database.execSQL(dataManager.onUpdate());
        onCreate(database);
    }
}
