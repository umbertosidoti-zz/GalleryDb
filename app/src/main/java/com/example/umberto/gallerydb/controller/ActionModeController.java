package com.example.umberto.gallerydb.controller;

/**
 * Created by Umberto Sidoti on 05/07/2015.
 */

import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.DeleteActionModeListener;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 24/04/15.
 */
public class ActionModeController {

    private final AppCompatActivity activity;
    private final DeleteActionModeListener listener;
    private ActionMode mMode;
    private final SparseBooleanArray itemsChecked;

    public ActionModeController(AppCompatActivity activity, DeleteActionModeListener listener) {

        this.listener = listener;
        this.activity = activity;
        itemsChecked = new SparseBooleanArray();
    }

    public void onItemLongClick(int position) {
        if (!isInActionModeStatus()) {
            mMode = activity.startSupportActionMode(new CallBackActionMode());
        }
        onItemClick(position);

    }

    public boolean onItemClick(int position) {

        if (isInActionModeStatus()) {
            int checkedElements = checkItemsSelected(position);
            updateActionMode(checkedElements);
            return true;
        }
        return false;
    }

    private void updateActionMode(int checkedElements) {
        if (checkedElements > 0)
            mMode.setTitle(Integer.toString(checkedElements));
        else
            mMode.finish();
    }

    private int checkItemsSelected(int position) {

        boolean checked = itemsChecked.get(position);
        checked=!checked;

        itemsChecked.put(position, checked);
        listener.checkItem(position, checked);

        int checkedElement = 0;
        for (int i = 0; i < itemsChecked.size(); i++) {
            if (itemsChecked.valueAt(i))
                checkedElement++;
        }
        return checkedElement;
    }

    private boolean isInActionModeStatus() {
        return mMode != null;
    }

    private class CallBackActionMode implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            MenuInflater inflater = activity.getMenuInflater();
            inflater.inflate(R.menu.contextual_actions, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

            ArrayList<Integer> positionToRemove = new ArrayList<>();


            final int size = itemsChecked.size();
            for (int i = 0; i < size; i++) {
                if (itemsChecked.get(itemsChecked.keyAt(i))) {
                    positionToRemove.add(itemsChecked.keyAt(i));
                }
            }
            listener.deleteItems(positionToRemove);
            mMode.finish();
            itemsChecked.clear();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            cleanListViewCheckedItems();
            mMode = null;
        }
    }

    private void cleanListViewCheckedItems() {

        final int size = itemsChecked.size();
        for (int i = 0; i < size; i++) {
            if (itemsChecked.get(itemsChecked.keyAt(i))) {
                listener.checkItem(itemsChecked.keyAt(i), false);
            }
        }
        itemsChecked.clear();
    }
}