package com.example.umberto.gallerydb.db;

/**
 * Created by Umberto Sidoti on 21/06/2015.
 */
import java.util.ArrayList;

public class ObjectFactory {

    public static final String GENERIC_GALLERY_OBJ ="GENERIC_GALLERY_OBJ";

    public GenericObject getDBObject(String objectType)
    {
        if(objectType == null){
            return null;
        }
//        if(objectType.equalsIgnoreCase(GENERIC_GALLERY_OBJ))


        return null;
    }
    public ArrayList<?extends GenericObject> getDBObjectArray(String objectType)
    {
        if(objectType == null){
            return null;
        }
//        if(objectType.equalsIgnoreCase(GENERIC_GALLERY_OBJ)){
//            return new ArrayList<Person>();
//        }
        return null;
    }
}
