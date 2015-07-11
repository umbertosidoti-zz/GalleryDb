package com.example.umberto.gallerydb.mockObject;

import com.example.umberto.gallerydb.business.GalleryObject;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 10/07/2015.
 */
public class MockDataManager implements GenericDataManager {

    ArrayList<GenericObject> data;

    MockDataManager(){

        data=MockFactory.getMockListGenericObject();

    }
    @Override
    public long insert(GenericObject obj) {
        int size=data.size();
        obj.setId(size);
        data.add(obj);
        return size;
    }

    @Override
    public int delete(long id) {
        int index=-1;
        int size=data.size();
        for(int i=0;(i<size)&&(index==-1);i++) {
            GenericObject obj=data.get(i);
            if (obj.getId() == id)
                index =i;
        }
        if(index!=-1)
            data.remove(index);
        return 1;
    }

    @Override
    public int update(GenericObject obj) {
        return 0;
    }

    @Override
    public ArrayList<GenericObject> getAll() {
        return data;
    }
}
