package com.example.umberto.gallerydb.function;

import android.net.Uri;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericDataManager;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

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

    public static Func1<Long, Long> getFunctionDeleteSingleItem() {

        return new Func1<Long, Long>() {
            @Override
            public Long call(Long id) {
                GenericDataManager dataManager = GalleryApplication.getInstance().getServiceLocator().getDataManagerImplementation();
                return Long.valueOf(dataManager.delete(id));
            }
        };
    }

    public static Func1<Long, ArrayList<GenericObject>> getFunctionGetAllItems() {
        return new Func1<Long, ArrayList<GenericObject>>() {
            @Override
            public ArrayList<GenericObject> call(Long value) {
                GenericDataManager dataManager = GalleryApplication.getInstance().getServiceLocator().getDataManagerImplementation();
                return dataManager.getAll();
            }
        };
    }

    public static Func1<Long, Boolean> getFunctionFilterNullValue() {
        return new Func1<Long, Boolean>() {
            @Override
            public Boolean call(Long s) {
                return s!=-1;
            }
        };
    }

    public static Func1<Uri, GenericObject> getFunctionGetObjectFromUri() {
        return new Func1<Uri, GenericObject>() {
            @Override
            public GenericObject call(Uri uri) {
                return ApplicationUtils.getObjectFromUri(uri);
            }
        };
    }

    public static Func1<GenericObject, Long> getFunctionInsertItem() {
        return  new Func1<GenericObject, Long>() {
            @Override
            public Long call(GenericObject item) {
                GenericDataManager dataManager = GalleryApplication.getInstance().getServiceLocator().getDataManagerImplementation();
                return dataManager.insert(item);
            }
        };
    }
}
