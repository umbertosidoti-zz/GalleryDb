package com.example.umberto.gallerydb.mockObject;

import android.media.MediaMetadataRetriever;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Umberto Sidoti on 08/07/2015.
 */
public class MockJsonObject {

    public static final int TYPE_NO_METADATA=1;
    public static final int TYPE_ONLY_TITLE = 2;

    public static final String MOCK_NO_METADATA="{}";

    public static final String[] MOCK_TITLE={"","Test title1","Test title2"};


    public static JSONObject getMockJsonObject(int type){

        switch (type){
            case TYPE_NO_METADATA:
                return  getJsonObjectNoMetadata();
            case TYPE_ONLY_TITLE:
                return getJsonObjectOnlyTitle();
            default:
                return null;
        }
    }

    private static JSONObject getJsonObjectNoMetadata(){

        try {
            return new JSONObject("{}");
        } catch (JSONException e) {
            return null;
        }
    }

    public static JSONObject getJsonObjectOnlyTitle() {
        HashMap<String, String> map = new HashMap<>();
        map.put(Integer.toString(MediaMetadataRetriever.METADATA_KEY_TITLE), MOCK_TITLE[1]);
        return new JSONObject(map);
    }
}
