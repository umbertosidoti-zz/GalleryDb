package com.example.umberto.gallerydb.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.FrameLayout;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.mockObject.MockServiceLocator;

/**
 * Created by Umberto Sidoti on 11/07/2015.
 */
public class BaseTestFragment extends ActivityInstrumentationTestCase2<MockActivity> {

    MockActivity activity;

    public BaseTestFragment() {
        super(MockActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        GalleryApplication.getInstance().setServiceLocator(new MockServiceLocator());
        activity = getActivity();
    }

    public Fragment startFragment(Fragment fragment) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.activity_test_fragment, fragment, "Fragment");
        transaction.commit();
        getInstrumentation().waitForIdleSync();
        Fragment frag = activity.getSupportFragmentManager().findFragmentByTag("Fragment");
        return frag;
    }
}
