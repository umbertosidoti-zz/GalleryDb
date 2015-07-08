package com.example.umberto.gallerydb.mockObject;

import com.example.umberto.gallerydb.business.GalleryObject;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import org.json.JSONObject;

/**
 * Created by Umberto Sidoti on 08/07/2015.
 */
public class MockGenericObject {

    public static final int TYPE_1=0;
    public static final int TYPE_2=1;

    private static final String[] urlList={
            "content://com.estrongs.files/mnt/sdcard/Alarms/Test1.mp3",
            "content://com.estrongs.files/mnt/sdcard/Image/Test2.mp3"};

    private static final int[] jsonTypeList={
            MockJsonObject.TYPE_NO_METADATA,
            MockJsonObject.TYPE_ONLY_TITLE,
            3};

    private static final int[] objectTypeList={
            GenericObject.AUDIO_TYPE,
            GenericObject.AUDIO_TYPE,3};

    public static final String[] resultLineOne={
            "File name: Test1.mp3",
            "Title: Test title1",
    };


    public static GenericObject getGenericObject(int type){
        return getGenericObject(urlList[type],
                MockJsonObject.getMockJsonObject(jsonTypeList[type]),
                objectTypeList[type]
                );
    }
    public static GenericObject getGenericObject(String url,JSONObject jsonObj,int type){

        GenericObject obj= new GalleryObject();
        obj.setType(type);
        obj.setMetadata(jsonObj);
        obj.setUriString(url);
        return obj;
    }

}
