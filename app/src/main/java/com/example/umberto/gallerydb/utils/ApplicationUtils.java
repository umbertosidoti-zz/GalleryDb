package com.example.umberto.gallerydb.utils;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.SparseArray;
import android.webkit.MimeTypeMap;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;


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
        String path=uri.getPath();
        SparseArray<String> metadata=getMetadataFromUri(type,uri);

        return GalleryApplication.getInstance().
                getServiceLocator().getObjectImplementation(type, path, metadata);
    }

    private static SparseArray<String> getMetadataFromUri(int type, Uri uri) {
        switch (type){
            case GenericObject.IMAGE_TYPE:
            case GenericObject.VIDEO_TYPE:
                return null;
            case GenericObject.AUDIO_TYPE:
                return getAudioMetadata(uri.getPath());
        }
        return null;
    }

    private static SparseArray<String> getAudioMetadata(String path) {
        MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
        metadataRetriever.setDataSource(path);
        try {
            SparseArray<String> metadata= new SparseArray<>();

            metadata.put(MediaMetadataRetriever.METADATA_KEY_ALBUM,metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
            metadata.put(MediaMetadataRetriever.METADATA_KEY_ARTIST, metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
            metadata.put(MediaMetadataRetriever.METADATA_KEY_GENRE, metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
            return metadata;
        } catch (Exception e) {

            return null;
        }
    }

    private static int getTypeFromUri(Uri uri) {
        String mime=getMimeType(uri.getPath());
        if(mime.contains(GenericObject.AUDIO_MIME))
            return GenericObject.AUDIO_TYPE;
        else if(mime.contains(GenericObject.VIDEO_MIME))
            return GenericObject.VIDEO_TYPE;
        else if(mime.contains(GenericObject.IMAGE_MIME))
            return GenericObject.IMAGE_TYPE;
        return -1;
    }

    public static String getMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return type;
    }
}
