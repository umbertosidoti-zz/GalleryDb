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
import com.example.umberto.gallerydb.business.interfaces.RecycleViewFragment;
import com.example.umberto.gallerydb.utils.ApplicationUtils;

import java.util.ArrayList;

/**
 * Created by Umberto Sidoti on 19/06/2015.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private RecycleViewFragment listener;
    private ArrayList<GenericObject> data;
    private GenericImageLoader imageLoader=GalleryApplication.getInstance().getServiceLocator().getImageLoaderImplementation();

    public GalleryAdapter(RecycleViewFragment listener){
        this.listener=listener;
    }
    public class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView thumbnail;
        TextView firstLine;
        TextView secondLine;

        public GalleryViewHolder(View v) {
            super(v);
            thumbnail = (ImageView) v.findViewById(R.id.thumbnail);
            firstLine = (TextView) v.findViewById(R.id.first_line);
            secondLine= (TextView) v.findViewById(R.id.second_line);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener!=null)
                listener.onItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            if(listener!=null)
                listener.onItemLongClick(getAdapterPosition());
            return false;
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
        if(item.getType()!=GenericObject.AUDIO_TYPE){
            imageLoader.loadImage(GalleryApplication.getInstance(),
                    holder.thumbnail,item.getFilePath(),R.drawable.no_image, R.drawable.loading);
            holder.firstLine.setVisibility(View.GONE);
            holder.secondLine.setVisibility(View.GONE);
        }else{
            imageLoader.loadImage(GalleryApplication.getInstance(),
                    holder.thumbnail,R.drawable.audio,R.drawable.no_image, R.drawable.loading);

            holder.firstLine.setText(ApplicationUtils.getLineOneText(item));
            holder.firstLine.setVisibility(View.VISIBLE);
            holder.secondLine.setText(ApplicationUtils.getLineTwoText(item));
            holder.secondLine.setVisibility(View.VISIBLE);
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
