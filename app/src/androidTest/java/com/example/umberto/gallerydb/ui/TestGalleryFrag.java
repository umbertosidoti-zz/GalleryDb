package com.example.umberto.gallerydb.ui;

import android.os.Bundle;

/**
 * Created by Umberto Sidoti on 11/07/2015.
 */
public class TestGalleryFrag extends BaseTestFragment {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testFrag(){
        GalleryFragment fragment= new GalleryFragment(){

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                assertNotNull(listener);
            }
        };
        startFragment(fragment);
    }
}
