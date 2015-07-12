package com.example.umberto.gallerydb.business;

import android.test.AndroidTestCase;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class TestGalleryObject extends AndroidTestCase {

    public void testGalleryObjectConstructor() {
        GalleryObject obj1 = new GalleryObject();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            assertTrue("Exception", false);
        }
        GalleryObject obj2 = new GalleryObject();
        assertTrue("Timestamp error", obj2.getCreationDate() > obj1.getCreationDate());
    }
}
