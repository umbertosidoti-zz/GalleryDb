package com.example.umberto.gallerydb.mockObject;

import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class MockDataManager implements GenericDataManager {
    @Override
    public String onCreate() {
        return null;
    }

    @Override
    public String onUpdate() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public long insert(GenericObject obj) {
        return 0;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public int update(GenericObject obj) {
        return 0;
    }

    @Override
    public ArrayList<GenericObject> getAll() {
        return null;
    }
}
