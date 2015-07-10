package com.example.umberto.gallerydb.business;

import android.test.AndroidTestCase;

import com.example.umberto.gallerydb.business.interfaces.GenericObject;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class TestGenericObjectComparator extends AndroidTestCase {

    public void testGenericComparator() {
        GenericObjectComparator comparator = new GenericObjectComparator();

        GenericObject obj1= new GalleryObject();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        GalleryObject obj2= new GalleryObject();

        assertTrue(comparator.compare(obj1,obj2)>0);

        comparator.setSortType(GenericObjectComparator.DESCENDING);

        assertTrue(comparator.compare(obj1,obj2)<0);
        assertEquals(0,comparator.compare(null,obj1));
        assertEquals(0,comparator.compare(obj1,null));
        assertEquals(0,comparator.compare(null,null));

    }
}
