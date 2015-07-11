package com.example.umberto.gallerydb.mockObject;

import com.example.umberto.gallerydb.business.GalleryObject;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 11/07/2015.
 */
public class MockFactory {

    public static ArrayList<GenericObject> getMockListGenericObject(){

        ArrayList<GenericObject> data = new ArrayList<>(15);
        GenericObject obj;

        for(int i=0;i<10;i++){
            obj=new GalleryObject();
            obj.setId(i);
            data.add(obj);
        }
        return data;
    }
}
