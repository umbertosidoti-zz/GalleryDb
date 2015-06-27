package com.example.umberto.gallerydb.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericControllerListener;
import com.example.umberto.gallerydb.business.interfaces.GenericGalleryController;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.business.interfaces.RecycleViewFragmentListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        GenericControllerListener,RecycleViewFragmentListener {

    private GenericGalleryController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller= GalleryApplication.getInstance().getServiceLocator().
                getGalleryControllerImplementation();
        controller.onActivityCreated(getSupportLoaderManager());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataReady(ArrayList<GenericObject> data) {

    }

    @Override
    public void onItemClick(int position) {
        controller.onItemClick(position);
    }

    @Override
    public void onItemLongClick(int position) {
        controller.onItemLongClick(position);
    }

    @Override
    public void onAddButtonClick() {
        controller.onAddButtonPressed(this);
    }
}
