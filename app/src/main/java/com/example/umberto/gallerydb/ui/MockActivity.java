package com.example.umberto.gallerydb.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.RecyclerViewFragmentListener;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 11/07/2015.
 */
public class MockActivity extends AppCompatActivity implements RecyclerViewFragmentListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_layout);
    }

    @Override
    public void onAddButtonClick() {

    }

    @Override
    public void onRecycleViewReady() {

    }

    @Override
    public void onActionModeDeleteRequest(ArrayList<Integer> positionToRemove) {

    }
}
