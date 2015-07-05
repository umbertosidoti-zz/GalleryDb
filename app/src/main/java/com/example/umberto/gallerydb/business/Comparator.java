package com.example.umberto.gallerydb.business;


import com.example.umberto.gallerydb.business.interfaces.GenericObject;

/**
 * Created by Umberto Sidoti on 05/07/2015.
 */
public class Comparator {

    public static final int ASCENDING=1;

    public static int compare(int sortType,GenericObject obj1,GenericObject obj2){
        switch (sortType){
            case ASCENDING:
            default:
                return (int) (obj2.getCreationDate()-obj1.getCreationDate());

        }
    }
}
