package com.example.umberto.gallerydb.controller;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.task.LoadAllGenericObject;
import com.example.umberto.gallerydb.task.SaveAndLoadGenericObject;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericControllerListener;
import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 29/06/2015.
 */

public class ControllerRetainFragment extends Fragment implements GenericGalleryController {
    private static final int REQ_CODE_PICK_SOUND_FILE = 12;
    private GenericControllerListener listener;
    private ArrayList<GenericObject> data;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof GenericControllerListener)
            listener = (GenericControllerListener) activity;
        else
            new ClassCastException("Listener must implements GenericControllerListener");
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
                REQ_CODE_PICK_SOUND_FILE);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(GalleryApplication.getInstance(), "Clicked =" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(int position) {
        Toast.makeText(GalleryApplication.getInstance(), "Long clicked =" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResultReceived(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE_PICK_SOUND_FILE && resultCode == Activity.RESULT_OK) {
            if ((data != null) && (data.getData() != null)) {
                Uri uri = data.getData();
                saveUriSelected(uri);
            }
        }
    }

    private void saveUriSelected(Uri uri) {
        new SaveAndLoadGenericObject() {
            @Override
            protected void onPostExecute(ArrayList<GenericObject> arrayData) {
                sendData(arrayData);
            }
        }.execute(uri);
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