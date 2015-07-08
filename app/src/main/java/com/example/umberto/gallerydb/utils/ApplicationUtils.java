package com.example.umberto.gallerydb.utils;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.net.Uri;

import com.example.umberto.gallerydb.GalleryApplication;
import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Umberto Sidoti on 26/06/2015.
 */
public class ApplicationUtils {

    public static Intent getIntentFileChooser() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType(GalleryApplication.getInstance().getString(R.string.mime_audio_video_image));
        return intent;
    }

    public static GenericObject getObjectFromUri(Uri uri) {
        int type = getTypeFromUri(uri);
        if (type == -1)
            return null;
        String path = uri.toString();
        HashMap<String, String> metadata = getMetadataFromUri(type, uri);

        GenericObject obj = GalleryApplication.getInstance().
                getServiceLocator().getObjectImplementation();
        obj.setType(type);
        obj.setUriString(path);
        if (metadata != null)
            obj.setMetadata(new JSONObject(metadata));

        return obj;
    }

    public static String getLineOneText(GenericObject object) {
        String title = getStringFromMetadata(object.getMetadata(),
                MediaMetadataRetriever.METADATA_KEY_TITLE);
        if (title != null) {
            return GalleryApplication.getInstance()
                    .getResources().getString(R.string.title, title);
        } else {
            Uri uri = Uri.parse(object.getUriString());
            return GalleryApplication.getInstance()
                    .getResources().getString(R.string.filename, uri.getLastPathSegment());
        }
    }

    public static String getLineTwoText(GenericObject object) {
        String artist = getStringFromMetadata(object.getMetadata(),
                MediaMetadataRetriever.METADATA_KEY_ARTIST);
        return GalleryApplication.getInstance()
                .getResources().getString(R.string.artist,
                        artist != null ?
                                artist : GalleryApplication.getInstance()
                                .getResources().getString(R.string.unknown));
    }

    private static String getStringFromMetadata(JSONObject metadata, int metadataKey) {
        try {
            return metadata
                    .getString(Integer.toString(metadataKey));
        } catch (JSONException e) {
            return null;
        }
    }

    public static GenericObject getObjectFromData(int type, String path, JSONObject metadata, long timestamp) {
        GenericObject obj = GalleryApplication.getInstance().
                getServiceLocator().getObjectImplementation();
        obj.setType(type);
        obj.setUriString(path);
        obj.setCreationDate(timestamp);
        obj.setMetadata(metadata);
        return obj;
    }

    private static HashMap<String, String> getMetadataFromUri(int type, Uri uri) {
        switch (type) {
            case GenericObject.IMAGE_TYPE:
            case GenericObject.VIDEO_TYPE:
                return null;
            case GenericObject.AUDIO_TYPE:
                return getAudioMetadata(uri.getPath());
        }
        return null;
    }

    private static HashMap<String, String> getAudioMetadata(String path) {
        MediaMetadataRetriever metadataRetriever = new MediaMetadataRetriever();
        metadataRetriever.setDataSource(path);
        try {
            HashMap<String, String> metadata = new HashMap<>();
            saveMetadata(metadataRetriever, metadata, MediaMetadataRetriever.METADATA_KEY_TITLE);
            saveMetadata(metadataRetriever, metadata, MediaMetadataRetriever.METADATA_KEY_ARTIST);
            saveMetadata(metadataRetriever, metadata, MediaMetadataRetriever.METADATA_KEY_ALBUM);
            return metadata;
        } catch (Exception e) {

            return null;
        }
    }

    public static Bitmap getBitmapPreviewFromUri(String uriString) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(GalleryApplication.getInstance(), Uri.parse(uriString));
        return mediaMetadataRetriever.getFrameAtTime(10);
    }

    private static void saveMetadata(MediaMetadataRetriever metadataRetriever, HashMap<String, String> metadata, int metadataKey) {
        String value = metadataRetriever.extractMetadata(metadataKey);
        if (value != null)
            metadata.put(Integer.toString(metadataKey), value);
    }

    private static int getTypeFromUri(Uri uri) {
        if (uri==null)
            return -1;

        String mime = getMimeType(uri);
        if(mime==null)
            return -1;

        if (mime.contains(GenericObject.AUDIO_MIME))
            return GenericObject.AUDIO_TYPE;
        else if (mime.contains(GenericObject.VIDEO_MIME))
            return GenericObject.VIDEO_TYPE;
        else if (mime.contains(GenericObject.IMAGE_MIME))
            return GenericObject.IMAGE_TYPE;
        return -1;
    }

    public static String getMimeType(Uri uri) {
        if (uri==null)
            return null;
        ContentResolver cR = GalleryApplication.getInstance().getContentResolver();
        return cR.getType(uri);
    }

    public static Point getNewSizeRatio(double w, int height, int width) {
        Point point = new Point();
        double ratio = height;
        ratio /= width;
        point.x = (int) w;
        point.y = (int) (w * ratio);
        return point;
    }

    public static ArrayList<Long> getIdsFromPosition(ArrayList<GenericObject> data,
                                                    ArrayList<Integer> positionToRemove) {

        ArrayList<Long> idToDelete= new ArrayList<>();

        int size = data.size();
        for (Integer position:positionToRemove){
            if(position<size) {
                GenericObject obj = data.get(position);
                idToDelete.add(obj.getId());
            }
        }
        return idToDelete;
    }
}
