package com.example.umberto.gallerydb.controller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.umberto.gallerydb.function.RxFunction;
import com.example.umberto.gallerydb.task.LoadAllGenericObject;
import com.example.umberto.gallerydb.task.SaveLoadGenericObject;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericControllerListener;
import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

import java.util.ArrayList;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.observers.Observers;
import rx.schedulers.Schedulers;

/**
 * Created by Umberto Sidoti on 29/06/2015.
 */

public class LoadDataRetainFragmentController extends Fragment implements GenericGalleryController {
    private static final int REQ_CODE_PICK_FILE = 12;
    protected GenericControllerListener listener;
    protected ArrayList<GenericObject> data;
    private Subscription subscription;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (GenericControllerListener) activity;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Listener must implements GenericControllerListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null)
            subscription.unsubscribe();
    }

    @Override
    public void start() {
        if (data != null) {
            sendData();
        } else {
            loadData();
        }
    }

    private void loadData() {
        new LoadAllGenericObject() {
            @Override
            protected void onPostExecute(ArrayList<GenericObject> arrayData) {
                sendData(arrayData);
            }
        }.execute();
    }

    @Override
    public void onAddButtonPressed(Activity activity) {
        Intent intent = ApplicationUtils.getIntentFileChooser();
        activity.startActivityForResult(
                Intent.createChooser(intent, activity.getString(R.string.select_file_title)),
                REQ_CODE_PICK_FILE);
    }

    @Override
    public void onResultReceived(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE_PICK_FILE && resultCode == Activity.RESULT_OK) {
            if ((data != null) && (data.getData() != null)) {
                Uri uri = data.getData();
                saveUriSelected(uri);
            }
        }
    }

    @Override
    public void onDeleteElementRequest(ArrayList<Integer> positionsToRemove) {

        subscription=ApplicationUtils.getIdsFromPosition(data, positionsToRemove)
                .subscribeOn(Schedulers.newThread())
                .flatMap(RxFunction.getFunctionConvertListToSingleValue())
                .map(RxFunction.getFunctionDeleteSingleItem())
                .last()
                .map(RxFunction.getFunctionGetAllItems())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNextAction);
    }

    private final Action1<ArrayList<GenericObject>> onNextAction = new Action1<ArrayList<GenericObject>>() {
        @Override
        public void call(ArrayList<GenericObject> data) {
            sendData(data);
        }
    };


    private void saveUriSelected(Uri uri) {
        subscription=ApplicationUtils.getObservableUriFromUri(uri)
                .subscribeOn(Schedulers.newThread())
                .map(RxFunction.getFunctionGetObjectFromUri())
                .map(RxFunction.getFunctionInsertItem())
                .filter(RxFunction.getFunctionFilterNullValue())
                .map(RxFunction.getFunctionGetAllItems())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNextAction);
    }

    private void sendData(ArrayList<GenericObject> arrayData) {
        if (arrayData != null) {
            data = arrayData;
            sendData();
        }
    }

    private void sendData() {
        if (listener != null)
            listener.onDataReady(data);
    }
}