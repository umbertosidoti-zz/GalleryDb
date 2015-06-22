package com.example.umberto.gallerydb.db;
/**
 * Created by Umberto Sidoti on 21/06/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.umberto.gallerydb.R;

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

    public SQLiteDatabase getWritableDbInstance(Context ctx) {
        if (sInstance == null)
            sInstance = getInstance(ctx);
        if (writableDB == null)
            writableDB = sInstance.getWritableDatabase();
        return writableDB;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context, context.getString(R.string.database_name), null,
                context.getResources().getInteger(R.integer.database_version));
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        ObjectFactory IBaseObject = new ObjectFactory();
        GenericObject obj = IBaseObject.getDBObject(ObjectFactory.GENERIC_GALLERY_OBJ);
        database.execSQL(obj.onCreateDb());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int ver1, int ver2)
    {
        ObjectFactory IBaseObject = new ObjectFactory();
        GenericObject obj = IBaseObject.getDBObject(ObjectFactory.GENERIC_GALLERY_OBJ);
        database.execSQL(obj.onUpdateDb());
        onCreate(database);
    }
}
