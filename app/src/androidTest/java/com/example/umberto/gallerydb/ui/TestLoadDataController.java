package com.example.umberto.gallerydb.ui;

import android.app.Activity;
import android.os.Bundle;

import com.example.umberto.gallerydb.controller.LoadDataRetainFragmentController;

/**
 * Created by Umberto Sidoti on 12/07/2015.
 */
public class TestLoadDataController extends BaseTestFragment {

    public void testLoadData() {

        LoadDataRetainFragmentController controller = new LoadDataRetainFragmentController() {
            @Override
            public void onAttach(Activity activity) {
                super.onAttach(activity);
                assertNotNull(listener);
            }

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                assertTrue(getRetainInstance());
            }
        };
        startFragment(controller);

        solo.sleep(1000);
        controller.start();
        solo.sleep(3000);
        assertTrue("Function dataReady not called", activity.functionCalled.get(MockActivity.FUNCT_DATAREADY));
        assertNotNull("Data are null", activity.data);
    }
}
