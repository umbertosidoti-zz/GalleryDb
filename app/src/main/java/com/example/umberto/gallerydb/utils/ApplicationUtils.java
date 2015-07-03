package com.example.umberto.gallerydb.utils;

import android.content.ContentResolver;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import org.json.JSONObject;

import java.util.HashMap;


/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class ApplicationUtils {

    public static Intent getIntentFileChooser(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*,video/*,audio/*");
        return intent;
    }

    public static GenericObject getObjectFromUri(Uri uri) {

        int type=getTypeFromUri(uri);
        if(type==-1)
            return null;
        String path=uri.toString();
        HashMap<String,String> metadata=getMetadataFromUri(type,uri);

        GenericObject obj=GalleryApplication.getInstance().
                getServiceLocator().getObjectImplementation();
        obj.setType(type);
        obj.setUriString(path);
        if(metadata!=null)
            obj.setMetadata(new JSONObject(metadata));

        return obj;
    }

    public static GenericObject getObjectFromData(int type,String path,JSONObject metadata) {
        GenericObject obj=GalleryApplication.getInstance().
                getServiceLocator().getObjectImplementation();
        obj.setType(type);
        obj.setUriString(path);
        obj.setMetadata(metadata);
        return obj;
    }

    private static HashMap<String,String> getMetadataFromUri(int type, Uri uri) {
        switch (type){
            case GenericObject.IMAGE_TYPE:
            case GenericObject.VIDEO_TYPE:
                return null;
            case GenericObject.AUDIO_TYPE:
                return getAudioMetadata(uri.getPath());
        }
        return null;
    }

    private static HashMap<String,String> getAudioMetadata(String path) {
        MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
        metadataRetriever.setDataSource(path);
        try {
            HashMap<String,String> metadata= new HashMap<String,String>();

            metadata.put(Integer.toString(MediaMetadataRetriever.METADATA_KEY_ALBUM),metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
            metadata.put(Integer.toString(MediaMetadataRetriever.METADATA_KEY_ARTIST), metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
            metadata.put(Integer.toString(MediaMetadataRetriever.METADATA_KEY_GENRE), metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
            return metadata;
        } catch (Exception e) {

            return null;
        }
    }

    private static int getTypeFromUri(Uri uri) {
        String mime=getMimeType(uri);
        if(mime.contains(GenericObject.AUDIO_MIME))
            return GenericObject.AUDIO_TYPE;
        else if(mime.contains(GenericObject.VIDEO_MIME))
            return GenericObject.VIDEO_TYPE;
        else if(mime.contains(GenericObject.IMAGE_MIME))
            return GenericObject.IMAGE_TYPE;
        return -1;
    }

    public static String getMimeType(Uri uri) {
        ContentResolver cR = GalleryApplication.getInstance().getContentResolver();
        return  cR.getType(uri);
    }
}
