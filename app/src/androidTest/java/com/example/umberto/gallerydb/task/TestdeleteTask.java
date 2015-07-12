package com.example.umberto.gallerydb.task;

import android.test.InstrumentationTestCase;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.mockObject.MockServiceLocator;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class TestDeleteTask extends InstrumentationTestCase {


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        GalleryApplication.getInstance().setServiceLocator(new MockServiceLocator());
    }

    public void testDelete() {
        final ArrayList<Long> itemsToDelete = new ArrayList<>(4);
        itemsToDelete.add((long) 1);
        itemsToDelete.add((long) 5);

        final CountDownLatch signal = new CountDownLatch(1);

        try {
            runTestOnUiThread(new Runnable() {

                @Override
                public void run() {
                    //noinspection unchecked
                    new DeleteGenericObject() {
                        @Override
                        protected void onPostExecute(ArrayList<GenericObject> genericObjects) {
                            assertEquals("Size of array not valid",8, genericObjects.size());
                            assertEquals("Item not deleted", -1, checkIfExist(genericObjects, 1));
                            assertEquals("Item not deleted",-1, checkIfExist(genericObjects, 5));
                            signal.countDown();
                        }
                    }.execute(itemsToDelete);
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
