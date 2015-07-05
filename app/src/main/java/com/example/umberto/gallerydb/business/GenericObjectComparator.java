package com.example.umberto.gallerydb.business;


import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.Comparator;

/**
 * Created by Umberto Sidoti on 05/07/2015.
 */
public class GenericObjectComparator implements Comparator<GenericObject> {

    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;

    private int sortType;

    @Override
    public int compare(GenericObject obj1, GenericObject obj2) {
        switch (sortType) {
            case ASCENDING:
            default:
                return (int) (obj2.getCreationDate() - obj1.getCreationDate());
            case DESCENDING:
                return (int) (obj1.getCreationDate() - obj2.getCreationDate());

        }
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }
}
