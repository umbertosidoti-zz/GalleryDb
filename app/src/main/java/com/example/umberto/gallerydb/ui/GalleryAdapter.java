package com.example.umberto.gallerydb.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericImageLoader;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 19/06/2015.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private ArrayList<GenericObject> data;
    private GenericImageLoader imageLoader=GalleryApplication.getInstance().getServiceLocator().getImageLoaderImplementation();

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView firstLine;
        TextView secondLine;

        public GalleryViewHolder(View v) {
            super(v);
            thumbnail = (ImageView) v.findViewById(R.id.thumbnail);
            firstLine = (TextView) v.findViewById(R.id.first_line);
            secondLine= (TextView) v.findViewById(R.id.second_line);
        }
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_generic, parent, false);
        GalleryViewHolder vh = new GalleryViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        GenericObject item=data.get(position);
        imageLoader.loadImage(GalleryApplication.getInstance(),
                holder.thumbnail,item.getImagePath(),R.drawable.no_image);
        if(item.getType()!=GenericObject.AUDIO_TYPE){
            holder.firstLine.setVisibility(View.GONE);
            holder.secondLine.setVisibility(View.GONE);
        }else{
            holder.firstLine.setText(item.getMetadata());
            holder.firstLine.setText(item.getMetadata());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(data==null || data.size()==0)
            return 0;
        return data.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(ArrayList<GenericObject> data) {
        this.data = data;
    }
}
