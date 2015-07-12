package com.example.umberto.gallerydb.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;

import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericControllerListener;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.business.interfaces.RecyclerViewFragmentListener;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 11/07/2015.
 */
public class MockActivity extends AppCompatActivity implements RecyclerViewFragmentListener,GenericControllerListener {

    public SparseArray<Boolean> functionCalled;
    public static final int FUNCT_ADDBUTTON=1;
    public static final int FUNCT_RECYLERREADY=2;
    public static final int FUNCT_ACTIONDELETE=3;
    public static final int FUNCT_DATAREADY=4;
    public ArrayList<GenericObject> data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_layout);
        functionCalled=new SparseArray<>();
    }

    @Override
    public void onAddButtonClick() {
        functionCalled.put(FUNCT_ADDBUTTON,Boolean.TRUE);
    }

    @Override
    public void onRecycleViewReady() {
        functionCalled.put(FUNCT_RECYLERREADY,Boolean.TRUE);
    }

    @Override
    public void onActionModeDeleteRequest(ArrayList<Integer> positionToRemove) {
        functionCalled.put(FUNCT_ACTIONDELETE,Boolean.TRUE);
    }

    @Override
    public void onDataReady(ArrayList<GenericObject> data) {
        this.data=data;
        functionCalled.put(FUNCT_DATAREADY, Boolean.TRUE);
    }
}
