package com.example.umberto.gallerydb.business;

import android.test.AndroidTestCase;

import com.example.umberto.gallerydb.business.interfaces.GenericObject;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class TestGenericObjectComparator extends AndroidTestCase {

    public void testGenericComparator() {
        GenericObjectComparator comparator = new GenericObjectComparator();

        GenericObject obj1 = new GalleryObject();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            assertTrue("Exception", false);
        }
        GalleryObject obj2 = new GalleryObject();

        assertTrue("Order ASCENDING not valid", comparator.compare(obj1, obj2) > 0);

        comparator.setSortType(GenericObjectComparator.DESCENDING);

        assertTrue("Order DESCENDING not valid", comparator.compare(obj1, obj2) < 0);
        assertEquals("Order with null value not valid", comparator.compare(null, obj1));
        assertEquals("Order with null value not valid", 0, comparator.compare(obj1, null));
        assertEquals("Order with null value not valid", 0, comparator.compare(null, null));
    }
}
