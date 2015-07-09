package com.example.umberto.gallerydb.mockObject;

import android.media.MediaMetadataRetriever;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Umberto Sidoti on 08/07/2015.
 */
public class MockJsonObject {

    public static final int TYPE_NO_METADATA = 0;
    public static final int TYPE_ONLY_TITLE = 1;
    public static final int TYPE_ONLY_ARTIST = 2;
    public static final int TYPE_TITLE_ARTIST = 3;

    public static final String MOCK_NO_METADATA = "{}";
    public static final String MOCK_TITLE = "{\"7\":\"Test title1\"}";
    public static final String MOCK_ARTIST = "{\"2\":\"Test artist1\"}";
    public static final String MOCK_TITLE_ARTIST = "{ \"7\":\"Test title2\",\"2\":\"Test artist2\"}";

    public static final String[] MOCK_JSON_LIST = {MOCK_NO_METADATA, MOCK_TITLE, MOCK_ARTIST, MOCK_TITLE_ARTIST};


    public static JSONObject getMockJsonObject(int type) {
        try {
            return new JSONObject(MOCK_JSON_LIST[type]);
        } catch (JSONException e) {
            return null;
        }
    }
}
