package com.example.umberto.gallerydb.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.mockObject.MockFactory;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 11/07/2015.
 */
public class TestGalleryFrag extends BaseTestFragment {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testFragInit() {
        GalleryFragment fragment = new GalleryFragment() {

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                assertNotNull("Listener is null", listener);
            }

            @Override
            public void onActivityCreated(Bundle savedInstanceState) {
                super.onActivityCreated(savedInstanceState);
                assertNotNull("Adapter is null", adapter);
                assertNotNull("Recycler is null", recyclerView);
                assertNotNull("Add button is null", addButton);
                assertNotNull("Controller is null", actionModeController);
            }
        };
        startFragment(fragment);
        solo.sleep(3000);
        assertTrue("Function recyclerReady not called", activity.functionCalled.get(MockActivity.FUNCT_RECYLERREADY));
    }

    public void testDataReceived() {

        final ArrayList<GenericObject> data = MockFactory.getMockListGenericObject();
        final int size = data.size();

        final GalleryFragment fragment = new GalleryFragment() {

            @Override
            public void onDataReceived(ArrayList<GenericObject> data) {
                super.onDataReceived(data);
                assertTrue("Array data not valid", data.size() == size);
                assertTrue("Array data inside adapter not valid", adapter.getData().size() == size);
            }
        };

        startFragment(fragment);
        solo.sleep(3000);
        try {
            runTestOnUiThread(new Runnable() {
                @Override
                public void run() {
                    fragment.onDataReceived(data);
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        solo.sleep(5000);
    }
}
