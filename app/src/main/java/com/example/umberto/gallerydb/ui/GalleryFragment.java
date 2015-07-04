package com.example.umberto.gallerydb.ui;

import android.app.Activity;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.business.interfaces.RecycleViewFragment;
import com.example.umberto.gallerydb.business.interfaces.RecycleViewFragmentListener;

import java.util.ArrayList;


public class GalleryFragment extends Fragment implements RecycleViewFragment {

    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private GalleryAdapter adapter;
    private RecycleViewFragmentListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof RecycleViewFragmentListener){
            listener= (RecycleViewFragmentListener) activity;
        }else{
            new ClassCastException("Activity must implement RecycleViewFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

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
        adapter = new GalleryAdapter(this);
        recyclerView.setLayoutManager(
                new GridLayoutManager(getActivity(),getResources().getInteger(R.integer.column_number)));
        recyclerView.setAdapter(adapter);
        addButton.setOnClickListener(addButtonListener);

        if (listener!=null)
            listener.onRecycleViewReady();
    }

    private View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(listener!=null)
                listener.onAddButtonClick();
        }
    };

    @Override
    public void onDataReceived(ArrayList<GenericObject> data){
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {

    }
}
