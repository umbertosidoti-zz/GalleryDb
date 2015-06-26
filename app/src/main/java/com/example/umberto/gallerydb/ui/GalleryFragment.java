package com.example.umberto.gallerydb.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericControllerListener;
import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.ArrayList;

public class GalleryFragment extends Fragment implements GenericControllerListener {

    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private GalleryAdapter adapter;
    private GenericGalleryController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        addButton= (FloatingActionButton) v.findViewById(R.id.addButton);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new GalleryAdapter();
        recyclerView.setLayoutManager(
                new GridLayoutManager(getActivity(),getResources().getInteger(R.integer.column_number)));
        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(addButtonListener);

        controller=GalleryApplication.getInstance().getServiceLocator().getGalleryControllerImplementation();
        controller.onActivityCreated(getLoaderManager());
    }

    private View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.onAddButtonPressed(GalleryFragment.this);
        }
    };

    @Override
    public void onDataReady(ArrayList<GenericObject> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        controller.onActivityResult(requestCode,resultCode,data);
    }
}
