package com.example.umberto.gallerydb.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.IControllerListener;
import com.example.umberto.gallerydb.business.interfaces.IGalleryController;
import com.example.umberto.gallerydb.db.GenericObject;

import java.util.ArrayList;

public class GalleryFragment extends Fragment implements IControllerListener {

    private RecyclerView recyclerView;
    private GalleryAdapter adapter;
    private IGalleryController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new GalleryAdapter();
        recyclerView.setLayoutManager(
                new GridLayoutManager(getActivity(),getResources().getInteger(R.integer.column_number)));
        recyclerView.setAdapter(adapter);
        controller=GalleryApplication.getInstance().getServiceLocator().getGalleryController();
        controller.onActivityCreated(getLoaderManager());
    }

    @Override
    public void onDataReady(ArrayList<GenericObject> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
