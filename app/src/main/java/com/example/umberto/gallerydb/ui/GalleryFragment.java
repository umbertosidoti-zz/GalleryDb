package com.example.umberto.gallerydb.ui;

import android.app.Activity;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.DeleteActionModeListener;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.business.interfaces.RecycleViewFragment;
import com.example.umberto.gallerydb.business.interfaces.RecyclerViewFragmentListener;
import com.example.umberto.gallerydb.controller.ActionModeController;

import java.util.ArrayList;


public class GalleryFragment extends Fragment implements RecycleViewFragment, DeleteActionModeListener {

    private CheckableRecyclerView recyclerView;
    private FloatingActionButton addButton;
    private GalleryAdapter adapter;
    private RecyclerViewFragmentListener listener;
    private ActionModeController actionModeController;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (RecyclerViewFragmentListener) activity;
        }catch (ClassCastException e){
            throw new IllegalStateException("Activity must implement RecyclerViewFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);
        recyclerView = (CheckableRecyclerView) v.findViewById(R.id.recyclerView);
        addButton = (FloatingActionButton) v.findViewById(R.id.addButton);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new GalleryAdapter(this);
        recyclerView.setLayoutManager(
                new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.column_number)));
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_item_recycleview);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(addButtonListener);

        actionModeController= new ActionModeController((AppCompatActivity) getActivity(),this);

        if (listener != null)
            listener.onRecycleViewReady();
    }

    private View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (listener != null)
                listener.onAddButtonClick();
        }
    };

    @Override
    public void onDataReceived(ArrayList<GenericObject> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        actionModeController.onItemClick(position);
    }

    @Override
    public void onItemLongClick(int position) {
        actionModeController.onItemLongClick(position);
    }

    @Override
    public void deleteItems(ArrayList<Integer> positionToRemove) {
        listener.onActionModeDeleteRequest(positionToRemove);
    }

    @Override
    public void checkItem(int position, boolean value) {
        recyclerView.checkItem(position,value);
    }
}
