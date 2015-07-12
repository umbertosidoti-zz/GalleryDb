package com.example.umberto.gallerydb.task;

import android.test.InstrumentationTestCase;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.mockObject.MockServiceLocator;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Umberto Sidoti on 11/07/2015.
 */
public class TestLoadAllTask extends InstrumentationTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        GalleryApplication.getInstance().setServiceLocator(new MockServiceLocator());
    }

    public void testLoadAll() {

        final CountDownLatch signal = new CountDownLatch(1);

        try {
            runTestOnUiThread(new Runnable() {

                @Override
                public void run() {
                    //noinspection unchecked
                    new LoadAllGenericObject() {
                        @Override
                        protected void onPostExecute(ArrayList<GenericObject> genericObjects) {

                            assertNotNull("Data are null",genericObjects);
                            assertEquals("Size array not valid", 10, genericObjects.size());
                            assertTrue("Item not present", checkIfExist(genericObjects, 1) != -1);
                            assertTrue("Item not present",checkIfExist(genericObjects, 5)!=-1);
                            signal.countDown();
                        }
                    }.execute();
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        try {
            signal.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
    }

    private int checkIfExist(ArrayList<GenericObject> genericObjects, int id) {
        int index = -1;
        int size = genericObjects.size();
        for (int i = 0; (i < size) && (index == -1); i++) {
            GenericObject obj = genericObjects.get(i);
            if (obj.getId() == id)
                index = i;
        }
        return index;
    }
}
