package com.example.umberto.gallerydb.function;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Umberto Sidoti on 03/08/2015.
 */
public class RxFunction {

    public static Func1<List<Long>, Observable<Long>> getFunctionConvertListToSingleValue() {

        return new Func1<List<Long>, Observable<Long>>() {
            @Override
            public Observable<Long> call(List<Long> idList) {
                return Observable.from(idList);
            }
        };
    }

    public static Func1<Long, Integer> getFunctionDeleteSingleItem() {

        return new Func1<Long, Integer>() {
            @Override
            public Integer call(Long id) {
                GenericDataManager dataManager = GalleryApplication.getInstance().getServiceLocator().getDataManagerImplementation();
                return dataManager.delete(id);
            }
        };
    }

    public static Func1<Integer, ArrayList<GenericObject>> getFunctionGetAllItems() {
        return new Func1<Integer, ArrayList<GenericObject>>() {
            @Override
            public ArrayList<GenericObject> call(Integer integer) {
                GenericDataManager dataManager = GalleryApplication.getInstance().getServiceLocator().getDataManagerImplementation();
                return dataManager.getAll();
            }
        };
    }
}
